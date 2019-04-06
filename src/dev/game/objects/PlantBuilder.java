package dev.game.objects;

import dev.game.maths.Vector2D;
import dev.game.plants.EggFlower;
import dev.game.plants.EggShooter;
import dev.game.plants.Plant;
import dev.game.plants.Walbert;
import dev.game.rooms.GameRoom;
import dev.game.rooms.Room;

public class PlantBuilder {
	public enum PlantType {
		EGGSHOOTER,
		EGGFLOWER,
		WALBERT,
		NONE
	}

	public PlantType currentPlant;

	public PlantBuilder() {
		currentPlant = PlantType.EGGSHOOTER;
	}

	public PlantType getCurrentPlantType() {
		return currentPlant;
	}

	public void setCurrentPlantType(PlantType type) {
		currentPlant = type;
	}

	public Plant buildPlant(Vector2D pos) {
		Plant plant = null;
		switch(currentPlant) {
			case EGGSHOOTER:
				plant = new EggShooter(pos, Vector2D.zero);
				break;
			case EGGFLOWER:
				plant = new EggFlower(pos, Vector2D.zero);
				break;
			case WALBERT:
				plant = new Walbert(pos, Vector2D.zero);
				break;
		}
		if (plant != null) {
			((GameRoom) Room.getRoom()).addGameObject(plant);
		}
		return plant;
	}
}
