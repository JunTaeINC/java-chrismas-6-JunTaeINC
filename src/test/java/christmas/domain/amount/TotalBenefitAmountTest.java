package christmas.domain.amount;

import static christmas.config.message.ResultMessage.NONE;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.VisitDate;
import christmas.domain.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalBenefitAmountTest {

	private Order order;
	private VisitDate visitDate;
	private TotalBenefitAmount totalBenefitAmount;

	@Test
	@DisplayName("주문,방문날짜에 따라서 총 혜택금액 반환 테스트")
	void getTotalBenefitAmount() {
		order = new Order("티본스테이크-1,초코케이크-1,제로콜라-1");
		visitDate = new VisitDate("25");
		totalBenefitAmount = new TotalBenefitAmount(order, visitDate);

		String result = totalBenefitAmount.getTotalBenefitAmountNumberFormat();

		// 크리스마스 디데이 할인 : 3,400
		// 평일 할인 : 2,023 (초코케이크)
		// 특별 할인 : 1,000
		assertThat(result).isEqualTo("-6,423원");
	}

	@Test
	@DisplayName("총 혜택금액이 없을 경우 없음 반환 테스트")
	void getTotalBenefitAmount_WhenNonBenefit() {
		order = new Order("티본스테이크-1,제로콜라-1");
		visitDate = new VisitDate("28");
		totalBenefitAmount = new TotalBenefitAmount(order, visitDate);

		String result = totalBenefitAmount.getTotalBenefitAmountNumberFormat();

		assertThat(result).isEqualTo("0원");
	}
}