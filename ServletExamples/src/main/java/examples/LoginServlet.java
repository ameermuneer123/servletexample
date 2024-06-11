package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		PrintWriter writer=response.getWriter();
//		writer.printf(email);
//		writer.printf(password);
		if(email.equals("admin@gmail.com")&&password.equals("admin123")) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("AdminServlet");
			dispatcher.forward(request, response);
		}
		else {
			
			writer.print("Incorrect email or password! Try again");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("/login.html");
			requestDispatcher.include(request, response);
		}
	}

}
