<%-- 
    Document   : simplelogin
    Created on : Apr 2, 2018, 1:17:43 PM
    Author     : Plamen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Mock</h1>
        <form action='userCheck'>
            <h2>Username</h2>
            <input type='text' name='user' value=''/>
            <br></br>
            <h2>Password</h2>
            <label value='Password'/>
            <input type='password' name='pwd' value=''/>
            <br></br>
            <input type='submit' value='Submit'/>
        </form>
    </body>
    

</html>
