package christmas.domain.discount;

import static christmas.domain.constant.DiscountConstant.SPECIAL_DISCOUNT_PRICE;

import christmas.domain.VisitDate;
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
}