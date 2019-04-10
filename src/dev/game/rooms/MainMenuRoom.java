package dev.game.rooms;

import dev.game.Game;
import dev.game.gfx.Assets;
import dev.game.gfx.ImageLoader;
import dev.game.maths.Vector2D;
import dev.game.rendering.RenderSpace;
import dev.game.ui.UIButton;
import dev.game.rendering.RenderCall;
import dev.game.ui.UIObject;
import dev.game.ui.UIManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class MainMenuRoom extends Room {
	private int levelSelected;
	private int gameWidth = RenderSpace.getStandard().getWidth();
	private int gameHeight = RenderSpace.getStandard().getHeight();
	public UIManager uiManager;

	public MainMenuRoom() {
		super(Assets.title);
		/* Keep the constructor in comments until we've created the objects we need. All objects are in src/game/navigation. */
		//this.PlayButton = new PlayButton();
		//this.SettingsButton = new SettingsButton();
		//this.ExitButton = new ExitButton();

		//objectsList.add(this.PlayButton);
		//objectsList.add(this.SettingsButton);
		//objectsList.add(this.ExitButton);
		uiManager = new UIManager();
		uiManager.addButton(new Vector2D(0.75f * gameWidth, 0.75f * gameHeight), 30, 15, () -> {Room.setRoom(Game.getInstance().gameRoom);}, Assets.startButton[0], Assets.startButton[1]);
		uiManager.addButton(new Vector2D(0.75f * gameWidth, 0.75f * gameHeight + 20), 30, 15, () -> {Room.setRoom(Game.getInstance().levelsRoom);}, Assets.levelsButton[0], Assets.levelsButton[1]);
	}

	public void init() {

	}

	public void startGame() {
		Room.setRoom(Game.getInstance().gameRoom);
	}

	public void Exit() {
		System.exit(0);
	}

	@Override
	public Iterable<RenderCall> render() {
		List<RenderCall> renderCalls = new ArrayList<>();
		for (UIObject uiObject : uiManager.uiObjectsList) {
			renderCalls.add(Game.getInstance().getCamera().translate(uiObject));
		}
		return renderCalls;
	}
}