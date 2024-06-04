package cl.alkewallet.model;

import java.util.Date;

public class Transaccion {
	
	private int idTransaccion;
    private int idCuenta;
    private double monto;
    private Date fechaDeTransaccion;
    private int cuentaOrigen;
    private int cuentaDestino;
    private String tipoMovimiento;
    
	public int getIdTransaccion() {
		return idTransaccion;
	}
	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	public int getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Date getFechaDeTransaccion() {
		return fechaDeTransaccion;
	}
	public void setFechaDeTransaccion(Date fechaDeTransaccion) {
		this.fechaDeTransaccion = fechaDeTransaccion;
	}
	public int getCuentaOrigen() {
		return cuentaOrigen;
	}
	public void setCuentaOrigen(int cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}
	public int getCuentaDestino() {
		return cuentaDestino;
	}
	public void setCuentaDestino(int cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
    
    
}
