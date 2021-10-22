package com.superbinogo.jungleboyadventure.actors.maptiles;

import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.superbinogo.jungleboyadventure.actors.RigidBody;
import com.superbinogo.jungleboyadventure.gamesys.GameManager;
import com.superbinogo.jungleboyadventure.screens.PlayScreen;

/**
 *
 *
 * MapTileObject
 */
public abstract class MapTileObject extends RigidBody {

    protected RectangleMapObject mapObject;

    public MapTileObject(PlayScreen playScreen, float x, float y, RectangleMapObject mapObject) {
        super(playScreen, x, y);

        this.mapObject = mapObject;

        setRegion(mapObject.getTextureRegion());

        float width = 16 / GameManager.PPM;
        float height = 16 / GameManager.PPM;

        setBounds(x - width / 2, y - height / 2, width, height);
    }

    @Override
    public void update(float delta) {

    }
}
