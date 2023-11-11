package christmas.domain.discount;

import static christmas.domain.constant.DateConstant.SPECIAL_DAYS;
import static christmas.domain.constant.DiscountConstant.SPECIAL_DISCOUNT_PRICE;

import christmas.domain.order.Order;

public class SpecialDiscount implements DiscountPolicy {

	@Override
	public boolean isApplicable(int date) {
		return SPECIAL_DAYS.contains(date);
	}

	@Override
	public int getDiscountAmount(Order order) {
		// TODO : 불필요한 매개변수(리펙토링 필요)
		return SPECIAL_DISCOUNT_PRICE;
	}
}