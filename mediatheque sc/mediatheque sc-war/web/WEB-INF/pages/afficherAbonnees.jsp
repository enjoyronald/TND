<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/AbonneeList" />
<c:set var="abonnees" value="${requestScope.abonnees}" />
<c:set var="abonnees_size" value="${requestScope.abonnees_size}" />
<div class="col-md-12">
    <fieldset>
        <legend>Abonnées</legend>
        <c:choose>
            <c:when test="${abonnees_size != 0}">
                <table class="table">
                    <thead>
                        <tr>
                            <th>User Name</th>
                            <th>Email</th>
                            <th>Tel</th>
                            <th>Abonnement</th>
                            <th>NB Prets</th>
                            <th>NB Prets retard</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="abonnee" items="${abonnees}" varStatus="loop">
                            <tr>
                                <td>${abonnee.getUserName()}</td>
                                <td>${abonnee.getEmai()}</td>
                                <td>${abonnee.getTelephone()}</td>
                                <td>${abonnee.getAbonnementId().getType()}</td>
                                <td>${abonnee.getMediaCollection().size()}</td>
                                <td>${abonnee.getNombreRetard()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                Pas d'abonnée dans la BD
            </c:otherwise>
        </c:choose>
    </fieldset>
</div>