import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Course> courses = getCourses();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("How many students do you want to register? ");
		int num = -1;
		while (num < 0) {
			try {
				num = scanner.nextInt();
				if (num < 0) {
					System.out.println("Please insert a number greater or equal to zero.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Please insert a number.");
				scanner.nextLine();
			}
		}
		
		for (int i = 0; i < num; i++) {
			Student student = new Student();
			student.enroll(courses);
//			System.out.println("\n\nYour tuitionBalance is $: " + student.getTuitionBalance());
//			System.out.println("Paying 2000 for tution...");
//			double tuitionChange =  student.payTuition(2000);
//			System.out.println("Tuition change: $" + tuitionChange);
//			System.out.println("New Tution balance: " + student.getTuitionBalance());
			System.out.println("\n\n" + student.showStatus());
		}
	}
	
	private static ArrayList<Course> getCourses() {
		ArrayList<Course> courses = new ArrayList<>();
		
		courses.add(new Course("History 101"));
		courses.add(new Course("Mathematics 101", 600));
		courses.add(new Course("English 101"));
		courses.add(new Course("Chemistry 101"));
		courses.add(new Course("Computer Science 101"));
		
		return courses;
	}
}
