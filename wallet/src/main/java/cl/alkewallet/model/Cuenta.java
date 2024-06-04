package cl.alkewallet.model;

import java.util.Date;

public class Cuenta {
	
	private int idCuenta;
    private int idUsuario;
    private String numeroCuenta;
    private double saldo;
    private String titular;
    private Date fechaCreacion;
    
    
    
	public Cuenta() {
		super();
	}

	public Cuenta(int idUsuario, String numeroCuenta, double saldo, String titular, Date fechaCreacion) {
		super();
		this.idUsuario = idUsuario;
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.titular = titular;
		this.fechaCreacion = fechaCreacion;
	}
	
	public int getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}
