CREATE TABLE client
(
    mail VARCHAR(100) PRIMARY KEY NOT NULL,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    email VARCHAR(255),
    adressePostale VARCHAR(255),
    motDePasse VARCHAR(255),
)

CREATE TABLE fichierImage
(
    idFichierImage int PRIMARY KEY NOT NULL,
    cheminAcces VARCHAR(100),
    resolution int,
    partage BOOL NOT NULL DEFAULT '0',
    adressePostale VARCHAR(255),
    motDePasse VARCHAR(255),
    tempsExposition int,
    ouverture int, 
    iso int,
)

CREATE TABLE photo
(
    titrPhoto VARCHAR(100) PRIMARY KEY NOT NULL,
    nom VARCHAR(100),
    commentaire VARCHAR(100),
    
    idFichierImage int FOREIGN KEY REF FichierImage(idFichierImage),
    PRIMARY KEY (idFichierImage), 
)

CREATE TABLE album
(
    idAlbum int PRIMARY KEY NOT NULL,
    client VARCHAR(100) FOREIGN KEY REF client(mail),
)

CREATE TABLE albumPhoto
(
    idFichierImage int FOREIGN KEY REF fichierImage(idFichierImage),
    titrPhoto int FOREIGN KEY REF photo(titrPhoto),
    idAlbum int FOREIGN KEY REF album(idAlbum),
    
    PRIMARY KEY (idFichierImage),
    PRIMARY KEY (titrPhoto),
    PRIMARY KEY (idAlbum),
)

CREATE TABLE livre
(
    idLivre int PRIMARY KEY NOT NULL,
    preface VARCHAR(100),
    postface VARCHAR(100),
    titrCouv VARCHAR(100),
    
    photoCouv int FOREIGN KEY REF photo(titrPhoto),
)

CREATE TABLE calendrier
(
    idCalendrier int PRIMARY KEY NOT NULL,
    typCalendrier ENUM ('mural','bureau'),
    
)

CREATE TABLE agenda
(
    idAgenda int PRIMARY KEY NOT NULL,
    idAlbum int FOREIGN KEY REF album(idAlbum),
    ...
)

CREATE TABLE commande
(
    refCommandande int PRIMARY KEY NOT NULL,
    dateCommande date,
    prixTotal int, 
    statuCommande ENUM ('encours','envoyé','annulé'),
)

CREATE TABLE albumCommande
(
    quantité int,
    
    refCommmande int FOREIGN KEY REF commande(refCommande),
    idAlbum int FOREIGN KEY REF album(idAlbum),
    idFormat int FOREIGN KEY REF format(idFormat),

    PRIMARY KEY (refCommande),
    PRIMARY KEY (idAlbum),
)

CREATE TABLE livraison
(
    idLivraison int PRIMARY KEY NOT NULL,
    dateEstime date,
    statuLivraison ENUM ('encours','envoyé','annulé'),
)

CREATE TABLE promo
(
    idPromo int PRIMARY KEY NOT NULL,
    idCommande int FOREIGN KEY REF commande(idCommande),
    idClient int FOREIGN KEY REF client(mail),
)

CREATE TABLE format 
(
    idFormat int FOREIGN KEY REF commande(refCommande),
    prixUnitaire int,
    libelle VARCHAR(100),
    resoluMini int,
    nbPhotoJour int,
    stockPapier int,
)

CREATE TABLE dispositifTirage
(
    idDispositif int FOREIGN KEY REF commande(refCommande),
)

CREATE TABLE formatDispositif
(
    idFormat int FOREIGN KEY REF format(idFormat),
    idDispositif int FOREIGN KEY REF formatDispositif(idDispositif),
    quantitePossible int,

    PRIMARY KEY (idFormat),
    PRIMARY KEY (idDispositif),
)

CREATE TABLE prestataire
)
    idPrestataire int FOREIGN KEY REF format(idFormat),
    preference ENUM ('1','2','3'),
)

CREATE TABLE formatPrestataire
(
    delaisEnJour int,

    idFormat int FOREIGN KEY REF format(idFormat),
    idPrestataire int FOREIGN KEY REF prestataire(idPrestataire),
    
    PRIMARY KEY (idFormat),
    PRIMARY KEY (idPrestataire),
     
)


