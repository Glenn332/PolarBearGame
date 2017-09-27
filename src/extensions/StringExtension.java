package extensions;

public class StringExtension {
    public static boolean isNumeric(String string){
        try{
            int i = Integer.parseInt(string);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public static int GetNumericValue(String string){
        return Integer.parseInt(string);
    }
}
