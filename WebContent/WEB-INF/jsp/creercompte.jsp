<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Création compte</title>
</head>
<body>
 <header>
        <h3>Mon profil</h3>   
    </header>

    <form action="inscription.html" method="post">
        <div>
            <label for="pseudo">Pseudo :</label>
            <input type="text" id="pseudo" name="userpseudo" value="" size="30" maxlength="30">
             <!--le pseudo doit etre unique & n'accepte que des caracteres alaphanumerique -->
        </div>
        </br>

        <div>
            <label for="name">Nom :</label>
            <input type="text" id="name" name="username" value="" size="30" maxlength="30">
        </div>
        </br>

        <div>
            <label for="prenom">Prenom :</label>
            <input id="prenom" name="userfirstname" value="" size="30" maxlength="30"></input>
        </div>
        </br>

        <div>
            <label for="mail">e-mail :</label>
            <input type="email" id="mail" name="usermail" value="" size="30" maxlength="100">
            <!--doit etre unique-->
        </div>
        </br>

        <div>
            <label for="tel">Téléphone :</label>
            <input type="text" id="tel" name="userphone"value="" size="20" maxlength="15">
        </div>
        </br>

        <div>
            <label for="rue">Rue :</label>
            <input type="text" id="rue" name="user_street"value="" size="30" maxlength="50">
        </div>
        </br>

        <div>
            <label for="codePostal">Code Postal :</label>
            <input type="text" id="cp" name="usercp" value="" size="30" maxlength="10">
        </div>
        </br>

        <div>
            <label for="ville">Ville:</label>
            <input type="text" id="ville" name="city" value="" size="30" maxlength="30">
        </div>
        </br>

        <div>
            <label for="password">Mot de passe:</label>
            <input type="text" id="s_password" name="spassword" size="30" value="" size="30" maxlength="30">
        </div>
        </br>

        <div>
            <label for="ConfirPassword">Confirmation du mot de passe:</label>
            <input type="text" id="s_password" name="spassword2" value=""  size="30" maxlength="30" required>
        </div>
        </br>
   
    </br>
    <div>
        <input type="submit" value="Creer">
        <!--redirection sur page liste d enchere en log IN page 4  du pdf -->
    </div> 
    </br>
 </form>
    <div>
    <form action="/ProjetEnchere">
    	<button>Annuler</button>
    </form>

    <!--redirection sur page d accueil page 1 du pdf -->
    </div> 
</body>
</html>