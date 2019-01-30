create database expractic1;


create table Verlag(
	ID int Primary key IDENTITY(1,1),
	name varchar(max),
	rating float,
);

create table Buch(
	ID int Primary key IDENTITY(1,1),
	name varchar(max),
	rating float,
	nrPages int,
	verlagID int foreign key references Verlag(ID),
);
create table Author(
	ID int Primary key IDENTITY(1,1),
	name varchar(max),
	rating float,
);

create table BuchAuthor(
	authorID int foreign key references Author(ID),
	buchID int foreign key references Buch(ID),
	Primary key (authorID, buchID)
);


create procedure getNrOfBooksOrADD(@authorname varchar(max))
AS
	begin
		Declare @isHeHere varchar(max);
		Select @isHeHere = count(*) from Author where name = @authorname;
		IF(@isHeHere = 0)
		begin
			insert into Author(name, rating) values(@authorname, 1);
		end
		ELSE
		begin
			Declare @authorID int;
			Select @authorID = A.ID from Author A where A.name = @authorname;
			Select count(*) from BuchAuthor where authorID = @authorID;
		end
	end
Go

exec getNrOfBooksOrADD 'autor5';


Select B.name from Buch B
Where B.ID IN (
Select buchID from BuchAuthor
group by buchID
having count(*) =2
)


Select A.name from Author A
where rating = ( 
Select max(rating) from Author
)


insert into Author(name, rating) 
values ('autor1', 2),('autor2', 5), ('autor3',6), ('autor4',6);

insert into Verlag(name, rating)
values ('op', 10);

select * from Verlag

insert into Buch(name, rating, nrPages, verlagID) 
values ('asdf', 8, 100, 1), ('asdf2', 6, 100, 1),('asdf3', 8, 100, 1),('asdf', 7, 100, 1);

insert into BuchAuthor(authorID, buchID) 
values(1,2), (3,2), (2,5), (3,4),(3,5),(2,4);


select * from BuchAuthor
select * from Buch
select * from Author

DELETE FROM  where ID > 4

delete from Verlag where 1=1

drop table BuchAuthor;
drop table Buch;
drop table Author;
drop table Verlag;