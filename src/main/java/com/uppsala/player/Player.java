package com.uppsala.player;

public abstract class Player {
    protected String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract int takeSticks(int sticksRemaining);

    public String getName() {
        return name;
    }
}
