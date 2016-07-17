<%@ include file="/common/taglibs.jsp" %>
<%@ page pageEncoding="UTF-8" %>

<html>
<head>
    <title>用户信息</title>
</head>
<body>

<form action="<c:url value="/user/userInfo/upgrade"/>" method="post">
    <input type="hidden" name="userId" value="${user.userId}"/>
    <input type="hidden" name="userType" value="${user.userType}"/>
    <table>
        <tr>
            <td>用户账号:</td>
            <td>${user.userName}</td>
        </tr>
        <tr>
            <td>用户昵称:</td>
            <td><input type="text" name="nickName" value="${user.nickName}"/></td>
        </tr>
        <tr>
            <td>用户类型:</td>
            <td>
                <c:if test="${user.userType == 1}">
                    车主
                </c:if>
                <c:if test="${user.userType == 2}">
                    驾驶人
                </c:if>
            </td>
        </tr>
        <c:if test="${user.userType == 2}">
            <tr>
                <td>关联车主:</td>
                <td><input type="text" name="carOwner"></td>
            </tr>
        </c:if>

        <tr>
            <td>身份证号:</td>
            <td>
                <input type="text" name="driveNumber" value="${user.driveNumber}"/>
            </td>
        </tr>
        <tr>
            <td>联系电话:</td>
            <td>
                <input type="text" name="mobile" value="${user.mobile}"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="保存用户信息"/>
            </td>
        </tr>

    </table>

</form>

</body>
</html>
