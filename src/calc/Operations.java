package calc;

import static calc.RomeNumbersOperations.arabNumbersToRome;
import static calc.RomeNumbersOperations.romeNumbersToArab;

class Operations {

    static byte correctConditionOfNumber(String[] numbers) throws Exception {
        if ((romeNumbersToArab(numbers[0]) != -1) & (romeNumbersToArab(numbers[1]) != -1)) {
            return 0;
        } else {
            if ((romeNumbersToArab(numbers[0]) == -1) | (romeNumbersToArab(numbers[1]) == -1)) {
                throw new Exception("числа не удовлетворяют условию");
            } else {
                if ((Byte.parseByte(numbers[0]) >= 1) & (Byte.parseByte(numbers[0]) <= 10)
                        & (Byte.parseByte(numbers[1]) >= 1) & (Byte.parseByte(numbers[1]) <= 10)) {
                    return 1;
                } else {
                    throw new Exception("числа не удовлетворяют условию");
                }
            }
        }
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
                result = result + Byte.parseByte(s);
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
            byte number1 = Byte.parseByte(input[0]);
            byte number2 = Byte.parseByte(input[1]);
            return (number1 - number2) + "";
        }
    }

    static String multiplication(String[] input) throws Exception {
        if (correctConditionOfNumber(input) == 0) {
            int number1 = romeNumbersToArab(input[0]);
            int number2 = romeNumbersToArab(input[1]);
            return arabNumbersToRome(number1 * number2);
        } else {
            byte number1 = Byte.parseByte(input[0]);
            byte number2 = Byte.parseByte(input[1]);
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
            byte number1 = Byte.parseByte(input[0]);
            byte number2 = Byte.parseByte(input[1]);
            return (number1 / number2) + "";
        }
    }
}
