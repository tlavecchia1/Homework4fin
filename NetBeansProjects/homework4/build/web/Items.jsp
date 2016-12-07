<!--
(c) Ryan Kugel and Tyler LaVecchia 2016
-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.jsp" />

<section>
        <h2>Checkout a book</h2>
        
        <form method="post" action="library">
            <input type="hidden" name="action" value="addBook">
            <table>
                <tr>
                    <td><label>First Name:</label></td>
                    <td><input type="text" name="firstName" value="${book.firstName}" required></td>
                </tr>
                <tr>
                    <td><label>Last Name:</label></td>
                    <td><input type="text" name="lastName" value="${book.lastName}" required></td>
                </tr>
                <tr>
                    <td><label>Email Address: </label></td>
                    <td><input type="email" name="emailAddress" value="${book.emailAddress}" required></td>
                </tr>
                <tr>
                    <td><label>Book Title:</label></td>
                    <td><input type="text" name="bookTitle" value="${book.bookTitle}" required></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Checkout" id="checkout"></td>
                </tr>
            </table>
        </form>
    </section>

<c:import url="/includes/footer.jsp" />