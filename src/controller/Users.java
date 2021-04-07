package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UserDAO;
import model.User;
import model.User.Role;

/**
 * Servlet implementation class Users
 */
@WebServlet("/Users")
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		List<User> users = UserDAO.getAllUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher("Users.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchInput = request.getParameter("searchInput");
		searchInput = searchInput.trim();
		HttpSession session = request.getSession();
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		List<User> users = UserDAO.getAllUsers();
	
		String action = request.getParameter("action");

		if (loggedInUser.getRole() == Role.admin && action != null) {

		switch (action) {
		
		case "asc":
			
			users = UserDAO.getAsc();
			break;
		case "desc":
			users = UserDAO.getDesc();
			break;	

			
		}}
		
		
		String usernameFilter = request.getParameter("usernameFilter");
	

		if (usernameFilter != null) {
			List<User> toRemove = new ArrayList<>();
			for (User user : users) {
				if (!(user.getUsername().toLowerCase().contains(searchInput.toLowerCase()))) {
					toRemove.add(user);
				}
			}
			users.removeAll(toRemove);
		}


		if (usernameFilter == null) {
			List<User> toRemove = new ArrayList<>();
			
			for (User user : users) {
				if (!(user.getUsername().toLowerCase().contains(searchInput.toLowerCase()))) {
					toRemove.add(user);
				}
			}
			users.removeAll(toRemove);
		}
				
		request.setAttribute("users", users);
		request.getRequestDispatcher("Users.jsp").forward(request, response);
	}

	
	}


