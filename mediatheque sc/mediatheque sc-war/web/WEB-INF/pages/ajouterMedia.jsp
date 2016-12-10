<!-- Zone selection type media-->
<fieldset>
    <legend align="center">
        <h1>Ajouter Un Media</h1>
    </legend>
</fieldset>
<div class="row">
    <div class="col-md-12">
        <ul class="nav nav-pills">
            <li class="active" id="bt_ajouter_livre">
                <a href="#" onclick="showLivre()">Ajouter Livre</a>
            </li>
            <li id="bt_ajouter_musique">
                <a href="#" onclick="showMusique()">Ajouter Musique</a>
            </li>
            <li id="bt_ajouter_film">
                <a href="#" onclick="showFilm()">Ajouter Film</a>
            </li>
        </ul>
    </div>
</div>

<!-- Zone Image a afficher-->

<div class="row">
    <div class="col-md-12"></div>
</div>


<!-- Zone ajout d'un livre-->
<div class="row" id="div_ajouter_film" style="display:none;">
    <div class="col-md-12">
        <div class="col-md-12">
            <h3>AJOUTER &nbsp; FILM</h3>
        </div>
        <div class="col-md-12">
            <form class="form-horizontal" role="form" method="POST" action="AjoutMedia">
                <div class="form-group">
                    <div class="col-md-2">
                        <label for="Titre" class="control-label">Titre</label>
                    </div>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="titre" placeholder="titre" name="titre" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2">
                        <label for="realisateur" class="control-label">Realisateur</label>
                    </div>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="realisateur" placeholder="realisateur" name="realisateur" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2">
                        <label for="format" class="control-label">Format</label>
                    </div>
                    <div class="col-md-10">
                        <select name="format" class="col-md-12 form-control" required>
                            <option value="dvd">DVD</option>
                            <option value="cd">CD</option>
                            <option value="Blu-Ray">Blu-ray</option>
                        </select>
                    </div>
                </div>
                <input type="hidden" class="form-control" id="type" name="type" value="film">
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <button type="submit" class="btn btn-default">Ajouter</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Zone ajout d'une musique-->
<div class="row" id="div_ajouter_livre">
    <div class="col-md-12">
        <div class="col-md-12">
            <h3>AJOUTER &nbsp; LIVRE</h3>
        </div>
        <div class="col-md-12">
            <form class="form-horizontal" role="form" method="POST" action="AjoutMedia">
                <div class="form-group">
                    <div class="col-md-2">
                        <label for="Titre" class="control-label">Titre</label>
                    </div>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="titre" placeholder="titre" name="titre" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2">
                        <label for="Auteur" class="control-label">Auteur</label>
                    </div>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="auteur" placeholder="auteur" name="auteur" required>
                    </div>
                </div>
                <input type="hidden" class="form-control" id="type" name="type" value="livre">
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <button type="submit" class="btn btn-default">Ajouter</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- Zone ajout d'un film-->
<div class="row" id="div_ajouter_musique" style="display:none;">
    <div class="col-md-12">

        <div class="col-md-12">
            <h3>AJOUTER MUSIQUE</h3>
        </div>
        <div class="col-md-12">
            <form class="form-horizontal" role="form" method="POST" action="AjoutMedia">
                <div class="form-group">
                    <div class="col-md-2">
                        <label for="titre" class="control-label">Titre</label>
                    </div>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="titre" name="titre" placeholder="titre" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2">
                        <label for="artiste" class="control-label">Artiste </label>
                    </div>
                    <div class="col-md-10">
                        <input type="text" class="form-control" id="artiste" placeholder="artiste" name="artiste" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-2">
                        <label for="format" class="control-label">Format</label>
                    </div>
                    <div class="col-md-10">
                        <select name="format" class="col-md-12 form-control" required>
                            <option value="dvd">DVD</option>
                            <option value="cd">CD</option>
                        </select>
                    </div>
                </div>
                <input type="hidden" class="form-control" id="type" name="type" value="musique">
                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <button type="submit" class="btn btn-default">Ajouter</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- JS pour choix ajout livre , film ou musique-->
<script>
    function showLivre() {
        var livre = document.getElementById("div_ajouter_livre");
        var musique = document.getElementById("div_ajouter_musique");
        var film = document.getElementById("div_ajouter_film");
        var bt_livre = document.getElementById("bt_ajouter_livre");
        var bt_musique = document.getElementById("bt_ajouter_musique");
        var bt_film = document.getElementById("bt_ajouter_film");
        bt_livre.className = "active";
        bt_musique.className = "";
        bt_film.className = "";
        livre.style.display = '';
        musique.style.display = 'none';
        film.style.display = 'none';
    }
    function showMusique() {
        var livre = document.getElementById("div_ajouter_livre");
        var musique = document.getElementById("div_ajouter_musique");
        var film = document.getElementById("div_ajouter_film");
        var bt_livre = document.getElementById("bt_ajouter_livre");
        var bt_musique = document.getElementById("bt_ajouter_musique");
        var bt_film = document.getElementById("bt_ajouter_film");
        bt_livre.className = "";
        bt_musique.className = "active";
        bt_film.className = "";
        livre.style.display = 'none';
        musique.style.display = '';
        film.style.display = 'none';
    }
    function showFilm() {
        var livre = document.getElementById("div_ajouter_livre");
        var musique = document.getElementById("div_ajouter_musique");
        var film = document.getElementById("div_ajouter_film");
        var bt_livre = document.getElementById("bt_ajouter_livre");
        var bt_musique = document.getElementById("bt_ajouter_musique");
        var bt_film = document.getElementById("bt_ajouter_film");
        bt_livre.className = "";
        bt_musique.className = "";
        bt_film.className = "active";
        livre.style.display = 'none';
        musique.style.display = 'none';
        film.style.display = '';
    }
</script>
