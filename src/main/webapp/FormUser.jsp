<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="./contents/headerTags.jsp"/>
        <title>Aplicação Books Store</title>
    </head>
    <body>
        <div class="container">
            <%--<jsp:include page="./contents/cabecalhoAdd.jsp"/>--%>
            <div class="responsive">
                <div align="left">
                    
                        <form action="<%=request.getContextPath()%>/bsuser/register" method="post">
              
                            <table class="table ">
                                <caption>    
                                    <h2> 
                                        Adicionar novo Usuario
                                    </h2>    
                                </caption>
                                <c:if test="${user != null}">
                                    <input type="hidden" name="formId" value="<c:out value='${user.id}' />" />
                                </c:if>
                                <tr>
                                    <th>Fullname: </th>
                                    <td>
                                        
                                        <input type="text" name="formFullname" size="45" value="<c:out value='${user.fullname}' />"
                                               />
                                    </td>
                                </tr>
                                <tr>
                                    <th>Email:</th>
                                    <td>
                                        <input type="text" name="formEmail" size="45" value="<c:out value='${user.email}' />"
                                               />
                                    </td>
                                </tr>
                                <tr>
                                    <th>Password: </th>
                                    <td>
                                        <input type="text" name="formPassword" size="5" value="<c:out value='${user.password}' />"
                                               />
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center">
                                        <button type="submit">
                                            <span class="glyphicon glyphicon-send"></span> Enviar 
                                        </button>

                                    </td>

                                </tr>
                            </table>
                        </form>
                </div>
            </div>
            <jsp:include page="./contents/rodape.jsp"/>
        </div>
    </body>
</html>