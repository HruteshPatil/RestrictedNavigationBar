package com.example.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.stereotype.Component;

@Component("customFormat")
public class CustomFormatters {

	public String formatCurrency(BigDecimal amount, String localeCode) {

		if (amount == null)
			return "N/A";

		Locale locale = switch (localeCode.toUpperCase()) {

		case "USD" -> Locale.US;
		case "INR" -> new Locale("en", "IN");
		case "GBP" -> Locale.UK;
		default -> Locale.getDefault();
		};

		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);

		return numberFormat.format(amount);
	}
}
