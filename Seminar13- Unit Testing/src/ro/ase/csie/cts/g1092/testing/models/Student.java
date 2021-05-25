package ro.ase.csie.cts.g1092.testing.models;

import java.util.ArrayList;
import java.util.List;

import ro.ase.csie.cts.g1092.testing.exceptions.WrongAgeException;
import ro.ase.csie.cts.g1092.testing.exceptions.WrongGradesException;
import ro.ase.csie.cts.g1092.testing.exceptions.WrongNameException;


public class Student {
	
	public static final int MIN_AGE = 14;
	public static final int MAX_AGE = 90;
	public static final int MIN_GRADE = 1;
	public static final int MAX_GRADE = 10;
	public static final int MIN_NAME_SIZE = 3;
	public static final int MAX_NAME_SIZE = 255;
	
	protected String name;
	protected int age;
	protected ArrayList<Integer> grades;
	
	
	public Student(String name, int age, List<Integer> grades2) {
		super();
		this.name = name;
		this.age = age;
		this.grades = (ArrayList<Integer>) grades2;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) throws WrongNameException{
		//fix the method, no one is validating...
		
		if(name.length() < MIN_NAME_SIZE) {
			throw new WrongNameException();
		}
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) throws WrongAgeException{
		if(age < MIN_AGE) {
			throw new WrongAgeException();
		}
		this.age = age;
	}


	public void setGrades(ArrayList<Integer> grades) throws WrongGradesException{
		this.grades = grades;
	}
	
	
	public int getGrade(int index) {
		return this.grades.get(index);
	}
	
	public int getNoGrades() {
		return this.grades.size();
	}
	

	public float getGradesAverage() {
		int sum = 0;
		for(int grade : this.grades) {
			sum += grade;
		}
		return sum/this.grades.size();
		
	}
	
	//for this fct, ordering will matter
	public int getMinGrade() {
		
		if(this.grades.size() == 0) {
			return 0;
		}
		
//		int min = 0;
		
		int min = this.grades.get(0); // should start at the first value
		//now, this will also fail if i dont have any grades...
		
		for(int grade : this.grades) {
			if(min > grade) {
				min = grade;
			}
		}
		
		return min; //min?
		
	}
	
	
	
}
