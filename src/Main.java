//TODO:
// 1. Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами:
//      a + b, a - b, a * b, a / b. Данные передаются в одну строку!
//      Решения, в которых каждое число и арифметическая операция передаются с новой строки считаются неверными.
// 2. Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.
//      На выходе числа не ограничиваются по величине и могут быть любыми.
// 3. Калькулятор умеет работать только с целыми числами.
// 4. При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.
// 5. При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций,
//      приложение выбрасывает исключение и завершает свою работу.
// 6. Результатом операции деления является целое число, остаток отбрасывается.
// 7. Результатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль.
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        HashSet<String> LEGAL_OPERATION = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        String eq_str;
        Scanner input = new Scanner(System.in);
        System.out.println("Type eq: "); eq_str = input.nextLine().trim();
        input.close();
        String[] eq_arr = eq_str.split(" ");

        try {
            if (eq_arr.length != 3) {
                throw new IOException();
            } else {
                int a = Integer.parseInt(eq_arr[0]);
                String operator = eq_arr[1];
                int b = Integer.parseInt(eq_arr[2]);
                boolean c1 = 0 >= a || 10 < a;
                boolean c2 = 0 >= b || 10 < b;
                boolean c3 = !LEGAL_OPERATION.contains(operator);
                if (c1 || c2 || c3){
                    throw new IOException();
                } else {
                    Equation eq = new Equation();
                    eq.setA(Integer.parseInt(eq_arr[0]));
                    eq.setB(Integer.parseInt(eq_arr[2]));
                    eq.setOperation(eq_arr[1]);
                    System.out.println(eq.doEq());
                }
            }
        } catch (IOException | NumberFormatException | IllegalStateException e){
            System.out.println("Введены некорректные входные данные. Заверщение работы");
            System. exit(1);
        }
    }
}

class Equation{
    int a;
    int b;
    String operation;

    void setA(int val){
        a = val;
    }

    void setB(int val){
        b = val;
    }

    void setOperation(String val){
        operation = val;
    }

    int doEq(){
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new IllegalStateException();
        };
    }
}