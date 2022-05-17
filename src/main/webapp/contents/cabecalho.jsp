<%-- 
    Document   : cabecalho
    Created on : 25 de abr de 2022, 13:50:47
    Author     : KGe
--%>

<!-- Inicio cabecalho-->
<div class="jumbotron"><h1>BookStoreWeb</h1></div>


<p>
    <a href="<%=request.getContextPath()%>/index.html" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus"></span>Logout</a>

</p>
<p>
    <a href="<%=request.getContextPath()%>/bstore/new" class="btn btn-primary">
        <span class="glyphicon glyphicon-plus"></span>Adicionar novo Livro</a>

        <a href="<%=request.getContextPath()%>/bstore/list" class="btn btn-default">
        <span class="glyphicon glyphicon-th-list"></span>
        Lista todos Livros</a>
        
        <a href="<%=request.getContextPath()%>/bsuser/list" class="btn btn-default">
        <span class="glyphicon glyphicon-th-list"></span>
        Lista todos Usuários</a>
</p>

<!-- Fim cabecalho-->