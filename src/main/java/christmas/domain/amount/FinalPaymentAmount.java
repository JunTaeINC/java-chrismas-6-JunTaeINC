package christmas.domain.amount;

import christmas.domain.event.discount.Discountable;
import christmas.domain.order.Order;

public class FinalPaymentAmount implements Amount {

	private final int finalPaymentAmount;

	public FinalPaymentAmount(Order order, Discountable discountable) {
		this.finalPaymentAmount = order.getTotalOrderAmount() - discountable.getAmount();
	}

	@Override
	public int getAmount() {
		return finalPaymentAmount;
	}
}