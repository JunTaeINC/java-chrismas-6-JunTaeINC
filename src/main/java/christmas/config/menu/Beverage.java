package christmas.config.menu;

public enum Beverage implements Menu {
	ZERO_COKE("제로콜라", 3_000),
	RED_WINE("레드와인", 60_000),
	CHAMPAGNE("샴페인", 25_000);

	private final String name;
	private final int price;

	Beverage(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public Category getCategory() {
		return Category.BEVERAGE;
	}
}