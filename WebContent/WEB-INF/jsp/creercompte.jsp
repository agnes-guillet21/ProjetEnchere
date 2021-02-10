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
            <input type="text" id="name" name="userpseudo">
             <!--le pseudo doit etre unique & n'accepte que des caracteres alaphanumerique -->
        </div>
        </br>

        <div>
            <label for="name">Nom :</label>
            <input type="text" id="name" name="username">
        </div>
        </br>

        <div>
            <label for="prenom">Prenom :</label>
            <input id="prenom" name="userfirstname"></input>
        </div>
        </br>

        <div>
            <label for="mail">e-mail :</label>
            <input type="email" id="mail" name="usermail">
            <!--doit etre unique-->
        </div>
        </br>

        <div>
            <label for="tel">Téléphone :</label>
            <input type="text" id="tel" name="userphone">
        </div>
        </br>

        <div>
            <label for="rue">Rue :</label>
            <input type="text" id="rue" name="user_street">
        </div>
        </br>

        <div>
            <label for="codePostal">Code Postal :</label>
            <input type="text" id="cp" name="usercp">
        </div>
        </br>

        <div>
            <label for="ville">Ville:</label>
            <input type="text" id="ville" name="city">
        </div>
        </br>

        <div>
            <label for="password">Mot de passe:</label>
            <input type="text" id="s_password" name="spassword">
        </div>
        </br>

        <div>
            <label for="ConfirPassword">Confirmation:</label>
            <input type="text" id="s_password" name="spassword2">
        </div>
        </br>
    </form>
    </br>

    <div>
        <input type="submit" value="Creer">
        <!--redirection sur page liste d enchere en log IN page 4  du pdf -->
    </div> 
    </br>

    <div>
    <form action="/ProjetEnchere">
    	<button>Annuler</button>
    </form>

    <!--redirection sur page d accueil page 1 du pdf -->
    </div> 
</body>
</html>