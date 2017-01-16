<%-- 
    Document   : index
    Created on : Jan 13, 2017, 5:19:10 PM
    Author     : laure
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage students' travels web site</title>
    </head>
    <body>
        <p><img src="http://www.ensiacet.fr/_resources/Images/Formations/Masteres-specialises/Logos-Risk/INSA_Toulouse.jpeg" align="left" alt="Illustration logo INSA Toulouse" width="200" height="150" border="0"/></p>
        <h1 align="center"> <font face="Courier" </font>Manage students' travels</h1>
        <br /> <br /> <br /> <br />
        <h2 align="left"> <font face="Courier" </font>Connexion</h2>    <%-- start web service invocation --%><hr/>
        <form  action="index.jsp" method="POST">
            Username: <input type="text" name="username" />
            <br />
            Password: <input type="password" name="password" >
            <br /> <br />
            <input type="SUBMIT" value="Log in"/>
        </form>    
        
    <%
            String username = request.getParameter("username");
            String pwd = request.getParameter("password");
            try {
              
                compositeapp1.CompositeApp1Service1 service = new compositeapp1.CompositeApp1Service1();
                compositeapp1.ClientAuthWSDLPortType port = service.getCasaPort1();
                org.netbeans.xml.schema.clienrequest.ClienRequestType clientReq = new org.netbeans.xml.schema.clienrequest.ClienRequestType();
                clientReq.setPassword(username);
                         
                clientReq.setUsername(pwd);
                  
                org.netbeans.xml.schema.clientreply.ClientReplyType result = port.getClientAuthOperation(clientReq);
                out.print("3");
                //port.getClientAuthOperation(clientReq);
                //out.println("Result = "+result.isIsInDBReplyClient() + " username:"+ clientReq.getPassword() + " pwd: " + clientReq.getUsername());
                if (result.isIsInDBReplyClient()){
              
              response.sendRedirect("profil_user.jsp?username_="+username+"&password_="+pwd);
             
           }else{%>
           <script type="text/javascript">alert("Mot de passe ou Username incorrect, réessayez");</script>

          <%
            }}catch (Exception ex) {} %>
    </body>
</html>
