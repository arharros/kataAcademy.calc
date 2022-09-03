package calc;

class RomeNumbersOperations {
    static String[] romeNumbers = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    static String[] romeDecimalNumbers = new String[]{"XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};


    static int romeNumbersToArab(String input) {
        int number = -1;
        for (int i = 0; i < romeNumbers.length; i++) {
            if (input.equals(romeNumbers[i])) {
                number = i + 1;
            }
        }
        return number;
    }

    static String arabNumbersToRome(int input) {
        String result = "";
        int decimal = (input / 10);
        int units = (input % 10);
        if (input > 10) {
            if (decimal >= 2) {
                result = result + romeDecimalNumbers[decimal - 2];
            } else {
                result = result + romeNumbers[9];
            }
            if (units != 0) {
                result = result + romeNumbers[units - 1];
            }
        } else {
            result = result + romeNumbers[input - 1];
        }
        return result;
    }
}
