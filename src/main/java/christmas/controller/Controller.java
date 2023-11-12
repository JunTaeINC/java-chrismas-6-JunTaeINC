package christmas.controller;

import christmas.domain.MenuCategory;
import christmas.domain.VisitDate;
import christmas.domain.order.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {

	private VisitDate visitDate;
	private Order order;

	public void run() {
		askVisitDate();

		askOrderMenu();

		showBenefit();
	}


	private void askVisitDate() {
		OutputView.askVisitDate();

		String userInput = InputView.getUserInput();

		visitDate = new VisitDate(userInput);
	}

	private void askOrderMenu() {
		OutputView.askOrderMenu();

		String userInput = InputView.getUserInput();

		order = new Order(new MenuCategory(), userInput);
	}

	private void showBenefit() {
		OutputView.showBenefit();

		OutputView.showOrderMenu(order);
	}
}