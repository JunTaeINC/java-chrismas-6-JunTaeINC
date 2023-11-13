package christmas.config.message;

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
	ORDER_MENU_FORMAT("%s %d개"),
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
}