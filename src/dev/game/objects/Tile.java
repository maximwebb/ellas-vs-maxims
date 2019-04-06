package dev.game.objects;

import dev.game.maths.Vector2D;
import dev.game.plants.Plant;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class Tile extends RenderedGameObject {

	private boolean empty;
	private Plant plant;

	public Tile(Vector2D pos, int width, int height) {
		super(pos, new Vector2D(0f, 0f), width, height, null);
		empty = true;

		setClickAction(() -> {
			setPlant(((GameRoom)Room.getRoom()).getPlantBuilder().buildPlant(pos));
			setEmpty(false);
		});
	}

	public void setPlant(Plant p) {
		plant = p;
	}
	public Plant getPlant() {
		return plant;
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

}
