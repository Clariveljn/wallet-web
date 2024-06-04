package cl.alkewallet.service;

import java.sql.SQLException;
import java.util.List;

import cl.alkewallet.dao.TransaccionDao;
import cl.alkewallet.model.Transaccion;

public class TransaccionService {
    private TransaccionDao transaccionDao;

    public TransaccionService(TransaccionDao transaccionDao) {
        this.transaccionDao = transaccionDao;
    }

    public List<Transaccion> consultarTransacciones() throws SQLException {
        return transaccionDao.consultar();
    }

    public int insertarTransaccion(Transaccion transaccion) throws SQLException {
        return transaccionDao.insertar(transaccion);
    }

    public int eliminarTransaccion(int idTransaccion) throws SQLException {
        return transaccionDao.eliminar(idTransaccion);
    }

    public int editarTransaccion(Transaccion transaccion) throws SQLException {
        return transaccionDao.editar(transaccion);
    }
}
