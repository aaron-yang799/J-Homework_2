package edu.mu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class StudentManager {
	
	Student[] students = null;
	
	public boolean readFromFile(String fileName) {
		try {
			FileInputStream inputStream = new FileInputStream(fileName);
			
			Scanner scanner = new Scanner(inputStream);
	
			while(scanner.hasNextInt()) {
				int id = scanner.nextInt();
				String fName = scanner.next();
				String lName = scanner.next();
				String name = fName + " " + lName;
				double grade = scanner.nextDouble();
				Student student = new Student(id, name, grade);
				if(students == null) {
					students = new Student[] {student};
				}else{
					students = addToArray(students, student);
				}
			};
			scanner.close();
			inputStream.close();
			return true;
		}
		catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private Student[] addToArray(Student[] oldArray, Student newStudent)
	{
	    Student[] newArray = Arrays.copyOf(oldArray, oldArray.length+1);
	    newArray[oldArray.length] = newStudent;
	    return newArray;
	}
}
