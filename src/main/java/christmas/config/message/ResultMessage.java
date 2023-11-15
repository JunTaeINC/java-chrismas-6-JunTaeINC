package christmas.config.message;

import christmas.util.NumberFormatter;

public enum ResultMessage {
	ORDER_MENU("<주문 메뉴>"),
	TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
	GIFT_MENU("<증정 메뉴>"),
	BENEFIT_DETAILS("<혜택 내역>"),
	TOTAL_BENEFIT_AMOUNT("<총혜택 금액>"),
	ESTIMATED_PAYMENT_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
	DECEMBER_EVENT_BADGE("<12월 이벤트 배지>"),
	NONE("없음"),
	MONETARY_UNIT("원"),
	ORDER_MENU_FORMAT("%s %s개"),
	BENEFIT_FORMAT("%s: -%s원"),
	TOTAL_BENEFIT_FORMAT("-%s원"),
	NEW_LINE("\n");

	private final String message;

	ResultMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public static String getOrderMenuFormat(String orderMenuList) {
		return NEW_LINE.getMessage() + ORDER_MENU.getMessage() + NEW_LINE.getMessage() + orderMenuList;
	}

	public static String getTotalOrderAmountFormat(int totalOrderAmount) {
		return TOTAL_ORDER_AMOUNT_BEFORE_DISCOUNT.getMessage() + NEW_LINE.getMessage()
			+ NumberFormatter.getNumberFormat(totalOrderAmount) + MONETARY_UNIT.getMessage() + NEW_LINE.getMessage();
	}

	public static String getGiftFormat(String gifts) {
		return GIFT_MENU.getMessage() + NEW_LINE.getMessage() + gifts + NEW_LINE.getMessage();
	}

	public static String getTotalBenefitAmountFormat(String totalBenefitAmount) {
		return TOTAL_BENEFIT_AMOUNT.getMessage() + NEW_LINE.getMessage() + totalBenefitAmount + NEW_LINE.getMessage();
	}

	public static String getFinalPaymentAmountFormat(int finalPaymentAmount) {
		return ESTIMATED_PAYMENT_AFTER_DISCOUNT.getMessage() + NEW_LINE.getMessage()
			+ NumberFormatter.getNumberFormat(finalPaymentAmount) + MONETARY_UNIT.getMessage() + NEW_LINE.getMessage();
	}

	public static String getBadgeEventFormat(String badge) {
		return DECEMBER_EVENT_BADGE.getMessage() + NEW_LINE.getMessage() + badge;
	}

	public static String getOrderMenuFormat(String menuName, int count) {
		return String.format(ORDER_MENU_FORMAT.getMessage(), menuName, NumberFormatter.getNumberFormat(count)) + NEW_LINE.getMessage();
	}

	public static String getPresentFormat(String menuName, int count) {
		return String.format(ORDER_MENU_FORMAT.getMessage(), menuName, NumberFormatter.getNumberFormat(count)) + NEW_LINE.getMessage();
	}

	public static String getBenefitFormat(String eventName, int discountAmount) {
		return String.format(BENEFIT_FORMAT.getMessage(), eventName, NumberFormatter.getNumberFormat(discountAmount));
	}

	public static String getTotalBenefitFormat(int totalBenefitAmount) {
		return String.format(TOTAL_BENEFIT_FORMAT.getMessage(), NumberFormatter.getNumberFormat(totalBenefitAmount));
	}
}