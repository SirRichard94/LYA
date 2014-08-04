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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ricardo
 * @param <T> Bean
 */
public abstract class AbstractDao<T> implements Dao<T>{
	
	Connection con;

	public AbstractDao(Connection con) {
		this.con = con;
	}

	protected boolean executeUpdate(String query){
		try {
			PreparedStatement ps = con.prepareStatement(query);
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
	
	protected ResultSet executeQuery(String query) {
		try {
			PreparedStatement ps = con.prepareStatement(query);
			return ps.executeQuery();
		} catch (SQLException ex) {
			Logger.getLogger(AbstractDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	
	abstract List<T> passResultSet(ResultSet res, List<T> list) throws SQLException;
	
}
