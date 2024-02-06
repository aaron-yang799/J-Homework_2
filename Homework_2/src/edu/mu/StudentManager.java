package edu.mu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class StudentManager {
	
	Student[] students;
	
	public boolean readFromFile(String fileName) {
		try {
			FileInputStream inputStream = new FileInputStream(fileName);
			
			Scanner scanner = new Scanner(inputStream);
	
			while(scanner.hasNextLine()) {
				int id = scanner.nextInt();
				String name = scanner.next();
				double grade = scanner.nextInt();
				Student student = new Student(id, name, grade); 
				students = addToArray(students, student);
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
