create table khl_BookHistoryAPI (
	name VARCHAR(75) not null primary key
);

create table khl_Kartoituskohde (
	kohdeid LONG not null,
	vkid INTEGER not null,
	primary key (kohdeid, vkid)
);

create table khl_Kuntainfo (
	kuntaid LONG not null,
	vkid INTEGER not null,
	primary key (kuntaid, vkid)
);

create table khl_Maakuntainfo (
	maakuntaid LONG not null,
	vkid INTEGER not null,
	primary key (maakuntaid, vkid)
);

create table khl_Vanhatkirjat (
	kohdeid INTEGER not null,
	vkid INTEGER not null,
	primary key (kohdeid, vkid)
);

create table khl_Vanhatkirjat_Kartoituskohde (
	kohdeid INTEGER not null,
	vkid INTEGER not null,
	primary key (kohdeid, vkid)
);

create table khl_Vanhatkirjat_Kuntainfo (
	kuntaid INTEGER not null,
	vkid INTEGER not null,
	primary key (kuntaid, vkid)
);

create table khl_Vanhatkirjat_Maakuntainfo (
	maakuntaid INTEGER not null,
	vkid INTEGER not null,
	primary key (maakuntaid, vkid)
);

create table khl_Vanhatkirjat_kuntainfo (
	kuntaid LONG not null,
	vkid LONG not null,
	primary key (kuntaid, vkid)
);

create table khl_kuntaid (
	maakuntaid INTEGER not null,
	vkid INTEGER not null,
	primary key (maakuntaid, vkid)
);

create table khl_maakuntaid (
	maakuntaid INTEGER not null,
	vkid INTEGER not null,
	primary key (maakuntaid, vkid)
);