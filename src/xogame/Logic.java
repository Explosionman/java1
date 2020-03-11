package xogame;

import javax.swing.*;
import java.util.Random;

public class Logic {
    static int SIZE = 3;
    static int DOTS_TO_WIN = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Random random = new Random();

    public static boolean gameFinish = false;
    public static String winnerName = "...";

    public static void go() {
        JPanel myRootPane = new JPanel();
        gameFinish = true;
        printMap();

        if (checkWinLines(DOT_X)) {
            System.out.println("Игрок победил");
            winnerName = "Игрок победил";
            JOptionPane.showMessageDialog(myRootPane, winnerName, "Игра завершена", JOptionPane.DEFAULT_OPTION);
            return;
        }

        if (isFull()) {
            System.out.println("Ничья");
            winnerName = "Ничья";
            JOptionPane.showMessageDialog(myRootPane, winnerName, "Игра завершена", JOptionPane.DEFAULT_OPTION);
            return;
        }

        aiTurn();
        printMap();

        if (checkWinLines(DOT_O)) {
            System.out.println("Компьютер победил");
            winnerName = "Компьютер победил";
            JOptionPane.showMessageDialog(myRootPane, winnerName, "Игра завершена", JOptionPane.DEFAULT_OPTION);
            return;
        }

        if (isFull()) {
            System.out.println("Ничья");
            winnerName = "Ничья";
            JOptionPane.showMessageDialog(myRootPane, winnerName, "Игра завершена", JOptionPane.DEFAULT_OPTION);
            return;
        }
        gameFinish = false;
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
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setHumanXY(int x, int y) {
        if (isCellValid(y, x)) {
            map[y][x] = DOT_X;
            go();
        }
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void aiTurn() {
        int x, y;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                //AI стремится выйграть
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWinLines(DOT_O)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
                //AI блокирует ходы
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWinLines(DOT_X)) {
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
            y = random.nextInt(SIZE);
            x = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkLine(int cy, int cx, int vy, int vx, char dot) {
        if (cx + vx * DOTS_TO_WIN - 1 > SIZE - 1 || cy + vy * DOTS_TO_WIN - 1 > SIZE - 1 ||
                cy + vy * (DOTS_TO_WIN - 1) < 0) {
            return false;
        }
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (map[cy + i * vy][cx + i * vx] != dot) {
                return false;
            }
        }
        return true;
    }

    static boolean checkWinLines(char dot) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, dot) || checkLine(i, j, 1, 0, dot) ||
                        checkLine(i, j, 1, 1, dot) || checkLine(i, j, -1, 1, dot)) {
                    return true;
                }
            }
        }
        return false;
    }
}
