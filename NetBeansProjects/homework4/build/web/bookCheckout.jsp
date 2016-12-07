<!--
(c) Ryan Kugel and Tyler LaVecchia 2016
-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />

    <section>
        <h2>Currently Checked out Books</h2>
        <table id="checkedOut">
            <tr id='table_header'>
                <th>Patron Name</th>
                <th></th>
                <th>Email Address</th>
                <th></th>
                <th>Book Title</th>
                <th></th>
                <th>Due Date</th>
                <th></th>
                <th>Overdue</th>
                <th></th>
            </tr>
                           
            <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.firstName} ${book.lastName}</td>
                    <td></td>
                    <td>${book.emailAddress}</td>
                    <td></td>
                    <td>${book.bookTitle}</td>
                    <td></td>
                    <td>${book.dateDue}</td>
                    <td></td>
                    <td>${book.overDue}</td>
                    <td></td>
                    <td>
                        <form method="post" action="library">        
                            <input type="hidden" name="action" value="doCheckIn">
                             <input type="hidden" name="userID" value="${book.id}">
                            <input type="submit" value="Check in" id="checkin"> 
                        </form>
                    </td>    
                </tr>
            </c:forEach>
        
            
        </table>
        
        <p><a href="library?action=join"><b>Return to front page</b></a></p>
    </section>

<c:import url="/includes/footer.jsp" />