<!--
(c) Ryan Kugel and Tyler LaVecchia 2016
-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section>
        <p>
           <span>Thank you for your patronage of the Belk Library. You've 
               successfully checked out the book, </span>
           <span>${book.bookTitle}.</span>
           <span> Please note that this book is due back on </span>
           <span>${book.dateDue}.</span>
           <span> A friendly email reminder will be sent to you if your book 
               becomes overdue.</span>
        </p>
        <p><a href="library?action=goToIndex&amp;">Return to front page</a></p>
    </section>
           
           
<c:import url="/includes/footer.jsp" />