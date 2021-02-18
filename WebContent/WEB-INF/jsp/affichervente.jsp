<%@ include file="/WEB-INF/fragments/header.jspf" %>
					
    </div>
        </div> <% ArticleVendu article = (ArticleVendu)request.getAttribute("NomArticle"); %>
        <table>
       		 <tr>
                <td class="td1"><p class="value-td1">Nom:</p></td>
                <td class="td2"><p class="value-td2"><%=article.getNomArticle() %></p></td>
            </tr>
            <tr>
                <td class="td1"><p class="value-td1">Description:</p></td>
                <td class="td2"><p class="value-td2"><%=article.getDescription() %></p></td>
            </tr>
            <%if(article.getPrixVente() != 0) { %>
            <tr>
                <td class="td1"><p class="value-td1">Meilleure offre:</p></td>
                <td class="td2"><p class="value-td2"><%=article.getMeilleureOffre() %></p></td>
            </tr>
            <% } %>
            <tr>
                <td class="td1"><p class="value-td1">Mise à prix:</p></td>
                <td class="td2"><p class="value-td2"><%=article.getMiseAPrix() %></p></td>
            </tr>  
            <tr>
                <td class="td1"><p class="value-td1">Fin de l'enchère:</p></td>
                <td class="td2"><p class="value-td2"><%=article.getFindeEncheres().format( !!!!! ("dd/MM/YYYY")) %></p></td>
            </tr>
            <tr>
                <td class="td1"><p class="value-td1">Retrait:</p></td>
                <td class="td2"><p class="value-td2"><%=article.getLieuRetrait().getRue()  %>, <%=article.getLieuRetrait().getCodePostal()%>, <%=article.getLieuRetrait().getVille() %></p></td>
            </tr>
            <tr>
                <td class="td1"><p class="value-td1">Vendeur:</p></td>
                <td class="td2"><p class="value-td2"><%=article.getutilisateurVendeur().getPseudo() %></p></td>
            </tr> 
        </table>
		<form action="<%=request.getContextPath()%>/encherir" method="post">
			<div class="input-field">
				<label for="mpropo">Ma Proposition :</label>
				<input class="input" type="number" name="mpropo" id="mpropo" step="1" max= "10000" required>
			</div>
		    <div>
		        <button class="btn-login" type="submit">Enchérir</button>
		    </div>
	      <input value="<%=article.getId()%>" type="text" id="idArticle" name="idArticle" style="visibility:hidden;">
		</form>
      </a>
    </div>
  </body>
</html>
	        	
<%@  include file="/WEB-INF/fragments/footer.jspf" %>