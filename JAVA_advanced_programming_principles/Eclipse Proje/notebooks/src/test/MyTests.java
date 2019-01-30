package test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import controller.Controller;
import exceptions.MyException;
import model.Notebook;

class MyTests {

	@Test
	void test() throws MyException {
		String filename = System.getProperty("user.dir")+"\\src\\notebooks.txt";
		
		Controller contr = new Controller(filename);
		
		assertEquals("Acer",contr.getRepo().getMyNotebookRepo().get(0).getMarke());
		
		List<Notebook> filtered = contr.filterNotebooksWithCD();
		assertEquals("HP", filtered.get(0).getMarke());
		
		String filenameSer = System.getProperty("user.dir")+"\\src\\notebooks.ser";
		
		contr.getRepo().WriteFromListToFile(filtered, filenameSer);
	}

	@Test
	public void ExceptionTest() {
		
		try {
			String filename = System.getProperty("user.dir")+"\\src\\notebooks.txt";
			
			Controller contr = new Controller(filename);
			
		}
		catch (MyException e) {}
	}
}
