package christmas.domain.amount;

import christmas.config.menu.Menu;
import java.util.Map;

public class TotalOrderAmount implements Amount {

	private int totalOrderAmount;

	public TotalOrderAmount(Map<Menu, Integer> order) {
		for (Map.Entry<Menu, Integer> menu : order.entrySet()) {
			totalOrderAmount += menu.getKey().getPrice() * menu.getValue();
		}
	}

	@Override
	public int getAmount() {
		return totalOrderAmount;
	}

	public boolean isPresentAvailable(int baseAmount) {
		return totalOrderAmount >= baseAmount;
	}
}