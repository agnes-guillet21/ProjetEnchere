<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="ProjetEnchere.bo.ArticleVendu"  %>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page d'acceuil</title>
</head>
<body>
             
             <p>ENI-Encheres</p><!-- insertion fragments header  Eni-enchere-->
             <a href="inscription.html">S'inscrire </a><!-- mettre l url de la jsp create login-->
             <a href="connexion.html">Se connecter </a><!-- mettre l url de la jsp  -->
            <h3>Liste des enchères</h3>
        <div>
            <p>Filtres : </p>
            <form class="rechercher" method="post" action="/ProjetEnchere"><!-- nom de servlet  -->
                <p>
                    <input type="search" placeholder="le nom de l'article contient" name="srecherche" id="lookup" /><br><br>
                 	<input type="text" name="sbarrerecherche" value="Recherche"><br><br>
                 	<!-- en css on aura une shadow sur cette div    -->
            	<label for="catégorie" method="get">Catégorie : </label>
                <select name="scategorie" id="categorie">   
                    <option value="">Toutes</option>
                    <option value="informatique">Informatique</option>
                    <option value="ameublement">Ameublement </option>
                    <option value="vetement">Vetement</option>
                    <option value="sport&loisir">Sport Loisirs</option>
                    <!-- il y a "&" entre sport et loisir   --> 
                </select><br><br>
 				<button id="loupe" type="submit" class="icone-loupe" type="submit">
                        Rechercher<!-- manque cette fucking  loupe   -->
                </button>
                </p>
            </form>
        </div>
        
        <div>
           <!-- il y aura un article  --> 
           <p>ArticleVendu</p>
 
            
           
        </div>
        </body>
</html>