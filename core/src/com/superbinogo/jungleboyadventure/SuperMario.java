package com.superbinogo.jungleboyadventure;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.superbinogo.jungleboyadventure.gamesys.GameManager;
import com.superbinogo.jungleboyadventure.screens.PlayScreen;

public class SuperMario extends Game {
	public SpriteBatch batch;

	private GameManager gameManager;

	@Override
	public void create () {
		batch = new SpriteBatch();

		if (GameManager.instance != null) {
			gameManager = GameManager.instance;
		}
		else {
			gameManager = new GameManager();
		}

		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}


	@Override
	public void dispose() {
		super.dispose();
		gameManager.dispose();
	}

}
