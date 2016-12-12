<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/ListCategorie" />
<c:set var="categories" value="${requestScope.categories}" />

<fieldset>
    <legend align="center">
        <h1>Ajouter Question </h1>
    </legend>
</fieldset>
<form class="form-horizontal" role="form" method="POST" action="AjoutQuestion">
    <div class="form-group">
        <div class="col-md-2">
            <label for="nom" class="control-label">Nom</label>
        </div>
        <div class="col-md-10">
            <input type="text" class="form-control" id="nom" placeholder="question ?"
                   name="nom" required>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-2">
            <label for="sCategories" class="control-label">Categorie</label>
        </div>
        <div class="col-md-10">
            <select name="sCategories" class="form-control" required>
                <c:forEach var="categorie" items="${categories}" varStatus="loop">
                    <option value="${categorie.getNom()}">${categorie.getNom()}</option>
                </c:forEach>
            </select> 
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-2">
            <label for="reponse" class="control-label">Reponse</label>
        </div>
        <div class="col-md-10">           
            <textarea class="form-control" rows="5" id="morceaux" name="reponse" required></textarea>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-offset-2 col-md-10">
            <button type="submit" class="btn btn-default">Ajouter</button>
        </div>
    </div>
</div>
</form>