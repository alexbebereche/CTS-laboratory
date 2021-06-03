package ro.ase.csie.cts.g1092.testing.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import ro.ase.csie.cts.g1092.testing.exceptions.WrongAgeException;
import ro.ase.csie.cts.g1092.testing.exceptions.WrongGradesException;
import ro.ase.csie.cts.g1092.testing.exceptions.WrongNameException;
import ro.ase.csie.cts.g1092.testing.models.Student;
import ro.ase.csie.cts.g1092.testing.tests.category.ImportantTest;
import ro.ase.csie.cts.g1092.testing.tests.category.PerformanceTest;

public class TestStudent {

	// this is called text fixture
	// collection of values that will reuse for my unit test

	static Student student;
	static List<Integer> grades;
	static String initialName;
	static int initialAge;

	// stuff that we want to use many times is init here
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

//		List<Integer> 
		grades = new ArrayList<Integer>();
		// can also add some grades:
		grades.add(9);
		grades.add(10);

		initialName = "John";
		initialAge = 21;

		// if we put it here, test cases will change it
//		Student - shadowing
//		student = new Student("John", 21, grades);
	}

	// like a destructor
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// not mandatory...GC will be called anyway
		grades.clear();
		grades = null;

	}

	// stuff we want to have before every unit test
	@Before
	public void setUp() throws Exception {
//		student = new Student("John", 21, grades); //hard-coded...
		student = new Student(initialName, initialAge, grades);
		// every time we run a unit test, we recreate the object!
	}

	@After
	public void tearDown() throws Exception {
		student = null;
	}

	// dummy test
	// 2 options to delete:
	// just delete it, or comment it
	// 3rd way for junit4, remove @Test

	// what if i just want to deactivate it for a test run?
	// use @Ignore
	// after that, still see it in the list

	@Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	// generally, write the name of the fct that we test, and add conditions
	@Test
	public void testSetNameRightValues() throws WrongNameException {
		// empty array of grades, NOT NULL
//		List<Integer> grades = new ArrayList<Integer>();
//
//		Student student = new Student("John", 21, grades);

		String newName = "Alice";
		student.setName(newName); // may throw a wrongname exc, but we dont expect it
		// how do we handles this?
		// either add throws: if it adds an exc for Alice, the unit test will fail with
		// an error
		// echiv to the test failing here

		// should check the new name is Alice
		// here, the equals checks the content
		assertEquals("Testing with proper name", newName, student.getName());

		// the other way..for setAge

	}

	// Right values - Conformance
	@Test
	public void testSetAgeRightValues() {
		// want to test that setAge works
		int newAge = initialAge + 1; // easier to test like that, just need a new value, generate it based on initial
										// value

		// the other way: not add throws
		// try-catch: if catch it, not ok, fail the test

		try {
			student.setAge(newAge);

			assertEquals("Testing for proper age value", newAge, student.getAge()); // expected vs given
		} catch (WrongAgeException e) {
			fail("We got an exception when taht was not expected");
		}

	}

	// Can you force error condition? - E?
	@Test
	public void testSetNameErrorCondition() {

		String newName = "Io"; // force a name that is not good based on our specification
		try {
			student.setName(newName);
			fail("We didn't get the expected exception"); // if i reach this line, setName is not throwing an exception
															// here, not good
		} catch (WrongNameException e) {
			assertTrue(true); // success: unit test passed, we are ok with it
		}

	}

	// this is echiv to the one above, for age
	@Test(expected = WrongAgeException.class) // decorated with an attribute
	public void testSetAgeErrorCondition() throws WrongAgeException {
		int newAge = -4;

		student.setAge(newAge); // expect an exception
	}

	
	//add category
	
	@Category(ImportantTest.class)
	@Test
	public void testGetMinGradeOrderingAsc() throws WrongGradesException {
		// cant use the initial grades, should define my own

		ArrayList<Integer> orderedGrades = new ArrayList<Integer>();

		// create my ordered list
		orderedGrades.add(7);
		orderedGrades.add(8);
		orderedGrades.add(9);

		student.setGrades(orderedGrades);

		int expectedGrade = 7;
		int minGrade = student.getMinGrade();

		assertEquals("Testing with an ordered array of grades", expectedGrade, minGrade);

	}

	@Test
	public void testGetMinGradeCardinalityZero() throws WrongGradesException {
		ArrayList<Integer> emptyGrades = new ArrayList<Integer>();

		student.setGrades(emptyGrades); // will throw an error, but thats not what we are testing

		int expectedGrade = 0;
		int minGrade = student.getMinGrade();

		// careful, not a null ptr, just doesn't have values
		assertEquals("Testing with zero grades", expectedGrade, minGrade);

	}

	@Category({ImportantTest.class, PerformanceTest.class})
	@Test
	public void testGetMinGradeCardinalityOne() throws WrongGradesException {
		int singleGrade = 9;

		ArrayList<Integer> oneGrade = new ArrayList<Integer>();

		oneGrade.add(singleGrade);

		student.setGrades(oneGrade); // will throw an error, but thats not what we are testing

		int expectedGrade = singleGrade;
		int minGrade = student.getMinGrade();

		// careful, not a null ptr, just doesn't have values
		assertEquals("Testing with zero grades", expectedGrade, minGrade);

	}

	// proving the opposite is not true
	@Test
	public void testSetNameInverseRelation() throws WrongNameException {

		String newName = "Alice";

		student.setName(newName); // it works, the newName is not the initial one anymore

		assertNotEquals(initialName, student.getName()); // if its chaning the name, should not get this
	}

}
