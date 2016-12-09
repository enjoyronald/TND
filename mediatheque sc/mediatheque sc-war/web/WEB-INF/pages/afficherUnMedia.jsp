<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="type" value="${requestScope.type}"/>
<c:if test="${type == null}">
    <c:redirect url="index.jsp"/>
</c:if>
<c:choose>
    <c:when test="${type == 'livre'}">
        <c:set var="livre" value="${requestScope.livre}"/>
        <div>
            <fieldset>
                <legend><h1><c:out value="${livre.getTitre()}" /></h1></legend>
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
                <div class="col-md-12"><h3>
                        <div class="col-md-4">Résumé :</div>
                        <div class="col-md-8"><c:out value="${livre.getResume()}" /></div>
                    </h3>
                </div>
            </fieldset>
        </div>
    </c:when>
    <c:when test="${type == 'musique'}">
        <c:set var="musique" value="${requestScope.musique}"/>
        <div>
            <fieldset>
                <legend><h1><c:out value="${musique.getTitre()}" /></h1></legend>
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
                <div class="col-md-12"><h3>
                        <div class="col-md-4">Morceaux :</div>
                        <div class="col-md-8"><c:out value="${musique.getMorceaux()}" /></div>
                    </h3>
                </div>
            </fieldset>
        </div>
    </c:when>
    <c:when test="${type == 'film'}">
        <c:set var="film" value="${requestScope.film}"/>
        <fieldset>
            <legend><h1><c:out value="${film.getTitre()}" /></h1></legend>
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
            <div class="col-md-12"><h3>
                    <div class="col-md-4">Résumé :</div>
                    <div class="col-md-8"><c:out value="${film.getResume()}" /></div>
                </h3>
            </div>
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
        </fieldset>
    </c:when>
    <c:otherwise>
        <c:redirect url="index.jsp"/>
    </c:otherwise>
</c:choose>


