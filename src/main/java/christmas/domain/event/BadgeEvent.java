package christmas.domain.event;

import static christmas.config.message.ResultMessage.NONE;

import java.util.Arrays;
import java.util.Comparator;

public class BadgeEvent {

	private final int discountAmount;

	public BadgeEvent(int discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getBadge() {
		return Arrays.stream(christmas.config.Badge.values())
			.filter(badge -> discountAmount >= badge.getBaseAmount())
			.max(Comparator.comparingInt(christmas.config.Badge::getBaseAmount))
			.map(christmas.config.Badge::getName)
			.orElse(NONE.getMessage());
	}
}