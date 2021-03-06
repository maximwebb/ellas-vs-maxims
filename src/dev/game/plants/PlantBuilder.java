package dev.game.plants;

import dev.game.maths.Vector2D;
import dev.game.objects.Tile;
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
		YOUMU,
		WALBERT,
		NONE
	}

	public PlantType currentPlant;

	public PlantBuilder() {
		currentPlant = PlantType.YOUMU;
	}

	public PlantType getCurrentPlantType() {
		return currentPlant;
	}

	public void setCurrentPlantType(PlantType type) {
		currentPlant = type;
	}

	public Plant buildPlant(Vector2D pos, Tile tile) {
		Plant plant = null;
		switch (currentPlant) {
			case EGGSHOOTER:
				plant = new EggShooter(pos, Vector2D.zero, tile);
				break;
			case EGGFLOWER:
				plant = new EggFlower(pos, Vector2D.zero, tile);
				break;
			case WALBERT:
				plant = new Walbert(pos, Vector2D.zero, tile);
				break;
			case YOUMU:
				plant = new Youmu(pos, Vector2D.zero, tile);
				break;
		}
		return plant;
	}
}
