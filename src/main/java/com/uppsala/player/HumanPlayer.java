package com.uppsala.player;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner scanner;

    // Konstanter
    private static final String TURN_HEADER = "\n=== Din tur, ";
    private static final String TURN_FOOTER = "! ===";
    private static final String STICKS_ON_TABLE_PREFIX = "Det ligger ";
    private static final String STICKS_ON_TABLE_SUFFIX = " stickor på bordet.";
    private static final String ASK_STICKS_PREFIX = "Hur många stickor vill du ta (1-";
    private static final String ASK_STICKS_SUFFIX = ")? ";
    private static final String INVALID_INPUT = "Ogiltig inmatning. Ange ett tal mellan 1 och ";
    private static final String COLON = ": ";

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

        System.out.println(TURN_HEADER + name + TURN_FOOTER);
        System.out.println(STICKS_ON_TABLE_PREFIX + sticksRemaining + STICKS_ON_TABLE_SUFFIX);
        System.out.print(ASK_STICKS_PREFIX + max + ASK_STICKS_SUFFIX);

        int taken = scanner.nextInt();
        while (taken < 1 || taken > max) {
            System.out.print(INVALID_INPUT + max + COLON);
            taken = scanner.nextInt();
        }
        return taken;
    }
}
