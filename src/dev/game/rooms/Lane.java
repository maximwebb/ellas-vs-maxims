package dev.game.rooms;

import dev.game.objects.Zombie;
import dev.game.plants.Plant;

import java.util.ArrayList;

public class Lane {

	private ArrayList<Zombie> zombiesList;
	private ArrayList<Plant> plantsList;
	private int laneNumber;

	public Lane(int num) {
		zombiesList = new ArrayList<>();
		plantsList = new ArrayList<>();
		laneNumber = num;
	}

	public void addZombie(Zombie zombie) {
		zombiesList.add(zombie);
	}

	public void addPlant(Plant plant) {
		plantsList.add(plant);
	}

	public ArrayList<Zombie> getZombiesList() {
		return zombiesList;
	}

	public ArrayList<Plant> getPlantsList() {
		return plantsList;
	}
}
