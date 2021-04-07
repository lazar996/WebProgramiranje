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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if (loggedInUser == null) {
			response.sendRedirect("./Login.jsp");
			return;
		}
		else {
			response.sendRedirect("./Home");
			return;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getSession().invalidate();
		
		HttpSession session = request.getSession();
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String message = "korisnicko ime ili sifra nisu dobri!";
		request.setAttribute("PogresanUnos", message);
		
		User user = UserDAO.get(username);
		if (user == null) {
			request.getRequestDispatcher("./Login.jsp").forward(request, response);
			return;
		}
		if (!user.getPassword().equalsIgnoreCase(password)) {
			request.getRequestDispatcher("./Login.jsp").forward(request, response);
			return;
		}
		
		
		session.setAttribute("loggedInUser", user);
		response.sendRedirect("./Home");
	}
}
