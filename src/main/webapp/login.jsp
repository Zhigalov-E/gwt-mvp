<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="i18n.loginConst" />
<html lang="${language}">
<head>
    <title>Login</title>
    <link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/css/signin.css" />" rel="stylesheet">
</head>
<body>
    <div id="header">
        <a href="https://www.ardas.dp.ua/ru">
            <img src="<c:url value="/resources/logo.png"/>"/>
        </a>
    </div>
    <div class="container login-block" style="width: 300px;">
        <form name='f' action="login" method='POST'>
            <c:if test="${param.error != null}">
                <div class="error">
                    <p><fmt:message key="login.message.badcredetian"/></p>
                </div>
            </c:if>
            <c:if test="${param.logout != null}">
                <div class="blue">
                    <p><fmt:message key="login.message.logout"/></p>
                </div>
            </c:if>
            <table>
                <tr>
                    <td class="title"><fmt:message key="login.label.username"/></td>
                    <td><input class="form-control" type='text' name='username' value=''></td>
                </tr>
                <tr>
                    <td class="title"><fmt:message key="login.label.password"/></td>
                    <td><input class="form-control" type='password' name='password'/></td>
                </tr>
                <tr>
                    <td/>
                    <td>
                        <fmt:message key="login.button.submit" var="buttonValue" />
                        <input class="btn btn-primary" name="submit" type="submit" value="${buttonValue}"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="footer">
        © 2016 Ardas Group
    </div>
</body>
</html>