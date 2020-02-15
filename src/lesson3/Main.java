package lesson3;

import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        Закомментировано для раздельной проверки
//        System.out.println("Задание №1:");
//        guessTheNumber();
        System.out.println("Задание №2:");
        guessTheWord();
    }

    //Задача №1. Создём программу, которая загадывает случайное число от 0 до 9. Пользователю дается 3 попытки угадать
    //это число. При каждой попытке компьютер сообщает, больше ли указанное пользователем число, чем загаданное,
    // или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»
    static void guessTheNumber() {
        Random rand = new Random();
        int randomDigit = rand.nextInt(10);
        int attemptsCount = 1;
        System.out.println("Загадано число от 0 до 9. У Вас есть 3 попытки, чтобы его угадать.");

        while (attemptsCount < 4) {
            System.out.printf("Попытка №%d, введите число:\n", attemptsCount);
            int userInput = sc.nextInt();
            if (userInput == randomDigit) {
                System.out.println("Поздравляю! Вы угадали!\nПовторить игру еще раз? 1 – да / 0 – нет");
                int userChoice = sc.nextInt();
                restartOrEnd(userChoice);
                break;
            } else if (userInput > randomDigit) {
                System.out.println("Вы ввели слишком большое число.");
                attemptsCount++;
            } else if (userInput < randomDigit) {
                System.out.println("Вы ввели слишком маленькое число.");
                attemptsCount++;
            }
            if (attemptsCount == 4 && userInput != randomDigit) {
                System.out.println("Вы проиграли =(\nПовторить игру еще раз? 1 – да / 0 – нет");
                int userChoice = sc.nextInt();
                restartOrEnd(userChoice);
            }
        }
    }

    //Метод для продолжения/завершения игры
    static void restartOrEnd(int userInput) {
        switch (userInput) {
            case 0:
                System.out.println("До новых встреч!");
                break;
            case 1:
                guessTheNumber();
                break;
            default:
                throw new IllegalArgumentException("Ошибка ввода: " + userInput);
        }
    }

    //Задание №2. Создаём массив. При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    //сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер
    //показывает буквы, которые стоят на своих местах.
    static void guessTheWord() {
        Random rand = new Random();
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        String randomWord = words[rand.nextInt(words.length - 1)];
        String encryptedWord = "###############";
        char[] arrayOfEncryptedChars = encryptedWord.toCharArray();
        String userInput = "";
        System.out.println("Загадано: " + randomWord);

        System.out.print("Загадано одно слово из списка: ");
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1) {
                System.out.printf("%s", words[i]);
            } else if (i % 13 == 0) {
                System.out.println();
            } else {
                System.out.printf("%s, ", words[i]);
            }
        }

        System.out.println("\nВаша задача угадать его. Введите Ваш вариант:");
        while (!userInput.equals(randomWord)) {
            userInput = sc.nextLine();
            //Определяем количество итераций принципом: какое слово имеет меньшую длину (Math.min), такое и берем за основу
            for (int i = 0; i < Math.min(randomWord.length(), userInput.length()); i++) {
                if (userInput.charAt(i) == randomWord.charAt(i)) {
                    arrayOfEncryptedChars[i] = userInput.charAt(i);
                }
            }
            //Если ввод пользователя = загаданному слову или пользователь добился успеха вводом нескольких неправльных вводов
            if (userInput.equals(randomWord) || randomWord.equals(printArray(arrayOfEncryptedChars).substring(0, randomWord.length()))) {
                System.out.printf("Верно, это, %s. Поздравляю!", randomWord);
                break;
            }
            System.out.printf("Ответ кроется за решетками, угадайте оставшиеся буквы:\n%s\nВы не угадали =( Попробуйте ещё, " +
                    "ведь игра не остановится, пока Вы не добьётесь успеха.\n", printArray(arrayOfEncryptedChars));
        }
    }
    //Этот метод создан для дальнейшей обработки случаев, когда пользователь отгадал слово, но победа не засчиталась (см. строка 101),
    //а также вывода промежуточного результата, к примеру, за 2 попытки юзер угадал слово "apple", но сделал это двумя неверными попытками,
    // например: apricot и adsple. Фактически, решетки будут открыты, но не будет счтитаться выйгрышным.
    static String printArray(char[] array) {
        StringBuilder tempResult = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            tempResult.append(array[i]);
        }
        return tempResult.toString();
    }
}
