<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="message" value="${requestScope.message}" />
<c:if test="${not empty message}">
    <div>
        <c:out value="${message}"/> 
    </div>
</c:if>
<fieldset>
    <legend align="center">
        <h1>Inscription</h1>
    </legend>
</fieldset>
<form class="form-horizontal" role="form" method="POST" action="inscription_connexion">
    <div class="form-group">
        <div class="col-sm-2">
            <label for="username" class="control-label">User Name</label>
        </div>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="username" name="username" placeholder="toto" required>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-2">
            <label for="nom" class="control-label">Nom</label>
        </div>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="nom" name="nom" placeholder=" toto" required>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-2">
            <label for="prenom" class="control-label">Prenom</label>
        </div>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="prenom" name="prenom" placeholder=" toto prenom" required>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-2">
            <label for="adresse" class="control-label">Adresse</label>
        </div>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="adresse" name="adresse" placeholder=" 33 boulevard de la mort 93012 sfs" required>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-2">
            <label for="tel" class="control-label">Tel</label>
        </div>
        <div class="col-sm-10">
            <input type="number" class="form-control" id="tel" name="tel" placeholder="0110203040" required>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-2">
            <label for="email" class="control-label">Email</label>
        </div>
        <div class="col-sm-10">
            <input type="email" class="form-control" id="email" name="email" placeholder="tot@yahoo.fr" required>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-2">
            <label for="pwd" class="control-label">Password</label>
        </div>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Password" required>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-2">
            <label for="cpwd" class="control-label">Confirmation </label>
        </div>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="cpwd" name="cpwd" placeholder="Password" required>
        </div>
    </div>
    <input type="hidden" class="form-control" id="type" name="type" value="inscription">
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">inscription</button>
        </div>
    </div>
</form>