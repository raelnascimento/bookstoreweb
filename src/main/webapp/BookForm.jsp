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
            <jsp:include page="./contents/cabecalhoAdd.jsp"/>
            <div class="responsive">
                <div align="left">
                    <c:if test="${book != null}">
                        <form action="update" method="post">
                        </c:if>
                        <c:if test="${book == null}">
                            <form action="insert" method="post">
                            </c:if>
                            <table class="table ">
                                <caption>    
                                    <h2> 
                                        <c:if test="${book != null}">
                                            Editar Livro

                                        </c:if>
                                        <c:if test="${book == null}">
                                            Adicionar novo Livro
                                        </c:if>
                                    </h2>    
                                </caption>
                                <c:if test="${book != null}">
                                    <input type="hidden" name="formId" value="<c:out value='${book.id}' />" />
                                </c:if>
                                <tr>
                                    <th>Titulo: <span class="glyphicon glyphicon-book"></span></th>
                                    <td>
                                        
                                        <input type="text" name="formTitulo" size="45" value="<c:out value='${book.titulo}' />"
                                               />
                                    </td>
                                </tr>
                                <tr>
                                    <th>Autor: <span class="glyphicon glyphicon-user"></span></th>
                                    <td>
                                        <input type="text" name="formAutor" size="45" value="<c:out value='${book.autor}' />"
                                               />
                                    </td>
                                </tr>
                                <tr>
                                    <th>Preco: <span class="glyphicon glyphicon-usd"></span></th>
                                    <td>
                                        <input type="text" name="formPreco" size="5" value="<c:out value='${book.preco}' />"
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