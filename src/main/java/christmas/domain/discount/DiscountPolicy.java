package christmas.domain.discount;

import christmas.domain.VisitDate;
import christmas.domain.order.Order;

public interface DiscountPolicy {

	boolean isApplicable(VisitDate visitDate);

	int getDiscountAmount(Order order, VisitDate visitDate);
}