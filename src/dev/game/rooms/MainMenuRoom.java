package dev.game.rooms;

import dev.game.navigation.Button;
import dev.game.rendering.RenderCall;

import java.util.ArrayList;


public class MainMenuRoom extends Room {
	public ArrayList<Button> objectsList;
	private int levelSelected;

	public MainMenuRoom() {
		/* Keep the constructor in comments until we've created the objects we need. All objects are in src/game/navigation. */
		//this.PlayButton = new PlayButton();
		//this.SettingsButton = new SettingsButton();
		//this.ExitButton = new ExitButton();
		//this.Background = new Background("title.png");

		//objectsList.add(this.PlayButton);
		//objectsList.add(this.SettingsButton);
		//objectsList.add(this.ExitButton);
		//this.Background = new Background();
	}

	public void init() {

	}

	public void goLevelSelect() {
		//Remove all objects from the screen and load LevelSelectRoom
		for (int i=0;i<objectsList.size();i++){

		}

		//new LevelSelectRoom();
	}

	public void Exit() {
		System.exit(0);
	}

	@Override
	public Iterable<RenderCall> render() {
		return null;
	}
}