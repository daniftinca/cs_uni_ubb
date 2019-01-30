package lab1.api;


public class MeineFunktionen {

	/**
	 * Generiert eine Primzahl groeser als n.
	 * @param n
	 * @return
	 */
	public int generatePrime(int n) {
		n++;
		while(!isPrim(n)) {
			n++;
		}
		return n;
	}
	
	
	/**
	 * Pruft ob die Nummer in dem Parameter prim ist.
	 * @param nr
	 * @return boolean
	 */
	public boolean isPrim(int zahl) {
		boolean istPrimzahl = true;
		double zahlDouble = Double.valueOf(zahl);
		
		for (int i = 2; i<=Math.sqrt(zahlDouble);i++) {
			if(zahl % i == 0) {
				istPrimzahl = false;
			}
		}
		
		return istPrimzahl;
	}
	
	/**
	 * 
	 * @param n - dam un numar natural
	 * @return - primim urmatorul cel mai mic numar din sirul lui fibonacci
	 */
	public int getNextFibo(int n) {
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
	 * @param nrDat
	 * @return palindromul lui nrDat
	 */
	public int getPalindrom(int nrDat) {
		int aux = nrDat;
		int ucif, p=10, palindrom=0;
		while(aux!=0) {
			ucif = aux%10;
			palindrom = p*palindrom + ucif;
			aux = aux/10;
		}
		return palindrom;
	}
	
	/**
	 * Returneaza un array cu rezultatul
	 * @param n
	 * @return un array care are pe prima pozitie un zwilling si pe a doua pe celalalt. 
	 */
	public int[] getPrimeAddends(int n) {
				int aux = n;
				int[] addendPair = new int[2];
				while(true) {
					while(!this.isPrim(aux)) {
						aux++;
					}
					if(this.isPrim(aux+2)) {
						addendPair[0] = aux;
						addendPair[1] = aux+2;
						break;
					}
					aux++;
				}
				return addendPair;
	}
	
	public int getArrayPrimSum(int[] listaNr) {
		int suma=0;
		for(int i=0;i<listaNr.length;i++) {
			if(this.isPrim(listaNr[i]))
				suma+=listaNr[i];
		}
		return suma;
	}
}
