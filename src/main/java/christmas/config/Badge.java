package christmas.config;

public enum Badge {
	STAR(5_000, "별"),
	TREE(10_000, "트리"),
	SANTA(20_000, "산타");

	private final int baseAmount;
	private final String name;

	Badge(int baseAmount, String name) {
		this.baseAmount = baseAmount;
		this.name = name;
	}

	public int getBaseAmount() {
		return baseAmount;
	}

	public String getName() {
		return name;
	}
}