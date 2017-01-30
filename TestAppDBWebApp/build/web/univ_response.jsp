<%-- 
    Document   : univ_response
    Created on : Jan 15, 2017, 3:50:45 PM
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
        <h1 align="center"> <font face="Courier" </font>University profile</h1>
        <h2>Student who applied</h2>
        <%

       String id_univ = request.getParameter("id_univ");
       String id_student = request.getParameter("id_student");
       String insert = request.getParameter("insert_appliance");
       if (insert.equals("1")){
          
           insert = "0";
           Client cl_apply = Client.create();
           WebResource r_apply = cl_apply.resource("http://localhost:8080/TestAppDBWebApp/resources/apply?id_student="+id_student+"&id_univ="+id_univ);
           r_apply.put(String.class);
      }

        String param = request.getParameter("univ");

        Client c1_univ = Client.create();
        WebResource r_univ = c1_univ.resource("http://localhost:8080/TestAppDBWebApp/resources/ListStudentWhoApplied?id_univ="+id_univ);

        String chaine = r_univ.get(String.class);
        String[] c = chaine.split("=");
        Integer taille = Integer.parseInt(c[0]);
        //////////////

        parser.Table_Student[] Table = new parser.Table_Student[taille] ;

        // PARSING !
        Table = parser.ParserStudent.parse(r_univ.get(String.class));


        if (Table != null) {

            for(parser.Table_Student univ : Table)
            {
             %>
             <p><%out.print(univ.getFirstname()+ " " + univ.getSurname() + ", Year: " + Integer.toString(univ.getYearAtInsa()) + ", INSA STUDENT");%></p>
            
             <p>mail: <%out.print(univ.getEmail());%></p>
            


           <form name="formAccept" action="" method="POST">
               speciality: <%out.print(univ.getINSAspeciality());%>
               <input type="submit" name="accept" value="Accept ">
               <input type="submit" name="refuse" value="Refuse ">
               <input type="hidden"  name="id_student" value=<%out.print(id_student);%>>
           </form>
           <br/>

               <%
              }
        }

        if (request.getParameter("accept") != null) {
           id_student = request.getParameter("id_student");
           id_univ = request.getParameter("id_univ");
           Client cl = Client.create();
           WebResource r = cl.resource("http://localhost:8080/TestAppDBWebApp/resources/studentAccepted?id_student="+id_student+"&id_univ="+id_univ);
           r.put(String.class);
            //inserer truz dans la db
        }
        else if (request.getParameter("refuse") != null) {
            
            //inserer false dans la db
        }
       %>

    </body>
</html>
