package christmas.view;

import static christmas.config.message.GuideMessage.ASK_MENU;
import static christmas.config.message.GuideMessage.ASK_VISIT_DATE;
import static christmas.config.message.GuideMessage.GREETING;
import static christmas.config.message.GuideMessage.PREVIEW_EVENT;
import static christmas.config.message.ResultMessage.GIFT_MENU;
import static christmas.config.message.ResultMessage.MONETARY_UNIT;
import static christmas.config.message.ResultMessage.ORDER_MENU;
import static christmas.config.message.ResultMessage.ORDER_MENU_FORMAT;
import static christmas.config.message.ResultMessage.TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT;

import christmas.config.menu.Menu;
import christmas.domain.order.Order;
import java.text.NumberFormat;
import java.util.Map;

public class OutputView {

	private final String NEW_LINE = "\n";
	private final NumberFormat numberFormat = NumberFormat.getInstance();

	public void askVisitDate() {
		System.out.println(GREETING.getMessage());
		System.out.println(ASK_VISIT_DATE.getMessage());
	}

	public void askOrderMenu() {
		System.out.println(ASK_MENU.getMessage());
	}

	public void showBenefit() {
		System.out.println(PREVIEW_EVENT.getMessage());
	}

	public void showPreviewBenefit(Order order) {
		showOrderMenu(order);
		showTotalOrderAmount(order);
		showPresent(order);
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
		String totalOrderAmount = numberFormat.format(order.getTotalOrderAmount());

		System.out.println(TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.getMessage()
			+ NEW_LINE + totalOrderAmount + MONETARY_UNIT.getMessage() + NEW_LINE);
	}

	private void showPresent(Order order) {
		System.out.println(GIFT_MENU.getMessage() + NEW_LINE + order.getPresentEvent().getPresent());
	}
}