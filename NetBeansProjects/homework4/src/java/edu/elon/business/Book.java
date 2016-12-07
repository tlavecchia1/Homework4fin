/*
    (c) Ryan Kugel and Tyler LaVecchia 2016
 */

package edu.elon.business;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;



public class Book implements Serializable{
    private String bookTitle;
    private Integer bookID;    
    private String firstName;
    private String lastName;   
    private String email;   
    private Date dateDue;       
    private Boolean isOverdue; 
    private java.sql.Date date;


    public Book(){
        firstName = "";
        lastName = "";
        email = "";
        bookTitle = "";
        isOverdue = false;
        dateDue = null;
        bookID = null;
    }
    
    public Book(String firstName, String lastName, String email, String bookTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.bookTitle = bookTitle;
    
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.add(Calendar.WEEK_OF_YEAR, 2);
        this.dateDue = calendar.getTime();
    }
    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

 
    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmailAddress() {
        return email;
    }


    public void setEmailAddress(String emailAddress) {
        this.email = emailAddress;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    

    public Date getDateDue(){
        return dateDue;
    }
    
    
    public void setDateDue(Date dateDue){
        this.dateDue = dateDue;
    }

    public Date setSQLDate(Date dateDue) {
        date = new java.sql.Date(dateDue.getTime());
        return date;
    }
  
    public Integer getId(){
        return bookID;
    }

    public void setId(Integer bookID){
        this.bookID = bookID;
    }
    

    public Boolean getOverDue() {
        return isOverdue;
    }


    public void setOverDue(String overdue) {
        this.isOverdue = isOverdue;
    }
    
}