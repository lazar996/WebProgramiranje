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
import model.User.Role;

/**
 * Servlet implementation class UserSingle
 */
@WebServlet("/UserSingle")
public class UserSingle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserSingle() {
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
		String username = request.getParameter("username");
		User user = UserDAO.get(username);

		if (user == null) {
			response.sendRedirect("./Home");
			return;
		}
		if (loggedInUser != null && loggedInUser.getUsername().toLowerCase().equals(user.getUsername().toLowerCase())) {
			response.sendRedirect("./Myprofile.jsp");
			return;
		}

		request.setAttribute("user", user);
		request.getRequestDispatcher("./UserSingle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		session.removeAttribute("messageUPanel");
		session.removeAttribute("messageFailUPanel");

		User loggedInUser = (User) session.getAttribute("loggedInUser");

		String action = request.getParameter("action");

		String username = request.getParameter("username");
		User user = UserDAO.get(username);

	
		

		if (loggedInUser.getRole() == Role.admin) {

			
			switch (action) {

			case "ban":
				user.setBlokiran(true);
				UserDAO.update(user, user.getId());
				break;
			case "unban":
				user.setBlokiran(false);
				UserDAO.update(user, user.getId());
				break;
			case "delete":
				UserDAO.delete(user.getId());
				response.sendRedirect("./Users");
				return;

			case "admin":
				user.setRole(Role.admin);
				UserDAO.update(user, user.getId());
				break;

			}

		}

		response.sendRedirect("./UserSingle?username=" + user.getUsername());
	}
}
