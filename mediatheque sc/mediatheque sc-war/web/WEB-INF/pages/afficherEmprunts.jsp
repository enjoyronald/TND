<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/ListEmprunt" />
<c:set var="emprunts" value="${requestScope.emprunts}" />
<c:set var="musiqueFacade" value="${requestScope.musiqueFacade}" />
<c:set var="filmFacade" value="${requestScope.filmFacade}" />
<c:set var="livreFacade" value="${requestScope.livreFacade}" />

<div class="col-md-12">
    <fieldset>
        <legend>Liste des Empunts</legend>
        <c:choose>
            <c:when test="${emprunts.size() != 0}">
                <div class="table-responsive">
                    <table id="myTable" class="display table">
                        <thead>
                            <tr>
                                <th>Utilisateur</th>
                                <th>Titre Media</th>
                                <th>Date Debut</th>
                                <th>Date Fin</th>
                                <th>Date Rendu</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="emprunt" items="${emprunts}" varStatus="loop">
                                <c:set var="musique" value="${musiqueFacade.find(emprunt.getMediaId().getMediaId())}" />
                                <c:set var="livre" value="${livreFacade.find(emprunt.getMediaId().getMediaId())}" />
                                <c:set var="film" value="${filmFacade.find(emprunt.getMediaId().getMediaId())}" />
                                <tr>
                                    <td><a href="AfficherUnAbonnee?aId=${emprunt.getUserName().getUserName()}">${emprunt.getUserName().getUserName()}</a></td>
                                    <td><a href="AfficherUnMedia?mediaId=${film.getMediaId()}${musique.getMediaId()}${livre.getMediaId()}">${film.getTitre()}${musique.getTitre()}${livre.getTitre()}</a></td>
                                    <td>${emprunt.getDateDebut()}</td>
                                    <td>${emprunt.getDateFin()}</td>
                                    <td>${emprunt.getDateRetour()}</td>
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
                Pas d'emprunt réalisé
            </c:otherwise>
        </c:choose>
    </fieldset>
</div>
<script>
        $(document).ready(function () {
            $('#myTable').dataTable();
        });
</script>
