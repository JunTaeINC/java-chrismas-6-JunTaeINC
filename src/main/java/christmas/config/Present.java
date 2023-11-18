package christmas.config;

import christmas.config.menu.Beverage;
import christmas.config.menu.Menu;

public enum Present {
	CHAMPAGNE(120_000, Beverage.CHAMPAGNE, 1);

	private final int baseAmount;
	private final Menu menu;
	private final int presentCount;

	Present(int baseAmount, Menu menu, int presentCount) {
		this.baseAmount = baseAmount;
		this.menu = menu;
		this.presentCount = presentCount;
	}

	public int getBaseAmount() {
		return baseAmount;
	}

	public Menu getMenu() {
		return menu;
	}

	public int getPresentCount() {
		return presentCount;
	}
}