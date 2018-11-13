import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order extends Menu {

	Date DateFormat;
	Date date = new Date();

	List<MenuItem> orderitems;

	public Order() {
		orderitems = new ArrayList<MenuItem>();
	}

	public void SaveItem(MenuItem o) {
		if (o != null) {
			orderitems.add(o);
		} else {

			throw new IllegalArgumentException("Programming error, fix this");
		}
	}

	public void displayOrder() {
		for (int i = 0; i < orderitems.size(); i++) {
			if (orderitems.size() == 0) {
				System.out.print("you have no items in your order!");
			} else {
				System.out.println(orderitems.get(i).getPrice() + " " + orderitems.get(i).getName());
			}
		}

	}

	DecimalFormat df = new DecimalFormat("#.00");
	SimpleDateFormat dateform = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

	// add tax
	public void orderTotal() {
		double total = 0;
		double tax = .09;
		for (int i = 0; i < orderitems.size(); i++) {
			total = total + tax + orderitems.get(i).getPrice();
		}
		System.out.println("Sunny Burger Total: " + "$" + df.format(total));
		System.out.println(dateform.format(date));
	}
}
