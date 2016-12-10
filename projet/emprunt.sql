create table emprunt ( 
	emprunt_id integer generated always as identity primary key,
	USER_NAME varchar(100),
	MEDIA_ID integer,
	DATE_DEBUT date,
	DATE_FIN date,
	DATE_RENDU date,
	foreign key (USER_NAME) references ABONNEE(USER_NAME),
	foreign key (MEDIA_ID) references media(MEDIA_ID)
);