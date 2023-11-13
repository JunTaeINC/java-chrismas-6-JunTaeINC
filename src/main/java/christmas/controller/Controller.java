package christmas.controller;

import christmas.domain.MenuCategory;
import christmas.domain.VisitDate;
import christmas.domain.order.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {

	private VisitDate visitDate;
	private Order order;
	private final OutputView outputView = new OutputView();

	public void run() {
		askVisitDate();

		askOrderMenu();

		showPreviewBenefit();
	}


	private void askVisitDate() {
		outputView.askVisitDate();

		String userInput = InputView.getUserInput();

		visitDate = new VisitDate(userInput);
	}

	private void askOrderMenu() {
		outputView.askOrderMenu();

		String userInput = InputView.getUserInput();

		order = new Order(new MenuCategory(), userInput);
	}

	private void showPreviewBenefit() {
		outputView.showBenefit();
		outputView.showPreviewBenefit(order, visitDate);
	}
}