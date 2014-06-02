<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp" />

<ul data-role="listview">
    <li data-role="list-divider">Request Current Status</li>
    <li data-role="fieldcontain">
        <div>
            ${requestDetail.status}
            <c:if test="${requestDetail.status eq 'NEW'}">
                <form method="post" id="reviewForm" action="${formActionBase}/review"></form>
                <button form="reviewForm" 
                        data-role="button" 
                        data-theme="e" 
                        data-inline="true"
                        data-mini="true">Review This</button>
            </c:if>
        </div>
    </li>
    <li data-role="list-divider">Renewal Requester</li>
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
    <c:if test="${requestDetail.status eq 'UNDER_REVIEW'}">

        <li data-role="list-divider">Green &amp; Pink Slip</li>
        <li>
            <c:choose>
                <c:when test="${empty requestDetail.autoCheckResultId}">
                    <form method="post" id="autoCheckForm" action="${formActionBase}/check/invoke"></form>
                    <button type="submit" 
                            form="autoCheckForm"
                            data-role="button" 
                            data-theme="e"
                            data-mini="true">Perform auto-check</button>
                </c:when>
                <c:otherwise>
                    <a href="${formActionBase}/check/result/${requestDetail.autoCheckResultId}" 
                       data-role="button" 
                       data-theme="e" 
                       data-mini="true">View</a>
                </c:otherwise>
            </c:choose>
        </li>
        <li>
            <fieldset class="ui-grid-a">
                <div class="ui-block-a"><a href="${formActionBase}/accept" 
                                           data-role="button" data-theme="a">Accept</a></div>
                <div class="ui-block-b"><a href="${formActionBase}/reject" 
                                           data-role="button" data-theme="d">Reject</a></div>
            </fieldset>
        </li>
        <li data-role="list-divider">Accept</li>
        <li data-role="fieldcontain">
            <form method="post" id="acceptForm2" action="${formActionBase}/accept"></form>
            <label for="accept_fee">Fee</label>
            <input type="text" id="accept_fee" />
            <div>
                <button type="submit" 
                        form="acceptForm"
                        data-role="button" 
                        data-theme="e"
                        data-mini="true">Accept</button>
            </div>
        </li>
        <li data-role="list-divider">Reject</li>
        <li data-role="fieldcontain">
            <form method="post" id="rejectForm2" action="${formActionBase}/reject"></form>
            <label for="reject_reason">Reason</label>
            <textarea name="reason" id="reject_reason" /></textarea>
            <div>
                <button type="submit" 
                        form="rejectForm"
                        data-role="button" 
                        data-theme="e"
                        data-mini="true">Reject</button>
            </div>
        </li>
    </c:if>

</ul>

<jsp:include page="_footer.jsp" />
