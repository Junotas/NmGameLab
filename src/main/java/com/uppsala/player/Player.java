package com.uppsala.player;

public abstract class Player {
    protected String name;

    public Player(String name) {
        this.name = name;
    }

    /**
     * Metod för att ta ett drag.
     * @param sticksRemaining antalet stickor kvar i högen
     * @return antalet stickor att ta (mellan 1 och floor(sticksRemaining/2))
     */
    public abstract int takeSticks(int sticksRemaining);

    public String getName() {
        return name;
    }
}
