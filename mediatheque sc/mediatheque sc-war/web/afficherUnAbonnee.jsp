<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- verification authorization utilisateur -->
<c:set var="userType" value="${sessionScope.connected}" />

<c:if test="${(userType != 'abonnee') &&(userType != 'admin') }">
    <c:redirect url="index.jsp"/>
</c:if>
<c:if test="${userType == 'abonnee'}">
    <c:set var="user" value="${sessionScope.client}" />
    <c:set var="abonnee" value="${requestScope.abonnee}"/>
    <c:if test="${abonnee.getUserName() != user.getUserName()}">
        <c:redirect url="index.jsp"/>
    </c:if>
</c:if>



<jsp:include page="/WEB-INF/pages/template.jsp">
    <jsp:param name="title" value="Afficher Abonnee"/>
    <jsp:param name="main" value="pages/afficherUnAbonnee"/>
    <jsp:param name="parametres" value="test"/>
</jsp:include>