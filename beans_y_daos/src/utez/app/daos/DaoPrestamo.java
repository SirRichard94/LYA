/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utez.app.model.EjemplarBean;
import utez.app.model.LibroBean;
import utez.app.model.PrestamoBean;
import utez.app.model.UsuarioBean;

/**
 *
 * @author ricardo
 */
public class DaoPrestamo extends AbstractDao<PrestamoBean>{

	public DaoPrestamo(Connection con) {
		super(con);
	}

	@Override
	List<PrestamoBean> passResultSet(ResultSet result, List<PrestamoBean> list) throws SQLException {
		while (result.next()){
				PrestamoBean prestamo = new PrestamoBean();
				prestamo.setPrestamo_id(result.getInt("prestamo_id"));
				prestamo.setFecha_entrega(result.getDate("fecha_entrega"));
				prestamo.setFecha_salida(result.getDate("fecha_salida"));
				
				EjemplarBean ejemplar = new DaoEjemplar(con).get(result.getInt("ejemplar_id"));
				UsuarioBean usuario = new DaoUsuario(con).get(result.getInt("usuario_id"));
				
				prestamo.setEjemplar(ejemplar);
				prestamo.setUsuario(usuario);
				
				list.add(prestamo);
			}
		
		return list;
	}

	@Override
	public List<PrestamoBean> getAll() {
		List<PrestamoBean> list = new ArrayList<>();
		
		String query ="SELECT * FROM PRESTAMO;";
		try {
			ResultSet result = executeQuery(query);
			list = passResultSet(result, list);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		
		return list;
	}

	@Override
	public PrestamoBean get(int id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean update(PrestamoBean bean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean delete(PrestamoBean id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean add(PrestamoBean bean) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
