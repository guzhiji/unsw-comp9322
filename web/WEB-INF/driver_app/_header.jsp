
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head> 
        <meta charset="utf-8">
        <title></title> 
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <link rel="stylesheet" href="/RMS/jquery.mobile-1.2.0.min.css" />
        <script src="/RMS/scripts/jquery.min.js"></script>
        <script src="/RMS/scripts/jquery.mobile-1.2.0.min.js"></script>
    </head> 

    <body>

        <div data-role="page">

            <div data-role="header" data-position="fixed">
                {$LeftButton}
                <h1>${page_title}</h1>
                {$RightButton}
                {$TopNav}
            </div><!-- /header -->
            <div data-role="content">
