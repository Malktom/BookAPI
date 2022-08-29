<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
<a href="<c:url value="/admin/books/add"/>">add book</a>
<table border="1">
    <thead>
    <th>isbn</th>
    <th>title</th>
    <th>author</th>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>

            <td>
                <a href="<c:url value="/admin/books/delete/${book.id}"/>">delete</a>
                <a href="<c:url value="/admin/books/edit/${book.id}"/>">edit</a>
                <a href="<c:url value="/admin/books/show/${book.id}"/>">show details</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

