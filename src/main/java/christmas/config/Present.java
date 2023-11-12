package christmas.config;

public enum Present {
	CHAMPAGNE(120_000, "샴페인", 1);

	private final int baseAmount;
	private final String name;
	private final int presentCount;

	Present(int baseAmount, String name, int presentCount) {
		this.baseAmount = baseAmount;
		this.name = name;
		this.presentCount = presentCount;
	}

	public int getBaseAmount() {
		return baseAmount;
	}

	public String getName() {
		return name;
	}

	public int getPresentCount() {
		return presentCount;
	}
}