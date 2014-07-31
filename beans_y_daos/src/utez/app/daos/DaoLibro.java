
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
import utez.app.model.AutorBean;
import utez.app.model.EditorialBean;
import utez.app.model.EjemplarBean;
import utez.app.model.LibroBean;

/**
 *
 * @author ricardo
 */
public class DaoLibro extends AbstractDao<LibroBean>{
	
	private static final String TABLA = "LIBRO";
	private static final String PK = "libro_id";
	private static final String[] ATRIBUTES =
	{"ISBN", "nombre", "area_id", "editorial_id", "paginas", "alta"};
	
	@Override
	 List<LibroBean> passResultSet(ResultSet result, List<LibroBean> list) throws SQLException{
		
			while (result.next()){
				LibroBean libro = new LibroBean();
				libro.setLibro_id(result.getInt("libro_id"));
				libro.setIsbn(result.getLong("ISBN"));
				libro.setNombre(result.getString("nombre"));
				libro.setAlta(result.getBoolean("alta"));
				libro.setPaginas(result.getInt("paginas"));
				
				EditorialBean editorial = new DaoEditorial(con).get(result.getInt("editorial_id"));
				AreaBean area = new DaoArea(con).get(result.getInt("area_id"));
				List<AutorBean> autores = new DaoAutor(con).findByLibro(libro);
				
				libro.setEditorial(editorial);
				libro.setArea(area);
				libro.setAutores(autores);
				
				list.add(libro);
			}
			
		return list;
	}
	

	public DaoLibro(Connection con) {
		super(con);
	}

