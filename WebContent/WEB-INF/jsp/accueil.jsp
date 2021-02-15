<%@ include file="/WEB-INF/fragments/header.jspf" %>


		 <div class="row">
                     <div class="col-md-5">
                        <p>Filtres :</p>
            <form class="rechercher" method="post" action="/ProjetEnchere">
                
                    <input type="search" placeholder="le nom de l'article contient"name="srecherche" id="lookup" /><br>
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
             </br>
                 <div class="row">
                      <div class="col-md-8">
                         <label for="catégorie" method="get">Catégorie : </label>
                         <select name="scategorie" id="categorie">
                            <option value="">Toutes</option>
                            <option value="informatique">Informatique</option>
                            <option value="ameublement">Ameublement</option>
                            <option value="vetement">Vetement</option>
                            <option value="sport&loisir">Sport Loisirs</option>
                        <!-- il y a "&" entre sport et loisir   -->
                        </select>
                     </div>
                        <div class="col-md-4">
                         </div>
                 </div>
             </form>

		<div>
			<!-- il y aura un article  -->
			<p>ArticleVendu</p>
			
			<c:if test="${empty listeEncheres.size()}">				
				<p>Aucune vente en cours</p>		
			</c:if>
			
			<p>Il y a ${listeEncheres.size()} ventes.</p>				
				<c:forEach var="v" items="${listeEncheres}">
					<div>
						<p>${v.nomArticle}</p>
						<p>Prix : ${v.prixVente} points</p>
						<p>Fin de l'enchère : ${v.dateFinEncheres}</p>
						<p>Vendeur : ${v.utilisateurVendeur.getPseudo()}</p>
					</div><br>
				</c:forEach>					
		</div>
	</div>
	
	<%@  include file="/WEB-INF/fragments/footer.jspf" %>
