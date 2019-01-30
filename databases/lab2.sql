create database exercitiul1

create table persoane(
	ID int NOT NULL primary key,
	Nume varchar(50) NOT NULL,
	Varsta int NOT NULL,
	email varchar(50),
)

create table interese(
	ID int not null primary key,
	Nume varchar(50) not null,
)

create table persoane_interese(

	IDPersoana int not null foreign key references persoane(ID),
	IDInteres int not null foreign key references interese(ID),
	primary key(IDPersoana, IDInteres),
)

insert into persoane (ID, Nume, Varsta, email) values(1, 'Ion', 20,'ion@ion.ro')
insert into persoane (ID, Nume, Varsta, email) values(2, 'Ioan', 30,'ioan@ioan.ro')
insert into persoane (ID, Nume, Varsta, email) values(3, 'Dan', 40,'dan@dan.ro')
insert into persoane (ID, Nume, Varsta, email) values(4, 'aLex', 25,'alex@alex.ro')
insert into persoane (ID, Nume, Varsta, email) values(5, 'jahvee', 18,NULL)

insert into interese(ID, Nume) values(1, 'Fotbal')
insert into interese(ID, Nume) values(2, 'Carti')
insert into interese(ID, Nume) values(3, 'Animale')
insert into interese(ID, Nume) values(3, 'AudioBooks')


insert into persoane_interese(IDPersoana,IDInteres) values(1,1)
insert into persoane_interese(IDPersoana,IDInteres) values(1,3)
insert into persoane_interese(IDPersoana,IDInteres) values(2,1)
insert into persoane_interese(IDPersoana,IDInteres) values(2,2)
insert into persoane_interese(IDPersoana,IDInteres) values(3,2)
insert into persoane_interese(IDPersoana,IDInteres) values(3,1)
insert into persoane_interese(IDPersoana,IDInteres) values(3,3)

update  persoane_interese
set IDInteres = 3
where IDPersoana IN (
	Select ID from persoane
	where varsta between 21 and 40 and email is not null
) AND IDInteres=2

delete from persoane
where email like '%ion.com'