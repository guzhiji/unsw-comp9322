<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp" />

<ul data-role="listview">
    <c:forEach items="${checkErrors}" var="e">
        <li>${e} ${e.message}</li>
    </c:forEach>
</ul>

<jsp:include page="_footer.jsp" />
