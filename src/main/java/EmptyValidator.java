public class EmptyValidator {

    public static boolean valid(String s) {
        if(s == null) {
            return false;
        }

        if(s.length() == 0) {
            return false;
        }

        if(s.trim().length() == 0) {
            return false;
        }


        return true;
    }
}
