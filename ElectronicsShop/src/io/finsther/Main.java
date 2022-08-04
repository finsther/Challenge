package io.finsther;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Monica wants to buy a keyboard and a USB drive ...");

        int budget = 80;
        int[] keyboards = {40, 50, 60};
        int[] drives = {5, 20, 8};

        /** si option es true utilizara los valores definidos, para hacer la entrada por teclado define false */
        boolean option = false;

        if (!option) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Budget: ");
            budget = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter keyboard cost separated by space: ");
            keyboards = Arrays.stream(scanner.nextLine().trim().split(" ")).filter(x -> !x.equals("")).mapToInt(Integer::parseInt).toArray();

            System.out.print("Enter USB drives cost separated by space: ");
            drives = Arrays.stream(scanner.nextLine().trim().split(" ")).filter(x -> !x.equals("")).mapToInt(Integer::parseInt).toArray();

            scanner.close();
        }

        System.out.println(electronicsShop(budget, keyboards, drives));

    }

    private static String electronicsShop(int budget, int[] keyboards, int[] drives) {
        int amount = 0;
        int amountAux;
        int keyboard = 0;
        int usbDrive = 0;

        System.out.println("Monica Budget: " + budget);
        System.out.println("Keyboards prices: " + Arrays.toString(keyboards));
        System.out.println("USB drives prices: " + Arrays.toString(drives));

        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                amountAux = keyboards[i] + drives[j];

                if(amountAux >= amount && amountAux <= budget) {
                    amount = amountAux;
                    keyboard = keyboards[i];
                    usbDrive = drives[j];
                }
            }
        }

        if(amount > 0) {
            return String.format("result: %s [Monica can purcharse an %d drive + %s keyboard]", amount, usbDrive, keyboard);
        } else {
            return "result: -1 [There is no such way to purchase both keyboard and drive combo]";
        }
    }
}
