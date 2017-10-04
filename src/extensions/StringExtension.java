package extensions;

public class StringExtension {

    /**
     * returns true if the given string is of numeric value.
     * @param string the string value to check if it is an numeric value.
     */
    public static boolean IsNumeric(String string){
        try{
            Integer.parseInt(string);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    /**
     * returns numeric value of the given string.
     * @param string the string value to get the numeric value from.
     */
    public static int GetNumericValue(String string){
        return Integer.parseInt(string);
    }
}
