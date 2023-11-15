package christmas.domain.event.discount;

import static christmas.config.message.ResultMessage.NEW_LINE;
import static christmas.config.message.ResultMessage.NONE;
import static christmas.domain.constant.DiscountConstant.MINIMUM_ORDER_AMOUNT;
import static christmas.domain.constant.DiscountConstant.ZERO;

import christmas.config.message.ResultMessage;
import christmas.domain.VisitDate;
import christmas.domain.order.Order;
import java.util.stream.Collectors;

public class DiscountService {

	private final DiscountConfig discountConfig;

	public DiscountService() {
		this.discountConfig = new DiscountConfig();
	}

	public Discountable getTotalDiscountAmount(Order order, VisitDate visitDate) {
		if (order.getTotalOrderAmount() < MINIMUM_ORDER_AMOUNT) {
			return new NoDiscount();
		}

		int totalDiscountAmount = discountConfig.getDiscountPolicies().stream()
			.filter(policy -> policy.isApplicable(order, visitDate))
			.mapToInt(policy -> policy.getDiscountAmount(order, visitDate))
			.sum();

		return new Discount(totalDiscountAmount);
	}

	public String getDiscountDetail(Order order, VisitDate visitDate) {
		if (getTotalDiscountAmount(order, visitDate).getAmount() == ZERO) {
			return NONE.getMessage();
		}

		return discountConfig.getDiscountPolicies().stream()
			.filter(policy -> policy.isApplicable(order, visitDate))
			.map(policy -> ResultMessage.getBenefitFormat(policy.getEventName(), policy.getDiscountAmount(order, visitDate)))
			.collect(Collectors.joining(NEW_LINE.getMessage()));
	}
}