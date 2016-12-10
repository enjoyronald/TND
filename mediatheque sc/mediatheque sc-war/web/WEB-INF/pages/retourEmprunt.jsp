<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="message" value="${requestScope.message}" />
<c:if test="${not empty message}">
    <c:out value="${message}"/> 
</c:if>
<fieldset>
    <legend align="center">
        <h1>Retour Emprunt </h1>
    </legend>
</fieldset>
<form class="form-horizontal" role="form" method="POST" action="RetourEmprunt">
    <div class="form-group">
        <div class="col-sm-2">
            <label for="username" class="control-label">Abonnee</label>
        </div>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="username" name="username" placeholder="nom abonnee">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-2">
            <label for="titre" class="control-label">Titre Media</label>
        </div>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="titre" name="titre" placeholder="titre">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-2">
            <label for="auteur" class="control-label">Auteur</label>
        </div>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="auteur" name="auteur" placeholder="auteur">
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-2">
            <label for="type" class="control-label">Type</label>
        </div>
        <div class="col-md-10">
            <select name="type" class="col-md-12 form-control" required>
                <option value="film">Film</option>
                <option value="musique">Album</option>
                <option value="livre">Livre</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-2">
            <label for="type" class="control-label">Etat</label>
        </div>
        <div class="col-md-10">
            <select name="etat" class="col-md-12 form-control" id="etat">
                <option value="NEUF">NEUF</option>
                <option value="BIEN">BIEN</option>
                <option value="USAGER">USAGER</option>
                <option value="JETER">JETER</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">retour</button>
        </div>
    </div>
</form>