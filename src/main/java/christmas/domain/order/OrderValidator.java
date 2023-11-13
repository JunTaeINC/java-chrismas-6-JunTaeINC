package christmas.domain.order;

import static christmas.config.message.ErrorMessage.EXCEEDED_ORDER_QUANTITY_LIMIT;
import static christmas.config.message.ErrorMessage.INVALID_ORDER;
import static christmas.domain.constant.MenuConstant.MAXIMUM_ORDER_QUANTITY;
import static christmas.domain.constant.MenuConstant.MENU_SEPARATOR;
import static christmas.domain.constant.MenuConstant.NAME_QUANTITY_SEPARATOR;

import christmas.config.menu.Beverage;
import christmas.config.menu.Menu;
import christmas.domain.MenuCategory;
import christmas.validator.InputValidator;
import christmas.validator.NumberValidator;
import java.util.Arrays;
import java.util.List;

public class OrderValidator {

	public void validateOrderFormat(MenuCategory menuCategory, String orders) {
		String[] orderParts = orders.split(MENU_SEPARATOR);
		validateDuplicate(orderParts);
		validateOnlyBeverageOrder(menuCategory, orderParts);

		int totalQuantity = Arrays.stream(orderParts)
			.mapToInt(order -> validateEachOrder(menuCategory.getMenuCategory(), order))
			.sum();

		validateTotalQuantityLimit(totalQuantity);
	}

	private void validateTotalQuantityLimit(int totalQuantity) {
		if (totalQuantity > MAXIMUM_ORDER_QUANTITY) {
			throw new IllegalArgumentException(EXCEEDED_ORDER_QUANTITY_LIMIT.getMessage());
		}
	}

	private void validateDuplicate(String[] orders) {
		long distinctCount = Arrays.stream(orders)
			.map(order -> order.split(NAME_QUANTITY_SEPARATOR)[0])
			.distinct()
			.count();

		if (orders.length != distinctCount) {
			throw new IllegalArgumentException(INVALID_ORDER.getMessage());
		}
	}

	private void validateOnlyBeverageOrder(MenuCategory menuCategory, String[] orders) {
		boolean isOnlyBeverage = Arrays.stream(orders)
			.map(order -> order.split(NAME_QUANTITY_SEPARATOR)[0])
			.allMatch(orderName -> menuCategory.getMenuCategory().stream()
				.filter(menu -> menu instanceof Beverage)
				.anyMatch(beverage -> beverage.getName().equals(orderName)));

		if (isOnlyBeverage) {
			throw new IllegalArgumentException(INVALID_ORDER.getMessage());
		}
	}


	private int validateEachOrder(List<Menu> menuCategory, String order) {
		String[] parts = order.split(NAME_QUANTITY_SEPARATOR);
		validateBlank(order);
		validateOrderParts(parts);
		int quantity = validateQuantity(parts[1]);
		ensureMenuExists(menuCategory, parts[0]);

		return quantity;
	}

	private void validateBlank(String orders) {
		if (InputValidator.isBlank(orders)) {
			throw new IllegalArgumentException(INVALID_ORDER.getMessage());
		}
	}

	private void validateOrderParts(String[] parts) {
		if (parts.length != 2) {
			throw new IllegalArgumentException(INVALID_ORDER.getMessage());
		}
	}

	private int validateQuantity(String quantity) {
		if (!NumberValidator.isValidQuantity(quantity)) {
			throw new IllegalArgumentException(INVALID_ORDER.getMessage());
		}

		return Integer.parseInt(quantity);
	}

	private void ensureMenuExists(List<Menu> menuCategory, String menuName) {
		if (!menuExists(menuCategory, menuName)) {
			throw new IllegalArgumentException(INVALID_ORDER.getMessage());
		}
	}

	private boolean menuExists(List<Menu> menuCategory, String name) {
		return menuCategory.stream().anyMatch(menu -> menu.getName().equals(name));
	}
}