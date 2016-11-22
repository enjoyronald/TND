create table MEDIA."ABONNEMENT" (
    "ABONNEMENT_ID" integer generated always as identity primary key,
    "TYPE" varchar(100),
    "NBR_PRET" integer,
    "DURE_PAR_PRET" integer,
    "PRIX_ABONNEMENT" integer,
    "DUREE_ABONNEMENT" integer
);

create table MEDIA."ABONNEE" ( 
    "USER_NAME" varchar(100) primary key,
    "MDP" varchar(100),
    "NOM" varchar(100),
    "PRENOM" varchar(100),
    "TELEPHONE" integer,
	"ADRESSE" varchar(100),
    "FIN_ABONNEMENT" date,
	"ABONNEMENT_ID" integer,
	foreign key ("ABONNEMENT_ID") references MEDIA."ABONNEMENT"("ABONNEMENT_ID")
);

create table MEDIA."ADMIN" ( 
    "USER_NAME" varchar(100)  primary key,
    "MDP" varchar(100),
    "NOM" varchar(100),
    "PRENOM" varchar(100),
    "TELEPHONE" integer
);

create table MEDIA."media" ( 
	"MEDIA_ID" integer generated always as identity primary key,
	"EMPRUNT" integer,
	"DATE_DEBUT" date,
	"DATE_FIN" date,
	"ETAT" varchar(100),
	"TITRE" varchar(255),
	"ANNEE_PRODUCTION" integer,
	"FORMAT" varchar(10),
	"USER_NAME" varchar(100),
	foreign key ("USER_NAME") references MEDIA."ABONNEE"("USER_NAME")
);
ALTER TABLE MEDIA."media"
	add CONSTRAINT check_media_format check ( upper("FORMAT") IN ('DVD','CD','BLU-RAY'));
ALTER TABLE MEDIA."media"
	add CONSTRAINT check_media_etat check ( upper("FORMAT") IN ('NEUF','BIEN','USAGER','JETER'));
	
create table MEDIA."livre" ( 
	"MEDIA_ID" integer,
	"AUTEUR" varchar(100),
	"RESUME" varchar(255),
	primary key ("MEDIA_ID"),
	foreign key ("MEDIA_ID") references MEDIA."media"("MEDIA_ID")
);


create table MEDIA."musique" ( 
	"MEDIA_ID" integer generated always as identity primary key,
	"ARTISTE" varchar(100),
	"MORCEAUX" varchar(255),
	foreign key ("MEDIA_ID") references MEDIA."media"("MEDIA_ID")
);


create table MEDIA."FILM" ( 
	"MEDIA_ID" integer generated always as identity primary key,
	"REALISATEUR" varchar(100),
	"RESUME" varchar(255),
	foreign key ("MEDIA_ID") references MEDIA."media"("MEDIA_ID")
);

create table MEDIA."ACTEUR" ( 
	"ACTEUR_ID" integer generated always as identity primary key,
	"NOM" varchar(100)
);


create table MEDIA."FILM_ACTEUR" ( 
	"ACTEUR_ID" integer,
	"FILM_ID" integer,
	foreign key ("ACTEUR_ID") references MEDIA."ACTEUR"("ACTEUR_ID"),
	foreign key ("FILM_ID") references MEDIA."FILM"("MEDIA_ID"),
	primary key ("ACTEUR_ID","FILM_ID")
);

