package hackerRank;

import training.Methods;

import java.util.Scanner;

public class HackerRankTask extends Methods {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        timeAndData();

        /*
        Reduce a string of lowercase characters in range ascii[‘a’..’z’]
        by doing a series of operations.
        In each operation, select a pair of adjacent letters that match, and delete them.

        Delete as many characters as possible using this method and return the resulting string.
        If the final string is empty, return Empty String
         */

        // Търсят се само съседни съвпадения. <-
        // Вероятно ще трябва да се раздели първоначалният масив на два под масива.
        // И да се обхождат по-отделно.
        // В противен случай няма да се хване ПОСЛЕДНИЯТ индекс.

        // a a c d f a
        // a
        // a a c d f a

        // Срвнява "а" със всички останали. Едва след като е направено това
        // трябва да записва "а" в "result[""


        String inputString = scan.nextLine();                                   //  a a c d f a
        int size = inputString.length() + 1;
        char[] result = new char[inputString.length()];
        int count = 1, indexJ = 0;
        boolean isBreak = false;

        for (int i = 0; i < inputString.length(); i++) {
            isBreak = false;
            for (int j = i + 1; j < inputString.length(); j++) {
                if (inputString.charAt(i) == inputString.charAt(j)) {
                    isBreak = true;
                    break;
                }
                result[i] = inputString.charAt(i);
                break;
            }
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                System.out.printf("%s ", result[i]);
            }
        }


    }
}
