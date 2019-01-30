CREATE PROCEDURE addForeignKeyConstraint(@tableName varchar(20), @columnName varchar(20), @constraintName varchar(20),@referenceTable varchar(20), @insertTabel int)
	AS

		Declare @numeProcedura varchar(MAX)
		Set @numeProcedura='addForeignKeyConstraint';

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
			insert into IstoricVersiuni (NrVersiune, NumeProcedura, Parametru1, Parametru2, Parametru3, Parametru4)
			values(@nrVersiune, @numeProcedura, @tableName, @columnName, @constraintName, @referenceTable);
		END

		begin
			Declare @query as varchar(MAX)
			Set @query='alter table '+@tableName+' add constraint '+ @constraintName+' foreign key '+' ( '+@columnName+' ) '+' references '+@referenceTable+' ( '+@columnName+' )';
			print(@query)
			exec(@query)
		end


	GO


  CREATE PROCEDURE addForeignKeyConstraintUndo

  	AS

  		Declare @nrVersiune int;
  		Declare @tableName varchar(MAX);
  		Declare @constraintName varchar(MAX);

  		Select @tableName=Parametru1, @constraintName=Parametru3
  		From IstoricVersiuni
  		Where NumeProcedura='addForeignKeyConstraint';

  		Declare @versiune int
  		Select @versiune=Versiune
  		From CurrentVersion
  		Set @versiune=@versiune-1;
  		UPDATE CurrentVersion
  		SET Versiune=@versiune;


  		begin
  			Declare @query varchar(MAX)
  			Set @query='alter table '+@tableName+' drop constraint '+@constraintName
  			print(@query)
  			exec(@query)
  		end
  	GO
