package cl.alkewallet.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.alkewallet.model.Moneda;

public class MonedaDao extends Dao {

    public int insertar(Moneda moneda) {
        String stInsert = "INSERT INTO monedas(codigo, nombre, simbolo) VALUES('"
                + moneda.getCodigo() + "','" + moneda.getNombre() + "','" + moneda.getSimbolo() + "')";
        
        int insert = actualizarBaseDatos(stInsert);
        
        return insert;
    }
    
    public List<Moneda> consultar() throws SQLException {
    	
        List<Moneda> listMonedas = new ArrayList<>();
        
        String query = "SELECT idMoneda, codigo, nombre, simbolo FROM monedas";
        
        realizarConsulta(query);
        
        while (rs.next()) {
            Moneda moneda = new Moneda();
            moneda.setIdMoneda(rs.getInt("idMoneda"));
            moneda.setCodigo(rs.getString("codigo"));
            moneda.setNombre(rs.getString("nombre"));
            moneda.setSimbolo(rs.getString("simbolo"));
            
            listMonedas.add(moneda);
        }
        
        return listMonedas;
    }
    
    public int eliminar(int idMoneda) {
        String stDelete = "DELETE FROM monedas WHERE idMoneda = " + idMoneda;
        int delete = actualizarBaseDatos(stDelete);
        return delete;
    }
    
    public int editar(Moneda moneda) {
        String stEdit = "UPDATE monedas SET codigo='"
                        + moneda.getCodigo() + "', nombre='"
                        + moneda.getNombre() + "', simbolo='"
                        + moneda.getSimbolo() + "' WHERE idMoneda=" + moneda.getIdMoneda();
        
        int edit = actualizarBaseDatos(stEdit);
        return edit;
    }
}

