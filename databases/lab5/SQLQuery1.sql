
create table Ta (
	idA int Primary key IDENTITY(1,1),
	a2 int unique,
	a3 int,
);

create table Tb (
	idB int Primary key IDENTITY(1,1),
	b2 int,
	b3 int,
);

create table Tc (
	idC int Primary key IDENTITY(1,1),
	idA int Foreign key References Ta(idA),
	idB int Foreign key References Tb(idB),
	c2 int,
);

drop table Tc;
drop table Ta;
drop table Tb;


create procedure populeazaTabele
AS
	declare @ct int;
	set @ct = 10000;

	while(@ct > 0)
	begin 
		insert into Ta (a2,a3) values (@ct,1000);
		set @ct = @ct -1;
	end

	set @ct = 3000;
	while(@ct > 0)
	begin 
		insert into Tb (b2,b3) values (@ct,1000);
		set @ct = @ct-1;
	end

	set @ct = 10000;
	while(@ct > 0)
	begin 
		insert into Tc (idA,idB,c2) values (@ct, 1000, 1);
		
		insert into Tc (idA,idB,c2) values (@ct, 30, 1);

		insert into Tc (idA,idB,c2) values (@ct, 31, 1);
		set @ct = @ct-1;
	end 
Go

exec populeazaTabele;

drop procedure populeazaTabele;


select count(*) from Tc;

exec sp_helpindex Ta;
exec sp_helpindex Tb;
exec sp_helpindex Tc;



-- cl ind seek
select * from Ta T 
where T.idA=1;

-- cl ind scan; 
select * from Ta T 
order by a2 ASC

-- ncl ind seek
select a2 from Ta T 
where T.a2=1000

-- ncl ind scan
select a2 from Ta T
order by a2 ASC

-- ncl ind seek + key lookup
select * from Ta T 
where T.a2=1000

select * from Tb T2 where b2=3; -- cl ind scan

create nonclustered index index_Tb_b2
on Tb(b2);

drop index Tb.index_Tb_b2

select * from Tb T2 where b2=1000; 






create nonclustered index index_Tc_idA
on Tc(idA)
Include(idC,idB,c2);

Select *
From Ta T1
Inner join Tc T3
With (Index(index_Tc_idA))
	On T1.idA=T3.idA
Where T3.idB=31;


create nonclustered index index_Tc_idB
on Tc(idB);

Select *
From Tb T1
Inner join Tc T3
With (Index(index_Tc_idB))
	On T1.idB=T3.idB