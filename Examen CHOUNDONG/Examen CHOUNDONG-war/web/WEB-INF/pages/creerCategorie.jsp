<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/ListCategorie" />
<c:set var="categories" value="${requestScope.categories}" />

<fieldset>
    <legend align="center">
        <h1>Ajouter Catégorie </h1>
    </legend>
</fieldset>
<form class="form-horizontal" role="form" method="POST" action="AjoutCategorie">
    <div class="form-group">
        <div class="col-md-2">
            <label for="titre" class="control-label">Nom</label>
        </div>
        <div class="col-md-10">
            <input type="text" class="form-control" id="nom" placeholder="categorie1"
                    name="nom" required>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-2">
            <label for="sCategories" class="control-label">Categorie(s) liée(s)</label>
        </div>
        <div class="col-md-10">
            <select multiple name="sCategories">
               <c:forEach var="categorie" items="${categories}" varStatus="loop">
                   <option value="${categorie.getNom()}">${categorie.getNom()}</option>
                </c:forEach>
            </select> 
        </div>
        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <button type="submit" class="btn btn-default">Ajouter</button>
            </div>
        </div>
    </div>
    

</form>