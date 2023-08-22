package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.MyDao;
import dto.CoustomerSignUp;

@WebServlet("/signup")
@MultipartConfig
public class Signup extends HttpServlet {
	@Override
	// When there is form and we get data to be secured so we will go for doPost
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Receive values from Front End
		String user = req.getParameter("user");
		String pass = req.getParameter("pass");
		String email = req.getParameter("email");
		long phno = Long.parseLong(req.getParameter("phno"));
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		String gender = req.getParameter("gender");
		String pro = req.getParameter("country");
		int age = Period.between(dob, LocalDate.now()).getYears();

		Part pic = req.getPart("picture");
		byte[] picture = null;
		picture = new byte[pic.getInputStream().available()];
		pic.getInputStream().read(picture);
		
		MyDao dao=new MyDao();
		
		if (dao.fetchByEmail(email)==null && dao.fetchByMobile(phno)==null) {
			//loading values inside object
			CoustomerSignUp c=new CoustomerSignUp();
			c.setAge(age);
			c.setDob(dob);
			c.setEmail(email);
			c.setFullname(user);
			c.setGender(gender);
			c.setMobile(phno);
			c.setPassword(pass);
			c.setPicture(picture);
			
			dao.save(c);
			
			resp.getWriter().print("<h1 style='color:green'>Account Created Successfully</h1>");
			
		} else {
			resp.getWriter().print("<h1 style='color:green'>Email And Mobile Number Shoubld BE Unique</h1>");

		}
		
	}
	

}
