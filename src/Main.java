import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Student student = new Student();
		ArrayList<Course> courses = getCourses();
		
		System.out.println("\n");
		student.enroll(courses);
		
		System.out.println("\n\n" + student.showStatus());
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
