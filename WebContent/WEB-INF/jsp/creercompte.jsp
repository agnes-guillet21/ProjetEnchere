<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/fragments/header.jspf"%>


    <form action="inscription.html" method="post">
        
        
        
 
       
        <div class="row">
	                <div class="col-md-4"></div>
	                <div class="col-md-2"><label for="pseudo">Pseudo *:</label></div>
	               <div class="col-md-3"> <input type="text" id="pseudo" name="userpseudo" value="<c:out value="${param.userpseudo}"/>" size="30" maxlength="30" required>
             		<span class="erreur">${erreurs['userpseudo']}</span>
	                </div>
					</div>
					<br>
					<div class="row">
	                	<div class="col-md-4"></div>
	                	<div class="col-md-2"><label for="name">Nom *:</label></div>
	                	<div class="col-md-3">
	                	<input type="text" id="name" name="username" value="<c:out value="${param.username}"/>" size="30" maxlength="30" required> 
            			<span class="erreur">${erreurs['username']}</span>
	                	</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-2"> <label for="prenom">Prénom *:</label></div>
						<div class="col-md-3"><input id="prenom" name="userfirstname" value="<c:out value="${param.userfirstname}"/>"size="30" maxlength="30" required></input>
            			<span class="erreur">${erreurs['userfirstname']}</span>
           				</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-2"><label for="mail">Email *:</label></div>
            			<div class="col-md-3"><input type="email" id="mail" name="usermail" value="" size="30" maxlength="100" required>
          				<span class="erreur">${erreurs['userfirstname']}</span></div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-2"> <label for="tel">Téléphone :</label></div>
            			<div class="col-md-3"><input type="text" id="tel" name="userphone"value="" size="20" maxlength="15">
            			<span class="erreur">${erreurs['userphone']}</span>
            			</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-2"> <label for="rue">Rue * :</label></div>
						<div class="col-md-3"> <input type="text" id="rue" name="user_street"value="" size="30" maxlength="50" required>
       					<span class="erreur">${erreurs['user_street']}</span></div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-2">Ville * :</div>
						<div class="col-md-3"> <input type="text" id="ville" name="city" value="" size="30" maxlength="30" required>
        <span class="erreur">${erreurs['city']}</span></div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-2">Code Postal * :</div>
						<div class="col-md-3"> <input type="text" id="cp" name="usercp" value="" size="30" maxlength="10" required>
        				<span class="erreur">${erreurs['usercp']}</span></div>
					</div>
					<br>
       				 <div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-2">Mot de passe *:</div>
						<div class="col-md-3"> 
						<input type="text" id="s_password" name="spassword" size="30" value="" size="30" maxlength="30"required>
        				<span class="erreur">${erreurs['spassword']}</span></div>
						</div>
					<br>
					<div class="row">
      					 <div class="col-md-4"></div>
						<div class="col-md-2">Confirmation du mot de passe * :</div>
						<div class="col-md-3"><input type="text" id="s_password" name="spassword2" value=""  size="30" maxlength="30" required>
       					 <span class="erreur">${erreurs['spassword2']}</span></div>
					</div>
         <br>
        
        
        
        <div class="row">
        <div class="col-md-4"></div>
		<div class="col-md-4"><input class="btn btn-outline-success my-2 my-sm-0"  type="submit" value="Creer"></div>
         <div class="col-md-4"></div>
        </div>
        </form>
        <br>
      
         <form action="/ProjetEnchere">
          <div class="row">
         <div class="col-md-4"></div>
		<div class="col-md-4"><input class="btn btn-outline-danger" type="submit" value="Annuler"></div>
         <div class="col-md-4"></div>
         </div>
         </form>
     
        
        
        
<%@  include file="/WEB-INF/fragments/footer.jspf" %>