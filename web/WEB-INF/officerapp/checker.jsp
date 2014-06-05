<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="_header.jsp" />

<ul data-role="listview">
    <c:if test="${not empty checkErrors}">
        <li>
            <c:forEach items="${checkErrors}" var="e">
                <div class="ui-body ui-body-e">
                    ${e.message}
                </div>
            </c:forEach>
        </li>
    </c:if>
    <c:if test="${not empty checkResult}">

        <c:set var="passed" value="${true}" />
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
                <c:set var="passed" value="${false}" />
            </c:otherwise>
        </c:choose>
        <li>
            <h4>Green Slip</h4>
            <p>
                <c:choose>
                    <c:when test="${not empty checkResult.greenSlip}">
                        <c:choose>
                            <c:when test="${checkResult.greenSlip.paidFlag}">
                                Paid
                            </c:when>
                            <c:otherwise>
                                Required
                                <c:set var="passed" value="${false}" />
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        Required
                        <c:set var="passed" value="${false}" />
                    </c:otherwise>
                </c:choose>
            </p>
        </li>
        <c:if test="${not empty checkResult.vehicleInfo}">
            <li>
                <h4>Vehicle Type</h4>
                <p>${checkResult.vehicleInfo.vehicleType}</p>
            </li>
            <li>
                <h4>Manufactured</h4>
                <p>${checkResult.vehicleInfo.manufacturedDate}</p>
            </li>
            <li>
                <h4>Pink Slip</h4>
                <p>
                    <c:choose>
                        <c:when test="${checkResult.pinkSlipRequired}">
                            <c:choose>
                                <c:when test="${not empty checkResult.pinkSlip}">
                                    <c:choose>
                                        <c:when test="${checkResult.pinkSlip.checkedFlag}">
                                            Paid
                                        </c:when>
                                        <c:otherwise>
                                            Required
                                            <c:set var="passed" value="${false}" />
                                        </c:otherwise>
                                    </c:choose>
                                </c:when>
                                <c:otherwise>
                                    Required
                                    <c:set var="passed" value="${false}" />
                                </c:otherwise>
                            </c:choose>
                        </c:when>
                        <c:otherwise>
                            Not Required
                        </c:otherwise>
                    </c:choose>
                </p>
            </li>
        </c:if>
        <c:choose>
            <c:when test="${passed}">
                <li>
                    <fieldset class="ui-grid-a">
                        <div class="ui-block-a"><a href="${formActionBase}/accept" 
                                                   data-role="button" data-theme="a">Accept</a></div>
                        <div class="ui-block-b"><a href="${formActionBase}/reject" 
                                                   data-role="button" data-theme="d">Reject</a></div>
                    </fieldset>
                </li>
            </c:when>
            <c:otherwise>
                <a href="${formActionBase}/reject" 
                   data-role="button" data-theme="a">Reject</a>
            </c:otherwise>
        </c:choose>
    </c:if>
</ul>

<jsp:include page="_footer.jsp" />
