<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/MediaList" />
<c:set var="films" value="${requestScope.films}" />
<c:set var="musiques" value="${requestScope.musiques}" />
<c:set var="livres" value="${requestScope.livres}" />
<c:set var="films_size" value="${requestScope.films_size}" />
<c:set var="musiques_size" value="${requestScope.musiques_size}" />
<c:set var="livres_size" value="${requestScope.livres_size}" />
<c:set var="context" value="${pageContext.request.contextPath}" />

<fieldset>
    <legend align="center">
        <h1>Liste des M�dias </h1>
    </legend>
</fieldset>
<div class="col-md-12">
    <fieldset>
        <legend>Films</legend>
        <c:choose>
            <c:when test="${films_size != 0}">
                <div class="table-responsive">
                    <table id="myTable1" class="display table">
                        <thead>
                            <tr>
                                <th>Titre</th>
                                <th>R�alisateur</th>
                                <th>Ann�e</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="film" items="${films}" varStatus="loop">
                                <tr>
                                    <td><a href="AfficherUnMedia?mediaId=${film.getMediaId()}">${film.getTitre()}</a></td>
                                    <td>${film.getRealisateur()}</td>
                                    <td>${film.getAnneeProduction()}</td>
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
                Aucun film dans la base de donn�e
            </c:otherwise>
        </c:choose>
    </fieldset>
    <fieldset>
        <legend>Livre</legend>
        <c:choose>
            <c:when test="${livres_size != 0}">
                <div class="table-responsive">
                    <table id="myTable2" class="display table">
                        <thead>
                            <tr>
                                <th>Titre</th>
                                <th>Auteur</th>
                                <th>Ann�e</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="livre" items="${livres}" varStatus="loop">
                                <tr>
                                    <c:set var="mediaId" value="${livre.getMediaId()}" scope="request"/>
                                    <td><a href="AfficherUnMedia?mediaId=${livre.getMediaId()}">${livre.getTitre()}</a></td>
                                    <td>${livre.getAuteur()}</td>
                                    <td>${livre.getAnneeProduction()}</td>
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
                Aucun Livre dans la base de donn�e
            </c:otherwise>
        </c:choose>
    </fieldset>
    <fieldset>
        <legend>Album</legend>
        <c:choose>
            <c:when test="${musiques_size != 0}">
                <div class="table-responsive">
                    <table id="myTable3" class="display table">
                        <thead>
                            <tr>
                                <th>Titre</th>
                                <th>Artiste</th>
                                <th>Ann�e</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="musique" items="${musiques}" varStatus="loop">
                                <tr>
                                    <c:set var="mediaId" value="${musique.getMediaId()}" scope="request"/>
                                    <td><a href="${context}/AfficherUnMedia?mediaId=${musique.getMediaId()}">${musique.getTitre()}</a></td>
                                    <td>${musique.getArtiste()}</td>
                                    <td>${musique.getAnneeProduction()}</td>
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
                Aucun Album dans la base de donn�e
            </c:otherwise>
        </c:choose>
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