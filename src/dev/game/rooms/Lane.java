package dev.game.rooms;

import dev.game.projectiles.Lawnmower;
import dev.game.zombies.Zombie;
import dev.game.plants.Plant;

import java.util.ArrayList;
import java.util.Stack;

public class Lane {

	private ArrayList<Zombie> zombiesList;
	private ArrayList<Plant> plantsList;
	private ArrayList<Lawnmower> lawnmowersList;
	public Stack<Plant> plantsToRemove;
	public Stack<Zombie> zombiesToRemove;
	public Stack<Lawnmower> lawnmowersToRemove;
	private int laneNumber;

	public Lane(int num) {
		plantsList = new ArrayList<>();
		plantsToRemove = new Stack<>();
		zombiesList = new ArrayList<>();
		zombiesToRemove = new Stack<>();
		lawnmowersList = new ArrayList<>();
		lawnmowersToRemove = new Stack<>();
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

	public void addLawnmower(Lawnmower lawnmower) { lawnmowersList.add(lawnmower); }

	public void removeLawnmower(Lawnmower lawnmower) { lawnmowersToRemove.add(lawnmower); }

	public void removeObjects() {
		while (!plantsToRemove.empty()) {
			plantsList.remove(plantsToRemove.pop());
		}

		while (!zombiesToRemove.empty()) {
			zombiesList.remove(zombiesToRemove.pop());
		}

		while (!lawnmowersToRemove.empty()) {
			lawnmowersList.remove(lawnmowersToRemove.pop());
		}
	}

	public boolean checkGameOver() {
		for (Zombie zombie : zombiesList) {
			if (zombie.getPos().x < 0) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Zombie> getZombiesList() {
		return zombiesList;
	}

	public ArrayList<Plant> getPlantsList() {
		return plantsList;
	}
}
