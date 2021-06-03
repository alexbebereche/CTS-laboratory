package ro.ase.csie.cts.g1092.testing.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import ro.ase.csie.cts.g1092.testing.exceptions.WrongAgeException;
import ro.ase.csie.cts.g1092.testing.exceptions.WrongGradesException;
import ro.ase.csie.cts.g1092.testing.models.Student;
import ro.ase.csie.cts.g1092.testing.tests.category.ImportantTest;

public class TestStudentNewTests {

	// test fixture
	
	static Student student;
	static ArrayList<Integer> grades;
	static String initialName;
	static int initialAge;
	static int initialNoGrades;
	
	static ArrayList<Integer> performanceGrades;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		//could get this from a file, from a db...to make this into an autom.
		
		initialName = "John Doe";
		initialAge = Student.MIN_AGE + 1; // if MIN_AGE changes, initAge will change too, good
		initialNoGrades = 3;
		
		Random random = new Random();
		
		grades = new ArrayList<Integer>();
		for(int i = 0; i < initialNoGrades; i++) {
			grades.add(random.nextInt(Student.MAX_GRADE) + 1); // from 0 to max_grade + 1 atm, need to substr 1
		}
		
		
		performanceGrades = new ArrayList<Integer>();
		int noGrades = (int) 1e6; // scientific format
		
		for(int i = 0; i < noGrades; i++) {
			performanceGrades.add(random.nextInt(Student.MAX_AGE) + 1);
		}
		
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		student = new Student(initialName, initialAge, grades);
	}

	@After
	public void tearDown() throws Exception {
	}

	//error cond, use expected
	@Test(expected = WrongAgeException.class)
	public void testSetAgeRangeMaxValue() throws WrongAgeException {
		int newAge = Integer.MAX_VALUE;
		
		student.setAge(newAge);
	}
	
	@Test(expected = WrongAgeException.class)
	public void testSetAgeRangeBigValue() throws WrongAgeException {
		int newAge = 200;
		student.setAge(newAge);
	}
	
	@Test
	public void testSetAgeBoundaryLowLimit() throws WrongAgeException {
		int newAge = Student.MIN_AGE;
		student.setAge(newAge);
		
		assertEquals("Testing with the age lower limit", newAge, student.getAge());
	
	}
	
	@Test
	public void testSetAgeBoundaryUpperLimit() throws WrongAgeException {
		int newAge = Student.MAX_AGE;
		student.setAge(newAge);
		
		assertEquals("Testing with the age upper limit", newAge, student.getAge());
	}
	
	@Category(ImportantTest.class)
	@Test
	public void testSetGradesReferenceDeepCopy() throws WrongGradesException {
		
		int[] grades = new int[] {9,9,10};
//		ArrayList<Integer> refGrades =  (ArrayList<Integer>) Arrays.asList(9,9,10);
		
		ArrayList<Integer> refGrades = new ArrayList<Integer>();
		for(int grade : grades) {
			refGrades.add(grade);
		}
		
		student.setGrades(refGrades);
		
		refGrades.set(0, 5); // change the external collection, should not change...
		
		int[] studentGrades = new int[student.getNoGrades()];
		for(int i = 0; i < student.getNoGrades(); i++) {
			studentGrades[i] = student.getGrade(i);
		}
		
		assertArrayEquals("We do shallow copy", grades, studentGrades);
		
	}
	
	//performance limit of 10ms for 10m elements
	@Test
	public void testGetGradesAveragePerformance() throws WrongGradesException {
		ArrayList<Integer> grades = new ArrayList<Integer>();
		int noGrades = (int) 1e6; // scientific format
		
		Random random = new Random();
		for(int i = 0; i < noGrades; i++) {
			grades.add(random.nextInt(Student.MAX_AGE) + 1);
		}
		
		student.setGrades(grades);
		
		long tStart = System.currentTimeMillis(); //careful, this should be here, not in the beginning
		//measure only what you want to evaluate
		
		student.getGradesAverage();
		
		long tFinal = System.currentTimeMillis();
		
		long delta = tFinal - tStart;
		long performanceLimit = 14;
		if(delta <= performanceLimit) {
			assertTrue(true);
		}
		else {
			fail("Takes too long");
		}
		
	}
	
	//here, measuring the entire unit test
	//need to prepare in advance...
	//very big difference, cant externalize the setGrades anywhere else...
	//so, it measures also setGrades...it also needs time
	@Test(timeout = 22)
	public void testGetGradesAveragePerformance2() throws WrongGradesException {
		student.setGrades(performanceGrades);
		
		student.getGradesAverage();
	}
	
	@Test
	public void testSetAgeInverse() throws WrongAgeException {
		int newAge = initialAge + 1;
		
		student.setAge(newAge);
		
		assertNotEquals("setAge is not changing the age", initialAge, student.getAge());
	}
	
	//cant predit the output, verify that it works...
	@Test
	public void testGetMinGradeInverse() throws WrongGradesException {
		student.setGrades(performanceGrades);
		
		//inv
		int minGrade = student.getMinGrade();
		for(int grade : performanceGrades) {
			if(minGrade > grade) {
				fail("The value is not min");
			}
		}
		
		assertTrue(true);
	}
	
	// like ask a friend
	@Test
	public void testGetMinCrossCheck() throws WrongGradesException {
		student.setGrades(performanceGrades);
		
		int expectedMin = Collections.min(performanceGrades); //this is my friend, trust this fct
		
		int computedMin = student.getMinGrade();
		assertEquals("Min is not correct", expectedMin, computedMin);
		
	}
	
	//if dont have any other fct, can write it urself, like a benchmark
	//eg: for sorting, first of all, interchange, then quicks, ...

}
