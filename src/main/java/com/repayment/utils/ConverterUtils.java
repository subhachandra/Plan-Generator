package com.repayment.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ConverterUtils {

	public static Date stringToDateConverter(String dateInString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date date = null;
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
            e.printStackTrace();
        }
		return date;
	}
	public static String datetoStringConverter(Date datetoString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
		String stringDate = null;
		stringDate = formatter.format(datetoString);
		return stringDate;
	}
}
