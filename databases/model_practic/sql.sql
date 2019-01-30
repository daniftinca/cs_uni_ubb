
create database Zuge;

create table ZugTyp(
	ZugTypId int Primary key IDENTITY(1,1),
	Beschreibung varchar(Max),

);

create table Zug(
	ZugId int Primary key IDENTITY(1,1),
	Name varchar(MAX),
	Zugtyp int foreign key references ZugTyp(ZugTypId),

);

create table Bahnhofe(
	BahnhofID int Primary key IDENTITY(1,1),
	Name varchar(max),
);


create table Routen(
	RouteID int Primary key IDENTITY(1,1),
	Name varchar(MAX),
	ZugID int foreign key references Zug(ZugId),
	
);

create table Bahnhofe_Routen_Zeiten(
	BahnhofID int foreign key references Bahnhofe(BahnhofID),
	RouteID int foreign key references Routen(RouteID),
	StundenAnkunft int,
	MinutenAnkunft int,
	StundenAbfahrt int,
	MinutenAbfahrt int,
	primary key (BahnhofID,RouteID),
);

drop table Bahnhofe_Routen_Zeiten;


create procedure ex2(@routeID int, @bahnhofID int, @ankunftStunde int, @ankunftMinute int, @abafahrtStunde int, @abfahrtMinute int)
AS 
	
	declare @countvar int;
	Select @countvar = count(*) from Bahnhofe_Routen_Zeiten T where T.BahnhofId = @bahnhofID AND T.RouteID = @routeID; 
	if(@countvar > 0)
	begin 
		update Bahnhofe_Routen_Zeiten
		set StundenAnkunft = @ankunftStunde, MinutenAnkunft= @ankunftMinute, StundenAbfahrt = @abafahrtStunde, MinutenAbfahrt = @abfahrtMinute
		where BahnhofID = @bahnhofID AND RouteID = @routeID
	end
	else
		begin
			insert into Bahnhofe_Routen_Zeiten (BahnhofID, RouteID, StundenAnkunft, MinutenAnkunft, StundenAbfahrt, MinutenAbfahrt) 
			values (@bahnhofID,@routeID,@ankunftStunde,@ankunftMinute,@abafahrtStunde,@abfahrtMinute)
		end
GO