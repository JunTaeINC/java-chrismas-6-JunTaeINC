package christmas.domain.event.discount;

import christmas.domain.event.discount.Discount;

public class NoDiscount implements Discount {

	@Override
	public int getAmount() {
		return 0;
	}
}