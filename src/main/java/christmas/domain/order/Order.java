package christmas.domain.order;

import christmas.config.menu.Menu;
import christmas.config.message.ResultMessage;
import christmas.domain.MenuCategory;
import christmas.domain.amount.TotalOrderAmount;
import christmas.domain.event.PresentEvent;
import java.util.Map;

public class Order {

	private final Map<Menu, Integer> menus;
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

	public boolean isInCategory(Menu.Category category) {
		for (Map.Entry<Menu, Integer> menu : menus.entrySet()) {
			if (menu.getKey().getCategory() == category) {
				return true;
			}
		}

		return false;
	}

	public String getOrderMenuList() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Menu, Integer> menu : menus.entrySet()) {
			sb.append(ResultMessage.getOrderMenuFormat(menu.getKey().getName(), menu.getValue()));
		}

		return sb.toString();
	}

	public int getTotalOrderAmount() {
		return totalOrderAmount.getAmount();
	}

	public PresentEvent getPresentEvent() {
		return presentEvent;
	}
}