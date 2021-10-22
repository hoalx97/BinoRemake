package com.superbinogo.jungleboyadventure.actors.effects;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.superbinogo.jungleboyadventure.actors.RigidBody;
import com.superbinogo.jungleboyadventure.screens.PlayScreen;

/**
 *
 *
 * Effect
 */
public abstract class Effect extends RigidBody {

    protected TextureAtlas textureAtlas;

    public Effect(PlayScreen playScreen, float x, float y) {
        super(playScreen, x, y);
        this.textureAtlas = playScreen.getTextureAtlas();

    }

}
