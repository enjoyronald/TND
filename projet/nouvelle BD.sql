create table TYPE_ABONNEMENT (
    Nom_ABONNEMENT varchar(100) primary key,
    NBR_PRET integer,
    DUREE_PAR_PRET integer,
    PRIX_ABONNEMENT integer,
    DUREE_ABONNEMENT integer
);

create table ABONNEE ( 
    USER_NAME varchar(100) primary key,
    MDP varchar(100),
    NOM varchar(100),
    PRENOM varchar(100),
    TELEPHONE integer,
	ADRESSE varchar(100)
);

create table ABONNEMENT(
	USER_NAME varchar(100),
	Nom_ABONNEMENT varchar(100),
	DEBUT date,
	FIN date,
	foreign key (Nom_ABONNEMENT) references TYPE_ABONNEMENT(Nom_ABONNEMENT),
	foreign key (USER_NAME) references ABONNEE(USER_NAME),
	primary key (USER_NAME,Nom_ABONNEMENT,DEBUT)
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
	ETAT varchar(100),
	TITRE varchar(255),
	ANNEE_PRODUCTION integer,
	FORMAT varchar(10)
);
ALTER TABLE media
	add CONSTRAINT check_media_format check ( upper(FORMAT) IN ('DVD','CD','BLU-RAY'));
ALTER TABLE media
	add CONSTRAINT check_media_etat check ( upper(ETAT) IN ('NEUF','BIEN','USAGER','JETER'));
	
create table EMPRUNT (
	MEDIA_ID integer,
	USER_NAME varchar(100),
	DEBUT date,
	FIN date,
	foreign key (MEDIA_ID) references media(MEDIA_ID),
	foreign key (USER_NAME) references ABONNEE(USER_NAME),
	primary key (USER_NAME,MEDIA_ID,DEBUT)
);

create table RESERVATION(
	MEDIA_ID integer,
	USER_NAME varchar(100),
	DEBUT date,
	FIN date,
	foreign key (MEDIA_ID) references media(MEDIA_ID),
	foreign key (USER_NAME) references ABONNEE(USER_NAME),
	primary key (USER_NAME,MEDIA_ID,DEBUT)

);

create table livre ( 
	MEDIA_ID integer,
	AUTEUR varchar(100),
	RESUME varchar(255),
	primary key (MEDIA_ID),
	foreign key (MEDIA_ID) references media(MEDIA_ID)
);


create table musique ( 
	MEDIA_ID integer primary key,
	ARTISTE varchar(100),
	MORCEAUX varchar(255),
	foreign key (MEDIA_ID) references media(MEDIA_ID)
);


create table FILM ( 
	MEDIA_ID integer primary key,
	REALISATEUR varchar(100),
	RESUME varchar(255),
	foreign key (MEDIA_ID) references media(MEDIA_ID)
);

create table ACTEUR (
	NOM_ACTEUR varchar(100) primary key
);


create table FILM_ACTEUR ( 
	NOM_ACTEUR varchar(100),
	FILM_ID integer,
	foreign key (NOM_ACTEUR) references ACTEUR(NOM_ACTEUR),
	foreign key (FILM_ID) references FILM(MEDIA_ID),
	primary key (NOM_ACTEUR,FILM_ID)
);

