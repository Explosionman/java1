package lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkHorizontalLines(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            int counter = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symbol) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkVerticalLines(char symbol) {
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            int counter = 0;
            for (int j = 0; j < DOTS_TO_WIN; j++) {
                if (map[j][i] == symbol) {
                    counter++;
                }
                if (counter == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkFirstDiagonalLine(char symbol, int y, int x) {
        int counter = 0;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (map[i + y][i + x] == symbol) {
                counter++;
            }

            if (counter == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkSecondDiagonalLine(char symbol, int y, int x) {
        int counter = 0;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (map[DOTS_TO_WIN - (1 + i) + y][i + x] == symbol) {
                counter++;
            }
            if (counter == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkWin(char symbol) {
        if (checkHorizontalLines(symbol) || checkVerticalLines(symbol)
                || checkFirstDiagonalLine(symbol, 1, 0)
                || checkFirstDiagonalLine(symbol, 0, 0)
                || checkFirstDiagonalLine(symbol, 0, 1)
                || checkFirstDiagonalLine(symbol, 1, 1)

                || checkSecondDiagonalLine(symbol, 1, 0)
                || checkSecondDiagonalLine(symbol, 0, 0)
                || checkSecondDiagonalLine(symbol, 0, 1)
                || checkSecondDiagonalLine(symbol, 1, 1)) {
            return true;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                //AI блокирует ходы
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
                //AI стремится выйграть
                if (map[i][j] == DOT_O && (isCellValid(i, j + 1) && isCellValid(i, j + 3))) {
                    map[i][j + 1] = DOT_O;
                    return;
                }
                if (map[i][j] == DOT_O && (isCellValid(i + 1, j) && isCellValid(i + 3, j))) {
                    map[i + 1][j] = DOT_O;
                    return;
                }
                if (map[i][i] == DOT_O && (isCellValid(i + 1, i + 1) && isCellValid(i + 3, i + 3))) {
                    map[i + 1][i + 1] = DOT_O;
                    return;
                }
            }
        }
        do {
            y = rand.nextInt(SIZE);
            x = rand.nextInt(SIZE);
        } while (!

                isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (y + 1) + " " + (x + 1));
        map[x][y] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате: столбец (Y) строка (X)");
            y = sc.nextInt() - 1;
            x = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[x][y] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print("\t" + i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print("\t" + (i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print("\t" + map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
