<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <h1>RMS - Officer's App</h1>
            </div>

            <div data-role="content" data-theme="c">
                <p>${errorMessage}</p>
            </div>
        </div>

    </body>
</html>
