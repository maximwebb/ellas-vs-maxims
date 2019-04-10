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
	public UIManager uiManager;

	public LevelsRoom() {
		super(Assets.levels);

		uiManager = new UIManager();
		//uiManager.addButton(new Vector2D(0.75f * gameWidth, 0.75f * gameHeight), 30, 15, () -> {Room.setRoom(Game.getInstance().gameRoom);}, Assets.levelsButton[0], Assets.levelsButton[1]);
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
