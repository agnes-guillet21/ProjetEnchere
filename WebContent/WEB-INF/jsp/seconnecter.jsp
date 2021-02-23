<%@ include file="/WEB-INF/fragments/header.jspf" %>

			<div class="row">
	             <div class="col-md-4"></div><div class="col-md-4"><p class="text-danger">${messageErreur }</p></div>
			</div>

		<form action="connexion.html" method="POST">
			
			<div class="row">
	             <div class="col-md-4"></div><div class="col-md-1"><label for="susername">Identifiant</label></div>
	             <div class="col-md-3"><input type="text"
					placeholder="Entrer le nom d'utilisateur" name="susername" required></div>
			</div>

			<div class="row">
				<div class="col-md-4"></div><div class="col-md-1"><label for="spassword">Mot de passe</label></div>
				<div class="col-md-3"><input type="password"
					placeholder="Entrer le mot de passe" name="spassword" required></div>
			</div>
			
			<div class="row">
				<div class="col-md-4"></div><div class="col-md-3"><input class="btn btn-outline-success" type="submit" id="submit" value="Connexion"></div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4"></div><div class="col-md-4"><input type="checkbox" id="sesouvenir" name="ssouvenir">
				<!-- je ne sais pas si je mets une value -->
				<!--si on veut que se soit coche on fait un checked-->
				<label for="se souvenir de moi ">Se souvenir de moi </label></div>
			</div>
		</form>	
		
			<div class="row">
				<div class="col-md-4"></div><div class="col-md-4"><a href="">Mot de passe oublié</a></div>
			</div>
			<br>

			<div class="row">
			<div class="col-md-4"></div>
				<div class="col-md-2">	
					<a  class="btn btn-outline-primary" href="inscription.html">Créer un compte</a>
					</form>
				</div>
				<div class="col-md-2">
					<a class="btn btn-outline-danger" href="/ProjetEnchere">Annuler</a>
				</div>
		
			</div>
	    
	
<%@  include file="/WEB-INF/fragments/footer.jspf" %>