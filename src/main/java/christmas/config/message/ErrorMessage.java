package christmas.config.message;

import static christmas.domain.constant.MenuConstant.MAXIMUM_ORDER_QUANTITY;

public enum ErrorMessage {
	INVALID_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
	INVALID_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
	EXCEEDED_ORDER_QUANTITY_LIMIT(String.format("[ERROR] 메뉴는 한 번에 최대 %d개까지만 주문할 수 있습니다.", MAXIMUM_ORDER_QUANTITY)),
	ONLY_BEVERAGE_ORDER_ERROR("[ERROR] 음료만 주문할 수 없습니다. 다른 메뉴를 함께 주문해 주세요.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}