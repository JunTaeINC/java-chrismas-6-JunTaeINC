package christmas.domain.event.discount.list;

import christmas.domain.VisitDate;
import christmas.domain.order.Order;

public interface DiscountPolicy {

	boolean isApplicable(Order order, VisitDate visitDate);

	int getDiscountAmount(Order order, VisitDate visitDate);

	String getEventName();
}