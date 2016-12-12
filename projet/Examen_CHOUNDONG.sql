create table gestionnaire(
	USER_NAME varchar(100) primary key,
    MDP varchar(100)
);

create table categorie(
	nom varchar(100) primary key
);

create table categorie_liee(
	nom1 varchar(100),
	nom2 varchar(100),
	primary key (nom1,nom2),
	FOREIGN key (nom1) references categorie(nom),
	FOREIGN key (nom2) references categorie(nom)
);

create table question(
	id integer generated always as identity primary key,
	nom varchar(100),
	categorie varchar(100),
	user_name varchar(100),
	FOREIGN key (categorie) references categorie(nom),
	FOREIGN key (user_name) references gestionnaire(user_name)
);

create table reponse(
	id integer primary key,
	contenu varchar(255),
	foreign key (id) references question(id)
);

create table page(
	nom varchar(100) primary key,
	nbVisite int
);


insert into page values ('ajoutQuestion',0);
insert into page values ('creerCategorie',0);