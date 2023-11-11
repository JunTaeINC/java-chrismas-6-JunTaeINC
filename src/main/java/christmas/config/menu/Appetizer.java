package christmas.config.menu;

public enum Appetizer implements Menu {
	BUTTON_MUSHROOM_SOUP("양송이수프", 6_000),
	TAPAS("타파스", 5_000),
	CAESAR_SALAD("시저샐러드", 8_000);

	private final String name;
	private final int price;

	Appetizer(String name, int price) {
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
		return Category.APPETIZER;
	}
}