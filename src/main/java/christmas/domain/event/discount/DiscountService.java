package christmas.domain.event.discount;

import static christmas.config.message.ResultMessage.BENEFIT_FORMAT;
import static christmas.config.message.ResultMessage.NEW_LINE;

import christmas.domain.VisitDate;
import christmas.domain.amount.DiscountAmount;
import christmas.domain.order.Order;
import christmas.util.NumberFormatter;
import java.util.stream.Collectors;

public class DiscountService {

	private final DiscountConfig discountConfig;

	public DiscountService(DiscountConfig discountConfig) {
		this.discountConfig = discountConfig;
	}

	public DiscountAmount getTotalDiscountAmount(Order order, VisitDate visitDate) {
		int totalDiscountAmount = discountConfig.getDiscountPolicies().stream()
			.filter(policy -> policy.isApplicable(visitDate))
			.mapToInt(policy -> policy.getDiscountAmount(order, visitDate))
			.sum();

		return new DiscountAmount(totalDiscountAmount);
	}

	public String getDiscountDetail(Order order, VisitDate visitDate) {
		return discountConfig.getDiscountPolicies().stream()
			.filter(policy -> policy.isApplicable(visitDate))
			.map(policy -> String.format(BENEFIT_FORMAT.getMessage(), policy.getEventName(), NumberFormatter.getNumberFormat(policy.getDiscountAmount(order, visitDate))))
			.collect(Collectors.joining(NEW_LINE.getMessage()));
	}
}