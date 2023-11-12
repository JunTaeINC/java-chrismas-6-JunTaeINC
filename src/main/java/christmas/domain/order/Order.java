package christmas.domain.order;

import christmas.config.menu.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.amount.TotalOrderAmount;
import java.util.Map;

public class Order {

	private Map<Menu, Integer> menus;
	private TotalOrderAmount totalOrderAmount;

	public Order(MenuCategory menuCategory, String order) {
		OrderValidator validator = new OrderValidator();
		validator.validateOrderFormat(menuCategory, order);

		OrderParser orderParser = new OrderParser();
		menus = orderParser.parseOrder(menuCategory, order);
		totalOrderAmount = new TotalOrderAmount(menus);
	}

	public int getCountInCategory(Menu.Category category) {
		int count = 0;

		for (Map.Entry<Menu, Integer> menu : menus.entrySet()) {
			if (menu.getKey().getCategory() == category) {
				count += menu.getValue();
			}
		}

		return count;
	}

	public int getTotalOrderAmount() {
		return totalOrderAmount.getAmount();
	}
}