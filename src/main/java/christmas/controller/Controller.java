package christmas.controller;

import christmas.domain.VisitDate;
import christmas.domain.order.Order;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.function.Function;

public class Controller {

	private VisitDate visitDate;
	private Order order;
	private final OutputView outputView = new OutputView();
	private final InputView inputView = new InputView();

	public void run() {
		askVisitDate();

		askOrderMenu();

		showPreviewBenefit();
	}


	private void askVisitDate() {
		outputView.askVisitDate();

		String userInput = getValidInput(VisitDate::new);

		visitDate = new VisitDate(userInput);
	}

	private void askOrderMenu() {
		outputView.askOrderMenu();

		String userInput = getValidInput(Order::new);

		order = new Order(userInput);
	}

	private void showPreviewBenefit() {
		outputView.showBenefit();
		outputView.showPreviewBenefit(order, visitDate);
	}

	private <T> String getValidInput(Function<String, T> constructor) {
		String input;

		do {
			input = inputView.getUserInput().trim();
			try {
				constructor.apply(input);
			} catch (IllegalArgumentException e) {
				outputView.printExceptionMessage(e.getMessage());
				input = null;
			}
		} while (input == null);

		return input;
	}
}