/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utez.app.model.EditorialBean;

/**
 *
 * @author ricardo
 */
public class DaoEditorial extends AbstractDao<EditorialBean>{
	
	private static final String TABLA = "EDITORIAL";
	private static final String PK = "editorial_id";
	
	public DaoEditorial(Connection con) {
		super(con);
	}

	
	
	@Override
	public List<EditorialBean> getAll() {
		List<EditorialBean> list = new ArrayList<>();
		String query ="SELECT * FROM "+TABLA+";";
		try {
			ResultSet result = executeQuery(query);
			list = passResultSet(result, list);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}

	
	public List<EditorialBean> getActive() {
		List<EditorialBean> list = new ArrayList<>();
		
		String query ="SELECT * FROM "+TABLA+" where alta = 'true';";
		try {
			
			ResultSet result = executeQuery(query);
			list = passResultSet(result, list);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}

	@Override
	public EditorialBean get(int id) {
		List<EditorialBean> lista = new ArrayList<>();
		
		try {
			PreparedStatement statement = con.prepareStatement(
				"SELECT * FROM EDITORIAL WHERE editorial_id = "+id+";");
			
			ResultSet result = statement.executeQuery();
			
			lista = passResultSet(result, lista);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoEditorial.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return lista.get(0);
	}

	@Override
	public boolean update(EditorialBean bean) {
		String query = "UPDATE "+TABLA+" SET"
				+" nombre = ?,"
				+" direccion = ?,"
				+" alta = ?"
				+" WHERE "+PK+" = ?;";
		
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, bean.getNombre());
			ps.setString(2, bean.getDireccion());
			ps.setString(3, "" + bean.isAlta());
			ps.setInt(4, bean.getEditorial_id());

			if (ps.executeUpdate() == 1) {
				ps.close();
				return true;
			}
			ps.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
		}

		return false;
	}

	@Override
	public boolean delete(EditorialBean bean) {
		String query = "DELETE FROM "+TABLA
				+" WHERE "+PK+" =? ;";
			
		try(PreparedStatement ps = con.prepareStatement(query)){
			ps.setInt(1, bean.getEditorial_id());

			if (ps.executeUpdate() == 1) {
				ps.close();
				return true;
			}
			ps.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return false;
	}

	@Override
	public boolean add(EditorialBean bean) {
		String query  = "INSERT INTO "+TABLA+" (nombre, direccion) VALUES (?, ?);";
		 
		try(PreparedStatement ps = con.prepareStatement(query)){
			ps.setString(1, bean.getNombre());
			ps.setString(2, bean.getDireccion());

			if (ps.executeUpdate() == 1) {
				ps.close();
				return true;
			}
			ps.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return false;
	}
	
	public List<EditorialBean> findByNombre(String nombre){
		List<EditorialBean> list = new ArrayList<>();
		String query = ( "SELECT * FROM "+TABLA+" WHERE nombre LIKE ? and alta = 'true';");
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "%"+nombre+"%");
			ResultSet result = ps.executeQuery();
			
			list = passResultSet(result, list);
			ps.close();
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}
	
	
		
	@Override
	 List<EditorialBean> passResultSet(ResultSet res, List<EditorialBean> list) throws SQLException{
		
			while(res.next()){
				
				EditorialBean bean = new EditorialBean();
				bean.setEditorial_id(res.getInt("editorial_id"));
				bean.setNombre(res.getString("nombre"));
				bean.setDireccion(res.getString("direccion"));
				bean.setAlta(res.getBoolean("alta"));
				list.add(bean);
			}
		
		return list;
	}

	
}
