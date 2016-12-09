<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="message" value="${requestScope.message}" />
<c:if test="${not empty message}">
    <c:out value="${message}"/> 
</c:if>
<form class="form-horizontal" role="form" method="POST" action="inscription_connexion">
    <div class="form-group">
        <div class="col-sm-2">
            <label for="username" class="control-label">Nom Utilisateur</label>
        </div>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="username" name="username" placeholder="toto">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-2">
            <label for="pwd" class="control-label">Mot de passe</label>
        </div>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Password">
        </div>
    </div>
    <input type="hidden" class="form-control" id="type" name="type" value="connexion">
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <div class="checkbox">
                <label><input type="checkbox" name="administrateur" id="administrateur" value="administrateur"> administrateur </label>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">connexion</button>
        </div>
    </div>
</form>