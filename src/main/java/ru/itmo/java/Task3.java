package ru.itmo.java;

import java.util.HashMap;
import java.util.Map;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null) {
            return new int[0];
        }
        int n = inputArray.length;
        int[] tempArray = new int[n];
        for (int i = 0; i < n; i++) {
            tempArray[(i + 1) % n] = inputArray[i];
        }
        return tempArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null) {
            return 0;
        }
        int a = Integer.MIN_VALUE;
        int b = a;
        int ai = 0;
        int n = inputArray.length;
        for (int i = 0; i < n; i++) {
            if (inputArray[i] > a) {
                a = inputArray[i];
                ai = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if ((inputArray[i] > b) && (ai != i)) {
                b = inputArray[i];
            }
        }
        return a * b;
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null) {
            return 0;
        }
        int n = input.length();
        if (n == 0) {
            return 0;
        }
        int m = 0;
        for (int i = 0; i < n; i++) {
            char current = input.charAt(i);
            if ((current == 'a') || (current == 'A') || (current == 'b') || (current == 'B')) {
                m++;
            }
        }
        return (m * 100 / n);
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        int n = input.length();
        for (int i = 0; i < n / 2; i++) {
            if (input.charAt(i) != input.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if ((input == null) || (input.length() == 0)) {
            return "";
        }
        int n = input.length(); //длина строки
        String tempString = ""; //строка нового формата

        int current = 1;
        tempString += input.charAt(0);
        for (int i = 0; (i + 1) < n; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                current++;
            } else {
                tempString += current;
                tempString += input.charAt(i + 1);
                current = 1;
            }
        }

        tempString += current;

        return tempString;
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if ((one == null) || (two == null)) {
            return false;
        }
        int n = one.length();
        int m = two.length();
        if ((n == 0) || (m != n)) {
            return false;
        }

        Map<Character, Integer> mapOne = new HashMap<>();
        Map<Character, Integer> mapTwo = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char current = one.charAt(i);
            if (!mapOne.containsKey(current)) {
                mapOne.put(current, 0);
            } else {
                int temp = mapOne.get(current) + 1;
                mapOne.replace(current, temp);
            }
        }
        for (int i = 0; i < m; i++) {
            char current = two.charAt(i);
            if (!mapTwo.containsKey(current)) {
                mapTwo.put(current, 0);
            } else {
                int temp = mapTwo.get(current) + 1;
                mapTwo.replace(current, temp);
            }
        }

        for (var entry : mapOne.entrySet()) {
            if ((!mapTwo.containsKey(entry.getKey())) || (!mapTwo.get(entry.getKey()).equals(entry.getValue()))) {
                return false;
            }
        }
        return true;
    }


    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null) {
            return false;
        }
        int n = s.length();
        if (n == 0) {
            return false;
        }
        char[] tempArray = new char[n];
        for (int i = 0; i < n; i++) {
            tempArray[i] = s.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (tempArray[i] == tempArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null) {
            return new int[][]{{}, {}};
        }
        int n = m[0].length;
        if (n == 0) {
            return new int[][]{{}, {}};
        }
        int[][] tempMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tempMatrix[j][i] = m[i][j];
            }
        }
        return tempMatrix;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        String resultString = "";
        if (separator == null) {
            separator = ' ';
        }
        if (inputStrings == null) {
            return resultString;
        }
        if (inputStrings.length == 0){
            return resultString;
        }
        resultString += inputStrings[0];
        for (int i = 1; i < inputStrings.length; i++) {
            resultString += separator + inputStrings[i];
        }
        return resultString;
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if ((inputStrings == null) || (inputStrings.length == 0) || (prefix == null)) {
            return 0;
        }
        int count = 0;
        for (String current : inputStrings) {
            if (current.startsWith(prefix)) {
                count++;
            }
        }
        return count;
    }
}
