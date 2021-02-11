<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profil</title>
</head>
	<body>

				<header>
				<p>Eni-encheres</p>
			    <!--faire un fragment-->
				</header>
				
	<body>
	
	            <form action="" method="post">
	   
	                
	                <label for="pseudo">Pseudo :</label>
	             <p>${utilisateur.pseudo}<p>
					<br>
	
	                <label for="name">Nom :</label>
	             <p>${utilisateur.nom}</p>
					<br>
	
					<label for="firstname">Prénom :</label>
	             <p>${utilisateur.prenom}</p>
					<br>
					
					<label for="mail">Email :</label>
	             <p>${utilisateur.email}</p>
					<br>
					
					<label for="tel">Téléphone :</label>
	             <p>${utilisateur.telephone}</p>
					<br>
					
					<label for="address">Rue :</label>
	             <p>${utilisateur.rue}</p>
					<br>
					
					<label for="cpo">Code Postal :</label>
	             <p>${utilisateur.codePostal}</p>
					<br>
					
					<label for="city">Ville :</label>
	             <p>${utilisateur.ville}</p>
					<br>
					
					</form>	
				<div>
						
						<a id="modifProfil" href="modifierprofil" class="btn btn-primary">Modifier</a>
	        	</div>
	<script></script>
</body>
</html>