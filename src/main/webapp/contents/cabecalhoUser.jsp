<%-- 
    Document   : cabecalhoUser
    Created on : 10 de mai de 2022, 16:00:59
    Author     : devsys-a
--%>

<div class="jumbotron"><h1>Usu�rio</h1></div>



<p>
    <a href="<%=request.getContextPath()%>/bsuser/new" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus"></span>Adicionar novo Usu�rio</a>

        <a href="<%=request.getContextPath()%>/bsuser/list" class="btn btn-default">
        <span class="glyphicon glyphicon-th-list"></span>
        Lista todos Usu�rios</a>
</p>
