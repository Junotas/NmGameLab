package com.uppsala.player;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner scanner;

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

        System.out.println("\n=== Din tur, " + name + "! ===");
        System.out.println("Det ligger " + sticksRemaining + " stickor på bordet.");
        System.out.print("Hur många stickor vill du ta (1-" + max + ")? ");


        int taken = scanner.nextInt();
        while (taken < 1 || taken > max) {
            System.out.print("Ogiltig inmatning. Ange ett tal mellan 1 och " + max + ": ");
            taken = scanner.nextInt();
        }
        return taken;
    }
}
