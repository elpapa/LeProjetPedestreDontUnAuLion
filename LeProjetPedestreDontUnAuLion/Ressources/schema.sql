CREATE TABLE client
(
    mail VARCHAR(100) PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    adressePostale VARCHAR(255),
    motDePasse VARCHAR(255),
)

CREATE TABLE fichierImage
(
    idFichierImage int PRIMARY KEY,
    cheminAcces VARCHAR(100),
    resolution int,
    partage BOOL NOT NULL DEFAULT '0',
    tempsExposition int,
    ouverture int, 
    iso int,
    client VARCHAR(100) FOREIGN KEY references client(mail)
)

CREATE TABLE photo
(
    titrePhoto VARCHAR(100),
    commentaire VARCHAR(100),
    idFichierImage int FOREIGN KEY references FichierImage(idFichierImage),
    PRIMARY KEY (idFichierImage, titrePhoto), 
)

CREATE TABLE album
(
    idAlbum int PRIMARY KEY NOT NULL,
    client VARCHAR(100) FOREIGN KEY references client(mail),
)

CREATE TABLE albumPhoto
(
    idFichierImage int FOREIGN KEY references fichierImage(idFichierImage),
    titrePhoto int FOREIGN KEY references photo(titrPhoto),
    idAlbum int FOREIGN KEY references album(idAlbum),
    
    PRIMARY KEY (idFichierImage, titrePhoto, idAlbum)
)

CREATE TABLE livre
(
    idLivre int PRIMARY KEY,
    preface VARCHAR(100),
    postface VARCHAR(100),
    titrCouv VARCHAR(100),
    photoCouv int FOREIGN KEY references photo(titrePhoto),
    FOREIGN KEY idLivre references album(idAlbum)
)

CREATE TABLE calendrier
(
    idCalendrier int PRIMARY KEY,
    typeCalendrier ENUM ('mural','bureau'),
    FOREIGN KEY idCalendrier references album(idAlbum)
)

CREATE TABLE agenda
(
    idAgenda int PRIMARY KEY,
    typeAgenda ENUM ('jour','semaine'),
    FOREIGN KEY idAgenda references album(idAlbum)
)

CREATE TABLE commande
(
    refCommandande int PRIMARY KEY,
    dateCommande date,
    prixTotal int, 
    statuCommande ENUM ('encours','envoye','annule'),
    mailClient VARCHAR(100) FOREIGN KEY references client(mail),
    paye boolean 
)

CREATE TABLE prestataire
(
    idPrestataire int PRIMARY KEY,
    preference ENUM ('1','2','3'),
)

CREATE TABLE Article
(
    quantité int,
    refCommmande int FOREIGN KEY references commande(refCommande),
    idAlbum int FOREIGN KEY references album(idAlbum),
    idFormat int FOREIGN KEY references format(idFormat),
	idPrestataire int FOREIGN KEY references prestataire(idPrestataire),
    PRIMARY KEY (refCommande, idAlbum)
)

CREATE TABLE livraison
(
    idLivraison int PRIMARY KEY,
    dateEstime date,
    statuLivraison ENUM ('encours','envoye','annule'),
    refCommande int FOREIGN KEY commande(refCommande)
)

CREATE TABLE promo
(
    idPromo int PRIMARY KEY,
    idCommande int FOREIGN KEY references commande(idCommande),
    idClient int FOREIGN KEY references client(mail),
)

CREATE TABLE format 
(
    idFormat int PRIMARY KEY,
    prixUnitaire int,
    libelle VARCHAR(100),
    resoluMini int,
    nbPhotoJour int,
    stockPapier int,
)

CREATE TABLE dispositifTirage
(
    idDispositif int PRIMARY KEY),
)

CREATE TABLE formatDispositif
(
    idFormat int FOREIGN KEY references format(idFormat),
    idDispositif int FOREIGN KEY references formatDispositif(idDispositif),
    quantitePossible int,

    PRIMARY KEY (idFormat, idDispositif)
)



CREATE TABLE formatPrestataire
(
    delaisEnJour int,

    idFormat int FOREIGN KEY references format(idFormat),
    idPrestataire int FOREIGN KEY references prestataire(idPrestataire),
    
    PRIMARY KEY (idFormat, idPrestataire)
     
)


