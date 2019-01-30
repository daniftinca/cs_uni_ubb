CREATE PROCEDURE createTable(@tableName varchar(20), @columnName1 varchar(20), @columnName2 varchar(20), @datatype1 varchar(15), @datatype2 varchar(15), @insertTabel int)
	AS

		Declare @numeProcedura varchar(MAX)
		Set @numeProcedura='createTable';

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
			insert into IstoricVersiuni (NrVersiune, NumeProcedura, Parametru1, Parametru2, Parametru3, Parametru4, Parametru5)
			values(@nrVersiune, @numeProcedura, @tableName, @columnName1, @columnName2, @datatype1, @datatype2);
		END

		begin
			Declare @query varchar(MAX)
			Set @query='create table '+@tableName+' ( '+@columnName1+' '+@datatype1+' , '+@columnName2+' '+@datatype2+' , );'
			print(@query)
			exec(@query)
		end

	GO


  CREATE PROCEDURE createTableUndo
  	AS

  		Declare @nrVersiune int;
  		Declare @tableName varchar(MAX);

  		Select @tableName=Parametru1
  		From IstoricVersiuni
  		Where NumeProcedura='createTable';

  		Declare @versiune int
  		Select @versiune=Versiune
  		From CurrentVersion
  		Set @versiune=@versiune-1;
  		UPDATE CurrentVersion
  		SET Versiune=@versiune;

  		Begin
  			Declare @query varchar(MAX)
  			Set @query='drop table '+@tablename
  			print(@query)
  			exec(@query)
  		End
  	GO
