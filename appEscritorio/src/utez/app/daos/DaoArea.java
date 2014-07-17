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
import utez.app.model.AreaBean;

/**
 *
 * @author ricardo
 */
public class DaoArea extends AbstractDao<AreaBean>{

	public DaoArea(Connection con) {
		super(con);
	}

	/**
	 * Obtener todas las Areas
	 * @return Lista con -todas- las Areas incluyendo no activas
	 * 
	 */
	@Override
	public List<AreaBean> getAll() {
		List<AreaBean> list = new ArrayList<>();
		String query ="SELECT * FROM AREA;";
		try {
			ResultSet result = executeQuery(query);
			list = passResultSet(result, list);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}

	/**
	 * Obtener Areas Activas
	 * @return Lista con todas las Areas activas
	 */
	public List<AreaBean> getActive() {
		List<AreaBean> list = new ArrayList<>();
		String query ="SELECT * FROM AREA where alta = 'true';";
		try {
			
			ResultSet result = executeQuery(query);
			list = passResultSet(result, list);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}
	
	/**
	 * Obtener area especifica 
	 * @param id > ID_Area 
	 * @return El area que coincida
	 */
	@Override
	public AreaBean get(int id) {
		String query = "SELECT * FROM AREA where area_id=?;" ;
		AreaBean area = null;
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			
			if(result.next()){
				area = new AreaBean();
				area.setArea_id(result.getInt("area_id"));
				area.setNombre(result.getString("nombre"));
				area.setAlta(result.getBoolean("alta"));
			}
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return area;
	}

	/**
	 * Actualizar la base de datos,
	 * @param bean Actualizado, el ID debe coincidir
	 * @return si fue eitoso
	 */
	@Override
	public boolean update(AreaBean bean) {
		String query =  ("UPDATE AREA SET"
			+ " nombre = ?"
			+ " alta = ?"
			+ " WHERE area_id = ?;"
			);
		
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, bean.getNombre());
			ps.setString(2, ""+bean.isAlta());
			ps.setInt(3, bean.getArea_id());
			
			if(ps.executeUpdate()==1){
				ps.close();
				return true;
			}
			
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	/**
	 * Eliminar de la base de datos
	 * @param bean
	 * @return
	 */
	@Override
	public boolean delete(AreaBean bean) {
		String query = "DELETE FROM AREA WHERE area_id = ?";
		
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, bean.getNombre());
			ps.setString(2, ""+bean.isAlta());
			ps.setInt(3, bean.getArea_id());
			
			if(ps.executeUpdate()==1){
				ps.close();
				return true;
			}
			
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}


	/**
	 * Insertar en la BD
	 * @param bean a insertar, dbe tener Nombre, y Alta
	 * @return
	 */
	@Override
	public boolean add(AreaBean bean) {
		String query = "INSERT INTO AREA nombre values (?);";
		
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, bean.getNombre());
			if(ps.executeUpdate()==1){
				ps.close();
                                
				return true;
			}
			
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, "lksajdflñk", ex);
                        
		}
                System.out.println("hola");
		return false;
	}
	
	
	
	

	/**
	 * Encontrar Los bean con el param nombre
	 * @param nombre
	 * @return Lista con los Bean que coincidan
	 */
	public List<AreaBean> findByNombre(String nombre){
		List<AreaBean> list = new ArrayList<>();
		String query = "SELECT * FROM AREA where nombre LIKE ?;";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, nombre);
			
			ResultSet result = ps.executeQuery();
			list = passResultSet(result, list);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}
	
	@Override
	 List<AreaBean> passResultSet(ResultSet res, List<AreaBean> list) throws SQLException{
		
			while(res.next()){
				
				AreaBean area = new AreaBean();
				area.setArea_id(res.getInt("area_id"));
				area.setNombre(res.getString("nombre"));
				area.setAlta(res.getBoolean("alta"));
				list.add(area);
			}
		
		return list;
	}

}
