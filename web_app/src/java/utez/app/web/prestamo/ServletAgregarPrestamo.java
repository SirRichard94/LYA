/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.web.prestamo;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utez.app.daos.DaoEjemplar;
import utez.app.daos.DaoLibro;
import utez.app.daos.DaoPrestamo;
import utez.app.daos.DaoUsuario;
import utez.app.model.LibroBean;
import utez.app.model.UsuarioBean;
import utez.app.web.eq4.util.DbConnection;

/**
 *
 * @author ricardo
 */
public class ServletAgregarPrestamo extends HttpServlet {
	private UsuarioBean UsuarioBean;

	/**
	 * Processes requests for both HTTP <code>GET</code> and
	 * <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		Connection con = DbConnection.getConnection();
		if (con == null){
			throw new ServerException("No hay coneccion con la BD");
		
		}
		String mensaje = null;
		
		try{
		int idLibro = Integer.parseInt(request.getParameter("libro"));
		int idUsuario = Integer.parseInt(request.getParameter("usuario"));
		
		DaoPrestamo daoP = new DaoPrestamo(con);
		DaoUsuario daoU = new DaoUsuario(con);
		DaoLibro daoL = new DaoLibro(con);
		
		UsuarioBean  usuario = daoU.get(idUsuario);
		LibroBean libro = daoL.get(idLibro);
		
		if(usuario.getDeuda() > 0){
			mensaje = "<div class=\" alert alert-warning\"> El usuario posee deuda</div>";
		}else if(daoU.countPrestamos(usuario) >= 3){
			mensaje = "<div class=\" alert alert-warning\"> El usuario tiene varios prestamos activos</div>";
		}else if(daoL.countEjemplaresDisponibles(libro) <= 3){
			mensaje = "<div class=\" alert alert-warning\"> Na hay ejemplares para prestar de "
				+ libro.getNombre() +"</div>";
		}else{
			if(daoP.nuevoPrestamo(usuario, libro, 3, true)){ //mysql
				mensaje = "<div class=\" alert alert-info\"> Prestamo agregado</div>";
			}
			else{
				mensaje = "<div class=\" alert alert-warning\"> error al agregar prestamo</div>";
			}
		}
		
		}catch(Exception ex){
			mensaje = "<div class=\" alert alert-danger\"> ERROR </div>";
		}
		
		
		
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			out.println(mensaje);
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
