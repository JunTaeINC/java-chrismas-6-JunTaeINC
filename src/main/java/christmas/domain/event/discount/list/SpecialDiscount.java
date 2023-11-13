package christmas.domain.event.discount.list;

import static christmas.domain.constant.DiscountConstant.SPECIAL_DISCOUNT_PRICE;

import christmas.config.EventName;
import christmas.domain.VisitDate;
import christmas.domain.event.discount.DiscountPolicy;
import christmas.domain.order.Order;

public class SpecialDiscount implements DiscountPolicy {

	@Override
	public boolean isApplicable(VisitDate visitDate) {
		return visitDate.isSpecialDate();
	}

	@Override
	public int getDiscountAmount(Order order, VisitDate visitDate) {
		return SPECIAL_DISCOUNT_PRICE;
	}

	@Override
	public String getEventName() {
		return EventName.SPECIAL_DISCOUNT.getName();
	}
}