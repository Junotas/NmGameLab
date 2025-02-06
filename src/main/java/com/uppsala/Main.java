package com.uppsala;
import com.uppsala.player.HumanPlayer;
import com.uppsala.player.NPC;
import com.uppsala.player.Player;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Ange antal stickor vid start som ett argument.");
            System.exit(1);
        }
        int sticks = Integer.parseInt(args[0]);
        if (sticks < 1) {
            System.out.println("Antalet stickor måste vara minst 1.");
            System.exit(1);
        }

        // Skapa spelare: en mänsklig spelare och en NPC.
        Player human = new HumanPlayer("Människan");
        Player npc = new NPC("NPC");

        // Skapa och starta spelet.
        NmGame game = new NmGame(human, npc, sticks);
        game.play();
    }
}
