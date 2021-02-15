<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<<<<<<< HEAD
<meta charset="ISO-8859-1">
<title>Vendre un article</title>
</head>
<body>
	<h1>Nouvelle Vente</h1>
=======
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<title>Vendre un article</title>
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
						<span>Vendre un article</span>
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
                 <h3>Nouvelle Vente</h3>
		    </div>
		    <div class="col-md-4">
		    </div>
	    </div>
	    </br>
		  <form action="vendre.html" method="post">
		        <div>
		            <label for="nomArticle">Article :</label>
		            <input type="text" id="nomArticle" name="nomArticle" value="" size="30" maxlength="30">
		        </div>
		        </br>
		
		        <div>
		            <label for="description">Description :</label>
		            <input type="text" id="description" name="description" value="" maxlength="300">
		        </div>
		        </br>
		
		        <div>
		            <label for="categorie">Catégorie</label>
						<select name="categorie" id="categorie">
						<option value="exemple1">Exemple 1</option>
						<option value="exemple2">Exemple 2</option>
			            	<c:forEach var="v" items="${listeCategories}">	
						   		<option value="${v.nomCategorie}">${v.nomCategorie}</option>
						    </c:forEach>
						</select>
		        </div>
		        </br>
		
		        <div>
		            <label for="miseAPrix">Mise A Prix :</label>
		            <input type="number" id="miseAPrix" name="miseAPrix" value="">
		        </div>
		        </br>
		
		        <div>
		            <label for="dateDebutEnchere">Début de l'Enchère :</label>
		            <input type="date" id="dateDebutEnchere" name="dateDebutEnchere" value="">
		        </div>
		        </br>
		
		        <div>
		            <label for="dateFinEnchere">Fin de l'Enchère :</label>
		            <input type="date" id="dateFinEnchere" name="dateFinEnchere" value="">
		        </div>
		        </br>
		
				<fieldset>
    				<legend>Retrait</legend>
					
					<div>
			            <label for="rue">Rue:</label>
			            <input type="text" id="rue" name="rue" size="30" value="${user.getRue() }" size="30" maxlength="30">
			        </div>
		
			        <div>
			            <label for="codePostal">Code Postal :</label>
			            <input type="text" id="cp" name="codePostal" value="${user.getCodepostal() }" size="30" maxlength="10">
			        </div>
			        </br>
			
			        <div>
			            <label for="ville">Ville :</label>
			            <input type="text" id="ville" name="ville" value="${user.getVille() }" size="30" maxlength="30">
			        </div>
			        </br>
			
		    	</fieldset>
		    </br>
		    <div>
		        <input type="submit" value="Enregistrer">
		    </div> 
		</form>
		
    <div>
    <br>
    <form action="/ProjetEnchere">
    	<button>Annuler</button>
    </form>
    
    <form action="annulervente.html" method="post">
    	<button>Annuler la vente</button>
    </form>

    <!--redirection sur page d accueil page 1 du pdf -->
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
>>>>>>> branch 'main' of https://github.com/agnes-guillet21/ProjetEnchere
</body>
</html>