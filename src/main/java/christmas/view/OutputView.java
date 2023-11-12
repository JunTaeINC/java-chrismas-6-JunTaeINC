package christmas.view;

import static christmas.config.message.ResultMessage.ORDER_MENU;
import static christmas.config.message.ResultMessage.ORDER_MENU_FORMAT;

import christmas.config.menu.Menu;
import christmas.config.message.GuideMessage;
import christmas.domain.order.Order;
import java.util.Map;

public class OutputView {

	private static final String NEW_LINE = "\n";

	public static void askVisitDate() {
		System.out.println(GuideMessage.GREETING.getMessage());
		System.out.println(GuideMessage.ASK_VISIT_DATE.getMessage());
	}

	public static void askOrderMenu() {
		System.out.println(GuideMessage.ASK_MENU.getMessage());
	}

	public static void showBenefit() {
		System.out.println(GuideMessage.PREVIEW_EVENT.getMessage());
	}

	public static void showOrderMenu(Order order) {
		Map<Menu, Integer> menus = order.getMenus();
		StringBuilder sb = new StringBuilder();

		sb.append(NEW_LINE).append(ORDER_MENU.getMessage()).append(NEW_LINE);

		for (Map.Entry<Menu, Integer> menu : menus.entrySet()) {
			sb.append(String.format(ORDER_MENU_FORMAT.getMessage(), menu.getKey().getName(), menu.getValue())).append(NEW_LINE);
		}

		System.out.print(sb);
	}
}