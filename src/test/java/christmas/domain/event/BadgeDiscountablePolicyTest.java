package christmas.domain.event;

import static christmas.config.Badge.SANTA;
import static christmas.config.Badge.STAR;
import static christmas.config.Badge.TREE;
import static christmas.config.message.ResultMessage.NONE;

import christmas.domain.VisitDate;
import christmas.domain.amount.TotalBenefitAmount;
import christmas.domain.order.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BadgeDiscountablePolicyTest {

	private BadgeEvent badgeEvent;
	private Order order;
	private VisitDate visitDate;

	@Test
	@DisplayName("총 할인금액이 5,000원 이하일 경우 뱃지 없음")
	void getBadge_None() {
		order = new Order("해산물파스타-1,제로콜라-1");
		visitDate = new VisitDate("25");
		badgeEvent = new BadgeEvent(new TotalBenefitAmount(order, visitDate));

		String result = badgeEvent.getBadge();

		Assertions.assertThat(result).isEqualTo(NONE.getMessage());
	}

	@Test
	@DisplayName("총 할인금액이 5,000원 이상 10,000 미만일 경우 뱃지는 별")
	void getBadge_Star() {
		order = new Order("해산물파스타-1,초코케이크-1,제로콜라-1");
		visitDate = new VisitDate("25");
		badgeEvent = new BadgeEvent(new TotalBenefitAmount(order, visitDate));

		String result = badgeEvent.getBadge();

		Assertions.assertThat(result).isEqualTo(STAR.getName());
	}

	@Test
	@DisplayName("총 할인금액이 10,000원 이상 20,000 미만일 경우 뱃지는 트리")
	void getBadge_Tree() {
		order = new Order("초코케이크-3,제로콜라-1,티본스테이크-1");
		visitDate = new VisitDate("25");
		badgeEvent = new BadgeEvent(new TotalBenefitAmount(order, visitDate));

		String result = badgeEvent.getBadge();

		Assertions.assertThat(result).isEqualTo(TREE.getName());
	}

	@Test
	@DisplayName("총 할인금액이 20,000 이상일 경우 뱃지는 산타")
	void getBadge_Santa() {
		order = new Order("티본스테이크-10");
		visitDate = new VisitDate("25");
		badgeEvent = new BadgeEvent(new TotalBenefitAmount(order, visitDate));

		String result = badgeEvent.getBadge();

		Assertions.assertThat(result).isEqualTo(SANTA.getName());
	}
}