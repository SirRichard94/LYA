/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utez.app.web.editorial;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utez.app.daos.DaoEditorial;
import utez.app.daos.DaoEjemplar;
import utez.app.daos.DaoUsuario;
import utez.app.model.EditorialBean;
import utez.app.model.EjemplarBean;
import utez.app.model.UsuarioBean;
import utez.app.web.eq4.util.DbConnection;

/**
 *
 * @author ricardo
 */
public class ServletEliminarEditorial extends HttpServlet {

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
		try{
		
		HttpSession sesion = request.getSession();
		if ((Boolean)sesion.getAttribute("admin") == false || (Boolean) sesion.getAttribute("admin") == null){
			throw new ServerException("Acceso denegado");
		}
		}catch (NullPointerException ex){
			throw new ServerException("Acceso denegado");
		}
		
		Connection con = DbConnection.getConnection();
		if (con == null){
			throw new ServerException("No hay coneccion con la BD");
		}
		
		// Eliminar logica
		int id = Integer.parseInt(request.getParameter("i"));
		DaoEditorial dao = new DaoEditorial(con);
		
		EditorialBean bean = dao.get(id);
		bean.setAlta(false);
		
		//
		 
		String mensaje;
		if (dao.update(bean)){
			request.setAttribute("info", "Ha sido eliminada con exito");
			
		} else{
			request.setAttribute("warning", "Error al eliminar Editorial");
			
		}
		
		//this.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
		
		String pagina = response.encodeRedirectURL("admin.jsp");
		response.sendRedirect(pagina);
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
