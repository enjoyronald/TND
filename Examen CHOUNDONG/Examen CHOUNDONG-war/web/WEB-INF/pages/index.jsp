<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p>
<c:if test="${not empty message}">
    <c:out value="${message}"/> 
</c:if>
</p>
<img src="atelier1.jpg" class="img-responsive"/>