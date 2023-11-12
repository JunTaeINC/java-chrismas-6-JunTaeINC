package christmas.domain.discount.list;

import static christmas.domain.constant.DiscountConstant.WEEKDAY_DISCOUNT_PRICE;

import christmas.config.menu.Menu.Category;
import christmas.domain.VisitDate;
import christmas.domain.discount.DiscountPolicy;
import christmas.domain.order.Order;

public class WeekdayDiscount implements DiscountPolicy {

	@Override
	public boolean isApplicable(VisitDate visitDate) {
		return visitDate.isWeekday();
	}

	@Override
	public int getDiscountAmount(Order order, VisitDate visitDate) {
		int countInCategory = order.getCountInCategory(Category.DESSERT);
		return countInCategory * WEEKDAY_DISCOUNT_PRICE;
	}
}