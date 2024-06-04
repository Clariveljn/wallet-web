package cl.alkewallet.service;

import java.util.List;

import cl.alkewallet.dao.CuentaDao;
import cl.alkewallet.model.Cuenta;
import cl.alkewallet.model.Transaccion;

public class CuentaService {
	private CuentaDao cuentaDao;

	public CuentaService() {
		cuentaDao = new CuentaDao();
	}

	public int agregarCuenta(Cuenta cuenta) {
		return cuentaDao.agregarCuenta(cuenta);
	}

	public Cuenta obtenerCuentaPorIdCuenta(int idCuenta) {
		return cuentaDao.obtenerCuentaPorIdCuenta(idCuenta);
	}

	public List<Cuenta> obtenerCuentasPorIdUsuario(int idUsuario) {
		return cuentaDao.obtenerCuentasPorIdUsuario(idUsuario);
	}
	
	public boolean depositar(int idCuenta, double monto) {
        return cuentaDao.depositar(idCuenta, monto);
    }

	public boolean retirar(int idCuenta, double monto) throws Exception {
	    try {
	        return cuentaDao.retirar(idCuenta, monto);
	    } catch (Exception e) {
	        if (e.getMessage().contains("Saldo insuficiente")) {
	            throw new Exception("Saldo insuficiente");
	        } else {
	            throw new Exception("Error al retirar de la cuenta: " + e.getMessage());
	        }
	    }
	}

	public double obtenerSaldo(int idCuenta) {
        Cuenta cuenta = cuentaDao.obtenerCuentaPorIdCuenta(idCuenta);
        if (cuenta!= null) {
            return cuenta.getSaldo();
        } else {
            return 0.0; 
        }
    }
	
	public boolean agregarMovimiento(String tipo, double monto, int idCuenta) {
		return cuentaDao.agregarMovimiento(tipo, monto, idCuenta);
	}

//    public boolean transferir(int idCuentaOrigen, int idCuentaDestino, double monto) {
//        boolean origenUpdated = cuentaDao.actualizarSaldo(idCuentaOrigen, -monto);
//        boolean destinoUpdated = cuentaDao.actualizarSaldo(idCuentaDestino, monto);
//        return origenUpdated && destinoUpdated;
//    }

	public List<Transaccion> obtenerMovimientosPorCuenta(int idCuenta) {
		return cuentaDao.obtenerMovimientosPorCuenta(idCuenta);
	}
}