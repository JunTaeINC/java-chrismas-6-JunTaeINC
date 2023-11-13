package christmas.domain.amount;

import christmas.domain.event.discount.Discount;
import christmas.domain.order.Order;

public class FinalPaymentAmount implements Amount {

	private final int finalPaymentAmount;

	public FinalPaymentAmount(Order order, Discount discount) {
		this.finalPaymentAmount = order.getTotalOrderAmount() - discount.getAmount();
	}

	@Override
	public int getAmount() {
		return finalPaymentAmount;
	}
}
