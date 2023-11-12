package christmas.view;

import christmas.config.menu.Menu;
import christmas.config.message.GuideMessage;
import christmas.config.message.ResultMessage;
import christmas.domain.order.Order;
import java.util.Map;

public class OutputView {

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

	public void showMenu(Order order) {
		System.out.println(ResultMessage.ORDER_MENU);
		Map<Menu, Integer> menus = order.getMenus();
		StringBuilder sb = new StringBuilder();
	}
}