package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.LoginService;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/start")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/Start.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginService loginService = new LoginService();
		
		String userId, password;
		
		userId = request.getParameter("userId");
		password = request.getParameter("password");
		
		if(!loginService.authenticate(userId, password)) {
			request.setAttribute("error", "Die Eingabe war nicht korrekt. Probieren Sie es erneut!");
			RequestDispatcher rd = request.getRequestDispatcher("/Start.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("userId", userId);
			request.setAttribute("password", password);
			RequestDispatcher rd = request.getRequestDispatcher("/Success.jsp");
			rd.forward(request, response);
		}	
		
//		doGet(request, response);
	}	

}
