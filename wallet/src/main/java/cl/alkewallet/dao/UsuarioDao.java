package cl.alkewallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cl.alkewallet.model.Usuario;

public class UsuarioDao extends Dao {

	public boolean registrarUsuario(Usuario usuario) {
		boolean registrado = false;
		Connection conex = null;
		PreparedStatement pstmt = null;

		try {
			conex = conexion();
			String sql = "INSERT INTO usuarios (nombre, apellido, email, password) VALUES (?, ?, ?, ?)";
			pstmt = conex.prepareStatement(sql);
			pstmt.setString(1, usuario.getNombre());
			pstmt.setString(2, usuario.getApellido());
			pstmt.setString(3, usuario.getEmail());
			pstmt.setString(4, usuario.getPassword());

			int resultado = pstmt.executeUpdate();
			if (resultado > 0) {
				registrado = true;
			}
		} catch (SQLException sql) {
			System.out.println("Error al registrar el usuario: " + sql.getMessage());
		}

		return registrado;
	}

	public Usuario obtenerUsuarioPorEmail(String email) {
		Usuario usuario = null;
		Connection conex = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conex = conexion();
			String sql = "SELECT * FROM usuarios WHERE email = ?";
			pstmt = conex.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setEmail(rs.getString("email"));
				usuario.setPassword(rs.getString("password"));
			}
		} catch (SQLException sql) {
			System.out.println("Error al obtener el usuario por email: " + sql.getMessage());
		} 

		return usuario;
	}
}