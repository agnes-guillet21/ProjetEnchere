<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier mon profil</title>
</head>
<body>
	<header>
		<h3>Mon profil</h3>
	</header>

	<form action="" method="post">
		<div>
			<label for="pseudo">Pseudo :</label> <input type="text" id="name"
				name="userpseudo">
			<!--le pseudo doit etre unique & n'accepte que des caracteres alaphanumerique -->
		</div>
		</br>

		<div>
			<label for="name">Nom :</label> <input type="text" id="name"
				name="username">
		</div>
		</br>

		<div>
			<label for="prenom">Prénom :</label> <input id="prenom"
				name="userfirstname"></input>
		</div>
		</br>

		<div>
			<label for="mail">e-mail :</label> <input type="email" id="mail"
				name="usermail">
			<!--doit etre unique-->
		</div>
		</br>

		<div>
			<label for="tel">Téléphone :</label> <input type="text" id="tel"
				name="userphone">
		</div>
		</br>

		<div>
			<label for="rue">Rue :</label> <input type="text" id="rue"
				name="userstreet">
		</div>
		</br>

		<div>
			<label for="codePostal">Code Postal :</label> <input type="text"
				id="cp" name="usercp">
		</div>
		</br>

		<div>
			<label for="ville">Ville:</label> <input type="text" id="ville"
				name="city">
		</div>
		</br>

		<div>
			<label for="password">Mot de passe:</label> <input type="text"
				id="s_password" name="spassword">
		</div>
		</br>

		<div>
			<label for="ConfirPassword">Confirmation:</label> <input type="text"
				id="s_password" name="spassword">
		</div>
		</br>
	</form>
	</br>
	<div>
		<p>Credits :</p>
	</div>
	<div>
		<input type="submit" value="Enregistrer">
	</div>
	</br>

	<div>
		<input type="submit" value="Supprimer mon compte">
		  <ul>

		 <c:forEach var="utilisateur" items="${ utilisateurs }">
		             <li>
		             <c:out value="${ utilisateur.id }" />
		             <c:out value="${ utilisateur.prenom }" />

		             <c:out value="${ utilisateur.nom }" />
	            	 <c:out value="${ utilisateur.email }" />
		     <input type="checkbox" name="delete" value="${ utilisateur }"/>

		             </li>

		         </c:forEach>

		     </ul>    
		<!--renvoi sur la page d'acceuil-->
	</div>
</body>
</html>