package lesson_2;

import java.util.Arrays;

public class Main {
    //Создаём массив для задания №1
    private static int[] firstArray = {1, 0, 1, 0, 0, 1};
    //Создаём массив для задания №3 и №5**
    private static int[] secondArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    //Создаём массив для задания 6**
    private static int[] thirdArray = {2, 2, 2, 1, 2, 2, 10, 1};
    //Создаём массив для задания 7****
    private static int[] fourthArray = {1, 2, 3, 4, 5, 55};

    public static void main(String[] args) {
        //Выводим в консоль результаты заданий
        System.out.print("Результат по заданию №1. Изначальный массив: " + Arrays.toString(firstArray) + ", итоговый массив: ");
        invertArray();
        System.out.print("Результат по заданию №2. Заполненный массив: ");
        fillArray();
        System.out.print("Результат по заданию №3. Изначальный массив: " + Arrays.toString(secondArray) + ", итоговый массив: ");
        changeArray();
        System.out.println("Результат по заданию №4. Заполненные диагональные элементы:");
        fillDiagonal();
        System.out.print("Результат по заданию №5**. В массиве " + Arrays.toString(secondArray));
        findMinAndMax();
        System.out.print("Результат по заданию №6**. В массиве " + Arrays.toString(thirdArray));
        System.out.println(checkBalance(thirdArray));
        System.out.print("Результат по заданию №7****. Изначальный массив " + Arrays.toString(fourthArray)
                + " при отрицательном значении n = -2 получаем: " + modifyArray(fourthArray, -2)
                + ". \nОн стал изначальным массивом, при положительном n = 3 получаем: " + modifyArray(fourthArray, 3));
    }

    //Задание 1. Создаём целочисленный массив, состоящий из элементов 0 и 1.
    // С помощью цикла заменяем 0 на 1, 1 на 0;
    public static void invertArray() {
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = Math.abs(firstArray[i] - 1);
        }
        System.out.println(Arrays.toString(firstArray));
    }

    //Задание 2. Задаём пустой целочисленный массив размером 8.
    // С помощью цикла заполняем его значениями 0 3 6 9 12 15 18 21
    public static void fillArray() {
        int[] arr = new int[8];
        int indexValue = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = indexValue;
            indexValue += 3;
        }
        System.out.println(Arrays.toString(arr));
    }

    //Задание 3. Создаём массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], проходим по нему циклом и,
    //если число меньше 6, умножаем его на 2
    public static void changeArray() {
        for (int i = 0; i < secondArray.length; i++) {
            if (secondArray[i] < 6) {
                secondArray[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(secondArray));
    }

    //Задание 4. Создаём квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    // и с помощью цикла(-ов) заполняем его диагональные элементы единицами;
    public static void fillDiagonal() {
        int[][] arr = new int[4][4];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][i] = 1;
                arr[i][arr.length - 1 - i] = 1;
                System.out.print("\t" + arr[i][j]);
            }
            System.out.println();
        }
    }

    //Задание 5**. Создаём одномерный массив и находим в нем минимальный и максимальный элементы
    public static void findMinAndMax() {
        int maxValue = secondArray[0];
        int minValue = maxValue;

        for (int i = 1; i < secondArray.length; i++) {
            if (secondArray[i] >= maxValue) {
                maxValue = secondArray[i];
            } else if (secondArray[i] <= minValue) {
                minValue = secondArray[i];
            }
        }
        System.out.println(" максимальное число: " + maxValue + ", минимальное число: " + minValue);
    }

    //Задание 6**. Создаём метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    public static boolean checkBalance(int[] arr) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int leftSum = arr[startIndex];
        int rightSum = arr[endIndex];

        for (int i = 1; i < arr.length - 1; i++) {
            if (leftSum <= rightSum) {
                startIndex++;
                leftSum += arr[startIndex];
            } else if (leftSum >= rightSum) {
                endIndex--;
                rightSum += arr[endIndex];
            }
        }
        System.out.print(" сумма левой стороны: " + leftSum + ", сумма правой стороны: " + rightSum
                + ", метод возвращает: ");
        if (leftSum == rightSum) {
            return true;
        }
        return false;
    }

    //Задание 7****. Создаём метод, которому на вход подаём одномерный массив и число n
    //(может быть положительным или отрицательным). Метод смещает все элементы массива на n позиций
    //Для смещения создаём два метода, для сдвига влево и для сдвига вправо
    public static int[] moveElementsLeft(int[] arr, int n) {
        int tempValue = 0;
        for (int j = 0; j < n; j++) {
            //цикл смещает элементы массива на 1 влево
            for (int i = 0; i < arr.length - 1; i++) {
                tempValue = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = tempValue;
            }
        }
        return arr;
    }

    public static int[] moveElementsRight(int[] arr, int n) {
        int tempValue = 0;
        for (int j = 0; j < n; j++) {
            //цикл смещает элементы массива на 1 вправо
            for (int i = 0; i < arr.length - 1; i++) {
                tempValue = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tempValue;
            }
        }
        return arr;
    }

    //Метод возвращает массив со смещенными элементами вправо (при положительном входном параметре "n") и влево (при отрицательном)
    public static String modifyArray(int[] arr, int n) {
        if (n < 0) {
            n = Math.abs(n);
            arr = moveElementsLeft(arr, n);
        } else {
            arr = moveElementsRight(arr, n);
        }
        return Arrays.toString(arr);
    }
}
