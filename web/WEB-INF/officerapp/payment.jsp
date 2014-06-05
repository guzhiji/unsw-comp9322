<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp" />
<ul data-role="listview">
    <li>
        <h4>Id</h4>
        <p>${payment.id}</p>
    </li>
    <li>
        <h4>Amount</h4>
        <p>${payment.amount}</p>
    </li>
    <c:if test="${payment.isPaid()}">
        <li>
            <h4>Card Number</h4>
            <p>${payment.cardNumber}</p>
        </li>
        <li>
            <h4>Date</h4>
            <p>${payment.paidDate}</p>
        </li>
    </c:if>
</ul>
<jsp:include page="_footer.jsp" />
