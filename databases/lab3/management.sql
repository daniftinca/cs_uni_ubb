CREATE TABLE CurrentVersion (
    Versiune int NOT NULL PRIMARY KEY
);

insert into CurrentVersion(Versiune)
values(1);

CREATE TABLE IstoricVersiuni(
	NrVersiune int NOT NULL PRIMARY KEY,
	NumeProcedura varchar(Max),
	Parametru1 varchar(Max),
	Parametru2 varchar(Max),
	Parametru3 varchar(Max),
	Parametru4 varchar(Max),
	Parametru5 varchar(Max),
);


SELECT * FROM sys.objects
WHERE type_desc LIKE '%CONSTRAINT';

exec dbo.createTable TabelulMeuNou, InitInt, InitMoney, int, money, 1;

exec dbo.addColumn TabelulMeuNou, AltInt, int, 1;

exec dbo.modifyColumnType TabelulMeuNou, AltInt, float, 1;

exec dbo.addForeignKeyConstraint Chiriasi, ID_Proprietate, PC, Proprietati, 1; 

exec dbo.setDefaultConstraint TabelulMeuNou, AltInt, minc, 10, 1;

exec dbo.goToVersion 5;


Select * From IstoricVersiuni
Select * From CurrentVersion

select *
	FROM INFORMATION_SCHEMA.COLUMNS
	WHERE
     TABLE_NAME = 'Produse' AND
     COLUMN_NAME = 'Nume';
