package christmas.domain.amount;

import christmas.domain.order.Order;

public class FinalPaymentAmount implements Amount {

	private final int finalPaymentAmount;

	public FinalPaymentAmount(Order order, DiscountAmount discountAmount) {
		this.finalPaymentAmount = order.getTotalOrderAmount() - discountAmount.getAmount();
	}

	@Override
	public int getAmount() {
		return finalPaymentAmount;
	}
}
