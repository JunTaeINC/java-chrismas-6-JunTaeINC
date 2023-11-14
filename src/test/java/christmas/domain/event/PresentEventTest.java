package christmas.domain.event;

import static christmas.config.Present.CHAMPAGNE;
import static christmas.config.message.ResultMessage.NONE;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.order.Order;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PresentEventTest {

	private PresentEvent presentEvent;
	private Order order;

	@Test
	@DisplayName("총 주문금액에 증정품을 지급할 수 있을 경우 true 반환")
	void getPresent_true() {
		order = new Order("티본스테이크-10");

		presentEvent = order.getPresentEvent();

		assertThat(presentEvent.getPresents()).isEqualTo(List.of(CHAMPAGNE));
	}

	@Test
	@DisplayName("총 주문금액에 증정품을 지급할 수 없는 경우 false 반환")
	void getPresent_false() {
		order = new Order("티본스테이크-1");

		presentEvent = order.getPresentEvent();

		assertThat(presentEvent.getPresents()).isEmpty();
	}

	@Test
	@DisplayName("총 주문금액에 따라 증정품 반환 테스트 (샴페인 - 기준금액 120,000)")
	void getPresentList() {
		order = new Order("티본스테이크-10");
		presentEvent = order.getPresentEvent();

		String presentList = presentEvent.getPresentList();

		assertThat(presentList).isEqualTo(CHAMPAGNE.getMenu().getName());
	}

	@Test
	@DisplayName("증정품이 없을 경우 '없음' 반환")
	void getPresentList_WhenNonPresent() {
		order = new Order("티본스테이크-1");
		presentEvent = order.getPresentEvent();

		String presentList = presentEvent.getPresentList();

		assertThat(presentList).isEqualTo(NONE.getMessage());
	}
}
