package edu.mu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class StudentManager {
	
	Student[] students = null;
	
	public boolean readFromFile(String fileName) {
		try {
			FileInputStream inputStream = new FileInputStream("files/" + fileName);
			
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
	
	public boolean searchStudentById(int id) {
		for(int i = 0; i < students.length; i++) {
			if(students[i].equals(id)) {
				System.out.println(students[i]);
				return true;
			}
		}
		System.out.println("ID does not exist.");
		return false;
	}
	
	private Student[] addToArray(Student[] oldArray, Student newStudent)
	{
	    Student[] newArray = Arrays.copyOf(oldArray, oldArray.length+1);
	    newArray[oldArray.length] = newStudent;
	    return newArray;
	}
	
	
	public void displayStudents() {
		if(students == null) {
			System.out.println("Students array is empty.");
		} else {
			for(int i = 0; i < students.length; i++) {
				System.out.println(students[i]);
			}
		}
	}

}
