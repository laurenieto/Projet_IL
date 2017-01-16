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

     
          <h2>Hello <%out.print(username);%></h2>
          <%

                Client cl = Client.create();
                WebResource r = cl.resource("http://localhost:8080/TestAppDBWebApp/resources/apply?username="+username+"&password="+password);

                id_student = r.get(String.class);

          %>
        <form action="" method="POST">
            <h3> Search a university (by name) </h3> <br> Please let an empty field to display all universities.<br><br>
            <input type="text" name="univ" />
            <input type="SUBMIT" value="OK"/>
        </form>


           <%

            if (request.getParameter("univ") != null) {


                String param = request.getParameter("univ");

                Client c1_univ = Client.create();
                WebResource r_univ = c1_univ.resource("http://localhost:8080/TestAppDBWebApp/resources/univ?name="+param);

                System.out.println("|"+r_univ.get(String.class)+"|");

                 // ATTENTION CODE DEGUEULASSE
                String chaine = r_univ.get(String.class);
                String[] c = chaine.split("=");
                Integer taille = Integer.parseInt(c[0]);
                //////////////

                parser.Table_Course[] Table = new parser.Table_Course[taille] ;

                // PARSING !
                Table = parser.ParserCours.parse(r_univ.get(String.class));


                if (Table != null) {

                    for(parser.Table_Course cours : Table)
                        {
                           %>
            <form action="univ_response.jsp" method="get" target="_blank" >
                <%out.println(cours.getCourseName()+" | "+cours.getNbHours());%>
                <input name=<%out.print(cours.getId());%> type="submit" value="Apply">
                <input type="hidden"  name="id_student" value=<%out.print(id_student);%>>
                <input type="hidden"  name="id_univ" value=<%out.print(univ.getId());%>>
                <input type="hidden"  name="insert_appliance" value="1">
            </form>
                <%

                        }
                    }
                }
        %>
        <br/><br/><br/><br/>
        <form action="" method="POST">
            Display universities which accept my appliance<input name="refresh_button" type="submit" value="Display">
            <input type="hidden"  name="id_student" value=<%out.print(id_student);%>>
            <input type="hidden"  name="username" value=username>
        </form>
        <%
        if (request.getParameter("refresh_button") != null) {
            username = request.getParameter("username");
            id_student = request.getParameter("id_student");
            r = cl.resource("http://localhost:8080/TestAppDBWebApp/resources/seeAcceptUniv?id_student="+id_student);
            out.print(r.get(String.class));
        }
        %>
    </body>
</html>