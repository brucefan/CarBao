<%@ include file="/common/taglibs.jsp" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>用户登陆</title>
</head>
<body>

<form action="<c:url value="/user/login"/>" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input name="userName" type="text"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="login"/>
            </td>
        </tr>
    </table>
</form>

</br>

<a href="<c:url value="/user/enterRegister"/>">用户注册</a>

</body>
</html>
