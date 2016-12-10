<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- le but est ue notre pae se lance en fonction du type de media que l'on souhaite rajouter -->
<c:if test="${type}==null">
    <c:redirect  url="index.jsp"/>
</c:if>

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <div class="row">
            <h1>Editer ${type} /></h1>
        </div>
        <div class="row">
            <div class="col-md-12">
                <form class="form-horizontal" role="form" method="POST" action="EditerMedia">
                    <div class="form-group">
                        <div class="col-md-2">
                            <label for="titre" class="control-label">Titre</label>
                        </div>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="titre" placeholder="<c:out value="${titre}"/>"
                            readonly="" value="<c:out value="${titre}"/>" name="titre">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-2">
                            <label for="${authorLabel}" class="control-label">${authorLabel}"</label>
                        </div>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="${authorLabel}" placeholder="${authorName}" readonly value="${authorName}" name="${authorLabel}" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-2">
                            <label for="annee" class="control-label">Année Edition</label>
                        </div>
                        <div class="col-md-10">
                            <input type="number" class="form-control" id="annee" placeholder="2016"
                                   value="${annee}" name="annee" min="1900" max="2100">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-2">
                            <c:choose><c:when test="${type == 'musique'}">
                                    <label for="morceaux" class="control-label">Morceaux</label>
                                </c:when>
                                <c:otherwise>
                                    <label for="resume" class="control-label">Resumé</label>
                                </c:otherwise></c:choose>
                        </div>
                        <div class="col-md-10">
                            <c:choose><c:when test="${type == 'musique'}">
                                    <textarea class="form-control" rows="5" id="morceaux" name="morceaux">${musique.getMorceaux()}</textarea>
                                </c:when>
                                <c:otherwise>
                                    <textarea class="form-control" rows="5" id="resume" name="resume">${film.getResume()} ${livre.getResume()}</textarea>
                                </c:otherwise></c:choose>
                        </div>
                    </div>
                    <input type="hidden" name="edit" id="nouveau" value="${type}"/> 
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-10">
                            <button type="submit" class="btn btn-default">Editer</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="col-md-2"></div>
</div>

<script>
    var nba = 1; // nombre d'auteurs 
    function ajouterAuteur(node) {
        var frag = document.createElement('div');
        frag.className = "form-group";
        frag.innerHTML = ''
                + '<div class="col-md-2"><label for="acteurs[]" class="control-label">Nom acteur</label></div>'
                + '<div class="col-md-9 "><input class="form-control" type="text" name="acteurs[]" id="acteurs[' + nba + ']" required placeholder="ex:toto"></div>'
                + '<div class="col-md-1 form-group"><input class="btn btn-danger" type="button" onclick="supprimerAuteur(this.parentNode.parentNode)" value=" - " ></div>'
                ;
        nba += 1; //on incremente le nombre d'auteurs
        node.appendChild(frag);
    }
    function supprimerAuteur(node) {
        node.parentNode.removeChild(node);
    }
</script>
