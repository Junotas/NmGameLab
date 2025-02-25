package com.uppsala;
import com.uppsala.player.Player;

public class NmGame {
    private final Player player1;
    private final Player player2;
    private int sticks;

    // Konstanter
    private static final String GAME_START_PREFIX = "Spelet börjar med ";
    private static final String GAME_START_SUFFIX = " stickor på bordet.\n";
    private static final String INVALID_MOVE_PREFIX = "Ogiltigt drag av ";
    private static final String WINNER_SUFFIX = " vinner spelet!";
    private static final String SINGULAR_STICK = " sticka";
    private static final String PLURAL_STICKS = " stickor";
    private static final String TAKES_PREFIX = " tar ";
    private static final String TAKES_SUFFIX = ". ";
    private static final String REMAINING_PREFIX = "Det finns nu ";
    private static final String REMAINING_SUFFIX = " kvar.";
    private static final String LAST_STICK_PREFIX = "\nDet ligger bara 1 sticka kvar på bordet. ";
    private static final String NO_VALID_MOVE_SUFFIX = " kan inte göra ett giltigt drag.";

    public NmGame(Player player1, Player player2, int sticks) {
        this.player1 = player1;
        this.player2 = player2;
        this.sticks = sticks;
    }

    public void play() {
        Player current = player1;
        Player other = player2;

        // Visa startmeddelande
        System.out.println(GAME_START_PREFIX + sticks + GAME_START_SUFFIX);

        while (sticks > 1) {
            int max = sticks / 2;
            int taken = current.takeSticks(sticks);
            if (taken < 1 || taken > max) {
                System.out.println(INVALID_MOVE_PREFIX + current.getName() + ". " + other.getName() + WINNER_SUFFIX);
                return;
            }
            sticks -= taken;

            // Hantera singular och plural
            String stickWord = (taken == 1) ? SINGULAR_STICK : PLURAL_STICKS;
            String remainWord = (sticks == 1) ? SINGULAR_STICK : PLURAL_STICKS;
            System.out.println(current.getName() + TAKES_PREFIX + taken + stickWord + TAKES_SUFFIX
                    + REMAINING_PREFIX + sticks + remainWord + REMAINING_SUFFIX);

            // Byt spelare
            Player temp = current;
            current = other;
            other = temp;
        }

        // Om det bara finns 1 sticka kvar, kan current inte göra ett giltigt drag
        System.out.println(LAST_STICK_PREFIX + current.getName() + NO_VALID_MOVE_SUFFIX);
        System.out.println(other.getName() + WINNER_SUFFIX);
    }
}
