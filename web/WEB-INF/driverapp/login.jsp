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

        <li data-role="fieldcontain">
            <label for="fname">First Name</label>
            <input type="text" name="first_name" id="fname" value="${first_name}" />
        </li>
        <li data-role="fieldcontain">
            <label for="lname">Last Name</label>
            <input type="text" name="last_name" id="lname" value="${last_name}" />
        </li>
        <li data-role="fieldcontain">
            <label for="rego_num">Rego Number</label>
            <input type="text" name="rego_num" id="rego_num" value="${rego_num}" />
        </li>
        <li data-role="fieldcontain">
            <label for="password">Password</label>
            <input type="password" name="password" id="password" value="" />
        </li>
        <li>
            <fieldset class="ui-grid-a">
                <div class="ui-block-a"><button type="submit" data-theme="a">Login</button></div>
                <div class="ui-block-b"><a href="${requestForm}" 
                                           data-role="button" data-theme="d">Request</a></div>
            </fieldset>

        </li>
    </ul>
</form>
<jsp:include page="_footer.jsp" />
