package christmas.view;

import static christmas.config.message.GuideMessage.ASK_MENU;
import static christmas.config.message.GuideMessage.ASK_VISIT_DATE;
import static christmas.config.message.GuideMessage.GREETING;
import static christmas.config.message.GuideMessage.PREVIEW_EVENT;
import static christmas.config.message.ResultMessage.BENEFIT_DETAILS;

import christmas.config.message.ResultMessage;
import christmas.domain.VisitDate;
import christmas.domain.amount.FinalPaymentAmount;
import christmas.domain.amount.TotalBenefitAmount;
import christmas.domain.event.BadgeEvent;
import christmas.domain.event.PresentEvent;
import christmas.domain.event.discount.DiscountService;
import christmas.domain.order.Order;

public class OutputView {

	private final String NEW_LINE = ResultMessage.NEW_LINE.getMessage();
	private final DiscountService discountService;

	public OutputView() {
		this.discountService = new DiscountService();
	}

	public void printExceptionMessage(String message) {
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
		print(ResultMessage.getOrderMenuFormat(order.getOrderMenuList()));
	}

	private void showTotalOrderAmount(Order order) {
		print(ResultMessage.getTotalOrderAmountFormat(order.getTotalOrderAmount()));
	}

	private void showPresent(Order order) {
		print(ResultMessage.getGiftFormat(order.getPresentEvent().getPresentList()));
	}

	private void showBenefitList(Order order, VisitDate visitDate) {
		StringBuilder sb = new StringBuilder();
		PresentEvent presentEvent = order.getPresentEvent();

		sb.append(BENEFIT_DETAILS.getMessage()).append(NEW_LINE);
		sb.append(discountService.getDiscountDetail(order, visitDate)).append(NEW_LINE);

		if (presentEvent.isApplicable()) {
			sb.append(presentEvent.getPresentBenefitDetail()).append(NEW_LINE);
		}

		print(sb.toString());
	}

	private void showTotalBenefitAmount(Order order, VisitDate visitDate) {
		TotalBenefitAmount totalBenefitAmount = new TotalBenefitAmount(order, visitDate);

		print(ResultMessage.getTotalBenefitAmountFormat(totalBenefitAmount.getTotalBenefitAmountNumberFormat()));
	}

	private void showPaymentAmount(Order order, VisitDate visitDate) {
		FinalPaymentAmount finalPaymentAmount = new FinalPaymentAmount(order, discountService.getTotalDiscountAmount(order, visitDate));

		print(ResultMessage.getFinalPaymentAmountFormat(finalPaymentAmount.getAmount()));
	}

	private void showBadge(Order order, VisitDate visitDate) {
		BadgeEvent badge = new BadgeEvent(new TotalBenefitAmount(order, visitDate));

		print(ResultMessage.getBadgeEventFormat(badge.getBadge()));
	}

	private void print(String message) {
		System.out.println(message);
	}
}