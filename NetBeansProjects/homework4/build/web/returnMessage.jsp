<%--
2016 Tyler LaVecchia and Ryan Kugel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section>
        <p>
           <span>Thank you for your patronage of the Belk Library. You've 
               successfully checked out the book, </span>
           <span>${user.bookTitle}.</span>
           <span> Please note that this book is due back on </span>
           <span>${user.dueDate}.</span>
           <span> A friendly email reminder will be sent to you if your book 
               becomes overdue.</span>
        </p>
        <p><a href="library?action=goToIndex&amp;">Return to front page</a></p>
    </section>