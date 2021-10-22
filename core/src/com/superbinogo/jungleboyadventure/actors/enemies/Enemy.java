package com.superbinogo.jungleboyadventure.actors.enemies;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.superbinogo.jungleboyadventure.actors.Mario;
import com.superbinogo.jungleboyadventure.actors.RigidBody;
import com.superbinogo.jungleboyadventure.screens.PlayScreen;

/**
 *
 *
 * Enemy
 */
public abstract class Enemy extends RigidBody {

    protected TextureAtlas textureAtlas;

    protected boolean active = false;

    public Enemy(PlayScreen playScreen, float x, float y) {
        super(playScreen, x, y);
        this.textureAtlas = playScreen.getTextureAtlas();
    }

    public abstract void getDamage(int damage);

    public void interact(Mario mario) {

    }

}
