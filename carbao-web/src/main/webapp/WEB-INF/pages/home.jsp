<%@ include file="/common/taglibs.jsp" %>
<%@ page pageEncoding="UTF-8" %>

<html>
<head>
    <title>主页</title>
</head>
<body>
<h1>个人主页</h1>

<a href="<c:url value="/user/userInfo/enter?userId=${userId}"/>">完善个人信息</a>
</br>

<c:if test="${userType == 2}">
    <a href="">绑定车主</a>
    </br>
</c:if>

<c:if test="${carId == null}">
    <a href="<c:url value="/user/userInfo/enter?userId=${userId}"/>">注册车辆信息</a>
    </br>
</c:if>

<c:if test="${carId != null}">
    <a href="">完善车辆信息</a>
    </br>
</c:if>

</body>
</html>
