package calc;

import static calc.RomeNumbersOperations.arabNumbersToRome;
import static calc.RomeNumbersOperations.romeNumbersToArab;

class OperationsAndConditionsOfNumbers {

    static byte correctConditionOfNumber(String[] numbers) throws Exception {
        if ((romeNumbersToArab(numbers[0]) != -1) & (romeNumbersToArab(numbers[1]) != -1)) {
            return 0;
        } else {
            if ((romeNumbersToArab(numbers[0]) == -1) | (romeNumbersToArab(numbers[1]) == -1)) {
                if ((conditionOfArabNumber(numbers[0]) != -1) & (conditionOfArabNumber(numbers[1]) != -1)) {
                    return 1;
                } else {
                    throw new Exception("числа не удовлетворяют условию");
                }
            }
        }
        return 0;
    }

    static int conditionOfArabNumber(String number) {
        return switch (number) {
            case "1" -> 1;
            case "2" -> 2;
            case "3" -> 3;
            case "4" -> 4;
            case "5" -> 5;
            case "6" -> 6;
            case "7" -> 7;
            case "8" -> 8;
            case "9" -> 9;
            case "10" -> 10;
            default -> -1;
        };
    }


    static String addition(String[] input) throws Exception {
        int result = 0;
        if (correctConditionOfNumber(input) == 0) {
            for (String s : input) {
                result = result + romeNumbersToArab(s);
            }
            return arabNumbersToRome(result);
        } else {
            for (String s : input) {
                result = result + conditionOfArabNumber(s);
            }
            return "" + result;
        }
    }

    static String subtraction(String[] input) throws Exception {
        if (correctConditionOfNumber(input) == 0) {
            int number1 = romeNumbersToArab(input[0]);
            int number2 = romeNumbersToArab(input[1]);
            if (number1 <= number2) {
                throw new Exception("в римской системе нет отрицательных чисел и нуля");
            } else {
                return arabNumbersToRome(number1 - number2);
            }
        } else {
            int number1 = conditionOfArabNumber(input[0]);
            int number2 = conditionOfArabNumber(input[1]);
            return (number1 - number2) + "";
        }
    }

    static String multiplication(String[] input) throws Exception {
        if (correctConditionOfNumber(input) == 0) {
            int number1 = romeNumbersToArab(input[0]);
            int number2 = romeNumbersToArab(input[1]);
            return arabNumbersToRome(number1 * number2);
        } else {
            int number1 = conditionOfArabNumber(input[0]);
            int number2 = conditionOfArabNumber(input[1]);
            return (number1 * number2) + "";
        }
    }

    static String division(String[] input) throws Exception {
        if (correctConditionOfNumber(input) == 0) {
            int number1 = romeNumbersToArab(input[0]);
            int number2 = romeNumbersToArab(input[1]);
            if (number1 < number2) {
                throw new Exception("Результат деления меньше 1, в римской системе нет чисел меньше нуля");
            } else {
                return arabNumbersToRome(number1 / number2);
            }
        } else {
            int number1 = conditionOfArabNumber(input[0]);
            int number2 = conditionOfArabNumber(input[1]);
            return (number1 / number2) + "";
        }
    }
}
