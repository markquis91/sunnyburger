import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Program {

	private static void helpTips() {
		System.out.println("Type 'Start' to see the Menu");
		System.out.println("Type 'Order' to see your Order");
		System.out.println("Type 'Done' to end the program");
		System.out.println("Type 'Total' to see your order total");
	}

	public static String getRestaurantName() {
		String restaurantName = "Sunny Burger!";
		return restaurantName;
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		Order order = new Order();

		System.out.println("Welcome to " + getRestaurantName());
		System.out.println("Type 'Start' and press Enter to display the Menu");
		System.out.println("Type 'Help' and press Enter to display Help Tips");

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {

			boolean granted = true;
			while (granted) {

				System.out.println("Enter command");

				String userinput = reader.readLine();

				if (userinput.trim().equals("")) {
					System.out.println("Please enter an item.");
				}

				switch (userinput.toLowerCase()) {
				case "start":
					menu.displayMenuItems();
					continue;

				case "help":
					helpTips();
					continue;

				case "order":
					order.displayOrder();
					continue;

				case "done":
					System.out.println("Thanks for ordering from " + getRestaurantName() + "!");
					granted = false;
					continue;

				case "total":
					order.orderTotal();
					continue;

				}

				String[] userinputarray = userinput.split(",|\\s");
				List<String> userinputlist = Arrays.asList(userinputarray);

				for (int i = 0; i < userinputlist.size(); i++) {
					String userinputitem = userinputlist.get(i);
					if (userinputitem.equals("")) {
						continue;
					}
					MenuItem usermenuitem = menu.FindItem(userinputitem);

					if (usermenuitem != null) {
						order.SaveItem(usermenuitem);
						continue;
					}

					if (userinputitem.equals("and")) {
						continue;
					}

					System.out.println("your item is null");
				}
			}
		}

		catch (

		IllegalArgumentException e) {
			System.err.println("Error: name cannot be blank!");
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}
}