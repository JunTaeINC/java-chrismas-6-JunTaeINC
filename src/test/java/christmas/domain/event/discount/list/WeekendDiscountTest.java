package christmas.domain.event.discount.list;

import static christmas.domain.constant.DiscountConstant.WEEKEND_DISCOUNT_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.VisitDate;
import christmas.domain.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WeekendDiscountTest {

	private final WeekendDiscount weekendDiscount = new WeekendDiscount();

	@DisplayName("방문날짜가 주말인 경우 true를 반환한다")
	@ParameterizedTest
	@ValueSource(strings = {"1", "8", "16", "22"})
	void isApplicable_true(String visitDate) {
		assertThat(weekendDiscount.isApplicable(new VisitDate(visitDate))).isTrue();
	}

	@DisplayName("방문날짜가 주말이 아닌 경우 false를 반환한다")
	@ParameterizedTest
	@ValueSource(strings = {"4", "17", "26", "28"})
	void isApplicable_false(String visitDate) {
		assertThat(weekendDiscount.isApplicable(new VisitDate(visitDate))).isFalse();
	}

	@Test
	@DisplayName("방문날짜가 주말인 경우 메인음식의 갯수만큼 주말할인이 된다")
	void getDiscountAmount_WhenMainDishInOrder() {
		Order order = new Order("티본스테이크-4,제로콜라-1,레드와인-1");

		int discountAmount = weekendDiscount.getDiscountAmount(order, new VisitDate("1"));

		assertThat(discountAmount).isEqualTo(4 * WEEKEND_DISCOUNT_PRICE);
	}

	@Test
	@DisplayName("방문날짜가 주말인 경우 메인음식의 갯수만큼 주말할인이 된다")
	void getDiscountAmount_WhenNonMainDishInOrder() {
		Order order = new Order("양송이수프-4,제로콜라-1,레드와인-1");

		int discountAmount = weekendDiscount.getDiscountAmount(order, new VisitDate("1"));

		assertThat(discountAmount).isEqualTo(0);
	}
}