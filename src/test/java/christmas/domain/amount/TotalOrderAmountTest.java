package christmas.domain.amount;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.MenuCategory;
import christmas.domain.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalOrderAmountTest {

	@Test
	@DisplayName("총 주문 금액을 반환하는지 테스트")
	void getAmount_V1() {
		// 티본스테이크 - 55,000 / 제로콜라 - 3,000 / 양송이수프 -  6,000 = 총 64,000원
		Order order = new Order(new MenuCategory(), "티본스테이크-1,제로콜라-1,양송이수프-1");

		int totalOrderAmount = order.getTotalOrderAmount();

		assertThat(totalOrderAmount).isEqualTo(64_000);
	}

	@Test
	@DisplayName("총 주문 금액을 반환하는지 테스트")
	void getAmount_V2() {
		// 티본스테이크 - 550,000 / 제로콜라 - 3,000 / 양송이수프 -  6,000 = 총 559,000원
		Order order = new Order(new MenuCategory(), "티본스테이크-10,제로콜라-1,양송이수프-1");

		int totalOrderAmount = order.getTotalOrderAmount();

		assertThat(totalOrderAmount).isEqualTo(559_000);
	}
}