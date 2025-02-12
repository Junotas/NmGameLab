package com.uppsala.player;

public class NPC extends Player {
    public NPC(String name) {
        super(name);
    }

    @Override
    public int takeSticks(int sticksRemaining) {
        int max = sticksRemaining / 2;
        if (max < 1) {
            max = 1;
        }
        // Enkel strategi: NPC tar alltid 1 sticka.
        int taken = 1;
        System.out.println("\n" + name + " tar " + taken + " sticka.");

        return taken;
    }
}
