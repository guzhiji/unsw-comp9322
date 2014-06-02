<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp" />

<ul data-role="listview">
    <c:choose>
        <c:when test="${checkResult.isFinished()}">
            <li>
                ${checkResult.runDate}
            </li>
        </c:when>
        <c:otherwise>
            <li>
                Check still running...
            </li>
        </c:otherwise>
    </c:choose>
    <c:if test="${not empty checkResult.greenSlip}">
        <li>
            <h4>Green Slip</h4>
            <p>${checkResult.greenSlip.paidFlag}</p>
        </li>
    </c:if>
    <c:if test="${not empty checkResult.vehicleInfo}">
        <li>
            <h4>Vehicle Type</h4>
            <p>${checkResult.vehicleInfo.vehicleType}</p>
        </li>
        <li>
            <h4>Manufactured</h4>
            <p>${checkResult.vehicleInfo.manufacturedDate}</p>
        </li>
    </c:if>
    <c:if test="${checkResult.pinkSlipRequired}">
        <li>
            <h4>Pink Slip</h4>
            <p>
                <c:choose>
                    <c:when test="${not empty checkResult.pinkSlip}">
                        ${checkResult.pinkSlip.checkedFlag}
                    </c:when>
                    <c:otherwise>
                        Required
                    </c:otherwise>
                </c:choose>
            </p>
        </li>
    </c:if>
</ul>

<jsp:include page="_footer.jsp" />
