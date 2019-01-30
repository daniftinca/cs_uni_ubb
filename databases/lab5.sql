CREATE DATABASE lab5;



CREATE TABLE Ta (
    idA int IDENTITY(1,1) NOT NULL PRIMARY KEY,
    a2 int unique not null,
    a3 int,
);
CREATE TABLE Tb (
    idB int IDENTITY(1,1) NOT NULL PRIMARY KEY,
    b2 int unique not null,
    b3 int,
);

CREATE TABLE Tc (
    idC int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	idA int Not null FOREIGN KEY REFERENCES Ta(idA),
	idB int Not null FOREIGN KEY REFERENCES Tb(idB),
);

select * from Ta;
create procedure insert_random_Ta
	As
		begin
		declare @counter int;
		set @counter=0;
		declare @randomint int;
		declare @query varchar(max);
		declare @unique_int int;
		while (@counter < 10000)
			begin
				Select @randomint = CAST(RAND() * 10000 AS INT);
				set @unique_int = @counter+5;
				set @query = 'insert into Ta (a2,a3) values('+CONVERT(varchar(max),@unique_int)+', '+CONVERT(varchar(max),@randomint)+')';
				exec(@query);
				set @counter = @counter+1;
			end

		end
	GO


exec insert_random_Ta;


create procedure insert_random_Tb
	As
		begin
		declare @counter int;
		set @counter=0;
		declare @randomint int;
		declare @query varchar(max);
		declare @unique_int int;
		while (@counter < 3000)
			begin
				Select @randomint = CAST(RAND() * 10000 AS INT);
				set @unique_int = @counter+5;
				set @query = 'insert into Tb (b2,b3) values('+CONVERT(varchar(max),@unique_int)+', '+CONVERT(varchar(max),@randomint)+')';
				exec(@query);
				set @counter = @counter+1;
			end

		end
	GO

exec insert_random_Tb;

create procedure insert_random_Tc
	As
		begin
		declare @counter_a int;
		set @counter_a=1;
		declare @counter_b int;
		set @counter_b = 1;
		declare @query varchar(max);
		while (@counter_a <= 10000)
			begin
				while(@counter_b <= 3000)
					begin
					
						set @query = 'insert into Tc (idA,idB) values('+CONVERT(varchar(max),@counter_a)+', '+CONVERT(varchar(max),@counter_b)+')';
						exec(@query);
						set @counter_b = @counter_b+1;
						print(CONVERT(varchar(max),@counter_a)+' '+CONVERT(varchar(max),@counter_b));
					end
				set @counter_a = @counter_a+1;
				set @counter_b = 1;
			end

		end
	GO

delete from Tc where 1=1;

exec insert_random_Tc;

select * from Tc;
select count(*) from Tc;