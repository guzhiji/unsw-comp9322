<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp" />
<ul data-role="listview">
    <c:forEach items="${requestList}" var="req">
        <li data-theme="c">
            <a href="${requestPathBase}/renew/${req.id}">
                <h4>${req.firstName} ${req.lastName}</h4>
                <p>${req.regoNumber}</p>
            </a>
        </li>
    </c:forEach>

</ul>
<jsp:include page="_footer.jsp" />