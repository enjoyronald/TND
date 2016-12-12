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

    </head>
    <body style ='background-color: #eeeeee;'> 
        
            <jsp:include page="/WEB-INF/pages/header.jsp"></jsp:include>
            
            
                <div class="container">
                    <div class="row" style ='background-color: #ffffff;'>
                        <p>&nbsp; &nbsp;&nbsp; &nbsp;</p>
                        <p>&nbsp; &nbsp;&nbsp; &nbsp;</p>
                        <p>&nbsp; &nbsp;&nbsp; &nbsp;</p>
                        <div class="col-md-2"></div>
                        <div class="col-md-8">
                        <jsp:include page="/WEB-INF/${param.main}.jsp?${param.parametres}"></jsp:include>
                        <p>&nbsp; &nbsp;&nbsp; &nbsp;</p>
                        <p>&nbsp; &nbsp;&nbsp; &nbsp;</p>
                        <p>&nbsp; &nbsp;&nbsp; &nbsp;</p>
                        </div>
                        <div class="col-md-2"></div>
                    </div>
                </div>
            <jsp:include page="/WEB-INF/pages/footer.jsp"></jsp:include>
        

    </body>
</html>

