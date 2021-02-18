<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/fragments/header.jspf"%>


    <form action="inscription.html" method="post"  class="row gy-2 gx-3 align-items-center">
        <div class="col-auto form-group">
            <label for="pseudo">Pseudo :</label>
            <input type="text" id="pseudo" name="userpseudo" value="<c:out value="${param.userpseudo}"/>" size="30" maxlength="30" required>
             <span class="erreur">${erreurs['userpseudo']}</span>
        </div>
       <br>
      

        <div class="col-auto form-group">
            <label for="name">Nom :</label>
            
             <input type="text" id="name" name="username" value="<c:out value="${param.username}"/>" size="30" maxlength="30" required> 
            <span class="erreur">${erreurs['username']}</span>
           
        </div>
        <br>

        <div class="col-auto form-group">
            <label for="prenom">Prenom :</label>
            <input id="prenom" name="userfirstname" value="<c:out value="${param.userfirstname}"/>"size="30" maxlength="30" required></input>
            <span class="erreur">${erreurs['userfirstname']}</span>
        </div>
        <br>

        <div class="col-auto form-group">
            <label for="mail">e-mail :</label>
            <input type="email" id="mail" name="usermail" value="" size="30" maxlength="100" required>
           <span class="erreur">${erreurs['userfirstname']}</span>
        </div>
        <br>

        <div class="col-auto form-group">
            <label for="tel">Téléphone :</label>
            <input type="text" id="tel" name="userphone"value="" size="20" maxlength="15">
            <span class="erreur">${erreurs['userphone']}</span>
        </div>
        <br>

        <div class="col-auto form-group">
            <label for="rue">Rue :</label>
            <input type="text" id="rue" name="user_street"value="" size="30" maxlength="50" required>
       <span class="erreur">${erreurs['user_street']}</span>
        </div>
        <br>

        <div class="col-auto form-group">
            <label for="codePostal">Code Postal :</label>
            <input type="text" id="cp" name="usercp" value="" size="30" maxlength="10" required>
        <span class="erreur">${erreurs['usercp']}</span>
        </div>
        <br>

        <div class="col-auto form-group">
            <label for="ville">Ville:</label>
            <input type="text" id="ville" name="city" value="" size="30" maxlength="30" required>
        <span class="erreur">${erreurs['city']}</span>
        </div>
        <br>

        <div class="col-md-5 form-group">
            <label for="password">Mot de passe:</label>
            <input type="text" id="s_password" name="spassword" size="30" value="" size="30" maxlength="30"required>
        	<span class="erreur">${erreurs['spassword']}</span>
        </div>
        <br>
 <br>
        <div class="col-md-12 form-group">
            <label for="ConfirPassword">Confirmation du mot de passe:</label>
            <input type="text" id="s_password" name="spassword2" value=""  size="30" maxlength="30" required>
        <span class="erreur">${erreurs['spassword2']}</span>
        </div>
        <br>
    
   
    <div  class="pull-right- form-group">
        <input  type="submit" value="Creer">
        
        <!--redirection sur page liste d enchere en log IN page 4  du pdf -->
    </div> 
    <br>
</form>
   
    <form action="/ProjetEnchere">
    	<button class="pull-right form-group " >Annuler</button>
    </form>

    <!--redirection sur page d accueil page 1 du pdf -->
    </div> 
</body>
</html>