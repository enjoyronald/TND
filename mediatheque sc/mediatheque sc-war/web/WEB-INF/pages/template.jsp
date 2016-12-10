<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>MEDIATHEQUE - ${param.title}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="${pageContext.request.contextPath}/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/jquery.min.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
        <script src="${pageContext.request.contextPath}/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/bootstrap.min.js" type="text/javascript"></script>
        <!--
        <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
        -->
    </head>
    <body> 
        <header>
            <jsp:include page="/WEB-INF/pages/header.jsp"></jsp:include>
            </header>
            <div class="section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-2"></div>
                        <div class="col-md-8">
                        <jsp:include page="/WEB-INF/${param.main}.jsp?${param.parametres}"></jsp:include>
                        </div>
                        <div class="col-md-2"></div>
                    </div>
                </div>
            </div>
            <footer>
            <jsp:include page="/WEB-INF/pages/footer.jsp"></jsp:include>
        </footer>

    </body>
</html>

