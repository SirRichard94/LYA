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
import utez.app.model.AutorBean;
import utez.app.model.LibroBean;

/**
 *
 * @author ricardo
 */
public class DaoAutor extends AbstractDao<AutorBean>{

	private static final String TABLA = "AUTOR";
	private static final String PK = "autor_id";
	
	public DaoAutor(Connection con) {
		super(con);
	}

	@Override
	public List<AutorBean> getAll() {
		List<AutorBean> list = new ArrayList<>();
		String query ="SELECT * FROM "+TABLA+" "
			+ "ORDER BY nombre, apellido ASC;";
		try {
			ResultSet result = executeQuery(query);
			list = passResultSet(result, list);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}

	public List<AutorBean> getActive() {
		List<AutorBean> list = new ArrayList<>();
		String query ="SELECT * FROM "+TABLA+" where alta = 'true'"
			+ " ORDER BY nombre, apellido ASC;";
		try {
			
			ResultSet result = executeQuery(query);
			list = passResultSet(result, list);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}

	@Override
	public AutorBean get(int id) {
		AutorBean autor = new AutorBean();
		String query = "SELECT * FROM "+TABLA+" WHERE "+PK+" = ?";
		
		try {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			
			if(result.next()){
				
				autor.setAutor_id(result.getInt("autor_id"));
				autor.setNombre(result.getString("nombre"));
				autor.setApellido(result.getString("apellido"));
				autor.setAlta(result.getBoolean("alta"));
			}
			
			statement.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return autor;
	}

	@Override
	public boolean update(AutorBean bean) {
		String query = "UPDATE "+TABLA+" SET"
				+" nombre = ?,"
				+" apellido = ?,"
				+" alta = ?"
				+" WHERE "+PK+" = ?;";
		
		
		
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, bean.getNombre());
			ps.setString(2, bean.getApellido());
			ps.setString(3, "" + bean.isAlta());
			ps.setInt(4, bean.getAutor_id());

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
	public boolean delete(AutorBean bean) {
		String query = "DELETE FROM "+TABLA
				+" WHERE "+PK+" = ? ;";
			
		try(PreparedStatement ps = con.prepareStatement(query)){
			ps.setInt(1, bean.getAutor_id());

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
	public boolean add(AutorBean bean) {
		String query  = "INSERT INTO "+TABLA+" (nombre, apellido) VALUES (?, ?);";
		 
		try(PreparedStatement ps = con.prepareStatement(query)){
			ps.setString(1, bean.getNombre());
			ps.setString(2, bean.getApellido());

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
	
	public AutorBean getByNombre(String nombre){
		//List<AutorBean> list = new ArrayList<>();
                AutorBean autor=null;
		String query = ( "SELECT * FROM "+TABLA+" WHERE nombre = ? and alta = 'true';");
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, nombre);
			ResultSet result = ps.executeQuery();
			
			autor = passResultSet(result, new ArrayList<AutorBean>()).get(0);
                        
			ps.close();
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IndexOutOfBoundsException e){}
		
		return autor;
	}

	public List<AutorBean> findByNombre(String nombre){
		List<AutorBean> list = new ArrayList<>();
		String query = ( "SELECT * FROM "+TABLA+" WHERE nombre LIKE ? and alta = 'true'"
			+ " ORDER BY nombre, apellido ASC;");
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
	
	public List<AutorBean> findByApellido(String apellido){
		List<AutorBean> list = new ArrayList<>();
		String query = ( "SELECT * FROM "+TABLA+" WHERE apellido LIKE ?"
			+ "ORDER BY nombre, apellido ASC;");
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, apellido);
			ResultSet result = ps.executeQuery();
			
			list = passResultSet(result, list);
			ps.close();
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}
	
	/**
	 * UNE NOMBRE Y APELLIDO PARA LA BÚSQUEDA
	 * 
	 * 
	 * @param busqueda
	 * @param verdadero si se va a utilizar mysql
	 * @return
	 */
	public List<AutorBean> findByNombreYApellido(String busqueda){
		return findByNombreYApellido(busqueda, false);
	}
	public List<AutorBean> findByNombreYApellido(String busqueda, boolean mysql){
		List<AutorBean> list = new ArrayList<>();
		
		String query = "SELECT * FROM "+TABLA+" WHERE (nombre +' '+ apellido) LIKE ?";
		if (mysql){
		 query = ( "SELECT * FROM "+TABLA+" WHERE CONCAT(nombre,' ',apellido) LIKE ?");
		}
		
		query += " ORDER BY nombre, apellido ASC;";
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "%"+busqueda+"%");
			ResultSet result = ps.executeQuery();
			
			list = passResultSet(result, list);
			ps.close();
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}
	
	
	
	public List<AutorBean> findByLibro(LibroBean libro){
		List<AutorBean> list = new ArrayList<>();
		String query = "SELECT * FROM AUTOR"
				+ " WHERE "+PK+" IN ("
				+ " SELECT "+PK+" FROM AUTOR_DE"
				+ " WHERE libro_id = ? )"
			+ " ORDER BY nombre, apellido ASC;";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, libro.getLibro_id());
			
			ResultSet rs = ps.executeQuery();
			
			list = passResultSet(rs, list);
			
			ps.close();
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoLibro.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}
	
	@Override
	List<AutorBean> passResultSet(ResultSet res, List<AutorBean> list) throws SQLException{
		
			while(res.next()){
				
				AutorBean bean = new AutorBean();
				bean.setAutor_id(res.getInt("autor_id"));
				bean.setNombre(res.getString("nombre"));
				bean.setApellido(res.getString("apellido"));
				bean.setAlta(res.getBoolean("alta"));
				list.add(bean);
			}
		
		return list;
	}
	
	
	public int countLibros(AutorBean autor){
		int cuenta = -1;
		
		String sentence = "SELECT COUNT(*) as cuenta FROM LIBRO"
			+ " WHERE libro_id IN"
			+ " (SELECT libro_id FROM AUTOR_DE"
			+ " WHERE autor_id = "+autor.getAutor_id()+" );";
		
		try {
			ResultSet result = con.prepareStatement(sentence).executeQuery();
			
			if (result.next()){
				cuenta = result.getInt("cuenta");
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return cuenta;
	}
}
