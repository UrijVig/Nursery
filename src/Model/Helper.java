package Model;

public class Helper {
    public Helper() {

    }

    public static boolean isNumber(String data) {
        for (int i = 0; i < data.length(); i++) {
            if (!Character.isDigit(data.charAt(i)))
                return false;
        }
        return true;
    }
}
