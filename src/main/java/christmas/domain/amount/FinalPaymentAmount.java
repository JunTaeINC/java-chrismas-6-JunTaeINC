package christmas.domain.amount;

public class FinalPaymentAmount implements Amount {

	private int finalPaymentAmount;


	@Override
	public int getAmount() {
		return finalPaymentAmount;
	}
}
