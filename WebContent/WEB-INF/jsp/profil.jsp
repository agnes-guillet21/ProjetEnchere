<%@ include file="/WEB-INF/fragments/header.jspf" %>
	
	                <h3>${user.getPseudo()}</h3>
					<br>
	
	                <div>Nom :</div>
	             <div>${user.getNom()}</div>
					<br>
	
					<div for="firstname">Prénom :</label>
	             <span>${user.getPrenom()}</span>
					<br>
					
					<label for="mail">Email :</label>
	             <span>${user.getEmail()}</span>
					<br>
					
					<label for="tel">Téléphone :</label>
	             <span>${user.getTelephone()}</span>
					<br>
					
					<label for="address">Rue :</label>
	             <span>${user.getRue()}</span>
					<br>
					
					<label for="cpo">Code Postal :</label>
	             <span>${user.getCodepostal()}</span>
					<br>
					
					<label for="city">Ville :</label>
	             <span>${user.getVille()}</span>
					<br>

				<div>
						
						<a id="modifProfil" href="modifierprofil" class="btn btn-primary">Modifier</a>
	        	</div>
	
</body>
</html>