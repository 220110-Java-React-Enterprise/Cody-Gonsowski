package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Checker contains a static helper method to check for validity of certain strings.
 */
public class Checker {
    /**
     * Checks if a string is valid for a given type.
     *   Valid email indicates letters or numbers + @ +
     *     letters or numbers + . + letters or numbers.
     *   Valid name indicates standard alphabetic characters.
     * @param str string to check if of valid type
     * @return true  - string is of valid type
     *         false - string is not of valid type
     */
    public static boolean isValid(String str, String type) {
        // start with empty string
        String patternString = "";

        // determine what patternString given a type
        //   invalid type returns false
        if (type.matches("email")) {
            patternString = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        } else if (type.matches("firstName") | type.matches("lastName")) {
            patternString = "[a-zA-Z]+";
        } else {
            return false;
        }

        // create pattern & matcher given patternString
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);

        // return result of matcher
        return matcher.find();
    }

}
