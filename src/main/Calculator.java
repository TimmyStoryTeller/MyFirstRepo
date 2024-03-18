
import java.util.Scanner;

public class Calculator {
    public static String[] toStringArray(String input) {
        // Split the input string using whitespace
        return input.split("\\s+");
    }

    public static int calculate(int number1, int number2, String operation) {
        switch (operation) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0) {
                    throw new IllegalArgumentException("На ноль делить нельзя.");
                }
                return number1 / number2;
            default:
                throw new IllegalArgumentException("Неизвестный формат: " + operation);
        }
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        while (userInput.hasNext()) {
            String word = userInput.nextLine();

            try {
                String[] parts = toStringArray(word);
                if (parts.length != 3) {
                    throw new IllegalArgumentException("Пожалуйста, введите два числа и один оператор.");
                }

                // Check if first and third parts are valid integers and second part is a valid operator
                int firstNumber = Integer.parseInt(parts[0]);
                int secondNumber = Integer.parseInt(parts[2]);
                String operation = parts[1];
                if (!operation.matches("[+*/-]")) {
                    throw new IllegalArgumentException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                }

                if (firstNumber < 1 || firstNumber > 10 || secondNumber < 1 || secondNumber > 10) {
                    throw new IllegalArgumentException("Ошибка: Числа должны быть в диапазоне от 1 до 10.");
                }

                int result = calculate(firstNumber, secondNumber, operation);
                System.out.println(result);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка один из операндов не является числом.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Возникла непредвиденная ошибка.");
            }
        }
        userInput.close();
    }
}