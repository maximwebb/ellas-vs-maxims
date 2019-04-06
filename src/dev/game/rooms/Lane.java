package dev.game.rooms;

import dev.game.objects.Zombie;
import dev.game.plants.Plant;

import java.util.ArrayList;
import java.util.Stack;

public class Lane {

	private ArrayList<Zombie> zombiesList;
	private ArrayList<Plant> plantsList;
	public Stack<Plant> plantsToRemove;
	public Stack<Zombie> zombiesToRemove;
	private int laneNumber;

	public Lane(int num) {
		plantsList = new ArrayList<>();
		plantsToRemove = new Stack<>();
		zombiesList = new ArrayList<>();
		zombiesToRemove = new Stack<>();
		laneNumber = num;
	}

	public void addPlant(Plant plant) {
		plantsList.add(plant);
	}

	public void removePlant(Plant plant) {
		plantsToRemove.add(plant);
	}

	public void addZombie(Zombie zombie) {
		zombiesList.add(zombie);
	}

	public void removeZombie(Zombie zombie) {
		zombiesToRemove.add(zombie);
	}

	public void removeObjects() {
		while (!plantsToRemove.empty()) {
			plantsList.remove(plantsToRemove.pop());
		}

		while (!zombiesToRemove.empty()) {
			zombiesList.remove(zombiesToRemove.pop());
		}
	}

	public ArrayList<Zombie> getZombiesList() {
		return zombiesList;
	}

	public ArrayList<Plant> getPlantsList() {
		return plantsList;
	}
}
