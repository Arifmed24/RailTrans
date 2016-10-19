package servlets;

/**
 * Created by abalaev on 07.10.2016.
 */
public final class ValidationUtils {

    private ValidationUtils() {
    }

    private static final String ONLY_DIGITS = "[0-9]{2}";
    private static final String STATION_NAME  = "^[a-zA-Zа-я]+[- ]*[a-zA-Zа-я0-9]+$";
    private static final String LOGIN_PASSWORD = "^[a-zA-Z0-9]*$";
    private static final String DATE_CHECK = "(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)";
    private static final String FULL_NAME = "^[a-zA-Z]+ [a-zA-Z]+$";
    private static final String NAME = "^[a-zA-Z]+$";


    public static boolean checkNumber(String str) {
        return str.matches(ONLY_DIGITS);
    }

    public static boolean checkNumberSeats(Integer seats) {
        return (seats<=15);
    }

    public static boolean checkLogin(String login){
        return login != null && !login.isEmpty() && login.matches(LOGIN_PASSWORD);
    }

    public static boolean checkPassword(String password){
        return password != null && !password.isEmpty() && password.matches(LOGIN_PASSWORD);
    }

    public static boolean checkStationName(String name){
        return name != null && !name.isEmpty() && name.matches(STATION_NAME);
    }

    public static boolean checkDate(String date){
        return date != null && !date.isEmpty() && date.matches(DATE_CHECK);
    }

    public static boolean checkName(String name){
        return name != null && !name.isEmpty() && name.matches(NAME);
    }

    public static boolean checkFullName(String name){
        return name != null && !name.isEmpty() && name.matches(FULL_NAME);
    }
}
