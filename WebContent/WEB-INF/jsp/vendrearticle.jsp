<%@ include file="/WEB-INF/fragments/header.jspf" %>

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
			            	<c:forEach var="v" items="${listeCategories}">	
						   		<option value="${v.getLibelle()}">${v.getLibelle()}</option>
						    </c:forEach>
						</select>
		        </div>
		        <br>
		
		        <div>
		            <label for="miseAPrix">Mise A Prix :</label>
		            <input type="number" id="miseAPrix" name="miseAPrix" value="">
		        </div>
		        <br>
		
		        <div>
		            <label for="dateDebutEnchere">Début de l'Enchère :</label>
		            <input type="date" id="dateDebutEnchere" name="dateDebutEnchere" value="">
		        </div>
		        <br>
		
		        <div>
		            <label for="dateFinEnchere">Fin de l'Enchère :</label>
		            <input type="date" id="dateFinEnchere" name="dateFinEnchere" value="">
		        </div>
		        <br>
		
				<fieldset>
    				<legend>Retrait</legend>
					
					<div>
			            <label for="rue">Rue :</label>
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
			        <br>
			
		    	</fieldset>
		    <br>
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


    </div> 
	 <%@  include file="/WEB-INF/fragments/footer.jspf" %>