create schema TEST;

-- creation de 2 collection n:n 
create table TEST."abonnee" (
    "abonnee_id" INTEGER generated always as identity primary key,
    "name" VARCHAR(20)
);

create table TEST."media" (
    "media_id" INTEGER generated always as identity primary key,
    "name" VARCHAR(20)
);

create table TEST."abonnee_media" (
    "abonnee_id" INTEGER ,
    "media_id" INTEGER ,
	primary key ("abonnee_id","media_id"),
	foreign key ("abonnee_id") references TEST."abonnee"("abonnee_id"),
	foreign key ("media_id") references TEST."media"("media_id")
);
-----------------------------------fin ----------------------------------

--  1:n

create table TEST."abonnee" (
    "abonnee_id" INTEGER generated always as identity primary key,
    "name" VARCHAR(20)
);

create table TEST."media" (
    "media_id" INTEGER ,
    "name" VARCHAR(20),
    "abonnee_id" INTEGER,

	primary key ("media_id"),
	foreign key ("abonnee_id") references TEST."abonnee"("abonnee_id")
);

-----------------------------------fin ----------------------------------

-- heritage 
create table TEST."abonnee" (
    "abonnee_id" INTEGER generated always as identity primary key,
    "name" VARCHAR(20)
);

create table TEST."personne" (
	"personne_id" INTEGER generated always as identity primary key,
	"nom" VARCHAR(20)
);

alter table TEST."abonnee"
   add foreign key ("abonnee_id") references TEST."personne"("personne_id");
   
 