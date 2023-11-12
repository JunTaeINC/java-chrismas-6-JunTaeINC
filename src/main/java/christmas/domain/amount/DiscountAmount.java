package christmas.domain.amount;

public class DiscountAmount implements Amount {

	private final int discountAmount;

	public DiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}

	@Override
	public int getAmount() {
		return discountAmount;
	}
}