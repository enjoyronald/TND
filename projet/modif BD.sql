create table ABONNEMENT (
    TYPE_ABO varchar(100) primary key,
    NBR_PRET integer,
    DURE_PAR_PRET integer,
    PRIX_ABONNEMENT integer,
    DUREE_ABONNEMENT integer
);

create table ABONNEE ( 
    USER_NAME varchar(100) primary key,
    MDP varchar(100),
    NOM varchar(100),
    PRENOM varchar(100),
    TELEPHONE integer,
	ADRESSE varchar(100),
    FIN_ABONNEMENT date,
	TYPE_ABO varchar(100),
	foreign key (TYPE_ABO) references ABONNEMENT(TYPE_ABO)
);

create table MEDIA_EMPRUNT(
);

create table ADMIN ( 
    USER_NAME varchar(100)  primary key,
    MDP varchar(100),
    NOM varchar(100),
    PRENOM varchar(100),
    TELEPHONE integer
);

create table media ( 
	MEDIA_ID integer generated always as identity primary key,
	EMPRUNT integer,
	DATE_DEBUT date,
	DATE_FIN date,
	TITRE varchar(255),
	ANNEE_PRODUCTION integer,
	USER_NAME varchar(100),
	foreign key (USER_NAME) references ABONNEE(USER_NAME)
);

/*
ALTER TABLE media
	add CONSTRAINT check_media_format check ( upper(FORMAT) IN ('DVD','CD','BLU-RAY'));
ALTER TABLE media
	add CONSTRAINT check_media_etat check ( upper(FORMAT) IN ('NEUF','BIEN','USAGER','JETER'));
*/
create table livre ( 
	MEDIA_ID integer,
	AUTEUR varchar(100),
	RESUME varchar(255),
	primary key (MEDIA_ID,AUTEUR),
	foreign key (MEDIA_ID) references media(MEDIA_ID)
);


create table musique ( 
	MEDIA_ID integer,
	ARTISTE varchar(100),
	MORCEAUX varchar(255),
	primary key(MEDIA_ID,ARTISTE),
	foreign key (MEDIA_ID) references media(MEDIA_ID)
);

create table musique_ex(
	MUSIQUE_EX_ID integer generated always as identity,
	MEDIA_ID integer,
	ARTISTE varchar(100),
	ETAT varchar(20),
	primary key (MUSIQUE_EX_ID,MEDIA_ID,ARTISTE),
	foreign key (MEDIA_ID,ARTISTE) references musique(MEDIA_ID,ARTISTE)
	
);


create table FILM ( 
	MEDIA_ID integer,
	REALISATEUR varchar(100),
	RESUME varchar(255),
	primary key (MEDIA_ID,REALISATEUR),
	foreign key (MEDIA_ID) references media(MEDIA_ID)
);

create table ACTEUR ( 
	ACTEUR_NOM varchar(100) primary key
);


create table FILM_ACTEUR ( 
	ACTEUR_NOM varchar(100),
	FILM_ID integer,
	foreign key (ACTEUR_NOM) references ACTEUR(ACTEUR_NOM),
	foreign key (FILM_ID) references FILM(MEDIA_ID),
	primary key (ACTEUR_ID,FILM_ID)
);

