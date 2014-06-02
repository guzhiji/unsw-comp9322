<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp" />
<form method="post" action="${formAction}" data-ajax="false">
    <ul data-role="listview">

        <c:if test="${not empty errorMessage}">
            <li>
                <div class="ui-body ui-body-e">${errorMessage}</div>
            </li>
        </c:if>

        <li data-role="list-divider">Your Request</li>
        <li data-role="fieldcontain">
            <label for="fname">First Name</label>
            <input type="text" name="first_name" id="fname" value=""  />
        </li>
        <li data-role="fieldcontain">
            <label for="lname">Last Name</label>
            <input type="text" name="last_name" id="lname" value=""  />
        </li>
        <li data-role="fieldcontain">
            <label for="rego_num">Rego Number</label>
            <input type="text" name="rego_num" id="rego_num" value=""  />
        </li>
        <li data-role="fieldcontain">
            <label for="license">License Number</label>
            <input type="text" name="license" id="license" value=""  />
        </li>
        <li data-role="fieldcontain">
            <label for="address">Address</label>
            <input type="text" name="address" id="address" value=""  />
        </li>
        <li data-role="list-divider">Track Status</li>
        <li data-role="fieldcontain">
            <label for="password">Password</label>
            <input type="password" name="password" id="password" value=""  />
        </li>
        <li>
            <button type="submit" data-theme="a">Make a Request</button>
        </li>
    </ul>
</form>
<jsp:include page="_footer.jsp" />
