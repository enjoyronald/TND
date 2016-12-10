<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- verification authorization utilisateur -->
<c:set var="userType" value="${sessionScope.connected}" />

<c:if test="${userType != 'admin'}">
    <c:redirect url="index.jsp"/>
</c:if>

<jsp:include page="/WEB-INF/pages/template.jsp">
    <jsp:param name="title" value="Ajouter Media"/>
    <jsp:param name="main" value="pages/ajouterMedia"/>
    <jsp:param name="parametres" value="test"/>
</jsp:include>