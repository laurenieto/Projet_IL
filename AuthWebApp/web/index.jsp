<%-- 
    Document   : index
    Created on : Jan 10, 2017, 10:03:21 PM
    Author     : laure
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bonjour, connectez-vous!</h1>    <%-- start web service invocation --%><hr/>
        <form action="index.jsp" method="POST">
           
            Username: <input type="text" name="username" />
            Password:<input type="password" name="password" >
            <input type="SUBMIT" />
        </form>
    <%
            String username = request.getParameter("username");
            String pwd = request.getParameter("password");
           
            try {

                authcompositeapp.AuthCompositeAppService1 service = new authcompositeapp.AuthCompositeAppService1();
                authcompositeapp.ClientAuthWSDLPortType port = service.getCasaPort1();

                org.netbeans.xml.schema.clienrequest.ClienRequestType clientReq = new org.netbeans.xml.schema.clienrequest.ClienRequestType();
                clientReq.setPassword(username);

                clientReq.setUsername(pwd);

                org.netbeans.xml.schema.clientreply.ClientReplyType result = port.getClientAuthOperation(clientReq);

                //port.getClientAuthOperation(clientReq);

                result.setIsInDBReplyClient(false);


                //out.println("Result = "+result.isIsInDBReplyClient() + " username:"+ clientReq.getPassword() + " pwd: " + clientReq.getUsername());
                if (result.isIsInDBReplyClient()){
          %>
              <%response.sendRedirect("after_submit.jsp");%>

           <% }else{ %>
           <div >Le mot de passe est incorrecte, réessayez</div>



          <%
            }}catch (Exception ex) {} %>
    </body>
</html>
