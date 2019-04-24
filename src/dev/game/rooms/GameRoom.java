package dev.game.rooms;

import dev.game.*;
import dev.game.gfx.Assets;
import dev.game.objects.*;
import dev.game.plants.Plant;
import dev.game.plants.PlantBuilder;
import dev.game.rendering.RenderCall;
import dev.game.rendering.RenderSpace;
import dev.game.rendering.RenderText;
import dev.game.ui.UIManager;
import dev.game.waves.*;
import dev.game.waves.Wave.SpawnDistribution;
import dev.game.maths.Vector2D;
import dev.game.zombies.Zombie;
import dev.game.zombies.ZombieBuilder;
import dev.game.zombies.ZombieBuilder.ZombieType;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GameRoom extends Room {

	public ArrayList<GameObject> gameObjectsList;
	private Stack<GameObject> gameObjectsToAdd;
	private Stack<GameObject> gameObjectsToRemove;
	private static Tile[][] grid;
	private int totalLanes;
	private Lane[] lanesList;
	
	private Level level;
	/* For convenience */
	private int gameWidth = RenderSpace.getStandard().getWidth();
	private int gameHeight = RenderSpace.getStandard().getHeight();

	private static Plant maximPlant; //what's this for?
	private PlantBuilder plantBuilder;
	//private ZombieBuilder zombieBuilder; - not needed

	public static int eggCount = 1000;
	private static int eggCountTimer = 0;

	UIManager uiManager = new UIManager();

	public GameRoom() {
		super(Assets.lawn);
		totalLanes = 4;
		gameObjectsList = new ArrayList<>();
		gameObjectsToAdd = new Stack<>();
		gameObjectsToRemove = new Stack<>();
	}

	public void init() {
		gameObjectsList = new ArrayList<>();
		gameObjectsToAdd = new Stack<>();
		gameObjectsToRemove = new Stack<>();

		this.plantBuilder = new PlantBuilder();
		//this.zombieBuilder = new ZombieBuilder(); - not needed
		fillGrid(totalLanes, 6, 25);

		lanesList = new Lane[totalLanes];
		for (int i = 0; i < totalLanes; i++) {
			lanesList[i] = new Lane(i);
		}
		
		/*
		Wave wave1 = new CyclicWave(100, 20, null, SpawnDistribution.PEAK_END);
		this.addGameObject(wave1);
		wave1.play();
		*/
		
		this.setLevel(Level.level1());
		this.levelPlayNext();
	}

	@Override
	public void tick(double deltaTime) {
		super.tick(deltaTime);

		for (GameObject gameObject : gameObjectsList) {
			gameObject.update();
		}

		for (int i = 0; i < totalLanes; i++) {
			lanesList[i].removeObjects();
		}
		//Performs concurrent changes to the object list
		while (!gameObjectsToAdd.empty()) {
			gameObjectsList.add(gameObjectsToAdd.pop());
		}
		while (!gameObjectsToRemove.empty()) {
			gameObjectsList.remove(gameObjectsToRemove.pop());
		}

		if (eggCountTimer > 150) {
			eggCount += 25;
			eggCountTimer = 0;
		} else {
			eggCountTimer++;
		}
	}

	@Override
	public Iterable<RenderCall> render() {
		List<RenderCall> renderCalls = new ArrayList<>();

		for (GameObject object : gameObjectsList) {
			//Maybe this shouldn't access camera...
			renderCalls.add(Game.getInstance().getCamera().translate(object));
		}

		renderCalls.add(new RenderText("Egg count: " + eggCount, Game.getInstance().width - 500, 50));

		return renderCalls;
	}

	/* Vertical and horizontal determine number of tiles in the grid, border the free space on the right */
	public void fillGrid(int vertical, int horizontal, int border) {
		grid = new Tile[vertical][horizontal];
		int w = gameWidth / horizontal;
		int h = gameHeight / vertical;

		for (int i = 0; i < vertical; i++) {
			for (int j = 0; j < horizontal; j++) {
				grid[i][j] = new Tile(new Vector2D((border + j * w), (i * h)), w, h, i);
				addGameObject(grid[i][j]);
			}
		}
	}

	public static Tile[][] getGrid() {
		return grid;
	}

	public Lane[] getLanesList() {
		return lanesList;
	}

	/*public int getTotalZombies() {
		int ret = 0;
		//count the zombies in each lane
		Lane[] lanes = this.getLanesList();
		for (int i = 0; i < lanes.length; i++) {
			ret += lanes[i].getZombiesList().size();
		}
		return ret;
	}*/

	public Plant addPlant(Vector2D pos, Tile tile) {
		Plant plant = plantBuilder.buildPlant(pos, tile);
		if (plant != null && plant.getEggCost() < eggCount) {
			addGameObject(plant);
			lanesList[tile.getLaneNumber()].addPlant(plant);
		}
		return plant;
	}

	public void removePlant(Plant plant) {
		gameObjectsToRemove.add(plant);
		lanesList[plant.getLaneNumber()].removePlant(plant);
	}

	public void addZombie(int lane, ZombieType zombieType) {
		Zombie zombie = ZombieBuilder.buildZombie(lane, zombieType);
		addGameObject(zombie);
		lanesList[lane].addZombie(zombie);
	}

	public void removeZombie(Zombie zombie) {
		gameObjectsToRemove.add(zombie);
		lanesList[zombie.getLaneNumber()].removeZombie(zombie);
	}

	public PlantBuilder getPlantBuilder() {
		return plantBuilder;
	}
	
	/*
	public ZombieBuilder getZombieBuilder() {
		return zombieBuilder;
	}
	*/

	public void addGameObject(GameObject e) {
		gameObjectsToAdd.add(e);
	}

	public void removeGameObject(GameObject e) {
		gameObjectsToRemove.add(e);
	}
  
	public void setEggCount(int count) { eggCount = count; }
	
	public void setLevel(Level level) {
		this.level = level;
		for(Wave wave : level.waves) {
			this.addGameObject(wave);
		}
	}
	
	public void levelPlayNext() {
		this.level.playNext();
	}
}
