package christmas.domain.order;

import christmas.config.menu.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.amount.TotalOrderAmount;
import christmas.domain.event.PresentEvent;
import java.util.Map;

public class Order {

	private Map<Menu, Integer> menus;
	private final TotalOrderAmount totalOrderAmount;
	private final PresentEvent presentEvent;

	public Order(String order) {
		MenuCategory menuCategory = new MenuCategory();
		OrderValidator validator = new OrderValidator();
		validator.validateOrderFormat(menuCategory, order);

		OrderParser orderParser = new OrderParser();
		menus = orderParser.parseOrder(menuCategory, order);

		totalOrderAmount = new TotalOrderAmount(menus);
		presentEvent = new PresentEvent(totalOrderAmount);
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

	public PresentEvent getPresentEvent() {
		return presentEvent;
	}

	public Map<Menu, Integer> getMenus() {
		return menus;
	}
}