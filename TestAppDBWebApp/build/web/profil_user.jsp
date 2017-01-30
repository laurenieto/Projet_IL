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
        <%!String id_student;%>
        <h1 align="center"> <font face="Courier" </font>Manage students' travels</h1>
   
         <%
                id_student = request.getParameter("id_student");
                Client c1_st = Client.create();
                WebResource r_st = c1_st.resource("http://localhost:8080/TestAppDBWebApp/resources/listStudent?id_student="+id_student);
                String name = r_st.get(String.class);
       %>
          <h2>Hello <%out.print(name);%></h2>
         
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
            <input type="hidden"  name="name" value=name>            
        </form>
        <br/>
        <%
        if (request.getParameter("refresh_button") != null) {
               
                name = request.getParameter("name");
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
                <br/>
                <%out.println(univ.getName()+" | "+univ.getCountry());%>
                <input type="submit" value="Choose courses">
                
                <input type="hidden"  name="id_student" value=<%out.print(id_student);%>>
                <input type="hidden"  name="id_univ" value=<%out.print(univ.getId());%>>
                <input type="hidden" name="univ_name" value=<%out.print(univ.getName());%>>     
                <input type="hidden"  name="insert_appliance" value="1">
            </form>
           Your actual learning:
           <%         

                Client cl = Client.create();
                WebResource r = cl.resource("http://localhost:8080/TestAppDBWebApp/resources/listLearning?id_univ="+ univ.getId()+"&id_student="+id_student);


                String chaine_learning = r.get(String.class);
                String[] c_learning = chaine_learning.split("=");
                Integer taille_learning = Integer.parseInt(c_learning[0]);
                //////////////

                parser.Table_Course[] Table_learning = new parser.Table_Course[taille_learning] ;

                // PARSING !
                Table_learning = parser.ParserCours.parse(r.get(String.class));

                if (Table_learning != null) {

                    for(parser.Table_Course course : Table_learning)
                        {
                        %>
                       <ul style="list-style-type:disc">
                            <li> Course: <%out.print(course.getCourseName());%> </li>
                            <li> Number hours : <%out.print(course.getNbHours());%></li>
                       </ul>
                        <%
                        }
                    }        

                 }
             }
         }
        %>
    </body>
</html>
