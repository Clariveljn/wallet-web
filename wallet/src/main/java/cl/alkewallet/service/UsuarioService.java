package cl.alkewallet.service;

import cl.alkewallet.dao.UsuarioDao;
import cl.alkewallet.model.Usuario;

public class UsuarioService {
    private UsuarioDao usuarioDao;

    public UsuarioService() {
        usuarioDao = new UsuarioDao();
    }

    public boolean registrarUsuario(Usuario usuario) {
        return usuarioDao.registrarUsuario(usuario);
    }
    
    public Usuario autenticarUsuario(String email, String password) {
        Usuario usuario = usuarioDao.obtenerUsuarioPorEmail(email);
        if (usuario != null && usuario.getPassword().equals(password)) {
            return usuario;
        }
        return null;
    }
}