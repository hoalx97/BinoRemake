package com.superbinogo.jungleboyadventure.actors.stageitems;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.superbinogo.jungleboyadventure.gamesys.GameManager;
import com.superbinogo.jungleboyadventure.screens.PlayScreen;

/**
 *
 *
 * Flag
 */
public class Flag extends Actor {

    Sprite flagSprite;

    public Flag(PlayScreen playScreen, float x, float y) {
        flagSprite = new Sprite(new TextureRegion(playScreen.getTextureAtlas().findRegion("Flag"), 0, 0, 16, 16));
        flagSprite.setBounds(x, y, 16 / GameManager.PPM, 16 / GameManager.PPM);
        setBounds(flagSprite.getX(), flagSprite.getY(), flagSprite.getWidth(), flagSprite.getHeight());
    }

    @Override
    protected void positionChanged() {
        flagSprite.setPosition(getX(), getY());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        flagSprite.draw(batch);

    }
}
