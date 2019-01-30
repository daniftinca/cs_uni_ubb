CREATE PROCEDURE modifyColumnType(@tableName varchar(15), @columnName varchar(15), @dataType varchar(15), @insertTabel int)
AS
	Declare @initialType varchar(MAX);
	Declare @initialTypeLen int;
	select @initialType = DATA_TYPE, @initialTypeLen= CHARACTER_MAXIMUM_LENGTH
	FROM INFORMATION_SCHEMA.COLUMNS
	WHERE
     TABLE_NAME = @tableName AND
     COLUMN_NAME = @columnName;


	 if @initialType = 'varchar'
	 begin
		set @initialType ='varchar('+@initialTypeLen+')'
	END

	Declare @numeProcedura varchar(MAX)
	Set @numeProcedura='modifyColumnType';

	Declare @versiune int;
	Declare @nrVersiune int;

	Select @versiune=Versiune
	From CurrentVersion

	Set @versiune=@versiune+1;
	Set @nrVersiune=@versiune;

	UPDATE CurrentVersion
	SET Versiune=@versiune;

	IF @insertTabel=1
	Begin
		insert into IstoricVersiuni (NrVersiune, NumeProcedura, Parametru1, Parametru2, Parametru3, Parametru4)
		values(@nrVersiune, @numeProcedura, @tableName, @columnName,  @initialType, @dataType);
	End

	begin
	declare @query as varchar(MAX)
	set @query = 'alter table '+@tableName+' alter column '+@columnName+' '+@dataType
	print(@query)
	exec(@query)
	end
GO


CREATE PROCEDURE modifyColumnTypeUndo
AS

	Declare @numeProcedura varchar(MAX)
	Declare @initialType varchar(MAX);
	Declare @tableName varchar(MAX);
	Declare @columnName varchar(MAX);



	select @tableName = Parametru1, @columnName=Parametru2, @initialType = Parametru3
	from IstoricVersiuni
	Where NumeProcedura='modifyColumnType';


	Declare @versiune int

	Select @versiune=Versiune
	From CurrentVersion
	Set @versiune=@versiune-1;
	UPDATE CurrentVersion
	SET Versiune=@versiune;

	begin

	declare @query varchar(MAX);
	SET @query = 'Alter table '+@tableName+' alter column '+@columnName+' '+@initialType;
	print(@query);
	exec(@query);

	end
GO
