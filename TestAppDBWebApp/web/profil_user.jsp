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
        <title>Manage students' travels</title>
    </head>
    <body>
        <%!String id_student; String username;%>
        <h1 align="center"> <font face="Courier" </font>Manage students' travels</h1>
   
         <%
            username = request.getParameter("username_");
            String password = request.getParameter("password_");
          %>
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

                
                String chaine = r_univ.get(String.class);
                String[] c = chaine.split("=");
                Integer taille = Integer.parseInt(c[0]);
                //////////////

                parser.Table_Univ[] Table = new parser.Table_Univ[taille] ;

                // PARSING !
                Table = parser.ParserLolo.parse(r_univ.get(String.class));
               

                if (Table != null) {

                    for(parser.Table_Univ univ : Table)
                        {
                           %>
            <form action="univ_response.jsp" method="get" target="_blank" >
                <%out.println(univ.getName()+" | "+univ.getCountry());%>
                <input name=<%out.print(univ.getId());%> type="submit" value="Apply">
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
            Display universities which accepted my appliance<input name="refresh_button" type="submit" value="Display">
            <input type="hidden"  name="id_student" value=<%out.print(id_student);%>>
            <input type="hidden"  name="username" value=username>
            
        </form>
        <%
        if (request.getParameter("refresh_button") != null) {
               
                username = request.getParameter("username");
                id_student = request.getParameter("id_student");
                Client cl_ = Client.create();

                WebResource r_ = cl_.resource("http://localhost:8080/TestAppDBWebApp/resources/seeAcceptUniv?id_student="+id_student);

                System.out.println("|"+r_.get(String.class)+"|");

                 // ATTENTION CODE DEGUEULASSE
                String chaine = r_.get(String.class);
                String[] c = chaine.split("=");
                Integer taille = Integer.parseInt(c[0]);
                //////////////

                parser.Table_Univ[] Table = new parser.Table_Univ[taille] ;

                // PARSING !
                Table = parser.ParserLolo.parse(r_.get(String.class));

                if (Table != null) {

                    for(parser.Table_Univ univ : Table)
                        {

            %>
            <form action="list_courses.jsp" method="POST" target="_blank" >
                <%out.println(univ.getName()+" | "+univ.getCountry());%>
                <input type="submit" value="Choose courses">
                <input type="hidden"  name="id_student" value=<%out.print(id_student);%>>
                <input type="hidden"  name="id_univ" value=<%out.print(univ.getId());%>>
             <%//IL FAUT FAIRE UN PARSER POUR ADFFICHER UNIV AUXQUELLES ON A POSTULE %>
                <input type="hidden"  name="insert_appliance" value="1">
            </form>
                <br/>
            <%

                        }
                    }
                }
        %>
    </body>
</html>
