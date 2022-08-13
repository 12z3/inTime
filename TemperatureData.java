package hackerRank;

import training.Methods;

import java.util.*;

public class TemperatureData extends Methods {

    /*
        1. Намира мин, макс и средна стойност.
        2. Сортира паралелно двата масива (температура и имена на месеци) във възходящ ред.
        3. Принтира.

        -> Оправи масива за Февруари месец. Дните трябва да са 28. - It's DONE.
    */

    private static int getNumberOfDaysInMonth(int month) {
        int numberOfDays = 0;
        switch (month){
            case 1, 3, 5, 7, 8, 10, 12 -> {numberOfDays = 32;}
            case 4, 6, 9, 11 -> {numberOfDays = 31;}
            case 2 -> {numberOfDays = 29;}
        }
        return numberOfDays;
    }

    private static void generateTemperatureArray
            (int[][] temperatureArray, int maxA, int minA, int maxB, int minB) {
        Random random = new Random();
        int numberOfMonths = 13;

        for (int month = 1; month < numberOfMonths; month++) {
            int dayBorder = getNumberOfDaysInMonth(month);
            for (int day = 1; day < dayBorder; day++) {
                if (month == 1 || month == 2 || month == 3 || month == 4) {
                    temperatureArray[month - 1][day - 1] = random.nextInt((maxA - minA) + 1) + minA;
                } else if (month == 5 || month == 6 || month == 7 || month == 8 || month == 9) {
                    temperatureArray[month - 1][day - 1] = random.nextInt((40 - 10) + 1) + 10;
                } else if (month == 10 || month == 11 || month == 12) {
                    temperatureArray[month - 1][day - 1] = random.nextInt((maxA - (minA)) + 1) + (minA);
                } else {
                    temperatureArray[month - 1][day - 1] = random.nextInt((maxA - minA) + 1) + minA;
                }
            }
        }
        System.out.println();
        printTemperatureArray(temperatureArray);
    }

    private static void printTemperatureArray(int[][] temperatureArray) {
        for (int month = 1; month < 13; month++) {
            String monthName = getMonthName(month);
            System.out.printf("%d. %s:  ", month, monthName);

            int numberOfDays = getNumberOfDaysInMonth(month);
            for (int day = 1; day < numberOfDays; day++) {
               int tempValue =  temperatureArray[month - 1][day - 1];
                if (tempValue != 0){
                    System.out.print(tempValue + " ");
                }
            }
            System.out.println();
        }
    }

    private static void printMinTemperature(int[][] temperatureArray) {
        int minDay = 0;
        int minMonth = 0;
        int minT = Integer.MAX_VALUE;
        Map<Integer, Integer> minMap = new HashMap<>();        // Ненужно. HashMap - Експеримента не мина.

        for (int month = 1; month < 13; month++) {
            int numberOfDays = getNumberOfDaysInMonth(month);
            for (int day = 1; day < numberOfDays; day++) {
                int tempValue =  temperatureArray[month - 1][day - 1];
                if (tempValue < minT) {
                    minT = tempValue;
                    minDay = day;
                    minMonth = month;
                }
            }
        }
        System.out.printf("Min temp is %d.0C on Data %d.%d.22 \n", minT, minDay, minMonth);
    }

    private static void printMaxTemperature(int[][] temperatureArray) {
        int maxDay = 0;
        int maxMonth = 0;
        int maxT = Integer.MIN_VALUE;
        Map<Integer, Integer> maxMap = new HashMap<>();        // Ненужно. HashMap - Експеримента не мина.

        for (int month = 1; month < 13; month++) {
            int numberOfDays = getNumberOfDaysInMonth(month);
            for (int day = 1; day < numberOfDays; day++) {
                int tempValue =  temperatureArray[month - 1][day - 1];
                if (tempValue > maxT) {
                    maxT = tempValue;
                    maxDay = day;
                    maxMonth = month;
                }
            }
        }
        System.out.printf("Max temp is %d.0C on Data %d.%d.22 \n", maxT, maxDay, maxMonth);
    }

