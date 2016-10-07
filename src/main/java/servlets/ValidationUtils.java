package servlets;

/**
 * Created by abalaev on 07.10.2016.
 */
public final class ValidationUtils {

    private ValidationUtils() {
    }

    private static final String ONLY_DIGITS = "[0-9]";

    public static boolean checkNumber(String str) {
        return str.matches(ONLY_DIGITS);
    }
}
