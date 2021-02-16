<%@ include file="/WEB-INF/fragments/header.jspf" %>
					
					<div class="row">
	                <div class="col-md-4"></div><div class="col-md-2">Pseudo :</div><div class="col-md-2">${user.getPseudo()}</div>
					</div>
					
					<div class="row">
	                	<div class="col-md-4"></div><div class="col-md-2">Nom :</div><div class="col-md-2">${user.getNom()}</div>
					</div>
					
					<div class="row">
						<div class="col-md-4"></div><div class="col-md-2">Prénom :</div><div class="col-md-2">${user.getPrenom()}</div>
					</div>
					
					<div class="row">
						<div class="col-md-4"></div><div class="col-md-2">Email :</div><div class="col-md-2">${user.getEmail()}</div>
					</div>
					
					<div class="row">
						<div class="col-md-4"></div><div class="col-md-2">Téléphone :</div><div class="col-md-2">${user.getTelephone()}</div>
					</div>
					
					<div class="row">
						<div class="col-md-4"></div><div class="col-md-2">Rue :</div><div class="col-md-2">${user.getRue()}</div>
					</div>
					
					<div class="row">
						<div class="col-md-4"></div><div class="col-md-2">Code Postal :</div><div class="col-md-2">${user.getCodepostal()}</div>
					</div>
					
					<div class="row">
						<div class="col-md-4"></div><div class="col-md-2">Ville :</div><div class="col-md-2">${user.getVille()}</div>
					</div>
				<br>
				<div class="row">
						<div class="col-md-4"></div>
						<c:if test="${userProfil.getPseudo().equals(user.getPseudo())}">
							<div class="col-md-4"><a id="modifProfil" href="modifierprofil" class="btn btn-primary">Modifier</a></div>
						</c:if>	
	        	</div>
	        	
	        	
<%@  include file="/WEB-INF/fragments/footer.jspf" %>