    private static String averageTempInDate(int[][] temperatureArray, int thisDay) {
        int[] monthTempInThisDay = new int[13];                // Не използван масив. Да го има...
        double sum = 0, count = 0, avrT = 0.00;

        for (int month = 1; month < 13; month++) {
            int numberOfDays = getNumberOfDaysInMonth(month);
            for (int day = 1; day < numberOfDays; day++) {
                int tempValue =  temperatureArray[month - 1][day - 1];
                if (day == thisDay) {
                    monthTempInThisDay[month - 1] = tempValue;
                    sum += tempValue;
                    count++;
                    //avrT = sum / count;                       // Няма значение къде се намира. <-
                }
            }
        }
        avrT = sum / count;
        System.out.print("Temp by months on day 26th: \n");     // Тестов код.
        printIntArray(monthTempInThisDay);                      // Тестов код.
        return "Average Temperature in day " + thisDay + " is: " + Math.floor(avrT) + "C" + "\n";
    }

    private static void printMaxTempByMonths(int[][] temperatureArray) {
        String monthName = "";
        String[] montHName = new String[12];
        int[] temperature = new int[12];
        int numberOfDays = 0;
        //int maxT = Integer.MIN_VALUE;

        for (int month = 1; month < 13; month++) {
            int maxT = Integer.MIN_VALUE;        // или = maxT = 0;    // <- ! Яде главата. Ako e "O" ред 144 = false -
            numberOfDays = getNumberOfDaysInMonth(month);
            monthName = getMonthName(month);                    // Бърка логиката. Но Инициализацията трябва да е Там.


            for (int day = 1; day < numberOfDays; day++) {                // Аз съм го приел да започва от еденица.
                int tempValue =  temperatureArray[month - 1][day - 1];               // Обхожда масива от 1-я елемент.
                if (tempValue > maxT) {
                    maxT = tempValue;
                    montHName[month - 1] = monthName;                 // Запълва двата масива: montHName[]  и temp[].
                    temperature[month - 1] = maxT;
                }
            }
        }

        printMonthByTemp(montHName, temperature, 12);
        printAllInfo("Max Temp: ", montHName, temperature);
    }

    private static void printMinTempByMonths(int[][] temperatureArray) {
        String monthName = "";
        String[] montHName = new String[12];
        int[] temperature = new int[12];
        int numberOfDays = 0;

        for (int month = 1; month < 13; month++) {
            int minT = Integer.MAX_VALUE;
            numberOfDays = getNumberOfDaysInMonth(month);
            monthName = getMonthName(month);

            for (int day = 1; day < numberOfDays; day++) {                // Аз съм го приел да започва от еденица.
                int tempValue =  temperatureArray[month - 1][day - 1];
                if (tempValue < minT) {                                  // Обхожда масива от 1-я елемент.
                    minT = tempValue;
                    montHName[month - 1] = monthName;           // Запълва двата масива: montHName[]  и temp[].
                    temperature[month - 1] = minT; // За всеки месец намира min T и запълва двата масива [месеца] и [Т]
                }                                  // ... На края разполагам с два масива: [minT] и [monthName]
            }
        }

        printMonthByTemp(montHName, temperature, 12);
        printAllInfo("Min Temp: ", montHName, temperature);
    }

    private static void printMonthByTemp(String[] montHName, int[] temperature, int monthCount) {
        sortTemperatureArrayParallelWithMonthArray(montHName, temperature); // сортира [Т] успоредно с [monthName]
        if (monthCount > temperature.length) {                         // ... за да запази корелацията межди Т и месец.
            System.out.print("ERROR: Month count is greater than 12");
            return;
        }
        for (int month = 0; month < monthCount; month++) {
            System.out.println();
            System.out.printf("%s", montHName[month]);
            System.out.printf(" = %d.0C", temperature[month]);
        }
    }

    private static void printAllInfo(String x, String[] montHName, int[] temperature) {
        System.out.println();
        System.out.println();                                                    // Редовете от 196 до 205 са Тестови.
        System.out.println(x);
        System.out.print("Order sorted: ");
        printStringArray(montHName);
        printIntArray(temperature);
        sortMonthArrayByLexicographically(montHName, temperature);
        System.out.print("Sorted by Lexicographically: ");
        System.out.println(Arrays.toString(montHName));
        printIntArray(temperature);
    }

