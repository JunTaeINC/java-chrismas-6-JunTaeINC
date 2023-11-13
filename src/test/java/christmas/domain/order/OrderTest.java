package christmas.domain.order;

import static christmas.config.message.ErrorMessage.EXCEEDED_ORDER_QUANTITY_LIMIT;
import static christmas.config.message.ErrorMessage.INVALID_ORDER;
import static christmas.config.message.ErrorMessage.ONLY_BEVERAGE_ORDER_ERROR;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderTest {

	private Exception exception;

	@DisplayName("주문이 올바르게 생성되는지 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"제로콜라-1,티본스테이크-1,양송이수프-1", "레드와인-1,초코케이크-1"})
	void testValidate_WhenValid(String order) {
		assertDoesNotThrow(() -> new Order(order));
	}

	@Test
	@DisplayName("주문 입력시 공백을 입력할 경우 예외 발생")
	void testValidate_WhenBlank() {
		String blank = "";

		exception = assertThrows(IllegalArgumentException.class, () -> new Order(blank));

		assertEquals(exception.getMessage(), INVALID_ORDER.getMessage());
	}

	@DisplayName("없는 메뉴를 입력할 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"김치찌개-1,티본스테이크-1,양송이수프-1", "참이슬-1,튀김우동-1"})
	void testValidate_WhenNonMenu(String order) {
		exception = assertThrows(IllegalArgumentException.class, () -> new Order(order));

		assertEquals(exception.getMessage(), INVALID_ORDER.getMessage());
	}

	@DisplayName("정해진 주문 양식을 지키지 않을 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"제로콜라*1,티본스테이크*1,양송이수프*1", "레드와인:1,초코케이크:1", "제로콜라-0,티본스테이크-1"})
	void testValidate_WhenInvalidOrderFormat(String order) {
		exception = assertThrows(IllegalArgumentException.class, () -> new Order(order));

		assertEquals(exception.getMessage(), INVALID_ORDER.getMessage());
	}

	@DisplayName("정해진 주문 양식을 지키지 않을 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"제로콜라-한개,티본스테이크-1,양송이수프-두개", "레드와인-하나,초코케이크-셋"})
	void testValidate_WhenQuantityString(String order) {
		exception = assertThrows(IllegalArgumentException.class, () -> new Order(order));

		assertEquals(exception.getMessage(), INVALID_ORDER.getMessage());
	}

	@DisplayName("중복 메뉴를 입력한 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"제로콜라-1,티본스테이크-1,제로콜라-1", "레드와인-1,레드와인-1"})
	void testValidate_WhenDuplicateMenu(String order) {
		exception = assertThrows(IllegalArgumentException.class, () -> new Order(order));

		assertEquals(exception.getMessage(), INVALID_ORDER.getMessage());
	}

	@DisplayName("음료만 입력한 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"제로콜라-1,샴페인-1,레드와인-1", "제로콜라-1,레드와인-1"})
	void testValidate_WhenOnlyBeverage(String order) {
		exception = assertThrows(IllegalArgumentException.class, () -> new Order(order));

		assertEquals(exception.getMessage(), ONLY_BEVERAGE_ORDER_ERROR.getMessage());
	}

	@DisplayName("한번에 주문가능한 메뉴의 숫자를 넘을 경우 예외 발생")
	@ParameterizedTest
	@ValueSource(strings = {"제로콜라-7,티본스테이크-13,양송이수프-1", "레드와인-1,초코케이크-20"})
	void testValidate_WhenOverMaximumMenuQuantity(String order) {
		exception = assertThrows(IllegalArgumentException.class, () -> new Order(order));

		assertEquals(exception.getMessage(), EXCEEDED_ORDER_QUANTITY_LIMIT.getMessage());
	}
}