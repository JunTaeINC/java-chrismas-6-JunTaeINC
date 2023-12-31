package christmas.domain.event.discount.list;

import static christmas.domain.constant.DiscountConstant.WEEKDAY_DISCOUNT_PRICE;

import christmas.config.Event;
import christmas.config.menu.Menu.Category;
import christmas.domain.VisitDate;
import christmas.domain.order.Order;

public class WeekdayDiscount implements DiscountPolicy {

	@Override
	public boolean isApplicable(Order order, VisitDate visitDate) {
		return visitDate.isWeekday() && order.isInCategory(Category.DESSERT);
	}

	@Override
	public int getDiscountAmount(Order order, VisitDate visitDate) {
		int countInCategory = order.getCountInCategory(Category.DESSERT);
		return countInCategory * WEEKDAY_DISCOUNT_PRICE;
	}

	@Override
	public String getEventName() {
		return Event.WEEKDAY_DISCOUNT.getName();
	}
}