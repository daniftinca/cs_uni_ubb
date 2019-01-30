CREATE PROCEDURE addColumn(@tableName varchar(15), @columnName varchar(15),@datatype varchar(15), @insertTabel int)
	AS

		Declare @numeProcedura varchar(MAX)
		Set @numeProcedura='addColumn';

		Declare @versiune int;
		Declare @nrVersiune int;

		Select @versiune=Versiune
		From CurrentVersion
		Set @versiune=@versiune+1;

		Set @nrVersiune=@versiune;

		UPDATE CurrentVersion
		SET Versiune=@versiune;

		if @insertTabel=1
		BEGIN
			insert into IstoricVersiuni (NrVersiune, NumeProcedura, Parametru1, Parametru2, Parametru3)
			values(@nrVersiune, @numeProcedura, @tableName, @columnName, @datatype);
		END

		begin
			declare @query as varchar(MAX)
			set @query = 'alter table '+@tableName+' add '+@columnName+' '+@datatype
			print(@query)
			exec(@query)
		end

	GO

  CREATE PROCEDURE addColumnUndo
  	AS

  		Declare @nrVersiune int;
  		Declare @tableName varchar(MAX)
  		Declare @columnName varchar(MAX)
  		Declare @row_id int;

  		Select @tableName=Parametru1, @columnName=Parametru2
  		From IstoricVersiuni
  		Where NumeProcedura='addColumn';

  		Declare @versiune int
  		Select @versiune=Versiune
  		From CurrentVersion
  		Set @versiune=@versiune-1;
  		UPDATE CurrentVersion
  		SET Versiune=@versiune;


  		begin
  			Declare @query as varchar(MAX)
  			Set @query='alter table '+@tableName+' drop column '+@columnName
  			print(@query)
  			exec(@query)
  		end
  	GO
