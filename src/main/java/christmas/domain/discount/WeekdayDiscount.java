package christmas.domain.discount;

import static christmas.domain.constant.DateConstant.MONTH;
import static christmas.domain.constant.DateConstant.WEEKDAYS;
import static christmas.domain.constant.DateConstant.YEARS;
import static christmas.domain.constant.DiscountConstant.WEEKDAY_DISCOUNT_PRICE;

import christmas.config.menu.Menu.Category;
import christmas.domain.order.Order;
import java.time.LocalDate;

public class WeekdayDiscount implements DiscountPolicy {

	@Override
	public boolean isApplicable(int date) {
		LocalDate day = LocalDate.of(YEARS, MONTH, date);
		return WEEKDAYS.contains(day.getDayOfWeek());
	}

	@Override
	public int getDiscountAmount(Order order) {
		int countInCategory = order.getCountInCategory(Category.DESSERT);
		return countInCategory * WEEKDAY_DISCOUNT_PRICE;
	}
}