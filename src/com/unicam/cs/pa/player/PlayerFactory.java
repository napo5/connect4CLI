package com.unicam.cs.pa.player;

import com.unicam.cs.pa.core.Disc;

public interface PlayerFactory {

    public Player createPlayer(Disc color);

    public Player getPlayer();
}
