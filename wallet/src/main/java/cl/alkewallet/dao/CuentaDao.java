package cl.alkewallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.alkewallet.model.Cuenta;
import cl.alkewallet.model.Transaccion;

public class CuentaDao extends Dao {
	
	public int agregarCuenta(Cuenta cuenta) {
        String sql = "INSERT INTO cuentas (idUsuario, numeroCuenta, saldo, titular, fechaCreacion) VALUES (?,?,?,?,?)";
        try {
            Connection conn = Dao.conexion();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, cuenta.getIdUsuario());
            pstmt.setString(2, cuenta.getNumeroCuenta());
            pstmt.setDouble(3, cuenta.getSaldo());
            pstmt.setString(4, cuenta.getTitular());
            pstmt.setDate(5, new java.sql.Date(cuenta.getFechaCreacion().getTime()));

            int resultado = pstmt.executeUpdate();

            if (resultado > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        cuenta.setIdCuenta(generatedKeys.getInt(1));
                    }
                } catch (SQLException e) {
                    System.out.println("Error al obtener el ID de la cuenta generada: " + e.getMessage());
                }
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println("Error al agregar la cuenta: " + e.getMessage());
            return -1;
        }
    }

	public List<Cuenta> obtenerCuentasPorIdUsuario(int idUsuario) {
	    List<Cuenta> cuentas = new ArrayList<>();
	    Connection conex = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conex = conexion();
	        String sql = "SELECT * FROM cuentas WHERE idUsuario =?";
	        pstmt = conex.prepareStatement(sql);
	        pstmt.setInt(1, idUsuario);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            Cuenta cuenta = new Cuenta();
	            cuenta.setIdCuenta(rs.getInt("idCuenta"));
	            cuenta.setIdUsuario(rs.getInt("idUsuario"));
	            cuenta.setNumeroCuenta(rs.getString("numeroCuenta"));
	            cuenta.setSaldo(rs.getDouble("saldo"));
	            cuenta.setTitular(rs.getString("titular"));
	            cuenta.setFechaCreacion(rs.getDate("fechaCreacion"));
	            cuentas.add(cuenta);
	        }
	    } catch (SQLException sql) {
	        System.out.println("Error al obtener las cuentas por id de usuario: " + sql.getMessage());
	    }

	    return cuentas;
	}
	
	public boolean depositar(int idCuenta, double monto) {
	    String consulta = "UPDATE cuentas SET saldo = saldo + ? WHERE idCuenta = ?";
	    
	    try {
	        Connection conex = conexion();
	        PreparedStatement pstmt = conex.prepareStatement(consulta);
	        pstmt.setDouble(1, monto);
	        pstmt.setInt(2, idCuenta);
	        
	        int resultado = pstmt.executeUpdate();
	        
	        if (resultado > 0) {
	            return true;
	        }
	        
	    } catch (SQLException e) {
	        System.out.println("Error al depositar en la cuenta: " + e.getMessage());
	    }
	    
	    return false;
	}
	
	public boolean retirar(int idCuenta, double monto) throws Exception {
	    String consulta = "SELECT saldo FROM cuentas WHERE idCuenta = ?";
	    
	    try {
	        Connection conex = conexion();
	        PreparedStatement pstmt = conex.prepareStatement(consulta);
	        pstmt.setInt(1, idCuenta);
	        
	        ResultSet resultado = pstmt.executeQuery();
	        
	        if (resultado.next()) {
	            double saldoActual = resultado.getDouble("saldo");
	            
	            if (saldoActual < monto) {
	                throw new Exception("Saldo insuficiente");
	            }
	            
	            consulta = "UPDATE cuentas SET saldo = saldo - ? WHERE idCuenta = ?";
	            pstmt = conex.prepareStatement(consulta);
	            pstmt.setDouble(1, monto);
	            pstmt.setInt(2, idCuenta);
	            
	            int resultadoUpdate = pstmt.executeUpdate();
	            
	            if (resultadoUpdate > 0) {
	                return true;
	            }
	        }
	        
	    } catch (SQLException e) {
	        throw new Exception("Error al retirar de la cuenta: " + e.getMessage());
	    }
	    
	    return false;
	}

	public boolean agregarMovimiento(String tipo, double monto, int idCuenta) {
		boolean agregado = false;
		Connection conex = null;
		PreparedStatement pstmt = null;

		try {
			conex = conexion();
			String sql = "INSERT INTO movimientos (tipo, monto, idCuenta) VALUES (?,?,?)";
			pstmt = conex.prepareStatement(sql);
			pstmt.setString(1, tipo);
			pstmt.setDouble(2, monto);
			pstmt.setInt(3, idCuenta);
			int resultado = pstmt.executeUpdate();

			if (resultado > 0) {
				agregado = true;
			}
		} catch (SQLException sql) {
			System.out.println("Error al agregar movimiento: " + sql.getMessage());
		} 

		return agregado;
	}

	public List<Transaccion> obtenerMovimientosPorCuenta(int idCuenta) {
		List<Transaccion> movimientos = new ArrayList<>();
		Connection conex = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conex = conexion();
			String sql = "SELECT * FROM movimientos WHERE idCuenta =?";
			pstmt = conex.prepareStatement(sql);
			pstmt.setInt(1, idCuenta);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Transaccion movimiento = new Transaccion();
				movimiento.setIdTransaccion(rs.getInt("idMovimiento"));
				movimiento.setTipoMovimiento(rs.getString("tipo"));
				movimiento.setMonto(rs.getDouble("monto"));
				movimiento.setIdCuenta(rs.getInt("idCuenta"));
				movimiento.setFechaDeTransaccion(rs.getDate("fecha"));
				movimientos.add(movimiento);
			}
		} catch (SQLException sql) {
			System.out.println("Error al obtener movimientos por cuenta: " + sql.getMessage());
		} 

		return movimientos;
	}
	
	public Cuenta obtenerCuentaPorIdCuenta(int idCuenta) {
	    Cuenta cuenta = null;
	    Connection conex = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    try {
	        conex = conexion();
	        pstmt = conex.prepareStatement("SELECT * FROM cuentas WHERE idCuenta =?");
	        pstmt.setInt(1, idCuenta);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            cuenta = new Cuenta();
	            cuenta.setIdCuenta(rs.getInt("idCuenta"));
	            cuenta.setIdUsuario(rs.getInt("idUsuario"));
	            cuenta.setNumeroCuenta(rs.getString("numeroCuenta"));
	            cuenta.setSaldo(rs.getDouble("saldo"));
	            cuenta.setTitular(rs.getString("titular"));
	            cuenta.setFechaCreacion(rs.getDate("fechaCreacion"));
	        }
	    } catch (SQLException sql) {
	        System.out.println("Error al obtener la cuenta por id de cuenta: " + sql.getMessage());
	    }

	    return cuenta;
	}

	public boolean transferir(int idCuentaOrigen, int idCuentaDestino, double monto) {
		boolean transferido = false;
		Connection conex = null;
		PreparedStatement pstmt = null;

		try {
			conex = conexion();
			conex.setAutoCommit(false);

			String sqlOrigen = "UPDATE cuentas SET saldo = saldo -? WHERE idCuenta =?";
			pstmt = conex.prepareStatement(sqlOrigen);
			pstmt.setDouble(1, monto);
			pstmt.setInt(2, idCuentaOrigen);
			int resultadoOrigen = pstmt.executeUpdate();

			String sqlDestino = "UPDATE cuentas SET saldo = saldo +? WHERE idCuenta =?";
			pstmt = conex.prepareStatement(sqlDestino);
			pstmt.setDouble(1, monto);
			pstmt.setInt(2, idCuentaDestino);
			int resultadoDestino = pstmt.executeUpdate();

			if (resultadoOrigen > 0 && resultadoDestino > 0) {
				conex.commit();
				transferido = true;
			} else {
				conex.rollback();
			}
		} catch (SQLException sql) {
			System.out.println("Error al transferir: " + sql.getMessage());
		}

		return transferido;
	}
}
