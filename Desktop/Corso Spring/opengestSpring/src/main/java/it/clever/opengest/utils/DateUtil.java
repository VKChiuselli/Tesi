package it.clever.opengest.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;

public class DateUtil {
	private static final Map<String, String> DATE_PATTERN_MAP = new HashMap<String, String>();
	private static final Map<String, String> DATETIME_PATTERN_MAP = new HashMap<String, String>();
	private static final String DEFAULT_DATE_PATTERN = "dd/MM/yyyy";
	private static final String DEFAULT_DATETIME_PATTERN = "dd/MM/yy HH:mm:ss";
	
	static {
		DATE_PATTERN_MAP.put(Locale.ITALY.getLanguage(), "dd/MM/yyyy");
		DATE_PATTERN_MAP.put(Locale.UK.getLanguage(), "MM/dd/yyyy");
		
		DATETIME_PATTERN_MAP.put(Locale.ITALY.getLanguage(), "dd/MM/yyyy HH:mm:ss");
		DATETIME_PATTERN_MAP.put(Locale.UK.getLanguage(), "MM/dd/yyyy HH:mm:ss");
	}
	
	public static enum DateStyle {DATE, DATETIME};
	
	public static Date maxDate() {
		Calendar c = GregorianCalendar.getInstance();
		c.set(Calendar.YEAR, 9999);
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DAY_OF_MONTH, 31);
		return c.getTime();
	}
	
	public static String patternForStyleAndLocale(DateStyle dateStyle, Locale locale) {
		String pattern;
		switch (dateStyle) {
			case DATE:
				pattern = DEFAULT_DATE_PATTERN;
				if (DATE_PATTERN_MAP.containsKey(locale.getLanguage()))
					pattern = DATE_PATTERN_MAP.get(locale.getLanguage());
				break;
			case DATETIME:
				pattern = DEFAULT_DATETIME_PATTERN;
				if (DATETIME_PATTERN_MAP.containsKey(locale.getLanguage()))
					pattern = DATETIME_PATTERN_MAP.get(locale.getLanguage());
				break;
			default:
				pattern = DEFAULT_DATE_PATTERN;
				if (DATE_PATTERN_MAP.containsKey(locale.getLanguage()))
					pattern = DATE_PATTERN_MAP.get(locale.getLanguage());
				break;
		}
		
		return pattern;
	} 
	
	public static CustomDateEditor customDateEditorForStyleAndLocale(DateStyle dateStyle, Locale locale) {
		return new CustomDateEditor(new SimpleDateFormat(patternForStyleAndLocale(dateStyle, locale)), true);
	}
	
	public static String format(Date date, DateStyle dateStyle, Locale locale) {
		return new SimpleDateFormat(patternForStyleAndLocale(dateStyle, locale)).format(date);
	}
}
