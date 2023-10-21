<%@tag description="Alegeme Template" pageEncoding="UTF-8"%>
<%@attribute name="title" fragment="true"%>
<%@attribute name="content" fragment="true"%>
<%@attribute name="script" fragment="true"%>
<%@attribute name="css" fragment="true"%>

<!DOCTYPE html>
<html lang="nl">

    <head>

        <title>
            <jsp:invoke fragment="title"/>
        </title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <jsp:invoke fragment="css"/>

    </head>

    <body>

        <jsp:invoke fragment="content"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <jsp:invoke fragment="script"/>

    </body>

</html>