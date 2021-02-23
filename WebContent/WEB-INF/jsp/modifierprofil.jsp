<%@ include file="/WEB-INF/fragments/header.jspf" %>

					<div class="row">
	                <div class="col-md-4"></div><div class="col-md-4"><p class="text-success">${succes}</p></div>
					</div>
		
	            <form action="modifierprofil.html" method="post">
	   
	                <div class="row">
	                <div class="col-md-4"></div><div class="col-md-1"><label for="pseudo">Pseudo</label></div>
	                <div class="col-md-3"><input type="text" id="pseudo" name="pseudo" value="${user.getPseudo()}"></div>
	                <div class="col-md-4"></div>
					</div>
					
					<div class="row">
	                <div class="col-md-4"></div><div class="col-md-1"><label for="nom">Nom</label></div>
	                <div class="col-md-3"><input type="text" id="nom" name="nom" value="${user.getNom()}"></div>
					</div>
					
					<div class="row">
					<div class="col-md-4"></div><div class="col-md-1"><label for="prenom">Prénom</label></div>
	             	<div class="col-md-3"><input type="text" id="prenom" name="prenom" value="${user.getPrenom()}"></div>
					</div>
					
					<div class="row">
					<div class="col-md-4"></div><div class="col-md-1"><label for="mail">Email</label></div>
	               <div class="col-md-3"><input type="email" id="mail" name="mail" value="${user.getEmail()}"></div>
					</div>
					
					<div class="row">
					<div class="col-md-4"></div><div class="col-md-1"><label for="tel">Téléphone</label></div>
	                <div class="col-md-3"><input type="tel" id="tel" name="tel" value="${user.getTelephone()}"></div>
					</div>
					
					<div class="row">
					<div class="col-md-4"></div><div class="col-md-1"><label for="rue">Rue</label></div>
	                <div class="col-md-3"><input type="text" id="rue" name="rue" value="${user.getRue()}"></div>
					</div>
					
					<div class="row">
					<div class="col-md-4"></div><div class="col-md-1"><label for="cpo">Code Postal</label></div>
	                <div class="col-md-3"><input type="text"id="cpo" name="cpo" value="${user.getCodepostal()}"></div>
					</div>
					
					<div class="row">
					<div class="col-md-4"></div><div class="col-md-1"><label for="ville">Ville</label></div>
	                <div class="col-md-3"><input type="text" id="ville" name="ville" value="${user.getVille()}"></div>
					</div>
					
					<div class="row">
	                <div class="col-md-4"></div><div class="col-md-4"><p class="text-danger">${error}</p></div>
					</div>
					
					<div class="row">
					<div class="col-md-4"></div><div class="col-md-1"><label for="password">Mot de passe</label></div>
	                <div class="col-md-3"><input type="password" id="password" name="password" value="${user.getMotDePasse()}"></div>
					</div>
					
					<div class="row">
					<div class="col-md-4"></div><div class="col-md-1"><label for="checkPassword">Confirmation</label></div>
	                <div class="col-md-3"><input type="password" id="checkPassword" name="checkPassword" value="${user.getMotDePasse()}"></div>
					</div>
					
					<div class="row">
					<div class="col-md-4"></div><div class="col-md-1"><label for="credit">Credit</label></div>
	                <div class="col-md-3"><p>${user.getCredit()} points</p></div>
					</div>
	                
					<br>
					
					<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4">
						<button type="submit" id="submit" name="submit" class="btn btn-outline-success">Enregistrer</button>
						<a id="delete" name="delete" class="btn btn-outline-danger" href="SupprimerCompte.html">Supprimer mon compte</a>
						<a id="previous" href="profil.html" class="btn btn-outline-primary">Retour</a>
					</div>
					</div>
				  	</form>
					
		
<%@  include file="/WEB-INF/fragments/footer.jspf" %>