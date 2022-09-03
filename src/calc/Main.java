package calc;

import java.util.Scanner;
import static calc.Operations.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение арабскими(1,2,3..) или римскими цифрами(I,II,III,IV..)!");
        System.out.println("Числа должны быть от 1 до 10 включительно. Оператор действия должен быть один!");
        System.out.println("При вводе римскими цифрами выражения вычитания, второе число не должно быть больше или равно первому!");
        while (true) {
            System.out.print("Введите выражение или введите exit для выхода: ");
            String input = console.nextLine();
            if (input.equals("exit")) {
                break;
            }
            System.out.println("Результат: " + calc(input));
        }
    }

    public static String calc(String input) throws Exception {
        String result = "";
        char operator = 0;
        if ((input.contains("+"))
                | (input.contains("-"))
                | input.contains("*")
                | input.contains("/")) {
            int i = 0;
            int countOfOperators = 0;
            while (i < input.length()) {
                char c = input.charAt(i);
                if ((c == '+') | (c == '-') | (c == '*') | (c == '/')) {
                    countOfOperators++;
                    operator = c;
                }
                i++;
            }
            if (countOfOperators == 1) {
                switch (operator) {
                    case '+':
                        String[] numbers = input.split("\\+");
                        if (numbers.length < 2) {
                            throw new Exception("формат математической операции не удовлетворяет заданию");
                        } else {
                            result = addition(numbers);
                        }
                        break;
                    case '-':
                        numbers = input.split("-");
                        if (numbers.length < 2) {
                            throw new Exception("формат математической операции не удовлетворяет заданию");
                        } else {
                            result = subtraction(numbers);
                        }
                        break;
                    case '*':
                        numbers = input.split("\\*");
                        if (numbers.length < 2) {
                            throw new Exception("формат математической операции не удовлетворяет заданию");
                        } else {
                            result = multiplication(numbers);
                        }
                        break;
                    case '/':
                        numbers = input.split("/");
                        if (numbers.length < 2) {
                            throw new Exception("формат математической операции не удовлетворяет заданию");
                        } else {
                            result = division(numbers);
                        }
                        break;
                }
            } else {
                throw new Exception("формат математической операции не удовлетворяет заданию");
            }
        } else {
            throw new Exception("строка не является математической операцией");
        }
        return result;
    }
}
