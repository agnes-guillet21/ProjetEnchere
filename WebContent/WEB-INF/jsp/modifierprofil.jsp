<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier mon profil</title>
</head>
<body>
	<header>
		<h3>Profil</h3>
	</header>

	
	            <form action="modifierProfil" method="post">
	   
	                
	                <label for="pseudo">Pseudo :</label>
	                <input type="text" id="pseudo" name="pseudo" value="${utilisateur.pseudo}">
					<br>
	
	                <label for="nom">Nom :</label>
	                <input type="text" id="nom" name="nom" value="${utilisateur.nom}">
					<br>
	
					<label for="prenom">Prénom :</label>
	             	<input type="text" id="prenom" name="prenom" value="${utilisateur.prenom}">
					<br>
					
					<label for="mail">Email :</label>
	                <input type="email" id="mail" name="mail" value="${utilisateur.email}">
					<br>
					
					<label for="tel">Téléphone :</label>
	                <input type="tel" id="tel" name="tel" value="${utilisateur.telephone}">
					<br>
					
					<label for="rue">Rue :</label>
	                <input type="text" id="rue" name="rue" value="${utilisateur.rue}">
					<br>
					
					<label for="cpo">Code Postal :</label>
	                <input type="text"id="cpo" name="cpo" value="${utilisateur.codePostal}">
					<br>
					
					<label for="ville">Ville :</label>
	                <input type="text" id="ville" name="ville" value="${utilisateur.ville}">
					<br>
					
					
					<label for="password">Mot de passe :</label>
	                <input type="password" id="password" name="password" value="${utilisateur.motDePasse}">
					<br>
					
					<label for="checkPassword">Confirmation :</label>
	                <input type="password" id="checkPassword" name="checkPassword" value="${utilisateur.motDePasse}">
					<br>
					
					<label for="credit">Credit :</label>
	                <p>${utilisateur.credit}</p>
					<br>
					
					<div>
						<p>${success}</p>
						<button id="save" name="save">Enregistrer</button>
					</div>
				  </form>

	            
	            
	            <div>
	            	<form action="suppression" method="post">
	            		<button id="delete" name="delete">
	            		
	            			Supprimer mon compte
	            			
	            		</button>
	            	</form>
	            </div>
	            	
	            <div>
						
					<a id="previous" href="profil" class="btn btn-primary">Retour</a>
	       		</div>
	            	
		
	<script></script>
</body>
</html>