    private static void sortTemperatureArrayParallelWithMonthArray(String[] montHName, int[] temperature) {
        for (int i = 0; i < temperature.length; i++) {
            for (int j = i + 1; j < temperature.length; j++) {
                if (temperature[i] < temperature[j]) {
                    int tmpA = temperature[i];               // Паралелно сортира двата масива във възходящ ред.
                    String tmpB = montHName[i];         // Идеята е да не се загуби корелацията "Темп. -> Месец"
                    temperature[i] = temperature[j];
                    montHName[i] = montHName[j];
                    temperature[j] = tmpA;
                    montHName[j] = tmpB;
                }
            }
        }
    }

    //   [August, April, December, February, June, July, January, May, March, November, October, September]

    private static String[] sortMonthArrayByLexicographically(String[] montHName, int[] temperature) {
        for (int i = 0; i < montHName.length; i++) {
            for (int j = i + 1; j < montHName.length; j++) {
                if (montHName[i].charAt(0) > montHName[j].charAt(0)) {
                    String tempA = montHName[i];
                    int temB = temperature[i];
                    montHName[i] = montHName[j];
                    temperature[i] = temperature[j];
                    montHName[j] = tempA;
                    temperature[j] = temB;
                }
            }
        }
        return montHName;
    }

    private static String findMinTempInMonth(int[][] temperatureArray) {
        int minT = Integer.MAX_VALUE;
        int[] minTemperatureArray = new int[32];
        String[] minTempMonthNameArray = new String[13];
        String minMonthName = "", minDayNumber = "";

        for (int month = 1; month < 13; month++) {
            String montHName = getMonthName(month);
            int numberOfDays = getNumberOfDaysInMonth(month);

            for (int day = 1; day < numberOfDays; day++) {
                int tempValue = temperatureArray[month - 1][day - 1];
                if (tempValue < minT) {
                    minT = tempValue;
                    minMonthName = montHName;
                    minDayNumber = "" + day;
                }
            }
        }
        return "Min temperature is "
                + Math.ceil(minT) + "C" + " on day " + minDayNumber + " in month " + minMonthName;
    }

    private static String findMaxTempInMonth(int[][] temperatureArray) {
        int maxT = Integer.MIN_VALUE;
        int[] maxTemperatureArray = new int[32];
        String[] maxTempMonthNameArray = new String[13];
        String maxMonthName = "", maxDayNumber = "";

        for (int month = 1; month < 13; month++) {
            String montHName = getMonthName(month);
            int numberOfDays = getNumberOfDaysInMonth(month);

            for (int day = 1; day < numberOfDays; day++) {
                int tempValue = temperatureArray[month - 1][day - 1];
                if (tempValue > maxT) {
                    maxT = tempValue;
                    maxMonthName = montHName;
                    maxDayNumber = "" + day;
                }
            }
        }
        return "Max temperature is "
                + Math.ceil(maxT) + "C" + " on day " + maxDayNumber + " in month " + maxMonthName;
    }

    private static String getMonthName(int month) {
        String monthName = "";
        switch (month) {
            case 1 -> {monthName = "January";}
            case 2 -> {monthName = "February";}
            case 3 -> {monthName = "March";}
            case 4 -> {monthName = "April";}
            case 5 -> {monthName = "May";}
            case 6 -> {monthName = "June";}
            case 7 -> {monthName = "July";}
            case 8 -> {monthName = "August";}
            case 9 -> {monthName = "September";}
            case 10 -> {monthName = "October";}
            case 11 -> {monthName = "November";}
            case 12 -> {monthName = "December";}
        }
        return monthName;
    }

    private static int setMonthNumberFromMonthName(String month) {
        int monthName = 0 ;
        switch (month) {
            case "January" -> {monthName = 1;}
            case "February" -> {monthName = 2;}
            case "March" -> {monthName = 3;}
            case "April" -> {monthName = 4;}
            case "May" -> {monthName = 5;}
            case "June" -> {monthName = 6;}
            case "July" -> {monthName = 7;}
            case "August" -> {monthName = 8;}
            case "September" -> {monthName = 9;}
            case "October" -> {monthName = 10;}
            case "November" -> {monthName = 11;}
            case "December" -> {monthName = 12;}
        }
        return monthName;
    }

