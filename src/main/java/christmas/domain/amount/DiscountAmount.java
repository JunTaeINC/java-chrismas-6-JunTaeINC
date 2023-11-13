package christmas.domain.amount;

import christmas.domain.event.discount.Discount;

public class DiscountAmount implements Amount, Discount {

	private final int discountAmount;

	public DiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}

	@Override
	public int getAmount() {
		return discountAmount;
	}
}