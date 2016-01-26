INSERT INTO client (mail, nom, prenom, adressePostal, motDePasse)
 VALUES
 ('jean.dupont@yahou.fr', 'dupont', 'jean', 'cotedenuit'),
 ('marie.claire@gmail.com', 'claire', 'marie', 'cotedebeaune'),
 ('pierre.lacroix@gmail.com', 'lacroix', 'pierre', 'chateauxmargaux'),
 ('alexandre.dumas@yahou.fr', 'dumas', 'alexandre', 'chateauxlafitte'),
 ('jacques.michel@merci.fr', 'michel', 'jacques', 'montdor');


 INSERT INTO fichierImage (idFichierImage, cheminAcces, resolution, partage, tempsExposition, ouverture, iso, client)
 VALUES
 (7, 'serveur/client/dupont/home/fichiers/images/', 720, 0, 7000, 400, 1,'jean.dupont@yahou.fr'),
 (23, 'serveur/client/lacroix/home/fichiers/images/', 1080, 1, 8000, 500, 2,'pierre.lacroix@gmail.com'),
 (78, 'serveur/client/dumas/home/fichiers/images/', 360, 0, 4000, 400, 2,'alexandre.dumas@yahou.fr'),
 (10, 'serveur/client/dumas/home/fichiers/images/', 360, 0, 4000, 400, 2,'alexandre.dumas@yahou.fr'),
 (11, 'serveur/client/dumas/home/fichiers/images/', 360, 0, 4000, 400, 2,'alexandre.dumas@yahou.fr'),
 (12, 'serveur/client/dumas/home/fichiers/images/', 360, 0, 4000, 400, 2,'alexandre.dumas@yahou.fr'),
 (13, 'serveur/client/dumas/home/fichiers/images/', 360, 0, 4000, 400, 2,'alexandre.dumas@yahou.fr'),
 (14, 'serveur/client/dumas/home/fichiers/images/', 360, 0, 4000, 400, 2,'alexandre.dumas@yahou.fr'),
 (1, 'serveur/client/lacroix/home/fichiers/images/', 1080, 1, 8000, 500, 2,'pierre.lacroix@gmail.com'),
 (2, 'serveur/client/lacroix/home/fichiers/images/', 720, 1, 8000, 500, 2,'pierre.lacroix@gmail.com'),
 (3, 'serveur/client/lacroix/home/fichiers/images/', 1080, 1, 8000, 500, 2,'pierre.lacroix@gmail.com'),
 (4, 'serveur/client/lacroix/home/fichiers/images/', 1080, 1, 8000, 500, 2,'pierre.lacroix@gmail.com');


INSERT INTO photo (idPhoto, titrePhoto, commentaire, idFichierImage)
 VALUES
 (1, 'pipe', 'bob au snow',78),
 (2, 'ardeche', 'descente des gorges',23),
 (3, 'fondue', 'pleins de fromages!',7),
 (4, 'flip', '...',1),
 (5, 'coucher de soleil', '...',2),
 (6, 'port', '...',3),
 (7, 'lukum', '...',4),
 (8, 'steack', 'pleins de fromages!',10),
 (9, 'grande ours', '...',11),
 (10, 'yourt', '...',12),
 (11, 'rouges', '...',13),
 (12, 'aigle', '...',14);


INSERT INTO album (idAlbum, client)
 VALUES
 (1,'jean.dupont@yahou.fr'),
 (2,'pierre.lacroix@gmail.com'),
 (3,'alexandre.dumas@yahou.fr'),
 (4,'jacques.michel@merci.fr');

INSERT INTO albumPhoto (idPhoto,idAlbum)
 VALUES
 (1,3),
 (2,2),
 (3,1);

INSERT INTO livre (idLivre, preface, postface, titreCouv, idPhotoCouv)
 VALUES
 (1, 'bob a performe dans le pipe', '...','Winter 2016',1),
 (2, '...', '...','Decouverte du terroir',1),
 (3, '...', '...','Degustation',1);



INSERT INTO calendrier (idCalendrier, typeCalendrier, photoCouv, photoJan, photoFev, photoMar, photoAvr, photoMai, photoJuin, photoJuil, photoAou, photoSep, photoOct, photoNov, photoDec)
 VALUES
(1, 'mural',1,2,3,4,5,6,7,8,9,10,11,12);


INSERT INTO agenda (idAgenda, typeAgenda)
 VALUES
 (1, 'jour'),
 (2, 'semaine'),
 (3, 'semaine'),
 (4, 'jour'),
 (5, 'jour');

INSERT INTO commande (refCommande, dateCommande, prixTotal, statutCommande, mailClient, paye)
 VALUES
 (1,2015-10-13,100,'encours','jacques.michel@merci.fr',0);

INSERT INTO prestataire (idPrestataire, preference)
 VALUES
 (1, 1),
 (2, 3),
 (3, 2),
 (4, 1);
 
INSERT INTO format (idFormat, prixUnitaire, libelle, resoluMini, nbPhotoJour, stockPapier)
 VALUES
 (1,30,'a3',300,50,100);

 
INSERT INTO article (quantite, refCommande, idAlbum, idFormat, idPrestataire)
VALUES
(10, 1, 1, 1, 2),
(7, 2, 3, 2, 1),
(3, 3, 2, 1, 3);
  

INSERT INTO livraison (idLivraison, dateEstime, statutLivraison, refCommande)
 VALUES
 (1, 2015-10-16, 'envoye', 2),
 (2, 2015-10-17, 'envoye', 3),
 (3, 2015-10-18, 'encours',1);


INSERT INTO promo (idPromo, mailClient, montant)
 VALUES
 (1, 'alexandre.dumas@yahou.fr', 10,0),
 (2, 'pierre.lacroix@gmail.com', 15,90),
 (3, 'jean.dupont@yahou.fr', 9,99);


INSERT INTO dispositifTirage (idDispositifTirage)
 VALUES
 (1),
 (2),
 (3);


INSERT INTO formatPrestataire (delaisEnJour, idFormat, idPrestataire)
 VALUES
 (3, 1, 3),
 (1, 1, 2),
 (3, 2, 2);
