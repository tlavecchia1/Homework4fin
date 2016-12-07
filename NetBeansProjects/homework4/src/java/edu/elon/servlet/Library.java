/*
    (c) Ryan Kugel and Tyler LaVecchia 2016
 */

package edu.elon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.elon.business.Book;
import edu.elon.sql.DBLib;

import java.util.ArrayList;

public class Library extends HttpServlet {
    
@Override
protected void doPost(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {

String url = "/FirstPage.jsp";    
Book book = null;
String action = request.getParameter("action");

if (action == null) {
      action = "join";
    }
    
    if (action.equals("join")) {
      url = "/FirstPage.jsp";
    }
    
    if (action.equals("goToItems")) {
      url = "/Items.jsp";
    }
    if (action.equals("doCheckIn")) {
        String id = request.getParameter("id");
        DBLib.delete(id);
        ArrayList<Book> books = DBLib.selectBook();
        request.setAttribute("books", books);
        System.out.println("books" + books);
        url = "/bookCheckout.jsp";
    }
    if (action.equals("goToBooks")) {
        ArrayList<Book> books = DBLib.selectBook();
        request.setAttribute("books", books);
        url = "/bookCheckout.jsp";
         
    }
    else if (action.equals("addBook")) {
      String firstName = request.getParameter("firstName");
      String lastName = request.getParameter("lastName");
      String email = request.getParameter("emailAddress");
      String title = request.getParameter("bookTitle");
      
      book = new Book(firstName, lastName, email, title);
      url = "/returnMessage.jsp";
      DBLib.insert(book);
    }
    
    request.setAttribute("book", book);
  
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
