package christmas.domain.discount;

import static christmas.domain.constant.DateConstant.MONTH;
import static christmas.domain.constant.DateConstant.WEEKEND;
import static christmas.domain.constant.DateConstant.YEARS;
import static christmas.domain.constant.DiscountConstant.WEEKEND_DISCOUNT_PRICE;

import christmas.config.menu.Menu.Category;
import christmas.domain.order.Order;
import java.time.LocalDate;

public class WeekendDiscount implements DiscountPolicy {

	@Override
	public boolean isApplicable(int date) {
		LocalDate day = LocalDate.of(YEARS, MONTH, date);
		return WEEKEND.contains(day.getDayOfWeek());
	}

	@Override
	public int getDiscountAmount(Order order) {
		int countInCategory = order.getCountInCategory(Category.MAIN_DISH);
		return countInCategory * WEEKEND_DISCOUNT_PRICE;
	}
}