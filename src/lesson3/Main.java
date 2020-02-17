package lesson3;

import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static boolean restartOrEnd = true;

    public static void main(String[] args) {
        //  Закомментировано для раздельной проверки
        while (restartOrEnd) {
            System.out.println("Задание №1:");
            guessTheNumber();
        }
//        System.out.println("Задание №2:");
//        guessTheWord();
    }

    //Задача №1. Создём программу, которая загадывает случайное число от 0 до 9. Пользователю дается 3 попытки угадать
    //это число. При каждой попытке компьютер сообщает, больше ли указанное пользователем число, чем загаданное,
    // или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»
    static void guessTheNumber() {
        int randomDigit = rand.nextInt(10);
        System.out.println("Загадано число от 0 до 9. У Вас есть 3 попытки, чтобы его угадать.");
        int attemptsCount = 1;

        while (attemptsCount < 4) {
            System.out.printf("Попытка №%d, введите число:\n", attemptsCount);
            int userInput = sc.nextInt();
            if (userInput == randomDigit) {
                System.out.println("Поздравляю! Вы угадали!\nПовторить игру еще раз? 1 – да / 0 – нет");
                restartOrEnd = endGame();
                break;
            } else if (userInput > randomDigit) {
                System.out.println("Вы ввели слишком большое число.");
                attemptsCount++;
            } else if (userInput < randomDigit) {
                System.out.println("Вы ввели слишком маленькое число.");
                attemptsCount++;
            }
            checkLose(attemptsCount, randomDigit, userInput);
        }
    }

    //Метод проверки пороигрыша
    static void checkLose(int attemptsCount, int randomDigit, int userInput) {
        if (attemptsCount == 4 && userInput != randomDigit) {
            System.out.println("Вы проиграли =(\nПовторить игру еще раз? 1 – да / 0 – нет");
            restartOrEnd = endGame();
        }
    }

    //Метод для продолжения/завершения игры
    static boolean endGame() {
        int userChoice = sc.nextInt();
        return userChoice == 0 ? false : true;
    }

    //Задание №2. Создаём массив. При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    //сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер
    //показывает буквы, которые стоят на своих местах.
    static void guessTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        String randomWord = words[rand.nextInt(words.length - 1)];
        StringBuilder encryptedWord = new StringBuilder();
        encryptedWord.append("###############");
        String userInput = "";

        printList(words);

        while (!userInput.equals(randomWord)) {
            userInput = sc.nextLine();
            //Определяем количество итераций принципом: какое слово имеет меньшую длину (Math.min), такое и берем за основу
            int length = Math.min(randomWord.length(), userInput.length());

            for (int i = 0; i < length; i++) {
                if (userInput.charAt(i) == randomWord.charAt(i)) {
                    encryptedWord.setCharAt(i, userInput.charAt(i));
                }
            }
            //Создаём переменную на основе encryptedWord, длины загаданного слова, для проверки на совпадение
            String partOfEncryptedWord = encryptedWord.substring(0, randomWord.length());
            //Если ввод пользователя = загаданному слову или пользователь добился успеха вводом нескольких неправльных вводов
            if (userInput.equals(randomWord) || randomWord.equals(partOfEncryptedWord)) {
                System.out.printf("Верно, это, %s. Поздравляю!", randomWord);
                break;
            }
            System.out.printf("Ответ кроется за решетками, угадайте оставшиеся буквы:\n%s\nВы не угадали =( Попробуйте ещё, " +
                    "ведь игра не остановится, пока Вы не добьётесь успеха.\n", encryptedWord);
        }
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
