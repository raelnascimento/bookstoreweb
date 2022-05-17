<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="./contents/headerTags.jsp"/>

        <title>Aplicação BookStoreWeb</title>
    </head>
    <body>
        <div class="container"> 
            <jsp:include page="./contents/cabecalhoUser.jsp"/>
            
            <div class="responsive">
                <table class="table table-hover">
                    <caption><h2>List of Users</h2></caption>
                    <tr>
                        <th>ID</th>
                        <th>Fullname</th>
                        <th>Email</th>
                    </tr>

                    <c:forEach var="user" items="${listaUser}">
                        <tr>
                            <td><c:out value="${user.id}" /></td>
                            <td><c:out value="${user.fullname}" /></td>
                            <td><c:out value="${user.email}" /></td>
                            <!--<td>
                                <a href="<%=request.getContextPath()%>/bsuser/edit?id=<c:out value='${book.id}'/>">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </a>

                            </td>-->
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <jsp:include page="./contents/rodape.jsp"/>
        </div>

    </body>
</html>