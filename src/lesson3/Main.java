package lesson3;

import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static boolean restartOrEnd = true;

    public static void main(String[] args) {
        //  Закомментировано для раздельной проверки
        System.out.println("Задание №1:");
        guessTheNumber();
//        System.out.println("Задание №2:");
//        guessTheWord();
    }

    //Задача №1. Создём программу, которая загадывает случайное число от 0 до 9. Пользователю дается 3 попытки угадать
    //это число. При каждой попытке компьютер сообщает, больше ли указанное пользователем число, чем загаданное,
    // или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»
    static void guessTheNumber() {
        boolean restart = true;
        do {
            int randomDigit = rand.nextInt(10);
            System.out.println("Загадано число от 0 до 9. У Вас есть 3 попытки, чтобы его угадать.");
            for (int i = 1; i < 4; i++) {
                System.out.println("Попытка №" + i + ", введите число:");
                int userInput = sc.nextInt();
                if (userInput == randomDigit) {
                    System.out.println("Поздравляю! Вы угадали");
                    break;
                } else if (i == 3 && userInput != randomDigit) {
                    System.out.println("Вы проиграли =( ");
                    break;
                } else if (userInput > randomDigit) {
                    System.out.println("Вы ввели слишком большое число.");
                } else if (userInput < randomDigit) {
                    System.out.println("Вы ввели слишком маленькое число.");
                }
            }
            restart = setRestartOrEnd();
        } while (restart != false);
    }

    //Метод для продолжения/завершения игры
    static boolean setRestartOrEnd() {
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        int userChoice = sc.nextInt();
        if (userChoice == 0) {
            return false;
        } else {
            return true;
        }
    }

    //Задание №2. Создаём массив. При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    //сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер
    //показывает буквы, которые стоят на своих местах.
    static void guessTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        String randomWord = words[rand.nextInt(words.length - 1)];
        StringBuilder encryptedWord = new StringBuilder("###############");
        String userInput = "";

        printList(words);

        while (!userInput.equals(randomWord)) {
            userInput = sc.nextLine();
            updateEncryptedWord(userInput, encryptedWord, randomWord);

            if (userInput.equals(randomWord)) {
                System.out.printf("Верно, это, %s. Поздравляю!", randomWord);
                break;
            }
            System.out.println("Вы не угадали =( Ответ кроется за решетками, угадайте оставшиеся буквы:");
            System.out.println(encryptedWord);
        }
    }

    //Метод для обновления зашифрованного слова
    static StringBuilder updateEncryptedWord(String userInput, StringBuilder encryptedWord, String randomWord) {
        //Определяем количество итераций принципом: какое слово имеет меньшую длину (Math.min), такое и берем за основу
        int length = Math.min(randomWord.length(), userInput.length());
        for (int i = 0; i < length; i++) {
            if (userInput.charAt(i) == randomWord.charAt(i)) {
                encryptedWord.setCharAt(i, userInput.charAt(i));
            }
        }
        return encryptedWord;
    }

    //Метод для вывода задания
    static void printList(String[] words) {
        System.out.print("Загадано одно слово из списка: ");
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                System.out.print(words[i]);
            } else if (i % 13 == 0) {
                System.out.println();
            } else {
                System.out.printf("%s, ", words[i]);
            }
        }
        System.out.println("\nВаша задача угадать его. Введите Ваш вариант:");
    }
}
