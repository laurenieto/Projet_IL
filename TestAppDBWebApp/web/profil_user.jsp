<%-- 
    Document   : after_submit
    Created on : Jan 11, 2017, 8:58:51 AM
    Author     : laure
--%>
<%@page import="com.sun.jersey.api.client.Client,com.sun.jersey.api.client.WebResource"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Hello !</h1>

         <%
            int id = 1;
            String id_univ = String.valueOf(id);
            String username = request.getParameter("username_");
            String password = request.getParameter("password_");

            Client cl = Client.create();
            WebResource r = cl.resource("http://localhost:8080/TestAppDBWebApp/resources/apply?username="+username+"&password="+password);

            String id_student = r.get(String.class);
          
          
         %>


         <p>
        <form action="profil_user.jsp" method="POST">
            <h2> Recherche une université (par nom) : </h2> <br> Laissez le champ vide pour afficher toutes les universités.<br><br>

            <input type="text" name="univ" />
            <input type="SUBMIT" value="OK"/>
        </form>
        <br>

           <%
            out.println("coucou");
            if (request.getParameter("univ") != null) {
                out.println("coucou");
                
                String param = request.getParameter("univ");

                Client c1_univ = Client.create();
                WebResource r_univ = c1_univ.resource("http://localhost:8080/TestAppDBWebApp/resources/univ?name="+param);

                System.out.println("|"+r_univ.get(String.class)+"|");

                 // ATTENTION CODE DEGUEULASSE
                String chaine = r_univ.get(String.class);
                String[] c = chaine.split("=");
                Integer taille = Integer.parseInt(c[0]);
                //////////////

                parser.Table_Univ[] Table = new parser.Table_Univ[taille] ;

                // PARSING !
                Table = parser.ParserLolo.parse(r_univ.get(String.class));
                System.out.println("pascal");

                if (Table != null) {

                    for(parser.Table_Univ univ : Table)
                        {
                           System.out.println(univ);
                           out.println(univ.getName()+" | "+univ.getCountry());
                           %><br><%
                        }
                }
             }

            %>

        </p>
         
         <form action="univ_response.jsp" method="get" target="_blank">
            <input name="apply_button" type="submit" value="Apply">
            <input type="hidden"  name="id_univ" value=<%out.print(id_univ);%>>
            <input type="hidden"  name="id_student" value=<%out.print(id_student);%>>
        </form>

        <form action="" method="get">
            <input name="refresh_button" type="submit" value="Refresh">
            <input type="hidden"  name="id_student" value=<%out.print(id_student);%>>
        </form>
        <%
         
        if (request.getParameter("refresh_button") != null) {
            id_student = request.getParameter("id_student");
            r = cl.resource("http://localhost:8080/TestAppDBWebApp/resources/seeAcceptUniv?id_student="+id_student);
            out.print(r.get(String.class));
        }
        %>
    </body>
</html>
