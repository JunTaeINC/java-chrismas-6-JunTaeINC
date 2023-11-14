package christmas.domain.event.discount;

import christmas.domain.amount.DiscountAmount;

public class Discount implements Discountable {

	private final DiscountAmount discountAmount;

	public Discount(int discountAmount) {
		this.discountAmount = new DiscountAmount(discountAmount);
	}

	@Override
	public int getAmount() {
		return discountAmount.getAmount();
	}
}