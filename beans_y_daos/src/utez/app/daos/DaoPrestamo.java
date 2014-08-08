/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
				
				EjemplarBean ejemplar = 
					new DaoEjemplar(con).get(result.getInt("ejemplar_id"));
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
		
		String query ="SELECT * FROM PRESTAMO"
			+ " ORDER BY fecha_salida ASC;";
		try {
			ResultSet result = executeQuery(query);
			passResultSet(result, list);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		return list;
	}

	@Override
	public PrestamoBean get(int id) {
		PrestamoBean bean = null;
		
		String query  = "SELECT * FROM PRESTAMO WHERE prestamo_id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			bean = passResultSet(rs, new ArrayList<PrestamoBean>()).get(0);
			
			ps.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoPrestamo.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IndexOutOfBoundsException e){}
		
		return bean;
	}

	@Override
	public boolean update(PrestamoBean bean) {
		String query =  ("UPDATE PRESTAMO SET"
			+ " ejemplar_id = ?"
			+ ", usuario_id = ?"
			+ ", fecha_salida = ?"
			+ ", fecha_entrega = ?"
			+ " WHERE prestamo_id = ?;"
			);
		
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, bean.getEjemplar().getEjemplar_id());
			ps.setInt(2, bean.getUsuario().getUsuario_id());
			ps.setDate(3, bean.getFecha_salida());
			ps.setDate(4, bean.getFecha_entrega());
			ps.setInt(5, bean.getPrestamo_id());
			
			if(ps.executeUpdate()==1){
				ps.close();
				return true;
			}
			
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	@Override
	public boolean delete(PrestamoBean id) {
		String query = "DELETE FROM PRESTAMO WHERE prestamo_id = ?";
		
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id.getPrestamo_id());
			
			if(ps.executeUpdate()==1){
				ps.close();
				return true;
			}
			
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	@Override
	public boolean add(PrestamoBean bean) {
		String query =  ( "INSERT INTO PRESTAMO ("
			+ " ejemplar_id"
			+ ", usuario_id"
			+ ", fecha_salida"
			+ ", fecha_entrega"
			+ ") VALUES (?,?,?,?);"
			);
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, bean.getEjemplar().getEjemplar_id());
			ps.setInt(2, bean.getUsuario().getUsuario_id());
			ps.setDate(3, bean.getFecha_salida());
			ps.setDate(4, bean.getFecha_entrega());
			
			if(ps.executeUpdate()==1){
				ps.close();
				return true;
			}
			
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
	
//	public boolean nuevoPrestamo(UsuarioBean usuario, LibroBean libro, int dias){
//	return nuevoPrestamo(usuario, libro, dias, false);
//	}
//	
	public boolean nuevoPrestamo(UsuarioBean usuario, LibroBean libro, int dias, boolean mysql){
		EjemplarBean ejemplar = new DaoEjemplar(con).getDisponibleByLibro(libro);
		if (ejemplar == null || usuario == null){
			return false;
		}
		
		try{
			String query = "INSERT INTO PRESTAMO (usuario_id, ejemplar_id, fecha_salida, fecha_entrega)"
				+ " VALUES (?,?,"
				+ "GETDATE(), DATEADD(day,?,GETDATE()) "
				+ ");";
			
			if(mysql){
				query = "INSERT INTO PRESTAMO (usuario_id, ejemplar_id, fecha_salida, fecha_entrega)"
				+ " VALUES (?,?,"
				+ "CURDATE(), DATE_ADD(CURDATE(),INTERVAL ? DAY )"
				+ ");";
			}
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, usuario.getUsuario_id());
			ps.setInt(2, ejemplar.getEjemplar_id());
			ps.setInt(3, dias);
			
			if (ps.executeUpdate() == 1){
				ps.close();
				return true;
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoPrestamo.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		
		
		return false;
	}
	
	/**
	 *	Regresa cuanta penalizacion hay de x dias
	 * @param dias retraso
	 * @return  costo de el retraso
	 */
	public double penalizacion(int dias){
		double penalizacion = 0;
			String query = "SELECT costo FROM PENALIZACION WHERE limite_inferior IN"
				+ " (SELECT MAX(limite_inferior) FROM PENALIZACION WHERE limite_inferior <= ? );";
			
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, dias);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				penalizacion = rs.getDouble("costo");
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoPrestamo.class.getName()).log(Level.SEVERE, null, ex);
		}
		return penalizacion;
	}
	
	public int diasDeRetraso(PrestamoBean prestamo, boolean mysql){
		int dias = 0;
		String datediff = "datediff(day, ?, GETDATE())";
			if (mysql){
				datediff = "datediff(CURDATE(), ?)";
			}
		String query = "SELECT "+datediff+" as dias;";
		
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setDate(1, prestamo.getFecha_entrega());
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				dias = rs.getInt("dias");
			}
			
			ps.close();
		}catch (SQLException ex){
			
		}
		
		return dias;
	}
	
	public double penalizacion(PrestamoBean prestamo, boolean mysql){
		double penalizacion = 0;
		
		
			String datediff = "datediff(day, ?, GETDATE())";
			if (mysql){
				datediff = "datediff(CURDATE(), ?)";
			}
			
			String query = "SELECT costo FROM PENALIZACION"
				+ " WHERE  limite_inferior IN"
				+ " (SELECT MAX(limite_inferior) FROM PENALIZACION WHERE limite_inferior <= "
				+ datediff
				+ ");";
		try {
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setDate(1, prestamo.getFecha_entrega());
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				penalizacion = rs.getDouble("costo");
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoPrestamo.class.getName()).log(Level.SEVERE, null, ex);
		}
		return penalizacion;
	}
	
	public double penalizacion(PrestamoBean prestamo){
		return penalizacion(prestamo, false);
	}
	
	public List<PrestamoBean> findByUsuario(UsuarioBean usuario){
		 List<PrestamoBean>  lista = new ArrayList<>();	 
		 
		try {
			
			String query = "SELECT * FROM PRESTAMO WHERE usuario_id = "+usuario.getUsuario_id()+";";
			PreparedStatement ps = con.prepareStatement(query);
			lista = passResultSet(ps.executeQuery(), lista);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoPrestamo.class.getName()).log(Level.SEVERE, null, ex);
		}catch (NullPointerException e){
			
		}
		 
		 return lista;
	}
	
	public List<PrestamoBean> findByLibro(LibroBean libro){
		 List<PrestamoBean>  lista = new ArrayList<>();	 
		 
		try {
			
			String query = "SELECT * FROM PRESTAMO WHERE ejemplar_id IN"
				+ " (SELECT ejemplar_id from EJEMPLAR WHERE libro_id = "+libro.getLibro_id()+");";
			PreparedStatement ps = con.prepareStatement(query);
			lista = passResultSet(ps.executeQuery(), lista);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoPrestamo.class.getName()).log(Level.SEVERE, null, ex);
		}catch (NullPointerException e){
			
		}
		 
		 return lista;
	}
}
