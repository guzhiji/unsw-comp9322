<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
    <head>
        <meta charset="utf-8">
        <title>RMS - Driver's App</title> 
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <link rel="stylesheet" href="/RMS-App-Driver/jquery.mobile-1.2.0.min.css" />
        <script src="/RMS-App-Driver/scripts/jquery.min.js"></script>
        <script src="/RMS-App-Driver/scripts/jquery.mobile-1.2.0.min.js"></script>
    </head> 
    <body> 

        <div data-role="dialog">
            <div data-role="header" data-theme="d">
                <h1>RMS - Driver's App</h1>
            </div>

            <div data-role="content" data-theme="c">
                <p>${errorMessage}</p>
                <a href="#" data-role="button" data-theme="c" data-rel="back">OK</a>
            </div>
        </div>

    </body>
</html>
