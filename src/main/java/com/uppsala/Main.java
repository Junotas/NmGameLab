package com.uppsala;

import com.uppsala.player.HumanPlayer;
import com.uppsala.player.NPC;
import com.uppsala.player.Player;

import java.util.Scanner;

public class Main {
    // Konstanter
    private static final String WELCOME_MESSAGE = "=== Välkommen till Nm-spelet! ===";
    private static final String GAME_DESCRIPTION = "Du och en NPC turas om att ta mellan 1 och hälften av de stickor som finns.\n";
    private static final String ENTER_NAME_PROMPT = "Vad heter du? ";
    private static final String ARGUMENT_ERROR = "Ange antal stickor vid start som ett argument.";
    private static final String MIN_STICKS_ERROR = "Antalet stickor måste vara minst 1.";

    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(GAME_DESCRIPTION);

        // Fråga användaren efter namn
        Scanner scanner = new Scanner(System.in);
        System.out.print(ENTER_NAME_PROMPT);
        String playerName = scanner.nextLine();

        if (args.length < 1) {
            System.out.println(ARGUMENT_ERROR);
            System.exit(1);
        }
        int sticks = Integer.parseInt(args[0]);
        if (sticks < 1) {
            System.out.println(MIN_STICKS_ERROR);
            System.exit(1);
        }

        // Skapa spelare: användaren med valt namn samt NPC
        Player human = new HumanPlayer(playerName);
        Player npc = new NPC("NPC");

        // Skapa och starta spelet
        NmGame game = new NmGame(human, npc, sticks);
        game.play();
    }
}
