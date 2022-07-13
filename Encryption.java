package hackerRank;

import training.Methods;

import java.util.Scanner;

public class Encryption extends Methods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        timeAndData();


        // https://www.hackerrank.com/challenges/encryption/problem?utm_campaign=challenge-recommendation&utm_
        // medium=email&utm_source=24-hour-campaign

        // if man was meant to stay on the ground dog would have given os roots
        // have a nice day
        // feed the dog


        String[] input = scanner.nextLine().split(" ");
        StringBuilder stb = new StringBuilder();
        StringBuilder stbR = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            if (!(input[i].equals(" "))) {
                stb.append(input[i]);
            }
        }
        System.out.println(stb);
        double length = Math.sqrt(stb.length());
        int col = (int) Math.ceil(length);
        int row = (int) Math.floor(length);

        char[][] result = new char[row][col];

        int k = 0;
        boolean isBreak = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (k < stb.length()) {
                    System.out.print(stb.charAt(k));
                    result[i][j] = stb.charAt(k);
                    k++;
                } else {
                    isBreak = true;
                    break;
                }
            }
            if (isBreak) {
                break;
            }
            System.out.println();
        }
        for (int j = 0; j < col; j++) {               // <- Обхожда масива колона по колона, а не ред по ред.
            if (j != 0) stbR.append(" ");             // Т.е: За всеки ред от дадена колона....
            for (int i = 0; i < row; i++) {           // <-
                stbR.append(result[i][j]);
            }
        }
        System.out.println(stbR);
    }
}
