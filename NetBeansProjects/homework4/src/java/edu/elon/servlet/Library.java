/*
    (c) Ryan Kugel and Tyler LaVecchia
 */
package edu.elon.servlet;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import edu.elon.data.BookDB;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Library extends HttpServlet {
    
 @Override
protected void doPost(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {

String url = "/FirstPage.jsp";    
String action = request.getParameter("action");

if (action == null) {
      action = "join";
    }
    
    if (action.equals("join")) {
      url = "/FirstPage.jsp";
    }
    /*
    if (action.equals("display_checkout")) {
        url = "/Checkout.jsp";
    }
    if (action.equals("display_cart")) {
        ArrayList<Book> books = BookDB.selectBooks();
        request.setAttribute("books", books);
        url = "/Cart.jsp";
    }
    if (action.equals("delete")) {
    }
    */
    /*
    else if (action.equals("add")) {
      String firstName = request.getParameter("firstName");
      String lastName = request.getParameter("lastName");
      String email = request.getParameter("email");
      String title = request.getParameter("title");
      
      book = new Book(firstName, lastName, email, title);
      url = "/Return.jsp";
      BookDB.insert(book);
    }
    
    request.setAttribute("book", book);
    */
    getServletContext().getRequestDispatcher(url)
	    .forward(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request,
	  HttpServletResponse response)
	  throws ServletException, IOException {
    doPost(request, response);
  }
}
