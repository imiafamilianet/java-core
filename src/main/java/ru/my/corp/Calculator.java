package ru.my.corp;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

/**
 * Калькулятор.
 */
public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в Калькулятор!");
        System.out.println("Команды: 'C' — сброс, 's' — выход.");

        State state = new State();
        while (state.isRun) {
            if (state.operand == null) {
                System.out.print("Введите первое число: ");
                if (scanner.hasNext()) {
                    state.line = scanner.next();
                    if (checkLine(state)) {
                        continue;
                    }
                }
                try {
                    state.operand = Double.parseDouble(state.line);
                } catch (NumberFormatException ex) {
                    System.out.println("Введено не число");
                    continue;
                }
            }

            System.out.print("Введите операцию (+, -, *, /)");
            state.line = scanner.next();
            if (checkLine(state)) {
                continue;
            }

            char operation = state.line.charAt(0);
            if (state.line.length() > 1 || operation != '+' && operation != '-' && operation != '*' && operation != '/') {
                System.out.println("Ошибка: неподдерживаемая операция '" + state.line + "'.");
                continue;
            }

            System.out.print("Введите второе число: ");
            double operand2;
            if (scanner.hasNext()) {
                state.line = scanner.next();
                if (checkLine(state)) {
                    continue;
                }
            }
            try {
                operand2 = Double.parseDouble(state.line);
            } catch (NumberFormatException ex) {
                System.out.println("Введено не число");
                continue;
            }

            operate(operation, state, operand2);

        }
        System.out.println("--- Финальный результат: " + state.operand + " ---");
        scanner.close();
    }

    private static void operate(char operation, State state, double operand2) {
        switch (operation) {
            case '+':
                state.operand += operand2;
                System.out.println("Результат: " + state.operand);
                break;
            case '-':
                state.operand -= operand2;
                System.out.println("Результат: " + state.operand);
                break;
            case '*':
                state.operand *= operand2;
                System.out.println("Результат: " + state.operand);
                break;
            case '/':
                if (operand2 == 0) {
                    System.out.println("Ошибка: деление на ноль невозможно! Результат не изменен.");
                } else {
                    state.operand /= operand2;
                    System.out.println("Результат: " + state.operand);
                }
                break;
        }
    }

    private static boolean checkLine(State state) {
        if (state.line.equalsIgnoreCase("s")) {
            System.out.println("Программа завершена. До свидания!");
            state.isRun = false;
            return true;
        } else if (state.line.equalsIgnoreCase("c")) {
            System.out.println("Результат сброшен.");
            state.operand = null;
            return true;
        }
        return false;
    }

    /**
     * Внутренний класс состояния вычисления.
     */
    @Setter
    @Getter
    static class State {
        boolean isRun = true;
        String line;
        Double operand;
    }
}