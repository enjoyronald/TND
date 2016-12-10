<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="type" value="${requestScope.type}"/>
<c:set var="userType" value="${sessionScope.connected}" />
<c:set var="copies" value="${requestScope.copies}"/>
<c:if test="${type == null}">
    <c:redirect url="index.jsp"/>
</c:if>
<c:choose>
    <c:when test="${type == 'livre'}">
        <c:set var="livre" value="${requestScope.livre}"/>
        <div>
            <fieldset>
                <legend>
                    <h1>
                        ${livre.getTitre()}
                        <a href="EditerMedia?type=livre&titre=${livre.getTitre()}&auteur=${livre.getAuteur()}"><button type="button" class="btn btn-warning" aria-label="Left Align">
                                editer
                            </button></a>
                    </h1>
                </legend>
                <div class="col-md-12"><h3>
                        <div class="col-md-4">Auteur :</div>
                        <div class="col-md-8"><c:out value="${livre.getAuteur()}" /></div>
                    </h3>
                </div>
                <div class="col-md-12"><h3>
                        <div class="col-md-4">Année :</div>
                        <div class="col-md-8"><c:out value="${livre.getAnneeProduction()}" /></div>
                    </h3>
                </div>
                <c:if test="${userType == 'admin'}">
                    <div class="col-md-12"><h3>
                            <div class="col-md-4">Nb Copies :</div>
                            <div class="col-md-8"><c:out value="${copies.size()}" /></div>
                        </h3>
                    </div>
                </c:if>
                <div class="col-md-12"><h3>
                        <div class="col-md-4">Résumé :</div>
                        <div class="col-md-8"><c:out value="${livre.getResume()}" /></div>
                    </h3>
                </div>
            </fieldset>
        </div>
        <div><p>&nbsp;</p></div>
        <div>
            <c:if test="${userType == 'admin'}">
                <fieldset>
                    <legend><h2>Emprunts en Cours</h2></legend>
                    <c:choose>
                        <c:when test="${copies.size() != 0}">
                            <div class="table-responsive">
                                <table id="myTable1" class="display table">
                                    <thead>
                                        <tr>
                                            <th>User Name</th>
                                            <th>Email</th>
                                            <th>Date Emprunt</th>
                                            <th>Date Retour</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="copie" items="${copies}" varStatus="loop">
                                            <tr>
                                                <td><a href="AfficherUnAbonnee?aId=${copie.getUserName().getUserName()}">${copie.getUserName().getUserName()}</a></td>
                                                <td>${copie.getUserName().getEmai()}</td>
                                                <td>${copie.getDateDebut()}</td>
                                                <td>${copie.getDateFin()}</td>
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
                            Pas d'emprunt en cours
                        </c:otherwise>
                    </c:choose>
                </fieldset>
            </c:if>
        </div>
    </c:when>
    <c:when test="${type == 'musique'}">
        <c:set var="musique" value="${requestScope.musique}"/>
        <div>
            <fieldset>
                <legend><h1><c:out value="${musique.getTitre()}" />
                        <a href="EditerMedia?type=musique&titre=${musique.getTitre()}&auteur=${musique.getArtiste()}"><button type="button" class="btn btn-warning" aria-label="Left Align">
                                editer
                            </button></a>
                    </h1></legend>
                <div class="col-md-12"><h3>
                        <div class="col-md-4">Artiste :</div>
                        <div class="col-md-8"><c:out value="${musique.getArtiste()}" /></div>
                    </h3>
                </div>
                <div class="col-md-12"><h3>
                        <div class="col-md-4">Année :</div>
                        <div class="col-md-8"><c:out value="${musique.getAnneeProduction()}" /></div>
                    </h3>
                </div>
                <c:if test="${userType == 'admin'}">
                    <div class="col-md-12"><h3>
                            <div class="col-md-4">Nb Copies :</div>
                            <div class="col-md-8"><c:out value="${copies.size()}" /></div>
                        </h3>
                    </div>
                </c:if>
                <div class="col-md-12"><h3>
                        <div class="col-md-4">Morceaux :</div>
                        <div class="col-md-8"><c:out value="${musique.getMorceaux()}" /></div>
                    </h3>
                </div>
            </fieldset>
        </div>
        <div><p>&nbsp;</p></div>
        <div>
            <c:if test="${userType == 'admin'}">
                <fieldset>
                    <legend><h2>Emprunts en Cours</h2></legend>
                    <c:choose>
                        <c:when test="${copies.size() != 0}">
                            <div class="table-responsive">
                                <table id="myTable2" class="display table">
                                    <thead>
                                        <tr>
                                            <th>User Name</th>
                                            <th>Email</th>
                                            <th>Date Emprunt</th>
                                            <th>Date Retour</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="copie" items="${copies}" varStatus="loop">
                                            <tr>
                                                <td><a href="AfficherUnAbonnee?aId=${copie.getUserName().getUserName()}">${copie.getUserName().getUserName()}</a></td>
                                                <td>${copie.getUserName().getEmai()}</td>
                                                <td>${copie.getDateDebut()}</td>
                                                <td>${copie.getDateFin()}</td>
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
                            Pas d'emprunt en cours
                        </c:otherwise>
                    </c:choose>
                </fieldset>
            </c:if>
        </div>
    </c:when>
    <c:when test="${type == 'film'}">
        <c:set var="film" value="${requestScope.film}"/>
        <div>
            <fieldset>
                <legend><h1><c:out value="${film.getTitre()}" />
                        <a href="EditerMedia?type=film&titre=${film.getTitre()}&auteur=${film.getRealisateur()}"><button type="button" class="btn btn-warning" aria-label="Left Align">
                                editer
                            </button></a>
                    </h1></legend>
                <div class="col-md-12"><h3>
                        <div class="col-md-4">Réalisateur :</div>
                        <div class="col-md-8"><c:out value="${film.getRealisateur()}" /></div>
                    </h3>
                </div>
                <div class="col-md-12"><h3>
                        <div class="col-md-4">Année :</div>
                        <div class="col-md-8"><c:out value="${film.getAnneeProduction()}" /></div>
                    </h3>
                </div>
                <c:if test="${userType == 'admin'}">
                    <div class="col-md-12"><h3>
                            <div class="col-md-4">Nb Copies :</div>
                            <div class="col-md-8"><c:out value="${copies.size()}" /></div>
                        </h3>
                    </div>
                </c:if>
                <div class="col-md-12"><h3>
                        <div class="col-md-4">Résumé :</div>
                        <div class="col-md-8"><c:out value="${film.getResume()}" /></div>
                    </h3>
                </div>
            </fieldset>
        </div>
        <div><p>&nbsp;</p></div>
        <div>
            <fieldset>
                <legend><h2>Acteurs</h2></legend>
                <c:set var="acteurs" value="${film.getActeurCollection()}" />
                <c:choose>
                    <c:when test="${acteurs.size() > 0}">
                        <c:forEach var="acteur" items="${acteurs}">
                            <h3>- ${acteur.getNomActeur()}</h3>
                        </c:forEach>
                    </c:when>
                </c:choose>
            </fieldset>
        </div>

        <div><p>&nbsp;</p></div>
        <div>
            <c:if test="${userType == 'admin'}">
                <fieldset>
                    <legend><h2>Emprunts en Cours</h2></legend>
                    <c:choose>
                        <c:when test="${copies.size() != 0}">
                            <div class="table-responsive">
                                <table id="myTable3" class="display table">
                                    <thead>
                                        <tr>
                                            <th>User Name</th>
                                            <th>Email</th>
                                            <th>Date Emprunt</th>
                                            <th>Date Retour</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="copie" items="${copies}" varStatus="loop">
                                            <tr>
                                                <td><a href="AfficherUnAbonnee?aId=${copie.getUserName().getUserName()}">${copie.getUserName().getUserName()}</a></td>
                                                <td>${copie.getUserName().getEmai()}</td>
                                                <td>${copie.getDateDebut()}</td>
                                                <td>${copie.getDateFin()}</td>
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
                            Pas d'emprunt en cours
                        </c:otherwise>
                    </c:choose>
                </fieldset>
            </c:if>
        </div>
    </c:when>
    <c:otherwise>
        <c:redirect url="index.jsp"/>
    </c:otherwise>
</c:choose>
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
