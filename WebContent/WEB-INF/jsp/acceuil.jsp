<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page d'acceuil</title>
</head>
<body>
             
             <p>ENI-Encheres</p><!-- insertion fragments header  Eni-enchere-->
             <a href="">S'inscrire </a><!-- mettre l url de la jsp create login-->
             <a href="">Se connecter </a><!-- mettre l url de la jsp  -->
            <h3>Liste des enchères</h3>
        <div>
            <p>Filtres : </p>
            <form class="rechercher" method="post" action=""><!-- nom de servlet  -->
                <p>
                    <input type="search" placeholder="le nom de l'article contient" name="srecherche" id="lookup" />
                    <button id="loupe" type="submit" class="icone-loupe" type="submit">
                        <!-- manque cette fucking  loupe   -->
                    </button>
                </p>
            </form>
        </div>
        <div>
            <form action="" methode="GET"><!-- remplir l url action mais je ne sais pas quoi   -->
                 <input type="text" name="sbarrerecherche" value="Recherche">
                 <!-- en css on aura une shadow sur cette div    -->
            </form>
        </div>
        <br>
        <div>
            <label for="catégorie" methode="">Catégorie : </label>
                <select name="scategorie" id="categorie">   
                    <option value="">Toutes</option>
                    <option value="informatique">Informatique</option>
                    <option value="ameublement">Ameublement </option>
                    <option value="vetement">Vetement</option>
                    <option value="sport&loisir">Sport & Loisirs</option>
                </select>
        </div>
        <div>
           <!-- il y aura un article  --> 
           <p>ArticleVendu</p>
        </div>
        </body>
</html>