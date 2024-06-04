package cl.alkewallet.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.alkewallet.model.Transaccion;

public class TransaccionDao extends Dao {

    public int insertar(Transaccion transaccion) {
        String stInsert = "INSERT INTO transacciones(idCuenta, monto, fechaDeTransaccion, cuentaOrigen, cuentaDestino, tipoMovimiento) VALUES('"
                + transaccion.getIdCuenta() + "','" + transaccion.getMonto() + "','" + transaccion.getFechaDeTransaccion() + "','" + transaccion.getCuentaOrigen() + "','" + transaccion.getCuentaDestino() + "','" + transaccion.getTipoMovimiento() + "')";
        
        int insert = actualizarBaseDatos(stInsert);
        
        return insert;
    }
    
    public List<Transaccion> consultar() throws SQLException {
    	
        List<Transaccion> listTransacciones = new ArrayList<>();
        
        String query = "SELECT id, idCuenta, monto, fechaDeTransaccion, cuentaOrigen, cuentaDestino, tipoMovimiento FROM transacciones";
        
        realizarConsulta(query);
        
        while (rs.next()) {
            Transaccion transaccion = new Transaccion();
            transaccion.setIdTransaccion(rs.getInt("id"));
            transaccion.setIdCuenta(rs.getInt("idCuenta"));
            transaccion.setMonto(rs.getDouble("monto"));
            transaccion.setFechaDeTransaccion(rs.getDate("fechaDeTransaccion"));
            transaccion.setCuentaOrigen(rs.getInt("cuentaOrigen"));
            transaccion.setCuentaDestino(rs.getInt("cuentaDestino"));
            transaccion.setTipoMovimiento(rs.getString("tipoMovimiento"));
            
            listTransacciones.add(transaccion);
        }
        
        return listTransacciones;
    }
    
    
    public int eliminar(int idTransaccion) {
        String stDelete = "DELETE FROM transacciones WHERE id = " + idTransaccion;
        int delete = actualizarBaseDatos(stDelete);
        return delete;
    }
    
    public int editar(Transaccion transaccion) {
        String stEdit = "UPDATE transacciones SET idCuenta='"
                        + transaccion.getIdCuenta() + "', monto='"
                        + transaccion.getMonto() + "', fechaDeTransaccion='"
                        + transaccion.getFechaDeTransaccion() + "', cuentaOrigen='"
                        + transaccion.getCuentaOrigen() + "', cuentaDestino='"
                        + transaccion.getCuentaDestino() + "', tipoMovimiento='"
                        + transaccion.getTipoMovimiento() + "' WHERE id=" + transaccion.getIdTransaccion();
        
        int edit = actualizarBaseDatos(stEdit);
        return edit;
    }
}

