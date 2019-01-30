CREATE PROCEDURE setDefaultConstraint(@tableName varchar(15), @columnName varchar(15), @numeConstraint varchar(15), @constraint varchar(15), @insertTabel int)
AS
	Declare @numeProcedura varchar(MAX)
	Set @numeProcedura='setDefaultConstraint';

	Declare @versiune int;
	Declare @nrVersiune int;

	Select @versiune=Versiune
	From CurrentVersion
	Set @versiune=@versiune+1;

	Set @nrVersiune=@versiune;

	UPDATE CurrentVersion
	SET Versiune=@versiune;

	IF @insertTabel =1
	BEGIN
		insert into IstoricVersiuni (NrVersiune, NumeProcedura, Parametru1, Parametru2, Parametru3, Parametru4)
		values(@nrVersiune, @numeProcedura, @tableName, @columnName, @numeConstraint, @constraint);
	END

	begin
	declare @query as varchar(MAX)
	set @query = 'alter table '+@tableName+' ADD CONSTRAINT '+@numeConstraint+' Default '+@constraint+' for '+@columnName
	print(@query)
	exec(@query)
	end
GO


CREATE PROCEDURE setDefaultConstraintUndo
AS
	Declare @nrVersiune int;
	Declare @numeConstraint varchar (MAX);
	Declare @tableName varchar (MAX);
	Declare @columnName varchar (MAX);

	Select @tableName=Parametru1, @numeConstraint=Parametru3
	From IstoricVersiuni
	Where NumeProcedura='setDefaultConstraint';

	Declare @versiune int
	Select @versiune=Versiune
	From CurrentVersion
	Set @versiune=@versiune-1;
	UPDATE CurrentVersion
	SET Versiune=@versiune;


	begin
		declare @query as varchar(MAX)
		set @query = 'alter table '+@tableName+' Drop '+@numeConstraint;
		print(@query)
		exec(@query)
	end
GO
