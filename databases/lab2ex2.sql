
/* arata proprietatiile din Cluj  */
Select *
from Proprietati
where IDLocatie In (
	Select ID
	from Locatii
	where Nume = 'Cluj-Napoca'
	) 

/*arata chiria medie intr-o zona */
Select  IDlocatie, avg(pretChirie) as 'ChirieMedie'
from Proprietati
group by IDLocatie
having avg(pretChirie) > 100

/*arata managerii care au sesizari, si cate au */
Select ID_Manager, count(ID_Manager) as 'NumarSesizari'
from Sesizari
group by ID_Manager
having count(ID_Manager)>1

/* afiseaza venitul total pe o luna din fiecare locatie (venituri chirii - salarii angajati)
	IdLocatie, NumeLocatie, VenitTotal
 */


Select IDManager, sum(PretChirie)-M.Salariu as 'Venituri Totale'
from Proprietati inner join Manageri M on IDManager=M.ID
group by IDManager, M.Salariu
having M.Salariu > 120


Select *
from Proprietati inner join Manageri M on IDManager=M.ID


/* afiseaza net worth-ul: valoarea totala a proprietatilor */

Select sum(PretVanzare) as 'NetWorth'
from Proprietati


/* afiseaza un tabel de forma : IdChirias, Nume Chirias, IdSesizare Titlu Sesizare, Descriere Sesizare */

Select C.ID as 'IdChirias', C.Nume, S.ID as 'IdSesizare', S.Titlu, S.Descriere
from Chiriasi C inner join [Chiriasi-Sesizari] CS on C.ID = CS.IDChirias
				inner join Sesizari S on CS.IDSesizare = S.ID 


/* afiseaza un tabel de forma : Id proprietate, Id sesizare, Adresa proprietate, Locatie, Titlu sesizare, Descriere Sesizare, Nume manager care se ocupa */

Select P.ID as 'IDProprietate', S.ID as 'IDSesizari', P.Adresa, L.Nume, S.Titlu, S.Descriere, M.Nume
from Proprietati P inner join Sesizari S on P.ID = S.ID_Proprietate
					inner join Manageri M on M.ID = S.ID_Manager
					inner join Locatii L on P.IDLocatie = L.ID
					where L.Nume Like 'Cluj%'




/* afiseaza un tabel de forma : IdChirias, Nume Chirias, Nr Sesizari */


Select IDChirias as 'IdChirias', Nume, count(IDSesizare) as 'Nr Sesizari'
from Chiriasi C inner join [Chiriasi-Sesizari] CS on C.ID = CS.IDChirias
				inner join Sesizari S on CS.IDSesizare = S.ID 
group by IDChirias, Nume, Ocupatie
having C.Ocupatie Like '%Spalator%'

/* managerii care se ocupa de proprietatea 1 si proprietatea 4 */

Select M.ID as 'IdManager', M.Nume
from Manageri M, Proprietati P
where M.ID = P.IDManager AND P.ID = 1 
Intersect 
Select M.ID as 'IdManager', M.Nume
from Manageri M, Proprietati P
where M.ID = P.IDManager AND P.ID = 4

/* managerii care se ocupa de proprietatea 1 sau proprietatea 3 */
Select M.ID as 'IdManager', M.Nume
from Manageri M, Proprietati P
where M.ID = P.IDManager AND P.ID = 1 
Union
Select M.ID as 'IdManager', M.Nume
from Manageri M, Proprietati P
where M.ID = P.IDManager AND P.ID = 3

/* numele chiriasilor care stau la proprietatea 1 sau 2 */

Select C.ID, C.Nume, P.Adresa
from Chiriasi C, Proprietati P
where C.ID_Proprietate = P.ID and (P.ID = 1 OR  P.ID = 2)


/*selecteaza toti chiriasii in afara de cei care stau la proprietatea cu id 2 */
Select C.ID, C.Nume, P.Adresa, P.ID as 'IDProprietate'
from Chiriasi C, Proprietati P
where C.ID_Proprietate = P.ID 
Except
Select C.ID, C.Nume, P.Adresa, P.ID as 'IDProprietate'
from Chiriasi C, Proprietati P
where C.ID_Proprietate = P.ID and P.ID = 2

/*la fel ca sus doar ca cu not in */

Select C.ID, C.Nume, P.Adresa, P.ID as 'IDProprietate'
from Chiriasi C, Proprietati P
where C.ID_Proprietate = P.ID and P.ID not in(
	Select  P.ID 
	from Chiriasi C, Proprietati P
	where C.ID_Proprietate = P.ID and P.ID = 2
)

/* Arata toate ocupatiile chiriasilor */
Select Distinct C.Ocupatie
from Chiriasi C


/* Arata top 3 proprietati dupa cea mai scumpa chirie */
Select top(3) P.ID, P.Adresa, L.Nume, P.PretChirie
from Proprietati P, Locatii L
where P.IDLocatie = L.ID
order by P.PretChirie DESC 


/* Arata top 3 proprietati dupa cea mai ieftina chirie */
Select top(3) P.ID, P.Adresa, L.Nume, P.PretChirie
from Proprietati P, Locatii L
where P.IDLocatie = L.ID
order by P.PretChirie ASC


/* Arata top 3 proprietati dupa cea mai scumpa proprietate */
Select top(3) P.ID, P.Adresa, L.Nume, P.PretChirie, P.PretVanzare
from Proprietati P, Locatii L
where P.IDLocatie = L.ID
order by P.PretVanzare DESC 


/* Arata top 3 proprietati dupa cea mai ieftina proprietate */
Select top(3) P.ID, P.Adresa, L.Nume, P.PretChirie, P.PretVanzare
from Proprietati P, Locatii L
where P.IDLocatie = L.ID
order by P.PretVanzare ASC

/* Arata proprietatile in care nu exista chiriasi */

Select P.ID, P.Adresa , C.ID
from Proprietati P left outer join Chiriasi C on P.ID = C.ID_Proprietate
where C.ID is NULL

/* cu any - toate firmele de la care cumparam gaz */

Select f.Nume
from Firma F 
where F.ID = Any (
	Select FS.IDFirma 
	from [Firme-Proprietati] FS
	where FS.Serviciu Like '%gaz%'
) 



/* Toate proprietatile care au pretul de chirie mai mare decat toate proprietatile dintr-o locatie. */

Select * 
from Proprietati P
where P.PretChirie > All(
	Select Prop.PretChirie
	from Proprietati Prop
	where Prop.IDLocatie = 2
)