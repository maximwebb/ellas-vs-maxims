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

public class LevelsRoom extends Room {

	private int gameWidth = RenderSpace.getStandard().getWidth();
	private int gameHeight = RenderSpace.getStandard().getHeight();
	private int levelButtonHeight = 32;
	public UIManager uiManager;

	public LevelsRoom() {
		super(Assets.levels);

		uiManager = new UIManager();
		uiManager.addButton(new Vector2D(80, 5), 155, levelButtonHeight, () -> {Room.setRoom(Game.getInstance().gameRoom);}, Assets.levelsButton[0], Assets.levelsButton[1]);
		uiManager.addButton(new Vector2D( 80, 10 + levelButtonHeight), 155, levelButtonHeight, () -> {Room.setRoom(Game.getInstance().mainMenuRoom);}, Assets.levelsButton[1], Assets.levelsButton[1]);
		uiManager.addButton(new Vector2D(80, 5 + 2 * (levelButtonHeight + 5)), 155, levelButtonHeight, () -> {Room.setRoom(Game.getInstance().gameRoom);}, Assets.levelsButton[2], Assets.levelsButton[1]);
		uiManager.addButton(new Vector2D(80, 5 + 3 * (levelButtonHeight + 5)), 155, levelButtonHeight, () -> {Room.setRoom(Game.getInstance().gameRoom);}, Assets.levelsButton[3], Assets.levelsButton[1]);
	}

	@Override
	public void init() {

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
