CREATE Procedure goToVersion (@versiuneaDorita int)
AS
	BEGIN



		Declare @versiune int
		Select @versiune=Versiune
		From CurrentVersion

		Declare @numeProcedura varchar(MAX)
		Declare @param1 varchar(MAX)
		Declare @param2 varchar(MAX)
		Declare @param3 varchar(MAX)
		Declare @param4 varchar(MAX)
		Declare @param5 varchar(MAX)
		Declare @string varchar(MAX)
		Declare @nrVersiune int;
		Declare @proceduraUndo varchar(MAX)



		If @versiune > @versiuneaDorita
		BEGIN
			While @versiune > @versiuneaDorita
			BEGIN

				Set @nrVersiune=@versiune
				SELECT @numeProcedura=NumeProcedura
				From IstoricVersiuni
				Where NrVersiune=@nrVersiune

				Set @proceduraUndo=@numeProcedura+'Undo'
				exec(@proceduraUndo)
				Set @versiune=@versiune-1;

			END
		END
		ELSE
		BEGIN
			While @versiune < @versiuneaDorita
			BEGIN


				Set @nrVersiune=@versiune+1
				SELECT @numeProcedura=NumeProcedura
				From IstoricVersiuni
				Where NrVersiune=@nrVersiune

					if (@numeProcedura = 'modifyColumnType')
						Begin
						(SELECT @param1=Parametru1, @param2=Parametru2, @param4=Parametru4
						From IstoricVersiuni
						Where NrVersiune=@nrVersiune)
						Set @string=@numeProcedura+' '+@param1+' , '+@param2+' , '+@param4+' , 0'
						Exec(@string)
						Set @versiune=@versiune+1
						End

					else if (@numeProcedura = 'setDefaultConstraint')
						Begin
						(SELECT @param1=Parametru1, @param2=Parametru2, @param3=Parametru3, @param4=Parametru4
						From IstoricVersiuni
						Where NrVersiune=@nrVersiune)
						Set @string=@numeProcedura+' '+@param1+' , '+@param2+' , '+@param3+' , '+@param4+' , 0'
						Exec(@string)
						Set @versiune=@versiune+1
					    End

					else if (@numeProcedura = 'createTable')
						Begin
						(SELECT @param1=Parametru1, @param2=Parametru2, @param3=Parametru3, @param4=Parametru4, @param5=Parametru5
						From IstoricVersiuni
						Where NrVersiune=@nrVersiune)
						Set @string=@numeProcedura+' '+@param1+' , '+@param2+' , '+@param3+' , '+@param4+' , '+@param5+' , 0'
						Exec(@string)
						Set @versiune=@versiune+1
						End

					else if (@numeProcedura = 'addColumn')
						Begin
						(SELECT @param1=Parametru1, @param2=Parametru2, @param3=Parametru3
						From IstoricVersiuni
						Where NrVersiune=@nrVersiune)
						Set @string=@numeProcedura+' '+@param1+' , '+@param2+' , '+@param3+' , 0'
						Exec(@string)
						Set @versiune=@versiune+1
						End
					else if (@numeProcedura = 'addForeignKeyConstraint')
						Begin
						(SELECT @param1=Parametru1, @param2=Parametru2, @param3=Parametru3, @param4=Parametru4
						From IstoricVersiuni
						Where NrVersiune=@nrVersiune)
						Set @string=@numeProcedura+' '+@param1+' , '+@param2+' , '+@param3+' , '+@param4+' , 0'
						Exec(@string)
						Set @versiune=@versiune+1
						End
			END
		END
		UPDATE CurrentVersion
		SET Versiune=@versiune;
	END

GO
