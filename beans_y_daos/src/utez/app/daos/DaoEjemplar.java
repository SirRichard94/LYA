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
import utez.app.model.EjemplarBean;
import utez.app.model.LibroBean;
import utez.app.model.UsuarioBean;

/**
 *
 * @author ricardo
 */
public class DaoEjemplar extends AbstractDao<EjemplarBean>{
	
	
	private static final String TABLA = "EJEMPLAR";
	private static final String PK = "ejemplar_id";
	
	
	public DaoEjemplar(Connection con) {
		super(con);
	}
	
	@Override
	public List<EjemplarBean> getAll() {		
		List<EjemplarBean> list = new ArrayList<>();
		String query ="SELECT * FROM "+TABLA+";";
		try {
			ResultSet result = executeQuery(query);
			list = passResultSet(result, list);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}

	@Override
	public EjemplarBean get(int id) {
		
		
		EjemplarBean ejemplar = null;
		try {
			PreparedStatement sql = con.prepareStatement(
			"SELECT * FROM "+TABLA+" WHERE "+PK+" = ?;");
			sql.setInt(1, id);
			
			ResultSet result = sql.executeQuery();
			ejemplar = passResultSet(result, new ArrayList<EjemplarBean>()).get(0);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NullPointerException ex){
			
		}
		return ejemplar;
	}

	@Override
	public boolean update(EjemplarBean bean) {
		String query = "UPDATE "+TABLA+" SET"
				+" libro_id = ?"
				+", localizacion = ?"
				+" WHERE "+PK+" = ?;";
		
		try (PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, bean.getLibro().getLibro_id());
			ps.setString(2, bean.getLocalizacion());
			ps.setInt(3, bean.getEjemplar_id());

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
	public boolean delete(EjemplarBean bean) {
		String query = "DELETE FROM "+TABLA
				+" WHERE "+PK+" =? ;";
			
		try(PreparedStatement ps = con.prepareStatement(query)){
			ps.setInt(1, bean.getEjemplar_id());

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
	public boolean add(EjemplarBean bean) {
		String query  = "INSERT INTO "+TABLA+" (libro_id, localizacion) VALUES (?, ?);";
		 
		try(PreparedStatement ps = con.prepareStatement(query)){
			ps.setInt(1, bean.getLibro().getLibro_id());
			ps.setString(2, bean.getLocalizacion());

			if (ps.executeUpdate() >= 1) {
				ps.close();
				return true;
			}
			ps.close();
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return false;
	}
	
	
	public List<EjemplarBean> findByLibro(LibroBean libro){
		List<EjemplarBean> list = new ArrayList<>();
		try {
			PreparedStatement statement = con.prepareStatement(
				"SELECT * FROM EJEMPLAR WHERE libro_id in "
					+ "(SELECT libro_id from LIBRO"
					+ " where libro_id = ? or nombre = ?"
					+ ");");
			statement.setInt(1, libro.getLibro_id());
			statement.setString(2, libro.getNombre());
			
			ResultSet result = statement.executeQuery();
			
			list = passResultSet(result, list);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoLibro.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}
	
	public int count(LibroBean libro){
		int cuenta = -1;
		
		String sentence = "SELECT COUNT(*) as cuenta FROM EJEMPLAR"
			+ " WHERE libro_id = "+libro.getLibro_id()+";";
		
		try {
			ResultSet result = con.prepareStatement(sentence).executeQuery();
			
			if (result != null){
				cuenta = result.getInt("cuenta");
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return cuenta;
	}
	
	public int countDisponibles(LibroBean libro){
		int cuenta = -1;
		
		String sentence = "SELECT COUNT(*) as cuenta FROM EJEMPLAR"
			+ " WHERE libro_id = "+libro.getLibro_id()
			+ " and ejemplar_id not in"
			+ " (SELECT ejemplar_id FROM PRESTAMO);";
		
		try {
			ResultSet result = con.prepareStatement(sentence).executeQuery();
			
			if (result != null){
				cuenta = result.getInt("cuenta");
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return cuenta;
	}
	
	@Override
	List<EjemplarBean> passResultSet(ResultSet result, List<EjemplarBean> list) throws SQLException{
		
			while (result.next()){
				EjemplarBean ejempl = new EjemplarBean();
				ejempl.setEjemplar_id(result.getInt("ejemplar_id"));
				ejempl.setLocalizacion(result.getString("localizacion"));
				
				LibroBean lib = new DaoLibro(con).get(result.getInt("libro_id"));
				
				ejempl.setLibro(lib);
				
				list.add(ejempl);
			}
		
		return list;
	}
	
	public EjemplarBean getDisponibleByLibro(LibroBean libro){
		String query = "SELECT * FROM EJEMPLAR WHERE libro_id = ? " 
			+" AND ejemplar_id NOT IN (SELECT ejemplar_id FROM PRESTAMO);";
		EjemplarBean ejemplar = null;
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, libro.getLibro_id());
			
			ResultSet res = ps.executeQuery();
			if (res.next()){
				ejemplar = new EjemplarBean();
				ejemplar.setEjemplar_id(res.getInt("ejemplar_id"));
				ejemplar.setLibro(libro);
				ejemplar.setLocalizacion(res.getString("localizacion"));
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		
		return ejemplar;
	}
}