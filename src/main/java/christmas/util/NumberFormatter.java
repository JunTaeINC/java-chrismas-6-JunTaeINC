package christmas.util;

import java.text.NumberFormat;

public class NumberFormatter {

	public static String getNumberFormat(int number) {
		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		return numberFormat.format(number);
	}
}