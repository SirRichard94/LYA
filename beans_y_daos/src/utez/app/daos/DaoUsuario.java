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
import utez.app.model.LibroBean;
import utez.app.model.UsuarioBean;

/**
 *
 * @author ricardo
 */
public class DaoUsuario extends AbstractDao<UsuarioBean>{

	private static final String TABLA = "USUARIO";
	private static final String PK = "usuario_id";
	private static final String[] ATRIBUTES =
	{"nombre", "correo", "passwd", "deuda", "direccion", "telefono", "usuario_id", "alta", "es_admi"};

	public DaoUsuario(Connection con) {
		super(con);
	}
	
	
	/**
	 *
	 * @return TODOS los usuarios
	 */
	@Override
	public List<UsuarioBean> getAll() {
		String query = "SELECT * FROM USUARIO"
			+ "  ORDER BY nombre ASC;";
		
		List<UsuarioBean> list = new ArrayList<>();
		try {
			PreparedStatement sql = con.prepareStatement(query);
			list = passResultSet(sql.executeQuery(), list);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}
	
	/**
	 *
	 * @return Usuarios con alta = true
	 */
	public List<UsuarioBean> getActive() {
		String query = "SELECT * FROM USUARIO WHERE alta = 'true'"
			+ " ORDER BY nombre ASC;" ;
		List<UsuarioBean> list = new ArrayList<>();
		try {
			PreparedStatement sql = con.prepareStatement(query);
			list = passResultSet(sql.executeQuery(), list);
			sql.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}

	@Override
	public UsuarioBean get(int id) {
		UsuarioBean usr = null;
		try {
			PreparedStatement sql = con.prepareStatement(
				"SELECT * FROM USUARIO WHERE usuario_id = "+id+";");
			
			ResultSet res  = sql.executeQuery();
			List<UsuarioBean> list = new ArrayList<>();
			list = passResultSet(res, list);
			usr = list.get(0);
			
			sql.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IndexOutOfBoundsException ex){}
		
		return usr;
	}

	@Override
	public boolean update(UsuarioBean bean) {
		String query = "UPDATE USUARIO SET"
			+ " nombre = ?"
			+ ", correo = ?"
			+ ", passwd = ?"
			+ ", telefono = ?"
			+ ", direccion = ?"
			+ ", deuda = ?"
			+ ", alta= ?"
			+ ", es_admi= ?"
			+ " WHERE usuario_id = " + bean.getUsuario_id() + ";";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, bean.getNombre());
			ps.setString(2, bean.getCorreo());
			ps.setString(3, bean.getPasswd());
			ps.setString(4, bean.getTelefono());
			ps.setString(5, bean.getDireccion());
			ps.setDouble(6, bean.getDeuda());
			ps.setString(7, bean.isAlta()+"");
			ps.setString(8, bean.isEs_admi()+"");
			
			if (ps.executeUpdate() >= 1){
				ps.close();
			return true;
			}
			ps.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return false;
		
	}

	@Override
	public boolean delete(UsuarioBean bean) {
		String query = "DELETE FROM USUARIO WHERE usuario_id = "+bean.getUsuario_id();
		
		try {
			PreparedStatement statement = con.prepareStatement(query);
			if (statement.executeUpdate() >= 1){
				statement.close();
			return true;
			}
			statement.close();
		} catch (SQLException ex) {
			
			Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return false;
	}

	@Override
	public boolean add(UsuarioBean bean) {
		String query = "INSERT INTO USUARIO"
			+ " (nombre, correo, passwd, telefono, direccion, deuda, es_admi)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, bean.getNombre());
			ps.setString(2, bean.getCorreo());
			ps.setString(3, bean.getPasswd());
			ps.setString(4, bean.getTelefono());
			ps.setString(5, bean.getDireccion());
			ps.setDouble(6, bean.getDeuda());
			ps.setString(7, bean.isEs_admi()+"");
			
			if (ps.executeUpdate() ==1){
				ps.close();
				return true;
			}
			
			ps.close();
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoLibro.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return false;
	}
	
	public boolean autenticar(String correo, String passwd){
		
		try {
			PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM USUARIO WHERE"
					+ " correo = ? and"
					+ " passwd = ? and alta='true';" );
			ps.setString(1, correo);
			ps.setString(2, passwd);
			
			if (ps.executeQuery().next()){
				ps.close();
				return true;
			}
			
			ps.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoLibro.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return false;
	}
	
	public UsuarioBean findByCorreo(String correo){
		UsuarioBean usuario = new UsuarioBean();
		
		String sentence ="SELECT * FROM USUARIO WHERE correo = ?;";
		
		try {
			PreparedStatement ps = con.prepareStatement(sentence);
			ps.setString(1, correo);
			
			ResultSet rs  = ps.executeQuery();
			
			if (rs.next()){
				usuario.setAlta(rs.getBoolean("alta"));
				usuario.setEs_admi(rs.getBoolean("es_admi"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setPasswd(rs.getString("passwd"));
				usuario.setDireccion(rs.getString("direccion"));
				usuario.setTelefono(rs.getString("telefono"));
				usuario.setDeuda(rs.getDouble("deuda"));
				usuario.setUsuario_id(rs.getInt("usuario_id"));
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return usuario;
	}
	
	@Override
	 List<UsuarioBean> passResultSet(ResultSet res, List<UsuarioBean> list) throws SQLException {
		
		while (res.next()){
			UsuarioBean us = new UsuarioBean();
			us.setUsuario_id(res.getInt("usuario_id"));
			us.setAlta(res.getBoolean("alta"));
			us.setEs_admi(res.getBoolean("es_admi"));
			us.setCorreo(res.getString("correo"));
			us.setPasswd(res.getString("passwd"));
			us.setTelefono(res.getString("telefono"));
			us.setNombre(res.getString("nombre"));
			us.setDireccion(res.getString("direccion"));
			
			
			us.setDeuda(res.getDouble("deuda"));
			list.add(us);
		}
		
		return list;
	}
	 
	 
	 public int countPrestamos(UsuarioBean usuario){
		 int n = -1;
		 String sentence = "SELECT COUNT(*) as cuenta FROM PRESTAMO"
			 + " WHERE usuario_id = ?";
		 
		 try(PreparedStatement ps = con.prepareStatement(sentence)){
			 ps.setInt(1, usuario.getUsuario_id());
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				n = rs.getInt("cuenta");
			}
			
			ps.close();
		 } catch (SQLException ex) {
			Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
		}
		 return n;		 
	 }
}
