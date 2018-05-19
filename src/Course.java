/**
 * This class represents the University courses.
 * @author Anderson Cossul
 *
 */
public class Course {
	private String name;
	private double price;
	
	/**
	 * @param name (String. The price by default is 600)
	 */
	public Course(String name) {
		this.name = name;
		this.price = 600;
	}
	
	/**
	 * @param name (String)
	 * @param price (double)
	 */
	public Course(String name, double price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * @param name (String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return name (String)
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return price (double)
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price (double)
	 */
	public void setPrice(double price) {
		this.price = price;
	}
}
