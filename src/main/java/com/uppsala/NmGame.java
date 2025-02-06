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

        while (sticks > 1) {
            int max = sticks / 2;
            int taken = current.takeSticks(sticks);
            if (taken < 1 || taken > max) {
                System.out.println("Ogiltigt drag av " + current.getName() + ". " + other.getName() + " vinner spelet!");
                return;
            }
            sticks -= taken;
            System.out.println(current.getName() + " tar " + taken + " sticka(n). Stickor kvar: " + sticks);
            // Byt spelare
            Player temp = current;
            current = other;
            other = temp;
        }

        System.out.println("\nEndast 1 stick kvar. " + current.getName() + " kan inte göra ett giltigt drag.");
        System.out.println(other.getName() + " vinner spelet!");
    }
}
