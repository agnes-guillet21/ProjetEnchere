<%@ include file="/WEB-INF/fragments/header.jspf" %>


<<<<<<< HEAD
=======
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<title>
Page d'acceuil
</title>
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
						<a href="/ProjetEnchere">EnchÃ¨res</a>
						<a href="vendre.html">Vendre un article</a>
						<a href="profil.html">Mon Profil</a>
						<a href="deconnexion.html">DÃ©connexion</a>
					</c:if>
				</div>
			</div>
		</header>
		   <div class="row">
		    <div class="col-md-4">
		    </div>
		    <div class="col-md-4">
                 <h3>Listes des Ventes</h3>
		    </div>
		    <div class="col-md-4">
		    </div>
	    </div>
	    </br>
>>>>>>> branch 'main' of https://github.com/agnes-guillet21/ProjetEnchere
		 <div class="row">
		 <div class="col-md-1"></div>
                     <div class="col-md-5">
                        <p>Filtres :</p>
            <form class="rechercher" method="post" action="/ProjetEnchere">
                
                    <input type="search" placeholder="le nom de l'article contient"name="srecherche" size="25" id="lookup" /><br>
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
                 <div class="col-md-1"></div>
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
                        <div class="col-md-3">
                         </div>
                 </div>
             </form>

<<<<<<< HEAD
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
=======
		<div class="row">
		<div class="col-md-1"></div>
            <div class="col-md-11">
                <c:if test="${empty listeEncheres.size()}">
                    <div>				
                        <p>Aucune vente en cours</p>
                    </div>		
                </c:if>
                
                <c:if test="${!empty listeEncheres.size()}">
                    <p>Il y a ${listeEncheres.size()} ventes.</p>
                </c:if>
            </div>
        </div>
        <br>    
        <div class="row"> 
        <div class="col-md-1"></div>
        	<div class="col-md-10">
        		<div class="row">
					<c:forEach var="v" items="${listeEncheres}">
						<div class="card bg-default col-md-5 m-1 p-0">
							<h5 class="card-header"><c:if test="${!empty user}"><a href=""></c:if>${v.nomArticle}<c:if test="${!empty user}"></a></c:if></h5>
							<div class="card-text">
								<p>Prix : ${v.prixVente} points</p>
								<p>Fin de l'enchÃ¨re : ${v.dateFinEncheres}</p>
							</div>
							<div class="card-footer">Vendeur : <c:if test="${!empty user}"><a href=""></c:if>${v.utilisateurVendeur.getPseudo()}<c:if test="${!empty user}"></a></c:if></div>
						</div>
					</c:forEach>
				</div>
			</div>						
            <div class="col-md-1"></div>    
>>>>>>> branch 'main' of https://github.com/agnes-guillet21/ProjetEnchere
		</div>
	</div>
	
	<%@  include file="/WEB-INF/fragments/footer.jspf" %>
