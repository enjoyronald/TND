<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="userType" value="${sessionScope.connected}" />

<c:set var="abonnee" value="${requestScope.abonnee}"/>
<c:set var="films" value="${requestScope.films}"/>
<c:set var="livres" value="${requestScope.livres}"/>
<c:set var="musiques" value="${requestScope.musiques}"/>
<div>
    <fieldset>
        <legend><h1><c:out value="${abonnee.getUserName()}" /></h1></legend>
        <div class="col-md-12"><h3>
                <div class="col-md-4">Nom :</div>
                <div class="col-md-8"><c:out value="${abonnee.getNom()}" /></div>
            </h3>
        </div>
        <div class="col-md-12"><h3>
                <div class="col-md-4">Prenom :</div>
                <div class="col-md-8"><c:out value="${abonnee.getPrenom()}" /></div>
            </h3>
        </div>
        <div class="col-md-12"><h3>
                <div class="col-md-4">Email :</div>
                <div class="col-md-8"><c:out value="${abonnee.getEmai()}" /></div>
            </h3>
        </div>
        <div class="col-md-12"><h3>
                <div class="col-md-4">Adresse :</div>
                <div class="col-md-8"><c:out value="${abonnee.getAdresse()}" /></div>
            </h3>
        </div>
        <div class="col-md-12"><h3>
                <div class="col-md-4">Tel :</div>
                <div class="col-md-8"><c:out value="${abonnee.getTelephone()}" /></div>
            </h3>
        </div>
    </fieldset>
</div>
<div><p>&nbsp;</p></div>
<div>
    <fieldset>
        <legend><h2>Emprunts en Cours</h2></legend>

        <div class="col-md-10 col-md-offset-1">
            <div class="row"><h2>Films</h2></div>
            <div class="row">
                <c:choose>
                    <c:when test="${films.size() != 0}">
                        <div class="table-responsive">
                            <table id="myTable1" class="display table">
                                <thead>
                                    <tr>
                                        <th>Titre</th>
                                        <th>Realisateur</th>
                                        <th>Annee</th>
                                        <th>Date Emprunt</th>
                                        <th>Date Retour</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="film" items="${films}" varStatus="loop">
                                        <tr>
                                            <td><a href="AfficherUnMedia?mediaId=${film.getMediaId()}">${film.getTitre()}</a></td>
                                            <td>${film.getRealisateur()}</td>
                                            <td>${film.getAnneeProduction()}</td>
                                            <td>${film.getDateDebut()}</td>
                                            <td>${film.getDateFin()}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-md-12 text-center">
                            <ul class="pagination pagination-lg pager" id="myPager1"></ul>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <p>Pas de film en cours d'emprunt.</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>


        <!-- Les livres -->


        <div class="col-md-10 col-md-offset-1">
            <div class="row"><h2>Livres</h2></div>
            <div class="row">
                <c:choose>
                    <c:when test="${livres.size() != 0}">
                        <div class="table-responsive">
                            <table id="myTable2" class="display table">
                                <thead>
                                    <tr>
                                        <th>Titre</th>
                                        <th>Auteur</th>
                                        <th>Annee</th>
                                        <th>Date Emprunt</th>
                                        <th>Date Retour</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="livre" items="${livres}" varStatus="loop">
                                        <tr>
                                            <td><a href="AfficherUnMedia?mediaId=${livre.getMediaId()}">${livre.getTitre()}</a></td>
                                            <td>${livre.getAuteur()}</td>
                                            <td>${livre.getAnneeProduction()}</td>
                                            <td>${livre.getDateDebut()}</td>
                                            <td>${livre.getDateFin()}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-md-12 text-center">
                            <ul class="pagination pagination-lg pager" id="myPager2"></ul>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <p>Pas de livre en cours d'emprunt.</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>


        <!-- Les Albums -->


        <div class="col-md-10 col-md-offset-1">
            <div class="row"><h2>Albums</h2></div>
            <div class="row">
                <c:choose>
                    <c:when test="${musiques.size() != 0}">
                        <div class="table-responsive">
                            <table id="myTable3" class="display table">
                                <thead>
                                    <tr>
                                        <th>Titre</th>
                                        <th>Artiste</th>
                                        <th>Annee</th>
                                        <th>Date Emprunt</th>
                                        <th>Date Retour</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="musique" items="${musiques}" varStatus="loop">
                                        <tr>
                                            <td><a href="AfficherUnMedia?mediaId=${musique.getMediaId()}">${musique.getTitre()}</a></td>
                                            <td>${musique.getArtiste()}</td>
                                            <td>${musique.getAnneeProduction()}</td>
                                            <td>${musique.getDateDebut()}</td>
                                            <td>${musique.getDateFin()}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-md-12 text-center">
                            <ul class="pagination pagination-lg pager" id="myPager3"></ul>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <p>Pas d'Album en cours d'emprunt.</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

    </fieldset>
</div>
<script>
        $(document).ready(function () {
            $('#myTable1').dataTable();
        });
        $(document).ready(function () {
            $('#myTable2').dataTable();
        });
        $(document).ready(function () {
            $('#myTable3').dataTable();
        });
</script>


