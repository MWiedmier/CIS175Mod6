package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Fish;

/**
 * Servlet implementation class EditFishServlet
 */
@WebServlet(name = "editFishServlet", urlPatterns = { "/editFishServlet" })
public class EditFishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFishServlet() {
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
		
		String species = request.getParameter("species"); 
		String amount = request.getParameter("amount"); 
		Integer tempId = Integer.parseInt(request.getParameter("id")); 
		
		Fish fishToUpdate = dao.searchForFishById(tempId); 
		fishToUpdate.setSpecies(species); 
		fishToUpdate.setNumOfFish(Integer.parseInt(amount)); 
		
		dao.updateFish(fishToUpdate); 
		
		getServletContext().getRequestDispatcher("/viewAllFishServlet").forward(request, response);
	}

}
