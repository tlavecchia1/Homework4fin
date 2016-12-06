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
}
