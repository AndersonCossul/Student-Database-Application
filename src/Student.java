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
	private Course[] courses;
	private double balance;
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

	// enroll in courses

	// view balance

	// pay the tuition
	
	/**
	 * @return a string with the student info.
	 */
	public String showStatus() {
		String info = "";
		info += "Name: " + name;
		info += "\nID: " + uniqueID;
		info += "\nCourses Enrolled: ";
		// TODO: iteration over courses
		info += "\nBalance: " + balance;
		return info;
	}
}
