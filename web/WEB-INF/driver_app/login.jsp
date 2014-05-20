<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="_header.jsp" />
<form method="post" action="${formAction}" data-ajax="false">
    <ul data-role="listview">
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
            <label for="password">Password</label>
            <input type="password" name="password" id="password" value=""  />
        </li>
        <li>
            <button type="submit" data-theme="a">Login</button>
        </li>
    </ul>
</form>
<jsp:include page="_footer.jsp" />
