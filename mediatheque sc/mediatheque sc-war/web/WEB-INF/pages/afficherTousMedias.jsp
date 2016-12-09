<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/MediaList" />
<c:set var="films" value="${requestScope.films}" />
<c:set var="musiques" value="${requestScope.musiques}" />
<c:set var="livres" value="${requestScope.livres}" />
<c:set var="films_size" value="${requestScope.films_size}" />
<c:set var="musiques_size" value="${requestScope.musiques_size}" />
<c:set var="livres_size" value="${requestScope.livres_size}" />
<c:set var="context" value="${pageContext.request.contextPath}" />
<div class="col-md-12">
    <fieldset>
        <legend>Films</legend>
        <c:choose>
            <c:when test="${films_size != 0}">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Titre</th>
                            <th>Réalisateur</th>
                            <th>Année</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="film" items="${films}" varStatus="loop">
                            <tr>
                                <td><a href="${context}/pages/afficherUnMedia?mediaId=${film.getMediaId()}">${film.getTitre()}</a></td>
                                <td>${film.getRealisateur()}</td>
                                <td>${pizza.getAnneeProduction()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                Aucun film dans la base de donnée
            </c:otherwise>
        </c:choose>
    </fieldset>
    <fieldset>
        <legend>Livre</legend>
        <c:choose>
            <c:when test="${livres_size != 0}">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Titre</th>
                            <th>Auteur</th>
                            <th>Année</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="livre" items="${livres}" varStatus="loop">
                            <tr>
                                <td><a href="${context}/pages/afficherUnMedia?mediaId=${livre.getMediaId()}">${livre.getTitre()}</a></td>
                                <td>${livre.getAuteur()}</td>
                                <td>${livre.getAnneeProduction()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                Aucun Livre dans la base de donnée
            </c:otherwise>
        </c:choose>
    </fieldset>
    <fieldset>
        <legend>Album</legend>
        <c:choose>
            <c:when test="${musiques_size != 0}">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Titre</th>
                            <th>Artiste</th>
                            <th>Année</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="musique" items="${musiques}" varStatus="loop">
                            <tr>
                                <td><a href="${context}/pages/afficherUnMedia?mediaId=${musique.getMediaId()}&type=musique">${musique.getTitre()}</a></td>
                                <td>${musique.getArtiste()}</td>
                                <td>${musique.getAnneeProduction()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                Aucun Album dans la base de donnée
            </c:otherwise>
        </c:choose>
    </fieldset>
</div>