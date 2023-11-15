package christmas.domain.event;

import static christmas.config.Event.PRESENT_EVENT;
import static christmas.config.message.ResultMessage.NEW_LINE;
import static christmas.config.message.ResultMessage.NONE;

import christmas.config.Present;
import christmas.config.message.ResultMessage;
import christmas.domain.amount.TotalOrderAmount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PresentEvent {

	private final TotalOrderAmount totalOrderAmount;
	private List<Present> presents;

	public PresentEvent(TotalOrderAmount totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;

		presents = new ArrayList<>();

		addPresent();
	}

	public void addPresent() {
		presents = Arrays.stream(Present.values())
			.filter(present -> totalOrderAmount.isPresentAvailable(present.getBaseAmount()))
			.collect(Collectors.toList());
	}

	public List<Present> getPresents() {
		return presents;
	}

	public String getPresentList() {
		StringBuilder sb = new StringBuilder();

		if (!isApplicable()) {
			return NONE.getMessage();
		}

		for (Present present : presents) {
			sb.append(ResultMessage.getOrderMenuFormat(present.getMenu().getName(), present.getPresentCount())).append(NEW_LINE.getMessage());
		}

		return sb.toString().trim();
	}

	public String getPresentBenefitDetail() {
		return ResultMessage.getBenefitFormat(getEventName(), getTotalPresentAmount());
	}

	public boolean isApplicable() {
		return !presents.isEmpty();
	}

	private String getEventName() {
		return PRESENT_EVENT.getName();
	}

	public int getTotalPresentAmount() {
		return presents.stream()
			.mapToInt(present -> present.getMenu().getPrice())
			.sum();
	}
}