package christmas.domain.amount;

import static christmas.config.message.ResultMessage.NONE;
import static christmas.domain.constant.DiscountConstant.ZERO;

import christmas.config.message.ResultMessage;
import christmas.domain.VisitDate;
import christmas.domain.event.discount.DiscountService;
import christmas.domain.order.Order;

public class TotalBenefitAmount implements Amount {

	private final int totalBenefitAmount;

	public TotalBenefitAmount(Order order, VisitDate visitDate) {
		this.totalBenefitAmount = calculateBenefitAmount(order, visitDate);
	}

	private int calculateBenefitAmount(Order order, VisitDate visitDate) {
		DiscountService discountService = new DiscountService();
		return discountService.getTotalDiscountAmount(order, visitDate).getAmount()
			+ order.getPresentEvent().getTotalPresentAmount();
	}

	@Override
	public int getAmount() {
		return totalBenefitAmount;
	}

	public String getTotalBenefitAmountNumberFormat() {
		if (!isApplicable()) {
			return NONE.getMessage();
		}

		return ResultMessage.getTotalBenefitFormat(totalBenefitAmount);
	}

	private boolean isApplicable() {
		return totalBenefitAmount != ZERO;
	}
}