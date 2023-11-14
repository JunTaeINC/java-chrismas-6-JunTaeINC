package christmas.domain.event.discount;

import static christmas.config.message.ResultMessage.NONE;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.VisitDate;
import christmas.domain.amount.DiscountAmount;
import christmas.domain.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountServiceTest {

	private Order order;
	private VisitDate visitDate;
	private final DiscountService discountService = new DiscountService(new DiscountConfig());

	@Test
	@DisplayName("기준금액 미만일 경우 할인이 적용되지 않는다.")
	void getTotalDiscountAmount_WhenNoDiscount() {
		order = new Order("타파스-1");
		visitDate = new VisitDate("24");

		Discount nodiscount = discountService.getTotalDiscountAmount(order, visitDate);

		assertThat(nodiscount).isInstanceOf(NoDiscount.class);
	}

	@Test
	@DisplayName("기준금액 이상일 경우 할인이 적용된다.")
	void getTotalDiscountAmount_WhenDiscount() {
		order = new Order("타파스-2");
		visitDate = new VisitDate("24");

		Discount nodiscount = discountService.getTotalDiscountAmount(order, visitDate);

		assertThat(nodiscount).isInstanceOf(DiscountAmount.class);
	}

	@Test
	@DisplayName("혜택금액이 없을 경우 없음 반환")
	void getDiscountDetail_WhenNoDiscount() {
		order = new Order("타파스-1");
		visitDate = new VisitDate("24");

		String result = discountService.getDiscountDetail(order, visitDate);

		assertThat(result).isEqualTo(NONE.getMessage());
	}

	@Test
	@DisplayName("혜택금액이 있는 경우 혜택 전부 반환")
	void getDiscountDetail_WhenDiscount() {
		order = new Order("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
		visitDate = new VisitDate("3");

		String result = discountService.getDiscountDetail(order, visitDate);

		assertThat(result).contains("크리스마스 디데이 할인: -1,200원", "평일 할인: -4,046원", "특별 할인: -1,000원");
	}
}