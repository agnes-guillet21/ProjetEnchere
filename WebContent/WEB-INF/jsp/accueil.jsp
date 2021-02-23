<%@ include file="/WEB-INF/fragments/header.jspf"%>



		 <div class="row">
		 <div class="col-md-1"></div>
                     <div class="col-md-5">
                        <p>Filtres :</p>
            <form class="rechercher" method="post" action="/ProjetEnchere">
                
                    <input type="search" placeholder="le nom de l'article contient"name="srecherche" size="25" id="lookup" /><br>
                    </div>
                    <div class="col-md-5">
                         <input type="text" name="sbarrerecherche" value="Recherche">
                       <button id="loupe" type="submit" class="icone-loupe" type="submit">
                        Rechercher
                        <!-- manque cette fucking  loupe   -->
                    </button>
                    </div>
                      <div class="col-md-2">
                      </div>
                 </div>
             <br>
                 <div class="row">
                 <div class="col-md-1"></div>
                      <div class="col-md-8">
                         <label for="cat�gorie">Cat�gorie : </label>
                         <select name="scategorie" id="categorie">
                            <option value="">Toutes</option>
                            <option value="informatique">Informatique</option>
                            <option value="ameublement">Ameublement</option>
                            <option value="vetement">Vetement</option>
                            <option value="sport&loisir">Sport Loisirs</option>
                        <!-- il y a "&" entre sport et loisir   -->
                        </select>
                     </div>
                        <div class="col-md-3">
                         </div>
                 </div>
             </form>

		<div class="row">
		<div class="col-md-1"></div>
            <div class="col-md-11">
                <c:if test="${empty listeEncheres.size()}">
                    <div>				
                        <p>Aucune vente en cours</p>
                    </div>		
                </c:if>
                
                <c:if test="${!empty listeEncheres.size()}">
                    <p>Il y a ${listeEncheres.size()} ventes.</p>
                </c:if>
            </div>
        </div>
        <br>    
        <div class="row"> 
        <div class="col-md-1"></div>
        	<div class="col-md-10">
        		
					<c:forEach var="v" items="${listeEncheres}">
					<div class="row">
					<div class="col-md-3"></div>
						<div class="card bg-default col-md-6 m-2 p-0">
							<h4 class="card-header bg-dark text-white">${v.nomArticle}<c:if test="${!empty user}"><a href="vente.html" class="card-link" ><span class="h6 text-white card-link ml-4">Acc�der � la vente</span><c:if test="${!empty user}"></a></c:if></c:if></h4>
							<div class="card-text">
								<p>Prix : ${v.prixVente} points</p>
								<p>Fin de l'ench�re : ${v.dateFinEncheres}</p>
							</div>
							<div class="card-footer"> 
								<c:if test="${!empty user}">
									<form method="post" action="profil.html" class="inline">
  										<label>Vendeur : </label><input type="hidden">
  										<button class="btn btn-link" type="submit" name="utilisateurVendeur" value="${v.utilisateurVendeur.getPseudo()}" class="link-button">
    										${v.utilisateurVendeur.getPseudo()}</button>
									</form>
							</c:if>
							<c:if test="${empty user}">Vendeur : ${v.utilisateurVendeur.getPseudo()}</c:if></div>
						</div>
						<div class="col-md-3"></div>
						</div>
					</c:forEach>
				
			</div>						
            <div class="col-md-1"></div>    

		</div>
	</div>
	
	<%@  include file="/WEB-INF/fragments/footer.jspf"%>
