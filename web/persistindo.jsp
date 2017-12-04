
<%@page import="modelo.Usuario"%>
<%-- 
    Document   : index
    Created on : 27/05/2011, 08:47:19
    Author     : SONY
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="util.HibernateUtil"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuários</title>
    </head>
    <body>
        <h1>Persistindo Usuário</h1>
        <%
                    EntityManager manager = HibernateUtil.getManager();
                    Usuario usu = new Usuario();
                    usu.setLogin("data");
                    usu.setNome("data");
                    usu.setDatanascimento(DateFormat.getDateInstance().parse(("23/05/1984")));
                    usu.setObservacoes("data");
                    usu.setSenha("data");


                    manager.getTransaction().begin();
                    manager.persist(usu);
                    manager.getTransaction().commit();
                    manager.close();

        %>
    </body>
</html>
