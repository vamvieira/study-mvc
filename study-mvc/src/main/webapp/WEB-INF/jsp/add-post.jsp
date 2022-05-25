<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Adicionar Post</title>
</head>
<body>
<c:if test="${addPostSuccess}">
    <h3>Cadastro efetuado com sucesso com id: ${postId}</h3>
</c:if>

<c:url var="add_post_url" value="/view/addPost"/>
<form:form modelAttribute="post" action="${add_post_url}" method="post">
    <form:label path="id">Id:</form:label><br>
    <form:input type="text" path="id"/><br>

    <form:label path="author">Autor:</form:label><br>
    <form:input type="text" path="author"/><br>

    <form:label path="title">Título:</form:label><br>
    <form:input type="text" path="title"/><br><br>

    <input type="submit" value="Enviar"/>
</form:form>
</body>
</html>