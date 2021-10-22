package com.superbinogo.jungleboyadventure;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.superbinogo.jungleboyadventure.actors.enemies.Enemy;
import com.superbinogo.jungleboyadventure.actors.enemies.Goomba;
import com.superbinogo.jungleboyadventure.actors.enemies.Koopa;
import com.superbinogo.jungleboyadventure.actors.maptiles.Brick;
import com.superbinogo.jungleboyadventure.actors.maptiles.CoinBlock;
import com.superbinogo.jungleboyadventure.actors.maptiles.Flagpole;
import com.superbinogo.jungleboyadventure.actors.maptiles.MapTileObject;
import com.superbinogo.jungleboyadventure.actors.maptiles.Pipe;
import com.superbinogo.jungleboyadventure.actors.maptiles.Rock;
import com.superbinogo.jungleboyadventure.gamesys.GameManager;
import com.superbinogo.jungleboyadventure.screens.PlayScreen;

/**
 *
 *
 * WorldCreator
 */
public class WorldCreator {

    private Array<MapTileObject> mapTileObjects;
    private Array<Enemy> enemies;

    private Vector2 startPosition;
    private Vector2 flagPosition;

    public WorldCreator(PlayScreen playScreen, TiledMap tiledMap) {

        mapTileObjects = new Array<MapTileObject>();
        enemies = new Array<Enemy>();

        MapLayer mapLayer = tiledMap.getLayers().get("physics");
        if (mapLayer != null) {
            for (MapObject mapObject : mapLayer.getObjects()) {
                float x = ((RectangleMapObject) mapObject).getRectangle().getX();
                float y = ((RectangleMapObject) mapObject).getRectangle().getY();

                mapTileObjects.add(new Rock(playScreen, (x + 8) / GameManager.PPM, (y + 8) / GameManager.PPM, (RectangleMapObject) mapObject));
            }
        }

        mapLayer = tiledMap.getLayers().get("MetalBlocks");
        if (mapLayer != null) {
            for (MapObject mapObject : mapLayer.getObjects()) {
                float x = ((TiledMapTileMapObject) mapObject).getX();
                float y = ((TiledMapTileMapObject) mapObject).getY();

                mapTileObjects.add(new Pipe(playScreen, (x + 8) / GameManager.PPM, (y + 8) / GameManager.PPM, (TiledMapTileMapObject) mapObject));
            }
        }

        mapLayer = tiledMap.getLayers().get("Pipes");
        if (mapLayer != null) {
            for (MapObject mapObject : mapLayer.getObjects()) {
                float x = ((TiledMapTileMapObject) mapObject).getX();
                float y = ((TiledMapTileMapObject) mapObject).getY();

                mapTileObjects.add(new Pipe(playScreen, (x + 8) / GameManager.PPM, (y + 8) / GameManager.PPM, (TiledMapTileMapObject) mapObject));
            }
        }

        mapLayer = tiledMap.getLayers().get("Bricks");
        if (mapLayer != null) {
            for (MapObject mapObject : mapLayer.getObjects()) {
                float x = ((TiledMapTileMapObject) mapObject).getX();
                float y = ((TiledMapTileMapObject) mapObject).getY();

                mapTileObjects.add(new Brick(playScreen, (x + 8) / GameManager.PPM, (y + 8) / GameManager.PPM, (TiledMapTileMapObject) mapObject));
            }
        }

        mapLayer = tiledMap.getLayers().get("CoinBlocks");
        if (mapLayer != null) {
            for (MapObject mapObject : mapLayer.getObjects()) {
                float x = ((TiledMapTileMapObject) mapObject).getX();
                float y = ((TiledMapTileMapObject) mapObject).getY();

                mapTileObjects.add(new CoinBlock(playScreen, (x + 8) / GameManager.PPM, (y + 8) / GameManager.PPM, (TiledMapTileMapObject) mapObject));
            }
        }

        mapLayer = tiledMap.getLayers().get("Goombas");
        if (mapLayer != null) {
            for (MapObject mapObject : mapLayer.getObjects()) {
                float x = ((TiledMapTileMapObject) mapObject).getX();
                float y = ((TiledMapTileMapObject) mapObject).getY();

                enemies.add(new Goomba(playScreen, (x + 8) / GameManager.PPM, (y + 8) / GameManager.PPM));
            }
        }

        mapLayer = tiledMap.getLayers().get("Koopas");
        if (mapLayer != null) {
            for (MapObject mapObject : mapLayer.getObjects()) {
                float x = ((TiledMapTileMapObject) mapObject).getX();
                float y = ((TiledMapTileMapObject) mapObject).getY();

                enemies.add(new Koopa(playScreen, (x + 8) / GameManager.PPM, (y + 8) / GameManager.PPM));
            }
        }

        mapLayer = tiledMap.getLayers().get("Flagpole");
        if (mapLayer != null) {
            for (MapObject mapObject : mapLayer.getObjects()) {
                float x = ((TiledMapTileMapObject) mapObject).getX();
                float y = ((TiledMapTileMapObject) mapObject).getY();

                mapTileObjects.add(new Flagpole(playScreen, (x + 8) / GameManager.PPM, (y + 8) / GameManager.PPM, (TiledMapTileMapObject) mapObject));
            }
        }

        flagPosition = new Vector2();

        mapLayer = tiledMap.getLayers().get("Flag");
        if (mapLayer != null) {
            if (mapLayer.getObjects().getCount() > 0) {
                float x = ((TiledMapTileMapObject) mapLayer.getObjects().get(0)).getX();
                float y = ((TiledMapTileMapObject) mapLayer.getObjects().get(0)).getY();

                flagPosition = new Vector2(x, y);
            }
        }


        startPosition = new Vector2(64.0f, 64.0f);

        mapLayer = tiledMap.getLayers().get("Start");
        if (mapLayer != null) {
            if (mapLayer.getObjects().getCount() > 0) {
                float x = ((TiledMapTileMapObject) mapLayer.getObjects().get(0)).getX();
                float y = ((TiledMapTileMapObject) mapLayer.getObjects().get(0)).getY();

                startPosition = new Vector2(x, y);
            }
        }

    }

    public Vector2 getStartPosition() {
        return startPosition;
    }

    public Vector2 getFlagPosition() {
        return flagPosition;
    }

    public Array<MapTileObject> getMapTileObject() {
        return mapTileObjects;
    }

    public Array<Enemy> getEnemies() {
        return enemies;
    }
}
