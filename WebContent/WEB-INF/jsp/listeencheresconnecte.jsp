<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Enchères connecté</title>
</head>
<body>
	<header>
		<div>
			<p>ENI-Encheres</p>
			<!-- insertion fragments header  Eni-enchere-->
			<a href="">Enchères </a>
			<!-- mettre l url de la jsp create login-->
			<a href="">Vendre un article </a>
			<!-- mettre l url de la jsp  -->
			<a href="">Mon profil </a>
			<!-- mettre l url de la jsp create login-->
			<a href="">Déconnexion </a>
			<!-- mettre l url de la jsp  -->
		</div>
	</header>
<body>
	<div>
		<p>Filtres :</p>
		<form class="rechercher" method="post" action="">
			<!-- nom de servlet  -->
			<p>
				<input type="search" placeholder="le nom de l'article contient"
					name="srecherche" id="lookup" />
				<button id="loupe" type="submit" class="icone-loupe" type="submit">
					<!-- manque cette fucking  loupe   -->
				</button>
			</p>
		</form>
	</div>

	<div>
		<form action="" method="GET">
			<!-- remplir l url action mais je ne sais pas quoi   -->
			<input type="text" name="sbarrerecherche" value="Recherche">
			<!-- en css on aura une shadow sur cette div    -->
		</form>
	</div>
	</br>
	<!--definir regles de gestion concernant le choix entre achats et ventes-->
	<!--si achat est coches  alors les chexbox ds ventes seront descativees-->
	<!--sur cette page achat  est cochee dc ds vente tt est desactivees-->
	<div>
		<div class="roundedOne">
			<input type="checkbox" value="Achats" id="roundedOne" name="s_achats"
				checked />Achats
			<!--utilise boostrap pr faire un bouton checkbox rond-->
			<label for="roundedOne"></label>
		</div>

		<div>
			<input type="checkbox" id="encheresouvertes"
				name="s_encheres_ouvertes" checked>
			<!-- je ne sais pas si je mets une value -->
			<!--si on veut que se soit coche on fait un checked-->
			<label for="encheres ouvertes ">Enchères ouvertes </label>
		</div>

		<div>
			<input type="checkbox" id="mes encheres" name="s_mesencheres">
			<!-- je ne sais pas si je mets une value -->
			<!--si on veut que se soit coche on fait un checked-->
			<label for="mes encheres ">Mes encheres </label>
		</div>

		<div>
			<input type="checkbox" id="mes encheres remportées"
				name="s_mes_encheres_remportées">
			<!-- je ne sais pas si je mets une value -->
			<!--si on veut que se soit coche on fait un checked-->
			<label for="mes encheres remportées">Mes encheres remportées
			</label>
		</div>
	</div>
	</br>
	<div>
		<div class="roundedOne">
			<input type="checkbox" value="Mes ventes" id="roundedOne"
				name="s_ventes" />Mes ventes
			<!--utilise boostrap pr faire un bouton checkbox rond-->
			<label for="roundedOne"></label>
		</div>
		<!--si achat est coches  alors les chexbox ds ventes seront descativees-->
		<div>
			<input type="checkbox" id="ventes en cours" name="s_ventes_en_cours">
			<!-- je ne sais pas si je mets une value -->
			<!--si on veut que se soit coche on fait un checked-->
			<label for="ventes en cours ">Mes ventes en cours </label>
		</div>

		<div>
			<input type="checkbox" id="ventes non débutées"
				name="s_ventes_nn_debutees">
			<!-- je ne sais pas si je mets une value -->
			<!--si on veut que se soit coche on fait un checked-->
			<label for="ventes non debutées ">ventes non débutées </label>
		</div>

		<div>
			<input type="checkbox" id="mes encheres terminées"
				name="s_ventes_terminees">
			<!-- je ne sais pas si je mets une value -->
			<!--si on veut que se soit coche on fait un checked-->
			<label for="mes encheres terminées">ventes terminées </label>
		</div>
	</div>

	<div>
		<!-- il y aura un article  -->
		<h4>ArticleVendu</h4>
		<p>categorie</p>
		<p>prix</p>
		<p>date fin d enchere</p>
		<p>
			vendeur : <a href=""></a>
		</p>
	</div>
	<div>
		<!-- il y aura un article  -->
		<h4>ArticleVendu :</h4>
		<p>categorie:</p>
		<p>prix :</p>
		<p>date fin d enchere :</p>
		<p>
			vendeur : <a href=""></a>
		</p>
	</div>
<%@  include file="/WEB-INF/fragments/footer.jspf" %>