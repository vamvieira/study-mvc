<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>Body</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="comment" items="${comments}">
        <tr>
            <td>${comment.id}</td>
            <td>${comment.body}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
