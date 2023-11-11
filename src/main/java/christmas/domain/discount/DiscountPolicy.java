package christmas.domain.discount;

import christmas.domain.order.Order;

public interface DiscountPolicy {

	boolean isApplicable(int date);

	int getDiscountAmount(Order order);
}