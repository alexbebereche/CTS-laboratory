package ro.ase.csie.cts.testing.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.ase.csie.cts.testing.models.MathOperations;

public class TestCaseMathOperations {

	//executed only once before all the unit tests
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Hello from the TestCase");
	}

	//executed only once after the units tests
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Bye from the TestCase");
	}

	//executed before each test
	@Before
	public void blabla() throws Exception { //setUp
		System.out.println("Let's test something");
	}

	//executed after each test
	@After
	public void tearDown() throws Exception {
		System.out.println("Clean up");
	}

	//already got a predefined test, which is fialing
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	//dont forget annotation
	@Test
	public void testAdd() {
		int a = 5;
		int b = 6;
		
		int expectedResult = 11;
		
		int result = MathOperations.add(a, b);
		
//		if(result == expectedResult) {
//			System.out.println("We know how to add");
//		}
//		else {
//			System.out.println("Take some math classes");
//		}
		
		//replace with assert...
		
		assertEquals("Testing adding two int values", expectedResult, result);
	}

}
