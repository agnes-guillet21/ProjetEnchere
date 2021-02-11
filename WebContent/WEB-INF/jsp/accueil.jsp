<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="texte/css " href="/css/style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<title>Page d'acceuil</title>
</head>
<body>

	<div class="container-fluid">
		<header class="header">
			<div class="row">
				<div class="col-md-3">
					<p>ENI-Encheres</p>
					<!-- insertion fragments header  Eni-enchere-->
				</div>
				<div class="col-md-5"></div>
				<div class="col-md-4">
					<c:if test="${empty user}">
					<a href="connexion.html">S'inscrire - Se connecter </a>
					</c:if>
					<c:if test="${!empty user}">
						<a href="/ProjetEnchere">Enchères</a>
						<a href="vendre.html">Vendre un article</a>
						<a href="profil.html">Mon Profil</a>
						<a href="deconnexion.html">Déconnexion</a>
					</c:if>
				</div>
			</div>
		</header>
		   <div class="row">
		    <div class="col-md-4">
		    </div>
		    <div class="col-md-4">
                 <h3>Liste des enchères</h3>
		    </div>
		    <div class="col-md-4">
		    </div>
	    </div>
	    </br>
		 <div class="row">
                     <div class="col-md-5">
                        <p>Filtres :</p>
            <form class="rechercher" method="post" action="/ProjetEnchere">
                
                    <input type="search" placeholder="le nom de l'article contient"name="srecherche" id="lookup" /><br>
                    </div>
                    <div class="col-md-5">
                         <input type="text" name="sbarrerecherche" value="Recherche">
                       <button id="loupe" type="submit" class="icone-loupe" type="submit">
                        Rechercher
                        <!-- manque cette fucking  loupe   -->
                    </button>
                    </div>
                      <div class="col-md-2">
                      </div>
                 </div>
             </br>
                 <div class="row">
                      <div class="col-md-8">
                         <label for="catégorie" method="get">Catégorie : </label>
                         <select name="scategorie" id="categorie">
                            <option value="">Toutes</option>
                            <option value="informatique">Informatique</option>
                            <option value="ameublement">Ameublement</option>
                            <option value="vetement">Vetement</option>
                            <option value="sport&loisir">Sport Loisirs</option>
                        <!-- il y a "&" entre sport et loisir   -->
                        </select>
                     </div>
                        <div class="col-md-4">
                         </div>
                 </div>
             </form>

		<div>
			<!-- il y aura un article  -->
			<p>ArticleVendu</p>
			
			<c:if test="${empty listeEncheres.size()}">				
				<p>Aucune vente en cours</p>		
			</c:if>
			
			<p>Il y a ${listeEncheres.size()} ventes.</p>				
				<c:forEach var="v" items="${listeEncheres}">
					<div>
						<p>${v.nomArticle}</p>
						<p>Prix : ${v.prixVente} points</p>
						<p>Fin de l'enchère : ${v.dateFinEncheres}</p>
						<p>Vendeur : ${v.utilisateurVendeur.getPseudo()}</p>
					</div><br>
				</c:forEach>					

		</div>
	</div>
	 <footer>
        <div class="row">
            <div class="col-md-6"> 
            </div>
            <div class="col-md-6">
                <p>Amaury, Thomas & Agnès</p>  
            </div>
           
        </div>
    </footer>
</body>
</html>