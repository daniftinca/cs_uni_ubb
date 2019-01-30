package lab1.test;
import lab1.api.MeineFunktionen;

import org.junit.Assert;
import org.junit.Test;


public class MeineFunktionenTest {

	@Test
	public void isPrim() {
		MeineFunktionen funktionen = new MeineFunktionen();
		
		boolean istPrimzahl = funktionen.isPrim(11);
		Assert.assertTrue(istPrimzahl);
	}
	
	@Test
	public void generieirePriemzahl() {
		MeineFunktionen funktionen = new MeineFunktionen();
		
		int n = 63;
		int primZahl = funktionen.generatePrime(n);
			
		Assert.assertEquals(67, primZahl);
	}

	@Test
	public void getNextFiboTest() {
		MeineFunktionen funktionen = new MeineFunktionen();
		
		int n = 10;
		int nextFibo = funktionen.getNextFibo(n);
		
		Assert.assertEquals(13, nextFibo);
	}
	
	@Test
	public void getZwillingeTest() {
		MeineFunktionen funktionen = new MeineFunktionen();
		int n = 4;
		int[] zwillinge = funktionen.getPrimeAddends(n);
		int[] expected = new int[] {5,7};
		
		Assert.assertArrayEquals(expected, zwillinge);
	}
	
	@Test
	public void getPalindromTest() {
		MeineFunktionen funktionen = new MeineFunktionen();
		int n = 254;
		Assert.assertEquals(452, funktionen.getPalindrom(n));
	}
	
	@Test
	public void getArrayPrimSumTest() {
		MeineFunktionen funktionen = new MeineFunktionen();
		int sum = 12;
		int[] listaNr = new int[] {2,3,7,9};
		Assert.assertEquals(sum, funktionen.getArrayPrimSum(listaNr));
	}
	
}
