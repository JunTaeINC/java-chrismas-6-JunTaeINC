package christmas.domain.discount;

import christmas.domain.discount.list.ChristmasDdayDiscount;
import christmas.domain.discount.list.SpecialDiscount;
import christmas.domain.discount.list.WeekdayDiscount;
import christmas.domain.discount.list.WeekendDiscount;
import java.util.Arrays;
import java.util.List;

public class DiscountConfig {

	public DiscountService getDiscountService() {
		DiscountPolicy christmasDdayDiscount = new ChristmasDdayDiscount();
		DiscountPolicy specialDiscount = new SpecialDiscount();
		DiscountPolicy weekdayDiscount = new WeekdayDiscount();
		DiscountPolicy weekendDiscount = new WeekendDiscount();

		List<DiscountPolicy> discountPolicies = Arrays.asList
			(christmasDdayDiscount, specialDiscount, weekdayDiscount, weekendDiscount);

		return new DiscountService(discountPolicies);
	}
}