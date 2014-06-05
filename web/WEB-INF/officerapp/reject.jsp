<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html> 
<html>
    <head>
        <meta charset="utf-8">
        <title>RMS - Officer's App</title> 
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <link rel="stylesheet" href="/RMS/jquery.mobile-1.2.0.min.css" />
        <script src="/RMS/scripts/jquery.min.js"></script>
        <script src="/RMS/scripts/jquery.mobile-1.2.0.min.js"></script>
    </head> 
    <body> 

        <div data-role="dialog">
            <div data-role="header" data-theme="d">
                <h1>Reject Request</h1>
            </div>

            <div data-role="content" data-theme="c">
                <form method="post" action="${formActionBase}/reject" data-ajax="false">
                    <ul data-role="listview">

                        <c:if test="${not empty errorMessage}">
                            <li>
                                <div class="ui-body ui-body-e">${errorMessage}</div>
                            </li>
                        </c:if>

                        <li data-role="fieldcontain">
                            <label for="reject_reason">Reason</label>
                            <textarea name="reason" id="reject_reason" /></textarea>
                        </li>
                        <li>
                            <fieldset class="ui-grid-a">
                                <div class="ui-block-a">
                                    <button type="submit" 
                                            data-role="button" 
                                            data-theme="a"
                                            data-mini="true">Reject</button>
                                </div>
                                <div class="ui-block-b">
                                    <a  href="#" 
                                        data-role="button" 
                                        data-rel="back" 
                                        data-theme="d"
                                        data-mini="true">Cancel</a>
                                </div>
                            </fieldset>

                        </li>
                    </ul>
                </form>
            </div>
        </div>

    </body>
</html>
