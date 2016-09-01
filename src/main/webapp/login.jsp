<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>

    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/css/signin.css" />" rel="stylesheet">
</head>
<body>
    <div id="header">
        <a href="https://www.ardas.dp.ua/ru">
            <img src="/resources/logo.png"/>
        </a>
    </div>
    <div class="container login-block" style="width: 300px;">
        <h2 class="form-signin-heading">Please sign in</h2>
        <form name='f' action="login" method='POST'>
            <table>
                <tr>
                    <td class="title">User:</td>
                    <td><input class="form-control" type='text' name='username' value=''></td>
                </tr>
                <tr>
                    <td class="title">Password:</td>
                    <td><input class="form-control" type='password' name='password'/></td>
                </tr>
                <tr>
                    <td/>
                    <td><input class="btn btn-primary" name="submit" type="submit" value="submit"/></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="footer">© 2016 Ardas Group</div>
</body>
</html>