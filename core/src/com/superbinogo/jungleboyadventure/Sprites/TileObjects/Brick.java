package com.superbinogo.jungleboyadventure.Sprites.TileObjects;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.utils.Array;
import com.superbinogo.jungleboyadventure.MarioBros;
import com.superbinogo.jungleboyadventure.Scenes.Hud;
import com.superbinogo.jungleboyadventure.Screens.PlayScreen;
import com.superbinogo.jungleboyadventure.Sprites.Mario;

public class Brick extends InteractiveTileObject {
    private float stateTime;
    private Animation<TextureRegion> walkAnimation;
    private Array<TextureRegion> frames;
    private boolean setToDestroy;
    private boolean destroyed;
    float angle;

    public Brick(PlayScreen screen, MapObject object) {
        super(screen, object);
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.BRICK_BIT);
        frames = new Array<TextureRegion>();
        for (int i = 0; i < 8; i++)
            frames.add(new TextureRegion(screen.getEnemiesAtlas().findRegion("beetle"), i * 89, 0, 89, 64));
        walkAnimation = new Animation(0.1f, frames);
        stateTime = 0;
        setBounds(getX(), getY(), 89 / MarioBros.PPM, 64 / MarioBros.PPM);
        setToDestroy = false;
        destroyed = false;
        angle = 0;
        setRegion(walkAnimation.getKeyFrame(stateTime, true));
    }

    public void update(float dt) {
        stateTime += dt;
        if (setToDestroy && !destroyed) {
            setRegion(new TextureRegion(screen.getEnemiesAtlas().findRegion("beetle"), 898, 0, 89, 64));
            stateTime = 0;
        } else if (!destroyed) {
            setRegion(walkAnimation.getKeyFrame(stateTime, true));
        }
    }

    @Override
    public void onHeadHit(Mario mario) {
        if (mario.isBig()) {
            setCategoryFilter(MarioBros.DESTROYED_BIT);
            getCell().setTile(null);
            Hud.addScore(200);
            MarioBros.manager.get("audio/sounds/breakblock.wav", Sound.class).play();
        }
        MarioBros.manager.get("audio/sounds/bump.wav", Sound.class).play();
    }

}
