/*
    (c) Ryan Kugel and Tyler LaVecchia 2016
 */

package edu.elon.sql;


import edu.elon.business.Book;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DBLib {
    

    public static int insert(Book book) {
        PreparedStatement ps = null;

        String query
                = "INSERT INTO member (first_name, last_name, email_address, book_title, due_date)"
                + "VALUES (?, ?, ?, ?, ?)";
        
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection connection = cp.getConnection();
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, book.getFirstName());
            ps.setString(2, book.getLastName());
            ps.setString(3, book.getEmailAddress());
            ps.setString(4, book.getBookTitle());
            ps.setDate(5, (Date) book.setSQLDate(book.getDateDue()));
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(connection);
        }
    }
    public static int update(Book book) {
          ConnectionPool pool = ConnectionPool.getInstance();
          Connection connection = pool.getConnection();
          PreparedStatement ps = null;

          String query = "UPDATE tylerspace SET" + "FirstName = ?, " + "LastName = ?, "
                  + "Email = ?, " + "Title = ? + DueDate = ?";
          try {
              ps = connection.prepareStatement(query);
              ps.setString(1, book.getFirstName());
              ps.setString(2, book.getLastName());
              ps.setString(3, book.getEmailAddress());
              ps.setString(4, book.getBookTitle());
              

              return ps.executeUpdate();
          } catch (SQLException e) {
              System.out.println(e);
              return 0;
          } finally {
              DBUtil.closePreparedStatement(ps);
              pool.freeConnection(connection);
          }
      }
 
    
    public static int delete(String bookID) {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection connection = cp.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM member" + "WHERE id = ?";
        
        try {
            ps = connection.prepareStatement(query);
            Integer identification = Integer.parseInt(bookID);
            ps.setInt(1, identification);
            //ps.setString(1, identity.toString());
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(connection);
        }
    }

    public static ArrayList<Book> selectBook() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection connection = cp.getConnection();
        
        String query = "SELECT * FROM member";
        
        try {
            
            String dbURL = "jdbc:mysql://localhost:3306/library";
            String username = "root";
            String password = "mysqluser";
            
          /*  String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
            if((host != null) && (host.trim().length() > 1)){
                String port  = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
                String appname = System.getenv("OPENSHIFT_APP_NAME");
                username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
                password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
                dbURL = "jdbc:mysql://" + host + ":" + port + "/" + appname;
            }
            */
            
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Book> books = new ArrayList<>();
            
            while (rs.next()){
                Book book = new Book();
                book.setFirstName(rs.getString("first_name"));
                book.setLastName(rs.getString("last_name"));
                book.setEmailAddress(rs.getString("email_address"));
                book.setBookTitle(rs.getString("book_title"));
                book.setDateDue(rs.getDate("due_date"));
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(connection);
        }
    }
    
}