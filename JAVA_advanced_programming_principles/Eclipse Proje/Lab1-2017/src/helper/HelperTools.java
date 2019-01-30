package helper;

/**
 * Clasa cu functii statice de ajutor.
 * @author Dan
 *
 */
public class HelperTools {
	
	/**
	 * Testeaza daca un numar e prim
	 * @param nr
	 * @return true daca nr e prim, false daca nu
	 */
	public static boolean isPrim(int nr) {
		if(nr == 1) {
			return false;
		}
		if(nr==2) {
			return true;
		}
		if(nr<=0) {
			return false;
		}
		for(int i=2;i<nr;i++) {
			if(nr%i==0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param n - dam un numar natural
	 * @return - primim urmatorul cel mai mic numar din sirul lui fibonacci
	 */
	public static int fibo(int n) {
		if(n<=1)
			return 1;
		if(n==2)
			return 3;
		if(n==3)
			return 5;
		
		int fibo1 = 1;
		int fibo2 = 1;
		int fibo3 = fibo1+fibo2;
		while(fibo3 <n) {
			fibo1=fibo2;
			fibo2=fibo3;
			fibo3=fibo1+fibo2;
		}
		return fibo3;
	}
	
	/**
	 * Returneaza palindromul numarului dat
	 * @param nr_dat
	 * @return palindromul lui nr_dat
	 */
	public static int get_palindrom(int nr_dat) {
		int aux = nr_dat;
		int ucif, p=10, palindrom=0;
		while(aux!=0) {
			ucif = aux%10;
			palindrom = p*palindrom + ucif;
			aux = aux/10;
		}
		return palindrom;
	}
	
	/**
	 * Returneaza suma elemntelor dintr-un array
	 * @param arr
	 * @param length
	 * @return
	 */
	public static int get_array_sum(int[] arr,int length) {
		int suma=0;
		for(int i=0;i<=length;i++) {
			suma+=i;
		}
		return suma;
	}
	
	/**
	 * Afiseaza elementele din array pe ecran
	 * @param arr
	 * @param length
	 */
	public static void print_array(int[] arr,int length) {
		for(int i=0;i<=length;i++)
			System.out.print(i+" ");
	}

	/**
	 * returneaza suma divizorilor unui numar
	 * @param nrDat
	 * @return suma divizorilor
	 */
	public static int get_suma_divizori(int nrDat) {
		int[] listaDivizori = new int[300];
		int ct=0;
		for(int i=1;i<=nrDat/2;i++) {
			if(nrDat%i==0) {
				//System.out.println("Am de gand sa adaug "+i+" in array pe pozitia "+ct);
				listaDivizori[ct]=i;
				ct++;
			}
		}
		//HelperTools.print_array(listaDivizori, ct);
		//System.out.println(" ");
		int suma = HelperTools.get_array_sum(listaDivizori,ct);
		return suma;
	}
	
	/**
	 * Verifica daca un numar e perfect (dupa conditia din cerinta)
	 * @param nrDat
	 * @return true daca e perfect, false daca nu
	 */
	public static boolean isPerfect(int nrDat) {
		if(nrDat == HelperTools.get_suma_divizori(nrDat))
			return true;
		return false;
	}
}
