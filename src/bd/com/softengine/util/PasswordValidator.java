package bd.com.softengine.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 20/06/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 20/06/16
 * Version : 1.0
 */

public class PasswordValidator {
    public static void main(String[] args) {
        PasswordValidator validator =    new PasswordValidator();
        System.out.println(validator.validate("mY1A12222"));
    }

    private Pattern pattern;
    private Matcher matcher;

    private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    public PasswordValidator(){
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    /**
     * Validate password with regular expression
     * @param password password for validation
     * @return true valid password, false invalid password
     */
    public boolean validate(final String password){

        matcher = pattern.matcher(password);
        return matcher.matches();

    }

      /*
        Minimum 8 characters at least 1 Alphabet and 1 Number:

        "^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$"
        Minimum 8 characters at least 1 Alphabet, 1 Number and 1 Special Character:

        "^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$"
        Minimum 8 characters at least 1 Uppercase Alphabet, 1 Lowercase Alphabet and 1 Number:

        "^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$"
        Minimum 8 characters at least 1 Uppercase Alphabet, 1 Lowercase Alphabet, 1 Number and 1 Special Character:

        "^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}"
        Minimum 8 and Maximum 10 characters at least 1 Uppercase Alphabet, 1 Lowercase Alphabet, 1 Number and 1 Special Character:

        "^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,10}"
        * */
}
