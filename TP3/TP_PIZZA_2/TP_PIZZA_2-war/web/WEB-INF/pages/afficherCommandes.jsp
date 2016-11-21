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
    comande ajoutée
</c:if>
<div>
    <h3>Liste des Commandes</h3>
    <c:import url="/CommandList" />
    <c:set var="commands" value="${requestScope.commandsList}" />
    <!-- recuperation message de PizzaAdd-->
    <table class="table">
        <thead>
            <tr>
                <th>Type de Pizza</th>
                <th>Quantite</th>
                <th>Total</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="command" items="${commands}" varStatus="loop">
            <tr>
                <td>${command.getPizzaId().getPizzaId()}</td>
                <td>${command.getQuantite()}</td>
                <td>${command.getTotal()}</td>
                <td>${command.getEmail()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div>
    <h3>Passer Commande</h3>
    <form class="form-horizontal" role="form" method='POST' action="CommandAdd">
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
                <label for="quantite" class="control-label">Quantite</label>
            </div>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="quantite" name="quantite" placeholder="12">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-2">
                <label for="email" class="control-label">Email</label>
            </div>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="email" name="email" placeholder="10">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Valider</button>
            </div>
        </div>
    </form>
</div>
<c:import url="/CommandAdd" />

