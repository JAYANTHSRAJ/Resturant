package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyDao;
import dto.CoustomerSignUp;

//maping the url
@WebServlet(urlPatterns = "/Login")

public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Reciving values from Front-end
		
		String email = req.getParameter("email");
		String Password = req.getParameter("pswrd");

		// verifying if email exist

		MyDao dao = new MyDao();
		CoustomerSignUp Coustomer = dao.fetchByEmail(email);
		if (Coustomer == null) {
			resp.getWriter().print("<h1 style='color:red'>Inavlid Email</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);

		} else {
			if(Password.equals(Coustomer.getPassword())) {
				resp.getWriter().print("<h1 style='color:red'>Login Successful</h1>");
				req.getRequestDispatcher("HOME.html").include(req, resp);
				
			}else {
				//if response should be in both text and html 
			//	resp.setContentType("text/html");
				resp.getWriter().print("<h1 style='color:red'>Inavlid Password</h1>");
				req.getRequestDispatcher("login.html").include(req, resp);
			}

		}
	}
}
