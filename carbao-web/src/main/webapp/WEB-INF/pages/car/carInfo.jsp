<%@ include file="/common/taglibs.jsp" %>
<%@ page pageEncoding="UTF-8" %>

<html>
<head>
    <title>车辆信息</title>
</head>
<body>
<form action="<c:url value="/car/carInfo/save"/>" method="post">
    <input type="hidden" name="userId" value="${userId}"/>
    <input type="hidden" name="userType" value="${userType}"/>

    <table>
        <tr>
            <td>车牌号牌</td>
            <td>
                <select name="licenseProvince">
                    <c:forEach items="${provinces}" var="pv">
                        <option value="${pv.name}">${pv.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td><input type="text" name="plateNumber"></td>
        </tr>
        <tr>
            <td>发动机号</td>
            <td colspan="2">
                <input type="text" name="engineNumber">
            </td>
        </tr>
        <tr>
            <td>车架号</td>
            <td colspan="2">
                <input type="text" name="carVin">
            </td>
        </tr>
        <tr>
            <td>车型</td>
            <td colspan="2">
                <select name="carSeries">
                    <c:forEach items="${carSeries}" var="cs">
                        <option value="${cs.seriesNo}">${cs.seriesName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="submit" value="保存车辆信息"/>
            </td>
        </tr>

    </table>
</form>

</body>
</html>
