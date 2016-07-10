<%@ include file="/common/taglibs.jsp" %>
<%@ page pageEncoding="UTF-8" %>

<html>
<head>
    <title>用户注册</title>
</head>
<body>
<form action="<c:url value="/user/register"/>">
    <table>
        <tr>
            <td>用户名</td>
            <td><input name="user" type="text"/></td>
        </tr>
        <tr>
            <td>用户类型</td>
            <td>
                <select name="userType">
                    <c:forEach items="${userTypes}" var="ut">
                        <option value="${ut.type}">${ut.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td>联系手机</td>
            <td><input type="text" name="mobile"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="submit"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
