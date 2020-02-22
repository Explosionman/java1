package acmp;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String tRoom = in.nextLine();
        String temp = in.next();
        String[] arr = tRoom.split(" ");

        int answer = 0;
        if (temp.equals("freeze") && Integer.parseInt(arr[0]) > Integer.parseInt(arr[1])) {
            answer = Integer.parseInt(arr[1]);
        } else if ((temp.equals("freeze") && Integer.parseInt(arr[0]) <= Integer.parseInt(arr[1]))){
            answer = Integer.parseInt(arr[0]);
        }
        if (temp.equals("heat") && Integer.parseInt(arr[0]) < Integer.parseInt(arr[1])) {
            answer = Integer.parseInt(arr[1]);
        } else if (temp.equals("heat") && Integer.parseInt(arr[0]) >= Integer.parseInt(arr[1])) {
            answer = Integer.parseInt(arr[0]);
        }
        if (temp.equals("fan")) {
            answer = Integer.parseInt(arr[0]);
        }
        if (temp.equals("auto")) {
            answer = Integer.parseInt(arr[1]);
        }

        out.println(answer);

        out.flush();
    }
}