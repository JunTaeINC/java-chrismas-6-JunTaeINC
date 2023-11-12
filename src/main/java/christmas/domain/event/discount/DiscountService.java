package christmas.domain.event.discount;

import christmas.domain.VisitDate;
import christmas.domain.amount.DiscountAmount;
import christmas.domain.order.Order;

public class DiscountService {

	private final DiscountConfig discountConfig;

	public DiscountService(DiscountConfig discountConfig) {
		this.discountConfig = discountConfig;
	}

	public DiscountAmount getTotalDiscountAmount(Order order, VisitDate visitDate) {
		int totalDiscountAmount = discountConfig.getDiscountPolicies().stream()
			.filter(policy -> policy.isApplicable(visitDate))
			.mapToInt(policy -> policy.getDiscountAmount(order, visitDate))
			.sum();

		return new DiscountAmount(totalDiscountAmount);
	}
}