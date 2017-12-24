<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp" />

<ul data-role="listview">
    <!-- Status -->
    <li data-role="list-divider">Request Current Status</li>
    <li>
        <h3>${requestDetail.status}</h3>
    </li>
    <c:if test="${requestDetail.isRejected()}">
        <li>
            <h4>Rejection Reason</h4>
            <p>${requestDetail.rejectReason}</p>
        </li>
    </c:if>
    <c:if test="${requestDetail.status eq 'NEW'}">
        <li>
            <div>
                <form method="post" id="reviewForm" action="${formActionBase}/review" data-ajax="false"></form>
                <button form="reviewForm" 
                        data-role="button" 
                        data-theme="e" 
                        data-mini="true">Review This</button>
            </div>
        </li>
    </c:if>
    <!-- Request Detail -->
    <li data-role="list-divider">Renewal Request Detail</li>
    <li data-role="fieldcontain">
        <h4>First Name</h4>
        <p>${requestDetail.firstName}</p>
    </li>
    <li data-role="fieldcontain">
        <h4>Last Name</h4>
        <p>${requestDetail.lastName}</p>
    </li>
    <li data-role="fieldcontain">
        <h4>Rego Number</h4>
        <p>${requestDetail.regoNumber}</p>
    </li>
    <li data-role="fieldcontain">
        <h4>Licence Number</h4>
        <p>${requestDetail.licenceNumber}</p>
    </li>
    <li data-role="fieldcontain">
        <h4>Address</h4>
        <p>${requestDetail.address}</p>
    </li>
    <!-- Rego Detail -->
    <li data-role="list-divider">Rego Detail</li>
    <li data-role="fieldcontain">
        <h4>Last Rego Date</h4>
        <p>${regoDetail.lastRegoDate}</p>
    </li>
    <li data-role="fieldcontain">
        <h4>First Name</h4>
        <p>${regoDetail.firstName}</p>
    </li>
    <li data-role="fieldcontain">
        <h4>Last Name</h4>
        <p>${regoDetail.lastName}</p>
    </li>
    <li data-role="fieldcontain">
        <h4>Rego Number</h4>
        <p>${regoDetail.regoNumber}</p>
    </li>
    <li data-role="fieldcontain">
        <h4>Licence Number</h4>
        <p>${regoDetail.licenceNumber}</p>
    </li>
    <li data-role="fieldcontain">
        <h4>Address</h4>
        <p>${regoDetail.address}</p>
    </li>
    <!-- Green Pink Slips -->
    <c:if test="${requestDetail.status ne 'NEW'}">
        <li data-role="list-divider">Green &amp; Pink Slip</li>
        <li>
            <div>
                <c:choose>
                    <c:when test="${empty requestDetail.autoCheckResultId}">
                        <form method="post" id="autoCheckForm" action="${formActionBase}/check/invoke" data-ajax="false"></form>
                        <button type="submit" 
                                form="autoCheckForm"
                                data-role="button" 
                                data-theme="e"
                                data-mini="true">Perform auto-check</button>
                    </c:when>
                    <c:otherwise>
                        <a href="${formActionBase}/check" 
                           data-role="button" 
                           data-theme="e" 
                           data-mini="true">View</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </li>
    </c:if>
    <!-- Payment Info -->
    <c:if test="${requestDetail.status eq 'ACCEPTED'}">
        <li data-role="list-divider">Payment</li>
        <li>
            <div>
                <a href="${formActionBase}/payment" 
                   data-role="button" 
                   data-theme="e" 
                   data-mini="true">View</a>
            </div>
        </li>
    </c:if>
</ul>

<jsp:include page="_footer.jsp" />
