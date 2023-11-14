package christmas.domain.event.discount;

public class Discount implements Discountable {

	private final int discountAmount;

	public Discount(int discountAmount) {
		this.discountAmount = discountAmount;
	}

	@Override
	public int getAmount() {
		return discountAmount;
	}
}