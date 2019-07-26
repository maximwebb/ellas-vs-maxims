package dev.game.rooms;

import dev.game.Game;
import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.rendering.RenderCall;
import dev.game.rendering.RenderSpace;
import dev.game.ui.UIManager;
import dev.game.ui.UIObject;

import java.util.ArrayList;
import java.util.List;

import dev.game.Game;
import dev.game.gfx.Assets;
import dev.game.maths.Vector2D;
import dev.game.rendering.RenderCall;
import dev.game.rendering.RenderSpace;
import dev.game.ui.UIManager;
import dev.game.ui.UIObject;

import java.util.ArrayList;
import java.util.List;

public class LevelCompleteRoom extends Room {
	private int levelSelected;
	private int gameWidth = RenderSpace.getStandard().getWidth();
	private int gameHeight = RenderSpace.getStandard().getHeight();
	public UIManager uiManager;

	public LevelCompleteRoom() {
		super(Assets.levelComplete);
		uiManager = new UIManager();
		uiManager.addButton(new Vector2D(0.75f * gameWidth, 0.75f * gameHeight), 30, 15, () -> {Room.setRoom(Game.getInstance().mainMenuRoom);}, Assets.mainMenuButton, Assets.startButton[1]);
		uiManager.addButton(new Vector2D(0.75f * gameWidth, 0.75f * gameHeight + 20), 30, 15, () -> {Room.setRoom(Game.getInstance().gameRoom);}, Assets.startButton[0], Assets.levelSelectButton[1]);
	}

	public void init() {

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