package christmas.view;

import static christmas.config.message.GuideMessage.ASK_MENU;
import static christmas.config.message.GuideMessage.ASK_VISIT_DATE;
import static christmas.config.message.GuideMessage.GREETING;
import static christmas.config.message.GuideMessage.PREVIEW_EVENT;
import static christmas.config.message.ResultMessage.BENEFIT_DETAILS;
import static christmas.config.message.ResultMessage.GIFT_MENU;
import static christmas.config.message.ResultMessage.MONETARY_UNIT;
import static christmas.config.message.ResultMessage.ORDER_MENU;
import static christmas.config.message.ResultMessage.ORDER_MENU_FORMAT;
import static christmas.config.message.ResultMessage.TOTAL_BENEFIT_FORMAT;
import static christmas.config.message.ResultMessage.TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT;

import christmas.config.menu.Menu;
import christmas.config.message.ResultMessage;
import christmas.domain.VisitDate;
import christmas.domain.amount.FinalPaymentAmount;
import christmas.domain.amount.TotalBenefitAmount;
import christmas.domain.event.BadgeEvent;
import christmas.domain.event.PresentEvent;
import christmas.domain.event.discount.DiscountConfig;
import christmas.domain.event.discount.DiscountService;
import christmas.domain.order.Order;
import christmas.util.NumberFormatter;
import java.util.Map;

public class OutputView {

	private final String NEW_LINE = ResultMessage.NEW_LINE.getMessage();

	public static void printExceptionMessage(String message) {
		System.out.println(message);
	}

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

	public void showPreviewBenefit(Order order, VisitDate visitDate) {
		showOrderMenu(order);
		showTotalOrderAmount(order);
		showPresent(order);
		showBenefitList(order, visitDate);
		showTotalBenefitAmount(order, visitDate);
		showPaymentAmount(order, visitDate);
		showBadge(order, visitDate);
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
		String totalOrderAmount = NumberFormatter.getNumberFormat(order.getTotalOrderAmount());

		System.out.println(TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.getMessage()
			+ NEW_LINE + totalOrderAmount + MONETARY_UNIT.getMessage() + NEW_LINE);
	}

	private void showPresent(Order order) {
		System.out.println(GIFT_MENU.getMessage() + NEW_LINE + order.getPresentEvent().getPresentList());
	}

	private void showBenefitList(Order order, VisitDate visitDate) {
		DiscountService discountService = new DiscountService(new DiscountConfig());
		StringBuilder sb = new StringBuilder();
		PresentEvent presentEvent = order.getPresentEvent();

		sb.append(BENEFIT_DETAILS.getMessage()).append(NEW_LINE);
		sb.append(discountService.getDiscountDetail(order, visitDate)).append(NEW_LINE);

		if (presentEvent.isApplicable()) {
			sb.append(presentEvent.getPresentBenefitDetail()).append(NEW_LINE);
		}

		System.out.println(sb);
	}

	private void showTotalBenefitAmount(Order order, VisitDate visitDate) {
		TotalBenefitAmount totalBenefitAmount = new TotalBenefitAmount(order, visitDate);

		System.out.println(ResultMessage.TOTAL_BENEFIT_AMOUNT.getMessage()
			+ NEW_LINE + totalBenefitAmount.getTotalBenefitAmount() + NEW_LINE);
	}

	private void showPaymentAmount(Order order, VisitDate visitDate) {
		DiscountService discountService = new DiscountService(new DiscountConfig());
		FinalPaymentAmount finalPaymentAmount = new FinalPaymentAmount(order, discountService.getTotalDiscountAmount(order, visitDate));

		System.out.println(ResultMessage.ESTIMATED_PAYMENT_AFTER_DISCOUNT.getMessage()
			+ NEW_LINE + NumberFormatter.getNumberFormat(finalPaymentAmount.getAmount()) + MONETARY_UNIT.getMessage() + NEW_LINE);
	}

	private void showBadge(Order order, VisitDate visitDate) {
		DiscountService discountService = new DiscountService(new DiscountConfig());

		BadgeEvent badge = new BadgeEvent(discountService.getTotalDiscountAmount(order, visitDate).getAmount()
			+ order.getPresentEvent().getTotalBenefitAmount());

		System.out.print(ResultMessage.DECEMBER_EVENT_BADGE.getMessage() + NEW_LINE + badge.getBadge());
	}
}