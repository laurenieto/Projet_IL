<%-- 
    Document   : list_courses
    Created on : Jan 16, 2017, 7:50:54 PM
    Author     : laure
--%>

<%@page import="com.sun.jersey.api.client.Client,com.sun.jersey.api.client.WebResource"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage students' travels</title>
    </head>
    <body>
        <%!String id_student; String username;%>
        <h1 align="center"> <font face="Courier" </font>Manage students' travels</h1>

     
          <h2>Choose your course</h2>
          <%
                String id_univ = request.getParameter("id_univ");
                Client cl = Client.create();
                WebResource r = cl.resource("http://localhost:8080/TestAppDBWebApp/resources/listCourse?id_univ="+id_univ);

                id_student = r.get(String.class);

                System.out.println("|"+r.get(String.class)+"|");

                 // ATTENTION CODE DEGUEULASSE
                String chaine = r.get(String.class);
                String[] c = chaine.split("=");
                Integer taille = Integer.parseInt(c[0]);
                //////////////

                parser.Table_Course[] Table = new parser.Table_Course[taille] ;

                // PARSING !
                Table = parser.ParserCours.parse(r.get(String.class));

                if (Table != null) {

                    for(parser.Table_Course univ : Table)
                        {out.println(univ.getCourseName()+" | "+univ.getNbHours());}}

          %>
     

    </body>
</html>
