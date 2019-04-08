package dev.game.rooms;

import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.ui.UIButton;
import dev.game.rendering.RenderCall;

import javax.swing.*;
import java.util.ArrayList;


public class MainMenuRoom extends Room {
	private int levelSelected;
	public UIManager uiManager;

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
		uiManager = new UIManager();
		//uiManager.addButton(new Vector2D(40, 40), 30, 15, () -> (goLevelSelect()), Assets.startButton[0]); //TODO: Figure out how to pass a lambda method to the button class
	}

	public void init() {

	}

	public void goLevelSelect() {
		System.out.println("hello world!");
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