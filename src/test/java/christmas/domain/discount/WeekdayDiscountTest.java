package christmas.domain.discount;

import static christmas.domain.constant.DiscountConstant.WEEKDAY_DISCOUNT_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.MenuCategory;
import christmas.domain.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WeekdayDiscountTest {

	private final WeekdayDiscount weekdayDiscount = new WeekdayDiscount();

	@DisplayName("방문날짜가 평일인 경우 true를 반환한다")
	@ParameterizedTest
	@ValueSource(ints = {4, 12, 20, 28})
	void isApplicable_true(int date) {
		assertThat(weekdayDiscount.isApplicable(date)).isTrue();
	}

	@DisplayName("방문날짜가 평일이 아닌 경우 false를 반환한다")
	@ParameterizedTest
	@ValueSource(ints = {1, 9, 15, 23})
	void isApplicable_false(int date) {
		assertThat(weekdayDiscount.isApplicable(date)).isFalse();
	}

	@Test
	@DisplayName("방문날짜가 평일인 경우 디저트 수량만큼 평일할인 금액이 할인된다")
	void getDiscountAmount_WhenDessertInOrder() {
		Order order = new Order(new MenuCategory(), "초코케이크-10,제로콜라-1,해산물파스타-1");

		int discountAmount = weekdayDiscount.getDiscountAmount(order);

		assertThat(discountAmount).isEqualTo(10 * WEEKDAY_DISCOUNT_PRICE);
	}

	@Test
	@DisplayName("방문날짜가 평일이지만 디저트의 갯수가 없을 경우 할인이 적용되지 않는다")
	void getDiscountAmount_WhenNonDessertInOrder() {
		Order order = new Order(new MenuCategory(), "제로콜라-1,해산물파스타-1");

		int discountAmount = weekdayDiscount.getDiscountAmount(order);

		assertThat(discountAmount).isEqualTo(0);
	}
}