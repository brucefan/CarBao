<%-- Success Messages --%>
<c:if test="${not empty successMessages}">
    <div class="alert alert-success">
        <button class="close" data-dismiss="alert"></button>
        <c:forEach var="successMessage" items="${successMessages}">
            <c:out value="${successMessage}"/>
        </c:forEach>
    </div>
    <c:remove var="messagesMap" scope="session"/>
</c:if>
<%-- Error Messages --%>
<c:if test="${not empty errorMessages}">
    <div class="alert alert-error">
        <button class="close" data-dismiss="alert"></button>
        <c:forEach var="errorMessages" items="${errorMessage}">
            <strong><c:out value="${errorMessage}"/></strong><br/>
        </c:forEach>
    </div>
    <c:remove var="messagesMap" scope="session"/>
</c:if>
<%-- Info Messages --%>
<c:if test="${not empty infoMessages}">
    <div class="alert alert-info">
        <button class="close" data-dismiss="alert"></button>
        <c:forEach var="infoMessages" items="${infoMessage}">
            <strong><c:out value="${infoMessage}"/></strong><br/>
        </c:forEach>
    </div>
    <c:remove var="messagesMap" scope="session"/>
</c:if>
<%-- Warning Messages --%>
<c:if test="${not empty warningMessages}">
    <div class="alert alert-success">
        <button class="close" data-dismiss="alert"></button>
        <c:forEach var="warningMessages" items="${warningMessage}">
            <strong><c:out value="${warningMessage}"/></strong><br/>
        </c:forEach>
    </div>
    <c:remove var="messagesMap" scope="session"/>
</c:if>