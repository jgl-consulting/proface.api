package com.proface.api.util;

public class ProfaceCurrencyExchanger {
	
	public static double fromCurrencyToCurrency(String from, String to, double value) {
		if (from == null || to == null) {
			return value;
		}
		switch (from) {
		case "EUR":
			switch (to) {
			case "USD":
				return value * 1.12;
			case "PEN":
				return value * 3.78;
			default:
				return value;
			}
		case "USD":
			switch (to) {
			case "EUR":
				return value * 0.89;
			case "PEN":
				return value * 3.38;
			default:
				return value;
			}
		case "PEN":
			switch (to) {
			case "EUR":
				return value * 0.26;
			case "USD":
				return value * 0.30;
			default:
				return value;
			}
		default:
			return value;
		}
	}

}
