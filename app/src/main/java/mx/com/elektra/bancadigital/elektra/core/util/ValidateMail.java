package mx.com.elektra.bancadigital.elektra.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateMail {
    private static final Pattern VALID_EMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean isRightEmailFormat(String email){
        Matcher matcher = VALID_EMAIL.matcher(email);
        return matcher.find();
    }
}
