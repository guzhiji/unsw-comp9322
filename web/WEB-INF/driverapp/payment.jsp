<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp" />
<form method="post" action="${formAction}" data-ajax="false">
    <ul data-role="listview">
        <li>
            <h4>Id</h4>
            <p>${payment.id}</p>
        </li>
        <li>
            <h4>Amount</h4>
            <p>${payment.amount}</p>
        </li>
        <c:choose>
            <c:when test="${payment.isPaid()}">
                <li>
                    <h4>Card Number</h4>
                    <p>${payment.cardNumber}</p>
                </li>
                <li>
                    <h4>Date</h4>
                    <p>${payment.paidDate}</p>
                </li>
            </c:when>
            <c:otherwise>
                <li data-role="fieldcontain">
                    <label for="card">Card Number</label>
                    <input type="text" id="card" name="card">${payment.cardNumber}</p>
                </li>
                <li>
                    <fieldset class="ui-grid-a">
                        <div class="ui-block-a"><button type="submit" 
                                                        data-theme="a">Pay</button></div>
                        <div class="ui-block-b"><a href="#" 
                                                   data-role="button"
                                                   data-rel="back"
                                                   data-theme="d">Cancel</a></div>
                    </fieldset>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
</form>
<jsp:include page="_footer.jsp" />
