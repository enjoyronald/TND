<%-- 
    Document   : afficherPizzas
    Created on : 21 nov. 2016, 04:40:05
    Author     : enjoy
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="message" value="${requestScope.message}" />

<c:if test="${message != null}">
    <script type="text/javascript">
        alert("${message}");
    </script>
    pizza ajoutée
</c:if>
<div>
    <h3>Liste des pizzas</h3>
    <c:import url="/PizzaList" />
    <c:set var="pizzas" value="${requestScope.pizzasList}" />
    <!-- recuperation message de PizzaAdd-->
    <table class="table">
        <thead>
            <tr>
                <th>Type de Pizza</th>
                <th>Prix</th>
                <th>Quantitée</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="pizza" items="${pizzas}" varStatus="loop">
                <tr>
                    <td>${pizza.getPizzaId().getPizzaId()}</td>
                    <td>${pizza.getPizzaId().getPrix()}</td>
                    <td>${pizza.getQuantite()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<div>
    <h3>Ajout Pizza</h3>
    <form class="form-horizontal" role="form" method='POST' action="PizzaAdd">
        <div class="form-group">
            <div class="col-sm-2">
                <label for="type" class="control-label">Type</label>
            </div>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="type" name="type" placeholder="type pizza">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-2">
                <label for="prix" class="control-label">Prix</label>
            </div>
            <div class="col-sm-10">
                <input type="number" step="0.01" class="form-control" id="prix" name="prix" placeholder="12">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-2">
                <label for="quantite" class="control-label">Quantite</label>
            </div>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="quantite" name="quantite" placeholder="10">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Ajouter</button>
            </div>
        </div>
    </form>
</div>
<c:import url="/PizzaAdd" />

