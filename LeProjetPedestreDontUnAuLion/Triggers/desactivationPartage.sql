CREATE TRIGGER promo BEFORE update ON fichierImage for each row
DECLARE
int nb;
BEGIN
	--Si ca fait partie dune commande 
	select count(P.ifFichierImage) as nb from Article A, Album B, Photo P where P.idPhoto = B.idPhoto and B.idAlbum = A.idAlbum and A.idFichierImage = OLD.fichierImage; 
	--file d'attente
	IF nb > 0 THEN
		insert into fileAttente values (OLD.idFichierImage, OLD.cheminAcces, OLD.resolution, false, OLD.tempsExposition, OLD.ouverture, OLD.iso, OLD.client);
	END ID;
END ;
/