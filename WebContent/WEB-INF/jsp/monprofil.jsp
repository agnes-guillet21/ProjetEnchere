<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/fragments/header.jspf"%>
    <!--que de l affichage dc pas de form ni method-->
     <div>
        <p>  Pseudo : </p>
     </div>
    </br>

     <div>
        <p>  Nom: </p>
     </div>
    </br>

     <div>
        <p>  Prénom : </p>
     </div>
    </br>

    <div>
       <p>  Email : </p>
    </div>
    </br>

     <div>
        <p> Telephone : </p>
     </div>
    </br>
    <div>
       <p> Rue : </p>
    </div>
     </br>

     <div>
        <p> Code Postal : </p>
     </div>
    </br>

    <div>
        <p> Ville: </p>
    </div>
    </br>
    <!--a enlever pr la page 6 du pdf -->
    <div>
    <form action="" method="POST">
        <input type="submit" value="Modifier">
        <!--redirection page 8  du pdf -->
        </form>
    </div>
<%@  include file="/WEB-INF/fragments/footer.jspf" %>