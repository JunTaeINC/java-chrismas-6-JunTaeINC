package christmas.domain.order;

import christmas.config.menu.Menu;
import christmas.domain.MenuCategory;
import java.util.Map;

public class Order {

	private Map<Menu, Integer> menus;

	public Order(MenuCategory menuCategory, String order) {
		OrderValidator validator = new OrderValidator();
		validator.validateOrderFormat(menuCategory, order);

		OrderParser orderParser = new OrderParser();
		menus = orderParser.parseOrder(menuCategory, order);
	}
}