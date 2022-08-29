<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
<%--    <form:hidden path="id"/>--%>
    isbn:
    <form:input path="isbn"/>
    <form:errors path="isbn" cssClass="error-class"/>
    title:
    <form:input path="title"/>
    <form:errors path="title" cssClass="error-class"/>
    author:
    <form:input path="author"/>
    <form:errors path="author" cssClass="error-class"/>
    publisher:
    <form:input path="publisher"/>
    <form:errors path="publisher" cssClass="error-class"/>
    type:
    <form:input path="type"/>
    <form:errors path="type" cssClass="error-class"/>
    <input type="submit" value="submit">

</form:form>
</body>
</html>