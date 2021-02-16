<%@ include file="/WEB-INF/fragments/header.jspf" %>
					
					<div class="row">
	                <div class="col-md-4"></div><div class="col-md-1">Pseudo :</div><div class="col-md-3">${user.getPseudo()}</div>
					</div>
					
					<div class="row">
	                	<div class="col-md-4"></div><div class="col-md-1">Nom :</div><div class="col-md-3">${user.getNom()}</div>
					</div>
					
					<div class="row">
						<div class="col-md-4"></div><div class="col-md-1">Prénom :</div><div class="col-md-3">${user.getPrenom()}</div>
					</div>
					
					<div class="row">
						<div class="col-md-4"></div><div class="col-md-1">Email :</div><div class="col-md-3">${user.getEmail()}</div>
					</div>
					
					<div class="row">
						<div class="col-md-4"></div><div class="col-md-1">Téléphone :</div><div class="col-md-3">${user.getTelephone()}</div>
					</div>
					
					<div class="row">
						<div class="col-md-4"></div><div class="col-md-1">Rue :</div><div class="col-md-3">${user.getRue()}</div>
					</div>
					
					<div class="row">
						<div class="col-md-4"></div><div class="col-md-1">Code Postal :</div><div class="col-md-3">${user.getCodepostal()}</div>
					</div>
					
					<div class="row">
						<div class="col-md-4"></div><div class="col-md-1">Ville :</div><div class="col-md-3">${user.getVille()}</div>
					</div>
				<br>
				<div class="row">
						<div class="col-md-4"></div>
						<c:if test="${userProfil.getPseudo().equals(user.getPseudo())}">
							<div class="col-md-3"><a id="modifProfil" href="modifierprofil.html" class="btn btn-primary">Modifier</a></div>
						</c:if>	
	        	</div>
	        	
	        	
<%@  include file="/WEB-INF/fragments/footer.jspf" %>