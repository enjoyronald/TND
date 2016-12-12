<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp"><span>MEDIATHEQUE</span></a>
        </div>

        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="creerCategorie.jsp">creer categorie</a>
                </li>
                <c:if test="${sessionScope.connected == null}" >
                    <li>
                        <a href="inscription.jsp">Inscription</a>
                    </li>
                    <li>
                        <a href="connexion.jsp">Connexion</a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.connected != null}" > <!-- Pour voir si l'utilisateur est connecté. En suite type d'uilisateur -->
                    <c:set var="userType" value="${sessionScope.connected}" />
                    <c:set var="context" value="${pageContext.request.contextPath}" />
                    <c:if test="${userType == 'admin'}"> <!-- c'est un administrateur -->
                        <c:set var="admin" value="${sessionScope.client}" />
                        <li class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">Administrer <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="ajouterMedia.jsp">Ajouter Media</a></li>
                                <li><a href="afficherAbonnees.jsp">Afficher Abonnees</a></li>
                                <li><a href="afficherEmprunts.jsp">Afficher Emprunts</a></li>
                                <li><a href="enregistrerEmprunt.jsp">Enregistrer Emprunt</a></li>
                                <li><a href="retourEmprunt.jsp">Retour Emprunt</a></li>
                            </ul> 
                        </li>
                        <li class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#"><c:out value="${admin.getUserName()}"/> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="${context}/Deconnexion">deconnexion</a></li>
                            </ul>
                        </li>
                    </c:if>
                    <c:if test="${userType == 'abonnee'}"> <!-- c'est un abonnee -->
                        <c:set var="abonnee" value="${sessionScope.client}" />
                        <li class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#"><c:out value="${abonnee.getUserName()}"/> <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="${context}/AfficherUnAbonnee?aId=${abonnee.getUserName()}">profil</a></li>
                                <li><a href="${context}/Deconnexion">deconnexion</a></li>
                            </ul>
                        </li>
                    </c:if>
                </c:if>
            </ul>
            <form class="navbar-form navbar-right" method="POST" action="Recherche">
                <div class="input-group">
                    <input type="text" id="search" name="search" required="required" class="form-control" placeholder="search">
                    <!-- insert this line -->
                    <span class="input-group-addon" style="width:0px; padding-left:0px; padding-right:0px; border:none;"></span>
                    <select name="searchType" class="form-control" >
                        <option value="film">film</option>
                        <option value="musique">album</option>
                        <option value="livre">livre</option>
                        <option value="realisateur">realisateur</option>
                        <option value="artiste">artiste</option>
                        <option value="auteur">auteur</option>
                        <option value="acteur">acteur</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-default">Go</button>
            </form>
        </div>
    </div>
</div>