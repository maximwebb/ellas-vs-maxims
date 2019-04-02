package dev.game.rooms;

import dev.game.*;
import dev.game.plants.*;
import dev.game.maths.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class GameRoom extends Room {

	public ArrayList<GameObject> gameObjectsList;
	private Stack<GameObject> gameObjectsToAdd;
	private Stack<GameObject> gameObjectsToRemove;
	private static Tile[][] grid;

	private static Plant maximPlant;
	public static ArrayList<Plant> plantInventory;

	public static int eggCount = 100;
	private static int eggCountTimer = 0;

	public GameRoom() {
		gameObjectsList = new ArrayList<>();
		gameObjectsToAdd=new Stack<>();
		gameObjectsToRemove=new Stack<>();
	}

	public void init() {
		gameObjectsList = new ArrayList<>();
		gameObjectsToAdd=new Stack<>();
		gameObjectsToRemove=new Stack<>();

		fillGrid(4, 6, 200);
		addGameObject(new ZombieSpawner(4, 20));
	}

	@Override
	public void tick() {

		for(GameObject gameObject : gameObjectsList) {
			gameObject.update();
		}
		//Performs concurrent changes to the object list
		while(!gameObjectsToAdd.empty()){
			gameObjectsList.add(gameObjectsToAdd.pop());
		}
		while(!gameObjectsToRemove.empty()){
			gameObjectsList.remove(gameObjectsToRemove.pop());
		}

		if (eggCountTimer > 150) {
			eggCount += 25;
			eggCountTimer = 0;
		}
		else {
			eggCountTimer++;
		}
	}

	@Override
	public void render(Graphics g) {
		for (GameObject object : gameObjectsList){
			if (object instanceof RenderedGameObject) {
				g.drawImage(((RenderedGameObject)object).getSprite(), Math.round(((RenderedGameObject)object).getPos().x), Math.round(((RenderedGameObject)object).getPos().y), null);
			}
		}

		g.setColor(Color.white);
		g.setFont(new Font("consolas", Font.PLAIN, 50));
		g.drawString("Egg count: " + eggCount, Game.getInstance().width - 500, 50);
	}

	/* Vertical and horizontal determine number of tiles in the grid, border the free space on the right */
	public void fillGrid(int vertical, int horizontal, int border){
		grid = new Tile[vertical][horizontal];
		int w = (Game.getInstance().width-border)/horizontal;
		int h = Game.getInstance().height/vertical;
		for(int i = 0; i<vertical; i++){
			for(int j = 0; j<horizontal; j++){
				grid[i][j] = new Tile();
				grid[i][j].setPosition((border + j*w), (i*h));
				grid[i][j].setDimensions(w, h);
			}
		}
	}

	public static Tile[][] getGrid(){
		return grid;
	}

	//adds plant to tile which contains clicked coordinates
	public void addPlant(int x, int y, String plantType){
		/* Sort out this slightly cursed code */
		if (plantType.equals("eggShooter")) {
			maximPlant = new EggShooter(Vector2D.zero, Vector2D.zero);
		}
		else if (plantType.equals("eggFlower")) {
			maximPlant = new EggFlower(Vector2D.zero, Vector2D.zero);
		}
		else if (plantType.equals("walbert")) {
			maximPlant = new Walbert(Vector2D.zero, Vector2D.zero);
		}
//		else if (plantType == "chenapult") {
//			maximPlant = new EggShooter(25, 25, 0, 0);
//		}
    
		if (maximPlant.getEggCost() > eggCount) {
			System.out.println("You can't afford this!");
			return;
		}
		eggCount -= maximPlant.getEggCost();

		for(int i = 0; i<grid.length; i++){
			for(int j = 0; j<grid[i].length; j++){
				int posX = grid[i][j].getPosX();
				int posY = grid[i][j].getPosY();
				int w = grid[i][j].getWidth();
				int h = grid[i][j].getHeight();
				if(x<(posX+w) && x>(posX) && y<(posY+h) && y>(posY) && grid[i][j].empty){
					grid[i][j].setPlant(new EggShooter(new Vector2D(posX + 25, posY + 25), Vector2D.zero));
					grid[i][j].empty = false;
					addGameObject(grid[i][j].getPlant());
				}

			}
		}
	}

	public void addGameObject(GameObject e){
		gameObjectsToAdd.add(e);
	}

	public void removeGameObject(GameObject e){
		gameObjectsToRemove.add(e);
	}

	public void setEggCount(int count) { eggCount = count; }

}
