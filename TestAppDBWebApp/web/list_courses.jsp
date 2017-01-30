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
        <%String univName = request.getParameter("univ_name");%>
        <h1 align="center"> <font face="Courier" </font>Manage students' travels</h1>

     
          <h2>Choose your course for the university <%out.print(univName);%></h2>
          <br/>
          <br/>
         


          <%
          
                String id_univ = request.getParameter("id_univ");
                String id_student = request.getParameter("id_student");
                
                Client cl = Client.create();
                WebResource r = cl.resource("http://localhost:8080/TestAppDBWebApp/resources/listCourse?id_univ="+id_univ);

                 // ATTENTION CODE DEGUEULASSE
                String chaine = r.get(String.class);
                String[] c = chaine.split("=");
                Integer taille = Integer.parseInt(c[0]);
                //////////////

                parser.Table_Course[] Table = new parser.Table_Course[taille] ;

                // PARSING !
                Table = parser.ParserCours.parse(r.get(String.class));

                if (Table != null) {

                    for(parser.Table_Course course : Table)
                        {
                        %>
                   <form action="" method="POST" >
                        <%out.println(course.getCourseName()+" | "+course.getNbHours());%>
                        <input type="submit" value="Add to my learning" name="add_course">
                        <input type="hidden" name ="id_student" value="<%out.print(id_student);%>">
                        <input type="hidden"  name="id_univ" value=<%out.print(id_univ);%>>
                        <input type="hidden" name="univ_name" value=<%out.print(univName);%>>
                        <input type="hidden" name="id_course" value=<%out.print(course.getId());%>>
                        
                    </form>
                        <br/><%
                    }}
                    if (request.getParameter("add_course")!= null){
                        //appel au we service pour inserer dans db
                      
                        id_student = request.getParameter("id_student");
                        id_univ = request.getParameter("id_univ");
                        String id_course = request.getParameter("id_course");
                       

                        Client cl_add = Client.create();
                        WebResource r_add = cl_add.resource("http://localhost:8080/TestAppDBWebApp/resources/addCourseToLearning?id_student="+ id_student + "&id_univ="+id_univ + "&id_course="+id_course);

                        String ret = r_add.put(String.class);
                        if (ret.equals("ok")){
                            %>
                            <script type="text/javascript">alert("Successful insertion");</script>
                        <%
                            }
                        else {
                             %> <script type="text/javascript">alert("This course is already in your learning ");</script> <%
                            }
                        }
          %>
     

    </body>
</html>
