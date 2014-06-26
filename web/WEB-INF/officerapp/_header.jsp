<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head> 
        <meta charset="utf-8">
        <title>RMS - Officer's App</title> 
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <link rel="stylesheet" href="/RMS-App-Officer/jquery.mobile-1.2.0.min.css" />
        <script src="/RMS-App-Officer/scripts/jquery.min.js"></script>
        <script src="/RMS-App-Officer/scripts/jquery.mobile-1.2.0.min.js"></script>
    </head> 

    <body>

        <div data-role="page">

            <div data-role="header" data-position="fixed">

                <c:if test="${not empty homePage}">
                    <a href="${homePage}" 
                       data-role="button" 
                       data-icon="home" 
                       data-theme="a">Home</a>
                </c:if>

                <h1>RMS - Officer's App</h1>

                <c:if test="${not empty logoutAction}">
                    <form action="${logoutAction}" method="post" id="logoutForm"></form>
                    <button type="submit" form="logoutForm"
                            data-role="button"
                            data-icon="delete" 
                            data-iconpos="right" 
                            data-theme="a">Logout</button>
                </c:if>

                <c:if test="${not empty navButtons}">
                    <div data-role="navbar">
                        <ul>
                            <c:forEach var="btn" items="${navButtons}">
                                <li>
                                    <c:choose>
                                        <c:when test="${btn.key eq navButtons_active}">
                                            <a href="${btn.value}" 
                                               data-role="button" 
                                               data-theme="b">${btn.key}</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="${btn.value}" 
                                               data-role="button" 
                                               data-theme="a">${btn.key}</a>
                                        </c:otherwise>
                                    </c:choose>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </c:if>

            </div><!-- /header -->

            <div data-role="content">
