package christmas.domain.event;

import christmas.config.Present;
import christmas.config.message.ResultMessage;
import christmas.domain.amount.TotalOrderAmount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PresentEvent {

	private final String NEW_LINE = "\n";
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

	public String getPresent() {
		StringBuilder sb = new StringBuilder();

		if (presents.isEmpty()) {
			return ResultMessage.NONE.getMessage();
		}

		for (String present : presents) {
			sb.append(present).append(NEW_LINE);
		}

		return sb.toString();
	}
}