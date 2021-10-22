package com.superbinogo.jungleboyadventure.actors.items;


import com.superbinogo.jungleboyadventure.actors.RigidBody;
import com.superbinogo.jungleboyadventure.screens.PlayScreen;

/**
 *
 *
 * Item
 */
public abstract class Item extends RigidBody {

    protected String name = "item";

    public Item(PlayScreen playScreen, float x, float y) {
        super(playScreen, x, y);
    }

    public String getName() {
        return name;
    }

    public abstract void use();

}
