<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="_header.jsp" />

<ul data-role="listview">
    <li data-role="list-divider">Current Status</li>
    <li data-role="fieldcontain">
        <div>${myRequest.status}</div>
    </li>
    <li data-role="list-divider">Your Renewal Request</li>
    <li data-role="fieldcontain">
        <div>First Name</div>
        <div>${myRequest.firstName}</div>
    </li>
    <li data-role="fieldcontain">
        <div>Last Name</div>
        <div>${myRequest.lastName}</div>
    </li>
    <li data-role="fieldcontain">
        <div>Rego Number</div>
        <div>${myRequest.regoNumber}</div>
    </li>
    <li data-role="fieldcontain">
        <div>Licence Number</div>
        <div>${myRequest.licenceNumber}</div>
    </li>
    <li data-role="fieldcontain">
        <div>Address</div>
        <div>${myRequest.address}</div>
    </li>
</ul>

<jsp:include page="_footer.jsp" />
