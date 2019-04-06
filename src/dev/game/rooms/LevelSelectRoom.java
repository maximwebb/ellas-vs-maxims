package dev.game.rooms;

import dev.game.navigation.Button;
import dev.game.rendering.RenderCall;

import java.util.ArrayList;

public class LevelSelectRoom extends Room {
	public ArrayList<Button> objectsList;
	private int levelSelected;

	public LevelSelectRoom() {
		/* Keep the constructor in comments until we've created the objects we need. All objects are in src/game/navigation. */
		//this.level1Button = new Button();
		//this.BackButton = new BackButton();
	}

	public void init() {

	}

	@Override
	public Iterable<RenderCall> render() {
		return null;
	}
}