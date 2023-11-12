package christmas.view;

import static christmas.config.message.ResultMessage.MONETARY_UNIT;
import static christmas.config.message.ResultMessage.ORDER_MENU;
import static christmas.config.message.ResultMessage.ORDER_MENU_FORMAT;
import static christmas.config.message.ResultMessage.TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT;

import christmas.config.menu.Menu;
import christmas.config.message.GuideMessage;
import christmas.domain.order.Order;
import java.util.Map;

public class OutputView {

	private static final String NEW_LINE = "\n";

	public void askVisitDate() {
		System.out.println(GuideMessage.GREETING.getMessage());
		System.out.println(GuideMessage.ASK_VISIT_DATE.getMessage());
	}

	public void askOrderMenu() {
		System.out.println(GuideMessage.ASK_MENU.getMessage());
	}

	public void showBenefit() {
		System.out.println(GuideMessage.PREVIEW_EVENT.getMessage());
	}

	public void showPreviewBenefit(Order order) {
		showOrderMenu(order);
		showTotalOrderAmount(order);
	}

	private void showOrderMenu(Order order) {
		Map<Menu, Integer> menus = order.getMenus();
		StringBuilder sb = new StringBuilder();

		sb.append(NEW_LINE).append(ORDER_MENU.getMessage()).append(NEW_LINE);

		for (Map.Entry<Menu, Integer> menu : menus.entrySet()) {
			sb.append(String.format(ORDER_MENU_FORMAT.getMessage(), menu.getKey().getName(), menu.getValue())).append(NEW_LINE);
		}

		System.out.println(sb);
	}

	private void showTotalOrderAmount(Order order) {
		System.out.println(TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.getMessage()
			+ NEW_LINE + order.getTotalOrderAmount() + MONETARY_UNIT.getMessage());
	}
}