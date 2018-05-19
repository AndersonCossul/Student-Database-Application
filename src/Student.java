import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class represents a Student in the University.
 * 
 * @author Anderson Cossul
 *
 */
public class Student {
	private String name;
	private int year;
	private int uniqueID;
	private ArrayList<Course> courses = new ArrayList<>();
	private double tuitionBalance;
	private double gradeLevel;

	// number of total students, starting by 0 at first run
	private static int id = -1;

	/**
	 * Constructor will ask for name and year. Year relates to Freshmen,
	 * Sophomore, Junior or Senior.
	 */
	public Student() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter name: ");
		this.name = scanner.nextLine();

		while (true) {
			System.out.print("Enter year: 1 = Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior: ");
			try {
				this.year = scanner.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid number.");
				scanner.nextLine();
			}
		}

		this.uniqueID = generateUniqueID();
	}

	/**
	 * @return id (int that is based in the increment of the static id of the
	 *         Student Class.
	 */
	private int generateUniqueID() {
		id++;
		return Integer.parseInt(year + "" + id);
	}

	/**
	 * Method to enroll the Student in various courses.
	 * 
	 * @param courses
	 *            (ArrayList of objects from class Course)
	 */
	public void enroll(ArrayList<Course> courses) {
		String courseInput;
		boolean shouldExit = false;
		Scanner scanner = new Scanner(System.in);
		
		while (!shouldExit) {
			System.out.println("Enter course to enroll (\"quit\" to quit):");

			for (int i = 0; i < courses.size(); i++) {
				System.out.println(courses.get(i).getName());
			}

			System.out.print("----------------------\nCourse: ");
			courseInput = scanner.nextLine();

			if (courseInput.contains("quit")) {
				break;
			}
			
			if (isAlreadyOnCourse(courseInput)) {
				System.out.println("Student already enrolled in " + courseInput);
			} else {
				Course course = new Course(courseInput);
				this.courses.add(course);
				this.tuitionBalance += course.getPrice();
			}
		}
	}

	/**
	 * @param courseName
	 *            (String of the name of the course)
	 * @return true if the course is already in the list of courses.
	 */
	private boolean isAlreadyOnCourse(String courseName) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getName() == courseName) {
				return true;
			}
		}
		return false;
	}

	// view balance

	// pay the tuition

	/**
	 * @return a string with the student info.
	 */
	public String showStatus() {
		String info = "";
		info += "Name: " + name;
		info += "\nID: " + uniqueID;
		if (courses != null) {
			info += "\nCourses Enrolled:\n";
			for (int i = 0; i < courses.size(); i++) {
				info += "- " + courses.get(i).getName() + "\n";
			}
		}
		info += "\nBalance: " + tuitionBalance;
		return info;
	}
}
