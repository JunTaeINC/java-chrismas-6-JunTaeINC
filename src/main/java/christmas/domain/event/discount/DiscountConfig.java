package christmas.domain.event.discount;

import christmas.domain.event.discount.list.ChristmasDdayDiscount;
import christmas.domain.event.discount.list.DiscountPolicy;
import christmas.domain.event.discount.list.SpecialDiscount;
import christmas.domain.event.discount.list.WeekdayDiscount;
import christmas.domain.event.discount.list.WeekendDiscount;
import java.util.Arrays;
import java.util.List;

public class DiscountConfig {

	private final List<DiscountPolicy> discountPolicies;

	public DiscountConfig() {
		DiscountPolicy christmasDdayDiscount = new ChristmasDdayDiscount();
		DiscountPolicy specialDiscount = new SpecialDiscount();
		DiscountPolicy weekdayDiscount = new WeekdayDiscount();
		DiscountPolicy weekendDiscount = new WeekendDiscount();

		discountPolicies = Arrays.asList(christmasDdayDiscount, specialDiscount, weekdayDiscount, weekendDiscount);
	}

	public List<DiscountPolicy> getDiscountPolicies() {
		return discountPolicies;
	}
}