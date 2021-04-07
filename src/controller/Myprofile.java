package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UserDAO;
import model.User;


/**
 * Servlet implementation class MyProfile
 */
@WebServlet("/Myprofile")
public class Myprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Myprofile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		
		if (loggedInUser != null) {
			
			User users = UserDAO.get(loggedInUser.getUsername());
			
			request.setAttribute("users", users);
			request.getRequestDispatcher("Myprofile.jsp").forward(request, response);
			
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		User loggedInUser = (User) session.getAttribute("loggedInUser");

		String message = "";
		String action = request.getParameter("action");
		switch (action) {

		case "info":

			String username = request.getParameter("username");

			loggedInUser.setUsername(username);

			UserDAO.update(loggedInUser, loggedInUser.getId());

			message = "Korisnicko ime je uspesno promenjeno";
			break;

		case "password":

			String newPassword = request.getParameter("newPassword");
			loggedInUser.setPassword(newPassword);
			UserDAO.update(loggedInUser, loggedInUser.getId());
			break;
		}

		request.setAttribute("aerodroms", message);
		request.getRequestDispatcher("./Myprofile.jsp").forward(request, response);
	}

}
