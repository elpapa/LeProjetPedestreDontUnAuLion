DROP TABLE formatPrestataire;
DROP TABLE formatDispositif;
DROP TABLE dispositifTirage;
DROP TABLE Article;
DROP TABLE agenda;
DROP TABLE livre;
DROP TABLE calendrier;
DROP TABLE albumPhoto;
DROP TABLE album;
DROP TABLE promo;
DROP TABLE livraison;
DROP TABLE commande;
DROP TABLE format;
DROP TABLE photo;
DROP TABLE fichierImage;
DROP TABLE client;
DROP TABLE prestataire;


CREATE TABLE client
(
    mail VARCHAR(100) PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    adressePostale VARCHAR(255),
    motDePasse VARCHAR(255),
    desactive int,
    CONSTRAINT cli_1 CHECK (desactive IN (0,1))
);

CREATE TABLE fichierImage
(
    idFichierImage int PRIMARY KEY,
    cheminAcces VARCHAR(100),
    resolution int,
    partage int NOT NULL,
    tempsExposition int,
    ouverture int, 
    iso int,
    client VARCHAR(100),
    CONSTRAINT fic_1 FOREIGN KEY(client) references client(mail),  
    CONSTRAINT fic_2 CHECK (partage IN (0,1))
);

CREATE TABLE photo
(
	idPhoto int PRIMARY KEY,
    titrePhoto VARCHAR(100),
    commentaire VARCHAR(100),
    idFichierImage int,
    CONSTRAINT cp_1 FOREIGN KEY(idFichierImage) references FichierImage(idFichierImage)  
);

CREATE TABLE album
(
    idAlbum int PRIMARY KEY NOT NULL,
    client VARCHAR(100), 
    CONSTRAINT ca_1 FOREIGN KEY(client) references client(mail)    
);

CREATE TABLE albumPhoto
(
    idPhoto int,
    idAlbum int, 
    CONSTRAINT cap_1 FOREIGN KEY(idPhoto) references photo(idPhoto),
    CONSTRAINT cap_2 FOREIGN KEY(idAlbum) references album(idAlbum),
    PRIMARY KEY(idPhoto, idAlbum)
);

CREATE TABLE livre
(
    idLivre int PRIMARY KEY, 
    preface VARCHAR(100),
    postface VARCHAR(100),
    titreCouv VARCHAR(100),
    idPhotoCouv int, 
    CONSTRAINT cl_1 FOREIGN KEY(idLivre) references album(idAlbum),
    CONSTRAINT cl_2 FOREIGN KEY(idPhotoCouv) references photo(idPhoto)
);

CREATE TABLE calendrier
(
    idCalendrier int PRIMARY KEY,
    typeCalendrier VARCHAR(10),
    photoCouv int,
    photoJan int,
    photoFev int,
    photoMar int,
    photoAvr int,
    photoMai int,
    photoJuin int,
    photoJuil int,
    photoAou int,
    photoSep int,
    photoOct int,
    photoNov int,
    photoDec int,
    CONSTRAINT cc_1 FOREIGN KEY(idCalendrier) references album(idAlbum),
    CONSTRAINT cc_2 CHECK (typeCalendrier IN ('mural','bureau')),
    CONSTRAINT cc_3 FOREIGN KEY(photoCouv) references photo(idPhoto),
    CONSTRAINT cc_4 FOREIGN KEY(photoJan) references photo(idPhoto),
    CONSTRAINT cc_5 FOREIGN KEY(photoFev) references photo(idPhoto),
    CONSTRAINT cc_6 FOREIGN KEY(photoMar) references photo(idPhoto),
    CONSTRAINT cc_7 FOREIGN KEY(photoAvr) references photo(idPhoto),
    CONSTRAINT cc_8 FOREIGN KEY(photoMai) references photo(idPhoto),
    CONSTRAINT cc_9 FOREIGN KEY(photoJuin) references photo(idPhoto),
    CONSTRAINT cc_10 FOREIGN KEY(photoJuil) references photo(idPhoto),
    CONSTRAINT cc_11 FOREIGN KEY(photoAou) references photo(idPhoto),
    CONSTRAINT cc_12 FOREIGN KEY(photoSep) references photo(idPhoto),
    CONSTRAINT cc_13 FOREIGN KEY(photoOct) references photo(idPhoto),
    CONSTRAINT cc_14 FOREIGN KEY(photoNov) references photo(idPhoto),
    CONSTRAINT cc_15 FOREIGN KEY(photoDec) references photo(idPhoto)
);

