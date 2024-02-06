package edu.mu;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Yippee!");
		
		StudentManager manager = new StudentManager();
		
		manager.readFromFile("studentData.txt");
		
	}

}
