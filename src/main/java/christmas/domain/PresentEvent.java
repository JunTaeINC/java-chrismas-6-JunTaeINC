package christmas.domain;

import christmas.config.Present;
import christmas.domain.amount.TotalOrderAmount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PresentEvent {

	private final TotalOrderAmount totalOrderAmount;
	private List<String> presents;

	public PresentEvent(TotalOrderAmount totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;

		presents = new ArrayList<>();

		addPresent();
	}

	public void addPresent() {
		presents = Arrays.stream(Present.values())
			.filter(present -> totalOrderAmount.isPresentAvailable(present.getBaseAmount()))
			.map(Present::getName)
			.collect(Collectors.toList());
	}

	public List<String> getPresents() {
		return presents;
	}
}