package christmas.domain.event;

import static christmas.config.Present.CHAMPAGNE;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.MenuCategory;
import christmas.domain.order.Order;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PresentDiscountPolicyTest {

	private PresentEvent presentEvent;

	@Test
	@DisplayName("총 주문금액에 따라 증정품 증정 테스트(샴페인 증정)")
	void getPresent_true() {
		Order order = new Order(new MenuCategory(), "티본스테이크-10");

		presentEvent = order.getPresentEvent();

		assertThat(presentEvent.getPresents()).isEqualTo(List.of(CHAMPAGNE));
	}

	@Test
	@DisplayName("총 주문금액에 따라 증정품 증정 테스트(증정품 없음)")
	void getPresent_false() {
		Order order = new Order(new MenuCategory(), "티본스테이크-1");

		presentEvent = order.getPresentEvent();

		assertThat(presentEvent.getPresents()).isEmpty();
	}
}
