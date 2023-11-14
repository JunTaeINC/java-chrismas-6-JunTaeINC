package christmas.domain.amount;

import static org.assertj.core.api.Assertions.*;

import christmas.domain.VisitDate;
import christmas.domain.event.discount.Discountable;
import christmas.domain.event.discount.DiscountConfig;
import christmas.domain.event.discount.DiscountService;
import christmas.domain.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FinalPaymentAmountTest {

	@Test
	@DisplayName("최종 결제금액을 잘 반환하는지 테스트")
	void getAmount() {
		Order order = new Order("티본스테이크-1,제로콜라-1");
		DiscountService service = new DiscountService(new DiscountConfig());
		Discountable discountable = service.getTotalDiscountAmount(order, new VisitDate("3"));

		FinalPaymentAmount finalPaymentAmount = new FinalPaymentAmount(order, discountable);

		// 티본스테이크 - 55,000 / 제로콜라 - 3,000 = 총합 58,000
		// 특별할인 - 1,000원 / 크리스마스 디데이 할인 - 1,200
		assertThat(finalPaymentAmount.getAmount()).isEqualTo(55_800);
	}
}