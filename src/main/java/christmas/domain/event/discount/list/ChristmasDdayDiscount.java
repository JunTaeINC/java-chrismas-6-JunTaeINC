package christmas.domain.event.discount.list;

import static christmas.domain.constant.DiscountConstant.CHRISTMAS_DISCOUNT_BASE_AMOUNT;
import static christmas.domain.constant.DiscountConstant.CHRISTMAS_DISCOUNT_INCREASE_AMOUNT;

import christmas.config.EventName;
import christmas.domain.VisitDate;
import christmas.domain.event.discount.DiscountPolicy;
import christmas.domain.order.Order;

public class ChristmasDdayDiscount implements DiscountPolicy {

	@Override
	public boolean isApplicable(VisitDate visitDate) {
		return visitDate.isChristmasDdayPeriod();
	}

	@Override
	public int getDiscountAmount(Order order, VisitDate visitDate) {
		return CHRISTMAS_DISCOUNT_BASE_AMOUNT + visitDate.getChristmasDiscountAccrueDate() * CHRISTMAS_DISCOUNT_INCREASE_AMOUNT;
	}

	@Override
	public String getEventName() {
		return EventName.CHRISTMAS_D_DAY_DISCOUNT.getName();
	}
}
