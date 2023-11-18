package christmas.domain;

import christmas.config.menu.Appetizer;
import christmas.config.menu.Beverage;
import christmas.config.menu.Dessert;
import christmas.config.menu.MainDish;
import christmas.config.menu.Menu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuCategory {

	private final List<Menu> menuCategory = new ArrayList<>();

	public MenuCategory() {
		menuCategory.addAll(Arrays.asList(Appetizer.values()));
		menuCategory.addAll(Arrays.asList(Beverage.values()));
		menuCategory.addAll(Arrays.asList(Dessert.values()));
		menuCategory.addAll(Arrays.asList(MainDish.values()));
	}

	public List<Menu> getMenuCategory() {
		return menuCategory;
	}
}