    public static String findMinMaxAvrTempByMoth(int[][] temperatureArray, String monthName) {
        double maxT = Double.MIN_VALUE;
        double minT = Double.MAX_VALUE;
        int minDayTemp = 0, maxDayTemp = 0;
        int sum = 0, avrT = 0, count = 0;

        int setMonthNumber = setMonthNumberFromMonthName(monthName);
        int numberOfDays = getNumberOfDaysInMonth(setMonthNumber);

        for (int day = 1; day < numberOfDays; day++) {
            int tempValue = temperatureArray[setMonthNumber - 1][day - 1];
            if (tempValue > maxT) {
                maxT = tempValue;
                maxDayTemp = day;
            } else if (tempValue < minT) {
                minT = tempValue;
                minDayTemp = day;
            }
            count++;
            sum += tempValue;
            avrT = sum / count;
        }
        return monthName + ":    " + " Min Temperature is: " + minT + "C" + " on day: " + minDayTemp + "." +
                " Max Temperature is: " + maxT + "C" + " on day: " + maxDayTemp + "."
                + " Average Temperature is: " + avrT + "C";
    }

    private static void printMinMaxAvrTempByMonth(int[][] temperatureArray) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};

        for (int month = 0; month < 12; month++) {
            String info = findMinMaxAvrTempByMoth(temperatureArray, months[month]);
            System.out.printf("%s \n", info);
        }
    }

    private static int findMaXTemp(int[][] temperatureArray) {
        int maxT = Integer.MIN_VALUE;
        int[] maxTemperatureArray = new int[32];
        String[] maxTempMonthNameArray = new String[13];

        for (int month = 1; month < 13; month++) {
            int numberOfDays = getNumberOfDaysInMonth(month);
            for (int day = 1; day < numberOfDays; day++) {
                int tempValue = temperatureArray[month - 1][day - 1];
                if (tempValue > maxT) {
                    maxT = tempValue;
                }
            }
        }
        return maxT;
    }

    private static int findMiNTemp(int[][] temperatureArray) {
        int minT = Integer.MAX_VALUE;
        int[] minTemperatureArray = new int[32];
        String[] minTempMonthNameArray = new String[13];

        for (int month = 1; month < 13; month++) {
            int numberOfDays = getNumberOfDaysInMonth(month);
            for (int day = 1; day < numberOfDays; day++) {
                int tempValue = temperatureArray[month - 1][day - 1];
                if (tempValue < minT) {
                    minT = tempValue;
                }
            }
        }
        return minT;
    }


    private static void printMap(Map<String, Integer> tempMap) {
        System.out.println();
        for (String Key : tempMap.keySet()) {
            System.out.printf("%s = %d.0C \n", Key, tempMap.get(Key));
        }
    }

    public static void main(String[] args) {
        timeAndData();

        /*
         В таблица 12х31 са записани средните дневни температури за една година.
        Генерирайте случайни данни, като знаете,
        че за месеци ноември – март средните стойности са в интервал [-20; 10],
        а за останалите месеци [5; 35].
        Месеци, в които няма всички дати от календара се записват с температури -200.

        Използвайте данните и изведете следните справки:
            3.1. Изведете дата / месец на най-ниските температури
            3.2. Изведете средната температура за дата 26, независимо от месеца
            3.3. Изведете имената на трите месеца с най-високи температури,
            като ги подредите в намаляващ ред по температурите
         */

        int[][] temperature = new int[13][32];
        int maxA = 10;
        int minA = -20;
        int maxB = 35;
        int minB = 5;

        System.out.println();
        System.out.print("Generate Temperature Array Data: ");
        generateTemperatureArray(temperature, maxA, minA, maxB, minB);
        System.out.println();

        System.out.print("Print Min, Max and Average temp by Moths: \n");
        printMinMaxAvrTempByMonth(temperature);
        System.out.print("\n\n");

        System.out.print("Statistic is: \n");
        System.out.print("------------------ \n");

        printMinTemperature(temperature);
        System.out.println(findMinTempInMonth(temperature));
        System.out.println();

        printMaxTemperature(temperature);
        System.out.println(findMaxTempInMonth(temperature));

        System.out.println();
        System.out.println(averageTempInDate(temperature, 26));

        System.out.print("Max temperature by month: ");
        printMaxTempByMonths(temperature);
        System.out.println();

        System.out.print("Min temperature by month: ");
        printMinTempByMonths(temperature);
        System.out.println();

    }

}
