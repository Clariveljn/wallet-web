package cl.alkewallet.model;

public class Usuario {

	private int idUsuario;
    private String nombre;
    private String apellido;
    private String password;
    private String email;
    
    
	public Usuario(String nombre, String apellido, String password, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.email = email;
	}
	
	
	public Usuario(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}

	public Usuario() {
		super();
	}


	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} 
}
