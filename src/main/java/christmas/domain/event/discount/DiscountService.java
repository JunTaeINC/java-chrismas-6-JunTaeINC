package christmas.domain.event.discount;

import christmas.domain.VisitDate;
import christmas.domain.amount.DiscountAmount;
import christmas.domain.order.Order;
import java.util.List;

public class DiscountService {

	private final List<DiscountPolicy> discountPolicies;

	public DiscountService(List<DiscountPolicy> discountPolicies) {
		this.discountPolicies = discountPolicies;
	}

	public DiscountAmount getTotalDiscountAmount(Order order, VisitDate visitDate) {
		int totalDiscountAmount = discountPolicies.stream()
			.filter(policy -> policy.isApplicable(visitDate))
			.mapToInt(policy -> policy.getDiscountAmount(order, visitDate))
			.sum();

		return new DiscountAmount(totalDiscountAmount);
	}
}