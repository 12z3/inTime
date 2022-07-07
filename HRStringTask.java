package hackerRank;

import training.Methods;

import java.util.Scanner;

public class HRStringTask extends Methods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        timeAndData();

        /*
       https://www.hackerrank.com/challenges/funny-string/
       problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
        */

        int count = 0;
        String input = scanner.nextLine();
        String[] inputArray = input.split("");                   // Връща масив с елементи буквите на input.
        String[] resultArray = new String[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            resultArray[i] = inputArray[inputArray.length - 1 - i];    // Запълва resultArray
        }

        int differenceA = 0, differenceB = 0;
        int[] differenceAA = new int[inputArray.length - 1];
        int[] differenceBB = new int[inputArray.length - 1];

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (j == i + 2) break;// Сравнява само 2 с 1, 3 с 2...break -> Отива на следващата итерация на 1-я фор.
                differenceA = Math.abs((int) inputArray[j].charAt(0) - (int) inputArray[i].charAt(0));
                differenceAA[i] = differenceA;
            }
        }
        for (int i = 0; i < inputArray.length; i++) {                  // "Правилно" написан код
            for (int j = i + 1; j < inputArray.length; j++) {
                if (j == i + 2) {
                    break;
                } else {
                    differenceB = Math.abs((int) resultArray[j].charAt(0) - (int) resultArray[i].charAt(0));
                    differenceBB[i] = differenceB;
                }
            }
        }

        for (int i = 0; i < differenceAA.length; i++) {
            if (differenceAA[i] == differenceBB[i]) count++;
        }
        if (count == differenceAA.length) {
            System.out.println("Funny");
        } else System.out.println("Not Funny");

        printIntArray(differenceAA);
        printIntArray(differenceBB);

    }
}
