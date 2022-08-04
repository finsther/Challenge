package io.finsther;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int layers = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of layers: ");
        layers = scanner.nextInt();

        if (layers >= 1 && layers <= 100) {
            System.out.print("Output: " + hulk(layers));
        } else {
            System.out.print("Enter valid number of layers (1 ≤ layers ≤ 100)");
        }

        scanner.close();
    }

    private static String hulk(int layers) {
        String hate = "I hate ";
        String love = "I love ";
        String pronoun1 = "that ";
        String pronoun2 = "it ";
        String result = "";

        for (int i = 1; i <= layers; i++) {
            // feelings
            if (i % 2 == 0) {
                result += love;
            } else {
                result += hate;
            }
            // pronoun
            if (i == layers) {
                result += pronoun2;
            } else {
                result += pronoun1;
            }
        }

        return result;
    }
}
