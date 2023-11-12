package christmas.domain.discount;

import christmas.domain.VisitDate;
import christmas.domain.order.Order;
import java.util.List;

public class DiscountService {

	private final List<DiscountPolicy> discountPolicies;

	public DiscountService(List<DiscountPolicy> discountPolicies) {
		this.discountPolicies = discountPolicies;
	}

	public int getTotalDiscountAmount(Order order, VisitDate visitDate) {
		return discountPolicies.stream()
			.filter(policy -> policy.isApplicable(visitDate))
			.mapToInt(policy -> policy.getDiscountAmount(order, visitDate))
			.sum();
	}
}