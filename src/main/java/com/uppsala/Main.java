package com.uppsala;

import com.uppsala.player.HumanPlayer;
import com.uppsala.player.NPC;
import com.uppsala.player.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Välkommen till Nm-spelet! ===");
        System.out.println("Du och en NPC turas om att ta mellan 1 och hälften av de stickor som finns.\n");

        // Prompt user for name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Vad heter du? ");
        String playerName = scanner.nextLine();

        if (args.length < 1) {
            System.out.println("Ange antal stickor vid start som ett argument.");
            System.exit(1);
        }
        int sticks = Integer.parseInt(args[0]);
        if (sticks < 1) {
            System.out.println("Antalet stickor måste vara minst 1.");
            System.exit(1);
        }

        // Create players: the user with their chosen name, and the NPC
        Player human = new HumanPlayer(playerName);
        Player npc = new NPC("NPC");

        // Create and start the game
        NmGame game = new NmGame(human, npc, sticks);
        game.play();
    }
}
