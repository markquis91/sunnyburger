
public class MenuItem {

	private String name;
	private double price;

	public MenuItem(String n, double p) {
		if (p < 0.0) {
			throw new IllegalArgumentException("price must be a positive number");
		}

		name = n;
		price = p;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
}
