<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Comment</title>
</head>
<body>
<c:if test="${addCommentSuccess}">
    <h3>Cadastro efetuado com sucesso com id: ${commentId}</h3>
</c:if>

<c:url var="add_comment_url" value="/comments/addComment"/>
<form:form modelAttribute="comment" action="${add_comment_url}" method="post">
    <form:label path="id">Id:</form:label><br>
    <form:input type="text" path="id"/><br>

    <form:label path="body">Body:</form:label><br>
    <form:input type="text" path="body"/><br>


    <input type="submit" value="Enviar"/>
</form:form>
</body>
</html>