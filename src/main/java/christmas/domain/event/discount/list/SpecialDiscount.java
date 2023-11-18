package christmas.domain.event.discount.list;

import static christmas.domain.constant.DiscountConstant.SPECIAL_DISCOUNT_PRICE;

import christmas.config.Event;
import christmas.domain.VisitDate;
import christmas.domain.order.Order;

public class SpecialDiscount implements DiscountPolicy {

	@Override
	public boolean isApplicable(Order order, VisitDate visitDate) {
		return visitDate.isSpecialDate();
	}

	@Override
	public int getDiscountAmount(Order order, VisitDate visitDate) {
		return SPECIAL_DISCOUNT_PRICE;
	}

	@Override
	public String getEventName() {
		return Event.SPECIAL_DISCOUNT.getName();
	}
}