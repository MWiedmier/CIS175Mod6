package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Fish;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet(name = "navigationServlet", urlPatterns = { "/navigationServlet" })
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FishHelper dao = new FishHelper();
		String act = request.getParameter("doThisToFish"); 

		String path = "/viewAllFishServlet"; 
		if (act.equals("delete")) { 
			try { 
				Integer tempId = Integer.parseInt(request.getParameter("id")); 
				Fish fishToDelete = dao.searchForFishById(tempId); 
				dao.deleteItem(fishToDelete); 
			} catch (NumberFormatException e) { 
				System.out.println("Forgot to select a fish"); 
			}  
		} else if (act.equals("edit")) { 
			try { 
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Fish fishToEdit = dao.searchForFishById(tempId); 
				request.setAttribute("fishToEdit", fishToEdit); 
				path = "/edit-fish.jsp"; 
			} catch (NumberFormatException e) { 
				System.out.println("Forgot to select a fish"); 
			} 
		} else if (act.equals("add")) { 
		path = "/index.html"; 
		} 
		getServletContext().getRequestDispatcher(path).forward(request, response); 
	}

}
