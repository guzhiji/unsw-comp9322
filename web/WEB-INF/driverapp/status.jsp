<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp" />

<ul data-role="listview">
    <!-- Status -->
    <li data-role="list-divider">Current Status</li>
    <li>
        <h3>${myRequest.status}</h3>
    </li>
    <c:if test="${myRequest.isRejected()}">
        <li>
            <h4>Rejection Reason</h4>
            <p>${myRequest.rejectReason}</p>
        </li>
    </c:if>
    <c:if test="${myRequest.status ne 'UNDER_REVIEW'}">
        <c:if test="${myRequest.status ne 'ARCHIVED'}">
            <li>
                <div>
                    <form method="post" id="archiveForm" action="${requestBase}/archive"></form>
                    <button form="archiveForm" 
                            data-role="button" 
                            data-theme="e" 
                            data-mini="true">Archive This</button>
                </div>
            </li>
        </c:if>
    </c:if>
    <!-- Request Detail -->
    <li data-role="list-divider">Your Renewal Request</li>
    <li data-role="fieldcontain">
        <h4>Id</h4>
        <p>${myRequest.id}</p>
    </li>
    <li data-role="fieldcontain">
        <h4>First Name</h4>
        <p>${myRequest.firstName}</p>
    </li>
    <li data-role="fieldcontain">
        <h4>Last Name</h4>
        <p>${myRequest.lastName}</p>
    </li>
    <li data-role="fieldcontain">
        <h4>Rego Number</h4>
        <p>${myRequest.regoNumber}</p>
    </li>
    <li data-role="fieldcontain">
        <h4>Licence Number</h4>
        <p>${myRequest.licenceNumber}</p>
    </li>
    <li data-role="fieldcontain">
        <h4>Address</h4>
        <p>${myRequest.address}</p>
    </li>
    <c:if test="${myRequest.status eq 'NEW'}">
        <li>
            <div>
                <a href="${requestBase}/edit" 
                   data-role="button" 
                   data-theme="a">Edit</a>
            </div>
        </li>
    </c:if>
    <!-- Payment Info -->
    <c:if test="${myRequest.status eq 'ACCEPTED'}">
        <li data-role="list-divider">Payment</li>
        <li>
            <div>
                <a href="${requestBase}/payment" 
                   data-role="button" 
                   data-theme="e" 
                   data-mini="true">View</a>
            </div>
        </li>
    </c:if>

</ul>

<jsp:include page="_footer.jsp" />
