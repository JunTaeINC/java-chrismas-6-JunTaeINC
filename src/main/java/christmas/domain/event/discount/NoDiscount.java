package christmas.domain.event.discount;

public class NoDiscount implements Discountable {

	@Override
	public int getAmount() {
		return 0;
	}
}