package christmas.domain.discount.list;

import static christmas.domain.constant.DiscountConstant.WEEKEND_DISCOUNT_PRICE;

import christmas.config.menu.Menu.Category;
import christmas.domain.VisitDate;
import christmas.domain.discount.DiscountPolicy;
import christmas.domain.order.Order;

public class WeekendDiscount implements DiscountPolicy {

	@Override
	public boolean isApplicable(VisitDate visitDate) {
		return visitDate.isWeekend();
	}

	@Override
	public int getDiscountAmount(Order order, VisitDate visitDate) {
		int countInCategory = order.getCountInCategory(Category.MAIN_DISH);
		return countInCategory * WEEKEND_DISCOUNT_PRICE;
	}
}