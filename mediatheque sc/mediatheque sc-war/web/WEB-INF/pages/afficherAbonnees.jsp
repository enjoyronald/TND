<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/AbonneeList" />
<c:set var="abonnees" value="${requestScope.abonnees}" />
<c:set var="abonnees_size" value="${requestScope.abonnees_size}" />
<div class="col-md-12">
    <fieldset>
        <legend>Abonnées</legend>
        <c:choose>
            <c:when test="${abonnees_size != 0}">
                <div class="table-responsive">
                    <table id="myTable" class="display table">
                        <thead>
                            <tr>
                                <th>User Name</th>
                                <th>Email</th>
                                <th>Tel</th>
                                <th>NB Prets</th>
                                <th>NB Prets retard</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="abonnee" items="${abonnees}" varStatus="loop">
                                <tr>
                                    <td><a href="AfficherUnAbonnee?aId=${abonnee.getUserName()}">${abonnee.getUserName()}</a></td>
                                    <td>${abonnee.getEmai()}</td>
                                    <td>${abonnee.getTelephone()}</td>
                                    <td>${abonnee.getMediaCollection().size()}</td>
                                    <td>${abonnee.getNombreRetard()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-12 text-center">
                    <ul class="pagination pagination-lg pager" id="myPager"></ul>
                </div>
            </c:when>
            <c:otherwise>
                Pas d'abonnée dans la BD
            </c:otherwise>
        </c:choose>
    </fieldset>
</div>
<script>
        $(document).ready(function () {
            $('#myTable').dataTable();
        });
</script>