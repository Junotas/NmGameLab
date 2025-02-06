package com.uppsala.player;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name) {
        super(name);
        scanner = new Scanner(System.in);
    }

    @Override
    public int takeSticks(int sticksRemaining) {
        int max = sticksRemaining / 2;
        if (max < 1) {
            max = 1;
        }
        System.out.println("\n" + name + ", det är din tur.");
        System.out.println("Stickor kvar: " + sticksRemaining);
        System.out.print("Ange antal stickor att ta (min 1, max " + max + "): ");
        int taken = scanner.nextInt();
        while (taken < 1 || taken > max) {
            System.out.print("Ogiltigt antal. Ange ett tal mellan 1 och " + max + ": ");
            taken = scanner.nextInt();
        }
        return taken;
    }
}
