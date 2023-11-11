package christmas.config.menu;

public interface Menu {

	String getName();

	int getPrice();
	Category getCategory();

	enum Category {
		APPETIZER, BEVERAGE, DESSERT, MAIN_DISH;
	}
}