import java.util.ArrayList;
import java.util.List;

class Menu {

	private List<MenuItem> _menuItemsList;

	public Menu() {
		_menuItemsList = new ArrayList<MenuItem>();

		MenuItem hamburger = new MenuItem("hamburger", 2.50);
		MenuItem cheeseburger = new MenuItem("cheeseburger", 2.50);
		MenuItem fries = new MenuItem("fries", 1.00);
		MenuItem shake = new MenuItem("shake", 1.50);
		MenuItem soda = new MenuItem("soda", 1.00);
		_menuItemsList.add(hamburger);
		_menuItemsList.add(cheeseburger);
		_menuItemsList.add(fries);
		_menuItemsList.add(shake);
		_menuItemsList.add(soda);
	}

	void displayMenuItems() {
		for (int i = 0; i < _menuItemsList.size(); i++) {
			System.out.println("item; " + _menuItemsList.get(i).getName() + " " + _menuItemsList.get(i).getPrice());
		}

		System.out.println("To order, type the name of an item and press enter");
	}

	public MenuItem FindItem(String u) {
		for (int i = 0; i < _menuItemsList.size(); i++) {
			if (u.equals(_menuItemsList.get(i).getName())) {
				return _menuItemsList.get(i);
			}
		}
		return null;
	}
}
