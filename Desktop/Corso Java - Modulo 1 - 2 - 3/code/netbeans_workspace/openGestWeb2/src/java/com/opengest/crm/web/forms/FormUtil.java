package com.opengest.crm.web.forms;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Utility class for forms. This class contains commonly used request parameter processing and
 * validation logic which are been refactored in single static methods.
 *
 * @author Roberto Giontella
 */
public final class FormUtil {

	private static final String DATE_PATTERN_DD_MM_YYYY = "dd/MM/yyyy";
	
    // Constructors -------------------------------------------------------------------------------

    private FormUtil() {
        // Utility class, hide constructor.
    }

    // Request parameter processing ---------------------------------------------------------------

    /**
     * Returns the form field value from the given request associated with the given field name.
     * It returns null if the form field value is null or is empty after trimming all whitespace.
     * @param request The request to return the form field value for.
     * @param fieldName The field name to be associated with the field value.
     * @return The form field value from the given request associated with the given field name.
     */
    public static String getFieldValue(HttpServletRequest request, String fieldName) {
        String value = request.getParameter(fieldName);
        return isEmpty(value) ? null : value;
    }

    // Validation ---------------------------------------------------------------------------------

    /**
     * Returns true if the given value is null or is empty.
     * @param value The value to be checked on emptiness.
     * @return True if the given value is null or is empty.
     */
    public static boolean isEmpty(Object value) {
        if (value == null) {
            return true;
        } else if (value instanceof String) {
            return ((String) value).trim().length() == 0;
        } else if (value instanceof Object[]) {
            return ((Object[]) value).length == 0;
        } else if (value instanceof Collection<?>) {
            return ((Collection<?>) value).size() == 0;
        } else if (value instanceof Map<?, ?>) {
            return ((Map<?, ?>) value).size() == 0;
        } else {
            return value.toString() == null || value.toString().trim().length() == 0;
        }
    }

    /**
     * Returns true if the given old value does not equals the given new value.
     * @param oldValue The old value to be compared with the new value. The value may be null.
     * @param newValue The new value to be compared with the old value. The value may be null.
     * @return True if the given old value does not equals the given new value.
     */
    public static boolean isChanged(Object oldValue, Object newValue) {
        return oldValue == null ? newValue != null : !oldValue.equals(newValue);
    }

    /**
     * Returns true if the given string is a valid email address.
     * @param string The string to be checked on being a vaild email address.
     * @return True if the given string is a valid email address.
     */
    public static boolean isEmail(String string) {
        return string.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)");
    }

    /**
     * Returns true if the given string is a valid positive number.
     * @param string The string to be checked on being a vaild positive number.
     * @return True if the given string is a valid positive number.
     */
    public static boolean isNumber(String string) {
        return string.matches("^\\d+$");
    }
    
    public static BigDecimal trasformFromStringToBigDecimal(String amount, Locale locale) {
    	
    	NumberFormat numberFormatter =  NumberFormat.getNumberInstance(locale);
    	String output = numberFormatter.format(new Double(amount));
    	BigDecimal retBig = new BigDecimal(output);
    	
    	return retBig;
    }
    
    public static BigDecimal trasformFromStringToBigDecimal(String amount) {
    	
    	NumberFormat numberFormatter =  NumberFormat.getNumberInstance(new Locale("it", "IT"));
    	String output = numberFormatter.format(new Double(amount));
    	BigDecimal retBig = new BigDecimal(output);
    	return retBig;
    }
    
    public static Integer trasformFromStringToInteger(String amount) {
    	return new Integer(amount);
    }
    
    public static Date fromStringToDate_ddMMyyyy(String dataStr) throws Exception {
    	SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN_DD_MM_YYYY);
    	return sdf.parse(dataStr);
    }
    

}