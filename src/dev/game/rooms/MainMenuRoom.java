package dev.game.rooms;

import dev.game.gfx.ImageLoader;
import dev.game.rendering.RenderCall;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class MainMenuRoom extends Room {
	public ArrayList<Button> objectsList;
	public BufferedImage background;
	private int levelSelected;
	Button playButton, settingsButton, exitButton;


	public MainMenuRoom() {
		/* Keep the constructor in comments until we've created the objects we need. All objects are in src/game/navigation. */
		background = ImageLoader.loadImage("/backgrounds/title.png");
		//playButton = new Button(pos,sprite,width,height);
		//settingsButton = new Button(pos,sprite,width,height);
		//exitButton = new Button(pos,sprite,width,height);

		//objectsList.add(this.playButton);
		//objectsList.add(this.settingsButton);
		//objectsList.add(this.exitButton);
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