CREATE TABLE agenda
(
    idAgenda int PRIMARY KEY,
    typeAgenda VARCHAR(10),
    CONSTRAINT cag_1 FOREIGN KEY(idAgenda) references album(idAlbum),
    CONSTRAINT cag_2 CHECK (typeAgenda IN ('jour','semaine'))
);

CREATE TABLE commande
(
    refCommande int PRIMARY KEY,
    dateCommande date,
    prixTotal int, 
    statutCommande VARCHAR(10),
    mailClient VARCHAR(100), 
    paye int, 
    CONSTRAINT ccmd_1 FOREIGN KEY(mailClient) references client(mail), 
    CONSTRAINT ccmd_2 CHECK (statutCommande IN ('encours','envoye','annule')),
    CONSTRAINT ccmd_3 CHECK (paye IN (0,1))
);

CREATE TABLE prestataire
(
    idPrestataire int PRIMARY KEY,
    preference int,
    CONSTRAINT cprest_1 CHECK (preference IN (1,2,3))
);

CREATE TABLE format 
(
    idFormat int PRIMARY KEY,
    prixUnitaire int,
    libelle VARCHAR(100),
    resoluMini int,
    nbPhotoJour int,
    stockPapier int
);

CREATE TABLE Article
(
    quantite int,
    refCommande int, 
    idAlbum int, 
    idFormat int, 
	idPrestataire int, 
    CONSTRAINT cart_1 FOREIGN KEY(refCommande) references commande(refCommande),
    CONSTRAINT cart_2 FOREIGN KEY(idAlbum) references album(idAlbum),
    CONSTRAINT cart_3 FOREIGN KEY(idFormat) references format(idFormat),
	CONSTRAINT cart_4 FOREIGN KEY(idPrestataire) references prestataire(idPrestataire),
    PRIMARY KEY (refCommande, idAlbum)
);

CREATE TABLE livraison
(
    idLivraison int PRIMARY KEY,
    dateEstime date,
    statutLivraison VARCHAR(10),
    refCommande int, 
    CONSTRAINT cliv_1 FOREIGN KEY(refCommande) references commande(refCommande), 
    CONSTRAINT cliv_2 CHECK (statutLivraison IN ('encours','envoye','annule'))
);

CREATE TABLE promo
(
    idPromo int PRIMARY KEY, 
    refCommande int,
    mailClient VARCHAR(100), 
    montant float,
    CONSTRAINT cprom_1 FOREIGN KEY(mailClient) references client(mail)
    CONSTRAINT cprom_2 FOREIGN KEY(refCommande) references commande(refCommande)
);


CREATE TABLE dispositifTirage
(
    idDispositif int PRIMARY KEY
);

CREATE TABLE formatDispositif
(
    idFormat int, 
    idDispositif int, 
    quantitePossible int,
    CONSTRAINT cfd_1 FOREIGN KEY(idFormat) references format(idFormat),
    CONSTRAINT cfd_2 FOREIGN KEY(idDispositif) references dispositifTirage(idDispositif),
    PRIMARY KEY (idFormat, idDispositif)
);



CREATE TABLE formatPrestataire
(
    delaisEnJour int,
    idFormat int, 
    idPrestataire int, 
    CONSTRAINT cfp_1 FOREIGN KEY(idFormat) references format(idFormat),
    CONSTRAINT cfp_2 FOREIGN KEY(idPrestataire) references prestataire(idPrestataire),
    PRIMARY KEY (idFormat, idPrestataire)
);


