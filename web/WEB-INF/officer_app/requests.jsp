<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp" />
<ul data-role="listview">
    <c:forEach items="${requestList}" var="req">
        <li data-theme="c">
            <a href="${requestPathBase}/${req.id}">${req.firstName} ${req.lastName} (${req.regoNumber})</a>
        </li>
    </c:forEach>
    <li>
        <form action="${formAction}" method="post"><button type="submit" data-theme="a">Logout</button></form>
    </li>
</ul>
<jsp:include page="_footer.jsp" />