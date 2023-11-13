package christmas.domain.event.discount.list;

import static christmas.domain.constant.DiscountConstant.WEEKEND_DISCOUNT_PRICE;

import christmas.config.Event;
import christmas.config.menu.Menu.Category;
import christmas.domain.VisitDate;
import christmas.domain.event.discount.DiscountPolicy;
import christmas.domain.order.Order;

public class WeekendDiscount implements DiscountPolicy {

	@Override
	public boolean isApplicable(Order order, VisitDate visitDate) {
		return visitDate.isWeekend() && order.isInCategory(Category.MAIN_DISH);
	}

	@Override
	public int getDiscountAmount(Order order, VisitDate visitDate) {
		int countInCategory = order.getCountInCategory(Category.MAIN_DISH);
		return countInCategory * WEEKEND_DISCOUNT_PRICE;
	}

	@Override
	public String getEventName() {
		return Event.WEEKEND_DISCOUNT.getName();
	}
}