package com.uppsala;
import com.uppsala.player.Player;

public class NmGame {
    private final Player player1;
    private final Player player2;
    private int sticks;

    public NmGame(Player player1, Player player2, int sticks) {
        this.player1 = player1;
        this.player2 = player2;
        this.sticks = sticks;
    }

    public void play() {
        Player current = player1;
        Player other = player2;

        // Show initial state
        System.out.println("Spelet börjar med " + sticks + " stickor på bordet.\n");

        while (sticks > 1) {
            int max = sticks / 2;
            int taken = current.takeSticks(sticks);
            if (taken < 1 || taken > max) {
                System.out.println("Ogiltigt drag av " + current.getName() + ". " + other.getName() + " vinner spelet!");
                return;
            }
            sticks -= taken;

            // Plural / singular handling
            String stickWord = (taken == 1) ? " sticka" : " stickor";
            String remainWord = (sticks == 1) ? " sticka" : " stickor";
            System.out.println(current.getName() + " tar " + taken + stickWord + ". "
                    + "Det finns nu " + sticks + remainWord + " kvar.");

            // Byt spelare
            Player temp = current;
            current = other;
            other = temp;
        }

        // If there's only 1 stick left, current can't make a valid move
        System.out.println("\nDet ligger bara 1 sticka kvar på bordet. "
                + current.getName() + " kan inte göra ett giltigt drag.");
        System.out.println(other.getName() + " vinner spelet!");
    }
}
