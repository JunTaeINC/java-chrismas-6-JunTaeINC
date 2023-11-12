package christmas.domain;

import static christmas.config.message.ResultMessage.NONE;

import christmas.config.BadgeList;
import java.util.Arrays;
import java.util.Comparator;

public class Badge {

	private final int discountAmount;

	public Badge(int discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getBadge() {
		return Arrays.stream(BadgeList.values())
			.filter(badge -> discountAmount >= badge.getBaseAmount())
			.max(Comparator.comparingInt(BadgeList::getBaseAmount))
			.map(BadgeList::getName)
			.orElse(NONE.getMessage());
	}
}