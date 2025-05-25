package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/seasonurl")
public class SeasonFinderServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//set the content type
		resp.setContentType("text/html");
		
		//get PrintWriter
		PrintWriter pw = resp.getWriter();
		
		//get system time
		LocalDateTime idt = LocalDateTime.now();
		
		//get current month value
		int month = idt.getMonthValue();

		//get season
		String seasonName = null ;
		if(month >=3 && month <=6) {
			seasonName = "Summer Season";
		}
		else if(month >6 && month>=11) {
			seasonName = "Rainy Season";
		}
		else {
			seasonName = "Winter Season";
		}
		
		//write result / output to the browser 
		pw.println("<h1 style='color:cyan ; text-align:center'>" + seasonName +"</h1>");
		
		//add home hyperlink  	
		pw.println("<h1 style='text-align:center' ><a href='index.jsp' > Home <img src='images/home.jpeg' width='50' height='50'></a></h1>");
		
		//close stream
		pw.close();
		
		
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
