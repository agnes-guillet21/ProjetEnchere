<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page de Connexion</title>
</head>
<body>
	</br>
	<div id="container">
		<!-- zone de connexion -->

		<form action="verification.php" method="POST">
			<div>
				<label>Identifiant</label> <input type="text"
					placeholder="Entrer le nom d'utilisateur" name="susername" required>
			</div>
			</br>

			<div>
				<label>Mot de passe</label> <input type="password"
					placeholder="Entrer le mot de passe" name="spassword" required>
			</div>
			</br>
			<!-- if get username ou get password == null -->
			<!-- Utilisateur ou mot de passe incorrect-->
			<div>
				<input type="submit" id='submit' value='Connexion'>
			</div>
			</br>

			<div>
				<input type="checkbox" id="sesouvenir" name="ssouvenir">
				<!-- je ne sais pas si je mets une value -->
				<!--si on veut que se soit coche on fait un checked-->
				<label for="se souvenir de moi ">Se souvenir de moi </label>
			</div>
			</br>

			<div>
				<a href="">Mot de passe oublié</a>
			</div>
			</br>

			<div>
				<!-- ou lien vers page mon profil-->
				<input type="submit" value="creer un compte" name="screer">
				

			</div>
		</form>
	<div>
	    <form action="/ProjetEnchere">
	    	<button>Annuler</button>
	    </form>
	
	    <!--redirection sur page d accueil page 1 du pdf -->
    </div> 
	</div>
</body>
</html>