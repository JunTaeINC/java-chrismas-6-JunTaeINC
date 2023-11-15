package christmas.domain.event;

import static christmas.config.message.ResultMessage.NONE;

import christmas.config.Badge;
import christmas.domain.amount.TotalBenefitAmount;
import java.util.Arrays;
import java.util.Comparator;

public class BadgeEvent {

	private final int discountAmount;

	public BadgeEvent(TotalBenefitAmount totalBenefitAmount) {
		this.discountAmount = totalBenefitAmount.getAmount();
	}

	public String getBadge() {
		return Arrays.stream((Badge.values()))
			.filter(badge -> discountAmount >= badge.getBaseAmount())
			.max(Comparator.comparingInt(Badge::getBaseAmount))
			.map(Badge::getName)
			.orElse(NONE.getMessage());
	}
}