<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><span>MEDIATHEQUE</span></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="index.jsp">Home</a>
                </li>
                
                <li>
                    <a href="afficherTousMedias.jsp">Afficher Media</a>
                </li>
                <c:if test="${sessionScope.connected == null}" >
                <li>
                    <a href="inscription.jsp">inscription</a>
                </li>
                <li>
                    <a href="connexion.jsp">connexion</a>
                </li>
                </c:if>
                <c:if test="${sessionScope.connected != null}" > <!-- Pour voir si l'utilisateur est connecté. En suite type d'uilisateur -->
                    <c:set var="type" value="${sessionScope.connected}" />
                    <c:set var="context" value="${pageContext.request.contextPath}" />
                    <c:if test="${type == 'admin'}"> <!-- c'est un administrateur -->
                        <c:set var="admin" value="${sessionScope.client}" />
                        <li class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">administrer <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="ajouterMedia.jsp">Ajouter Media</a></li>
                                <li><a href="afficherAbonnees.jsp">afficher abonnees</a></li>
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
                        <c:if test="${type == 'abonnee'}"> <!-- c'est un administrateur -->
                            <c:set var="abonnee" value="${sessionScope.client}" />
                            <li class="dropdown">
                                <a data-toggle="dropdown" class="dropdown-toggle" href="#"><c:out value="${abonnee.getUserName()}"/> <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="${context}/Deconnexion">deconnexion</a></li>
                                </ul>
                            </li>
                        </c:if>
                </c:if>
                
            </ul>
        </div>
    </div>
</div>