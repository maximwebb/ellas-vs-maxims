package dev.game.objects;

import dev.game.maths.Vector2D;
import dev.game.plants.EggFlower;
import dev.game.plants.EggShooter;
import dev.game.plants.Plant;
import dev.game.plants.Walbert;

public class PlantBuilder {
	enum PlantType {
		EGGSHOOTER,
		EGGFLOWER,
		WALBERT,
		NONE
	}

	public  PlantType currentPlant;

	public PlantBuilder() {
		currentPlant = PlantType.NONE;
	}

	public PlantType getCurrentPlantType() {
		return currentPlant;
	}

	public void setCurrentPlantType(PlantType type) {
		currentPlant = type;
	}

	public Plant buildPlant(Vector2D pos) {
		switch(currentPlant) {
			case EGGSHOOTER:
				return new EggShooter(pos, Vector2D.zero);
			case EGGFLOWER:
				return new EggFlower(pos, Vector2D.zero);
			case WALBERT:
				return new Walbert(pos, Vector2D.zero);
			default:
				return null;
		}
	}
}
