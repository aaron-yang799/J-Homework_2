package edu.mu;

public class Main {

	public static void main(String[] args) {
		
		// Instantiate StudentManager, perform operations based on the requirements.
		StudentManager studentManager = new StudentManager();
		// Read student data from a file and initialize Student objects.
		boolean fileReadStatus = studentManager.readFromFile("studentData.txt");
		// Display all students.
		System.out.println("displayStudents results: ");
		studentManager.displayStudents();
		// Search for a student by ID.
		System.out.println("searchStudentByID results: ");
		boolean studentFound = studentManager.searchStudentById(101);
		// Update the grade of a student by ID.
	}

}
