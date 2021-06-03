package ro.ase.csie.cts.g1092.testing.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.ase.csie.cts.g1092.testing.exceptions.WrongAgeException;
import ro.ase.csie.cts.g1092.testing.exceptions.WrongGradesException;
import ro.ase.csie.cts.g1092.testing.models.Student;

public class TestStudentNewTests {

	// test fixture
	
	static Student student;
	static ArrayList<Integer> grades;
	static String initialName;
	static int initialAge;
	static int initialNoGrades;
	
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

}