	@Override
	public List<LibroBean> getAll() {
		List<LibroBean> list = new ArrayList<>();
		String query ="SELECT * FROM "+TABLA+
			" ORDER BY nombre ASC;";
		try {
			ResultSet result = executeQuery(query);
			list = passResultSet(result, list);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}

	public List<LibroBean> getActive() {
		List<LibroBean> list = new ArrayList<>();
		String query ="SELECT * FROM "+TABLA+" where alta = 'true'"
			+ " ORDER BY nombre ASC;";
		try {
			
			ResultSet result = executeQuery(query);
			list = passResultSet(result, list);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}

	@Override
	public LibroBean get(int id) {
		LibroBean libro = null;
		try {
			PreparedStatement statement = con.prepareStatement(
				"SELECT * FROM LIBRO where libro_id=?;");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			
			libro = passResultSet(result, new ArrayList<LibroBean>()).get(0);
			
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IndexOutOfBoundsException ex){
			System.err.println("Libro IndexOutOfBounds");
			return null;
		}
		
		return libro;
	}
	
	@Override
	public boolean update(LibroBean bean) {
		String sentence = "UPDATE "+TABLA+" SET"
			+ " ISBN = ?,"
			+ " nombre = ?,"
			+ " area_id = ?,"
			+ " editorial_id = ?,"
			+ " paginas = ?,"
			+ " alta = ?"
			+ " WHERE libro_id = ?;"
			;
			
		try {
			PreparedStatement ps = con.prepareStatement(sentence);
			ps.setLong(1, bean.getIsbn());
			ps.setString(2, bean.getNombre());
			ps.setInt(3, bean.getArea().getArea_id());
			ps.setInt(4, bean.getEditorial().getEditorial_id());
			ps.setInt(5, bean.getPaginas());
			ps.setString(6, bean.isAlta()+ "");
			ps.setInt(7, bean.getLibro_id());
			
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

	@Override
	public boolean delete(LibroBean bean) {
		String sentence = "DELETE FROM LIBRO WHERE libro_id = " + bean.getLibro_id()+";";
		
		try {
			PreparedStatement statement = con.prepareStatement(sentence);
			
			if(statement.executeUpdate()== 1){
				statement.close();
				DaoEjemplar daoE = new DaoEjemplar(con);
				for (EjemplarBean ejemplar: daoE.findByLibro(bean)){
					daoE.delete(ejemplar);
				}
				
				return true;
			}
			statement.close();
			return true;
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoLibro.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return false;
	}

	@Override
	public boolean add(LibroBean bean) {
		
		String query  = "INSERT INTO "+TABLA+" (nombre, ISBN, area_id, editorial_id, paginas) "
			+ "VALUES (?, ?, ?, ?, ?);";
		 
		try(PreparedStatement ps = con.prepareStatement(query)){
			
			ps.setString(1, bean.getNombre());
			ps.setLong(2, bean.getIsbn());
			ps.setInt(3, bean.getArea().getArea_id());
			ps.setInt(4, bean.getEditorial().getEditorial_id());
			ps.setInt(5, bean.getPaginas());
			
			if (ps.executeUpdate() != 1) {
				ps.close();
				return false;
			}
			ps.close();
			
			//insertar autores
			if (bean.getAutores() != null && bean.getAutores().size() > 0){
				
				for (AutorBean autor : bean.getAutores()){
					query = "INSERT INTO AUTOR_DE (autor_id, libro_id)"
						 + " VALUES (?, ?);";
					 PreparedStatement statement = con.prepareStatement(query);
					 statement.setInt(1, autor.getAutor_id());
					 statement.setInt(2, getByIsbn(bean.getIsbn()).getLibro_id());
					 
					if (statement.executeUpdate() != 1) {
						return false;
					}
					statement.close();
				}
			}
			
			return true;
		} catch (SQLException ex) {
			Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return false;
	}

	
	
	
	/**
	 *
	 * @return cantidad de ejemplares disponibles
	 * 
	 */
	public int countEjemplaresDisponibles(LibroBean bean){
		int n = -1;
		try {
			String query = "SELECT COUNT(*) AS num FROM EJEMPLAR "
				+ " WHERE libro_id = "+bean.getLibro_id()
				+ " and ejemplar_id not IN"
				+ " (SELECT ejemplar_id FROM PRESTAMO);";
			PreparedStatement statement = con.prepareStatement(query);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()){
				n = resultSet.getInt("num");
			}
		} catch (SQLException ex) {
			Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return n;
	}
	public int countEjemplares(LibroBean bean){
		int n = -1;
		try {
			String query = "select count(*) as num from EJEMPLAR where libro_id=?;";
			
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, bean.getLibro_id());
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()){
				n = resultSet.getInt("num");
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoEjemplar.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return n;
	}
		
	/**
	 * Obtener los libros del area
	 * @param area 
	 * @return Lista de libros
	 */
	public List<LibroBean> findByArea(AreaBean area){
		List<LibroBean> list = new ArrayList<>();
		String query = ("SELECT * FROM LIBRO WHERE area_id = ? and alta = 'true' "
			+ " ORDER BY nombre ASC;");
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, area.getArea_id());
			
			ResultSet result = ps.executeQuery();
			
			list = passResultSet(result, list);
			ps.close();
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoEditorial.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}
        
        public List<LibroBean> findByAreaNombre(AreaBean area){
		List<LibroBean> list = new ArrayList<>();
		String query = "SELECT * FROM LIBRO WHERE alta = 'true' and area_id IN (SELECT area_id FROM AREA WHERE nombre LIKE ?);";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "%"+area.getNombre()+"%");
			
			ResultSet result = ps.executeQuery();
			
			list = passResultSet(result, list);
			ps.close();
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoEditorial.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}
	
	/**
	 * Obtener los libros del area
	 * @param area 
	 * @return Lista de libros
	 */
	public List<LibroBean> findByTitulo(String titulo){
		List<LibroBean> list = new ArrayList<>();
		String query = ("SELECT * FROM LIBRO WHERE nombre LIKE ? and alta = 'true';");
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "%"+titulo+"%");
			
			ResultSet result = ps.executeQuery();
			
			list = passResultSet(result, list);
			ps.close();
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoEditorial.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}
	
	
	
	/**
	 * Obtener libros escritos por el autor
	 * @param autor
	 * @return
	 */
	public List<LibroBean> findByAutor(AutorBean autor){
		List<LibroBean> list = new ArrayList<>();
		String query = "SELECT * FROM LIBRO WHERE alta = 'true'"
			+ " and libro_id IN"
			+ " (SELECT libro_id FROM AUTOR_DE"
			+ " WHERE autor_id = ?);";
		
		try {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, autor.getAutor_id());
			
			ResultSet result = statement.executeQuery();
			
			list = passResultSet(result, list);
			
			statement.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoAutor.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}
	
        
        public List<LibroBean> findByAutorNombre(String nombre){
		List<LibroBean> list = new ArrayList<>();
		List<AutorBean> autores = new DaoAutor(con).findByNombreYApellido(nombre);
                
                for (AutorBean autorBean : autores) {
                    for (LibroBean libro : findByAutor(autorBean)) {
                        if (!list.contains(libro)){
                        list.add(libro);
                        }
                    }
            }
                
                return list;
	}
        
	/**
	 * Obtener los libros de la Editorial
	 * @param editorial
	 * @return Lista de libros
	 */
	public List<LibroBean> findByEditorial(EditorialBean editorial){
		List<LibroBean> list = new ArrayList<>();
		
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * FROM LIBRO"
				+ " WHERE editorial_id = "+ editorial.getEditorial_id()
				+ " and alta = 'true'"
				+ " ;");
			ResultSet result = statement.executeQuery();
			
			list = passResultSet(result, list);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoEditorial.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}
        
        public List<LibroBean> findByEditorialNombre(EditorialBean editorial){
		List<LibroBean> list = new ArrayList<>();
		
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * FROM LIBRO"
				+ " WHERE alta = 'true' and editorial_id in ("
                                + " SELECT editorial_id FROM EDITORIAL WHERE nombre like ?"
				+ " );");
                        statement.setString(1, "%"+editorial.getNombre()+"%");
			ResultSet result = statement.executeQuery();
			
			list = passResultSet(result, list);
			
		} catch (SQLException ex) {
			Logger.getLogger(DaoEditorial.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return list;
	}
	
	//conteos
	
	/**
	 * Libros de una editorial
	 * @param editorial
	 * @return
	 */
	public int countByEditorial(EditorialBean editorial){
		int cuenta = -1;
		
		String sentence = "SELECT COUNT(*) as cuenta FROM LIBRO"
			+ " WHERE editorial_id = "+editorial.getEditorial_id()+";";
		
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
	
	/**
	 *  Libros prestados
	 * @param libro
	 * @return 
	 */
	public int countPrestamos(LibroBean libro){
		int cuenta = -1;
		
		String sentence = "SELECT COUNT(*) as cuenta FROM PRESTAMO"
			+ " WHERE ejemplar_id IN"
			+ " (SELECT ejemplar_id FROM EJEMPLAR"
			+ " WHERE libro_id = "+libro.getLibro_id()+");";
		
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
	
	public int countByAutor(AutorBean autor){
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
	
	public int countByArea(AreaBean area){
		int cuenta = -1;
		
		String sentence = "SELECT COUNT(*) as cuenta FROM LIBRO"
			+ " WHERE area_id = "+area.getArea_id()+";";
		
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
	
	
	
	public LibroBean getByIsbn(long isbn) {
		LibroBean libro = null;
		try {
			PreparedStatement statement = con.prepareStatement(
				"SELECT * FROM LIBRO WHERE ISBN=?;");
			statement.setLong(1, isbn);
			ResultSet result = statement.executeQuery();
			
			libro = passResultSet(result, new ArrayList<LibroBean>()).get(0);
			
			
			statement.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoArea.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IndexOutOfBoundsException ex){
			
		}
		
		return libro;
	}
}

