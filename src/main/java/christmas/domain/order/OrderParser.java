package christmas.domain.order;

import static christmas.config.message.ErrorMessage.INVALID_ORDER;
import static christmas.domain.constant.MenuConstant.MENU_SEPARATOR;
import static christmas.domain.constant.MenuConstant.NAME_QUANTITY_SEPARATOR;

import christmas.config.menu.Menu;
import christmas.domain.MenuCategory;
import java.util.HashMap;
import java.util.Map;

public class OrderParser {

	public Map<Menu, Integer> parseOrder(MenuCategory menuCategory, String orders) {
		Map<Menu, Integer> menus = new HashMap<>();
		for (String order : orders.split(MENU_SEPARATOR)) {
			String[] parts = order.split(NAME_QUANTITY_SEPARATOR);
			String menuName = parts[0];
			int quantity = Integer.parseInt(parts[1]);
			Menu foundMenu = findMenu(menuCategory, menuName);
			menus.put(foundMenu, quantity);
		}

		return menus;
	}

	private Menu findMenu(MenuCategory menuCategory, String menuName) {
		return menuCategory.getMenuCategory().stream()
			.filter(menu -> menu.getName().equals(menuName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(INVALID_ORDER.getMessage()));
	}
}