package com.uppsala.player;

import java.util.Random;

public class NPC extends Player {
    private final Random random;

    public NPC(String name) {
        super(name);
        this.random = new Random();
    }

    @Override
    public int takeSticks(int sticksRemaining) {
        int max = sticksRemaining / 2;
        if (max < 1) {
            max = 1;
        }
        // NPC tar ett slumpmässigt antal stickor mellan 1 och max
        int taken = random.nextInt(max) + 1;
        System.out.println("\n" + name + " tar " + taken + (taken == 1 ? " sticka." : " stickor."));

        return taken;
    }
}
