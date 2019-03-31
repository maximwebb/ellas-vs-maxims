package dev.game;

import dev.game.display.Display;
import dev.game.gfx.Assets;
import dev.game.gfx.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Game implements Runnable {

	private Display display;
	public int width, height;
	public String title;
	private boolean showFPS = false;
	private boolean running = false;
	private Stack<Entity> entitiesToAdd;
	private Stack<Entity> entitiesToRemove;
	private Thread thread;
	private static Game intance = new Game("Ellas vs. Maxim", 1920, 1080);

	private Room room;

	/* A way for the computer to draw things to the screen */
	private BufferStrategy bs;
	private Graphics g;

	/* Add test properties here */
	private BufferedImage background;

	private static Tile[][] grid;
	private static Plant maximPlant;

	/* Equivalent of sun in PvZ */
	public static int eggCount = 0;
	private static int eggCountTimer = 200;

	private Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		entitiesToAdd=new Stack<>();
		entitiesToRemove=new Stack<>();
	}

	private void init() {
		display = new Display(title, width, height);
		Assets.init();
		setRoom(Rooms.getArenaRoom());
		background = ImageLoader.loadImage("/backgrounds/lawn.png");
		fillGrid(4, 6, 200);

	}

	/* Updates to various objects happen here */
	private void tick(double deltaTime) {
		eggCountTimer++;
		if (eggCountTimer > 300) {
			eggCount += 25;
			eggCountTimer = 0;
		}

		for(Entity entity: room.getEntities()){
			entity.update();
		}
		//Performs concurrent changes to the object list
		while(!entitiesToAdd.empty()){
			room.getEntities().add(entitiesToAdd.pop());
		}
		while(!entitiesToRemove.empty()){
			room.getEntities().remove(entitiesToRemove.pop());
		}
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		/* Draw graphics */
		g.clearRect(0, 0, width, height);
		g.drawImage(background, 0, 0, null);

		for (Entity entity: room.getEntities()){
			g.drawImage(entity.getSprite(),entity.getPosX(),entity.getPosY(),null);
		}

		g.setColor(Color.white);
		g.setFont(new Font("consolas", Font.PLAIN, 50));
		g.drawString("Egg count: " + eggCount, width - 500, 50);

		bs.show();
		g.dispose();
	}

	/* Required for Runnable */
	public void run() {
		init();

		double currentTime; //current time (in seconds)
		double lastTime = (double)System.nanoTime()/1000000000; //time of last update (in seconds)
		double deltaTime; //time between this update and the last (in seconds).
		double targetTime = lastTime; //target time for next update (in seconds)

		while(this.running) {
		currentTime = (double)System.nanoTime()/1000000000; //Updates time.

		if(currentTime >= targetTime) {
			deltaTime = currentTime - lastTime; //Sets deltaTime to equal the time since the last update
			lastTime = currentTime; //sets lastTime to equal time of this update

			targetTime += (1/this.fps) * Math.ceil((currentTime - targetTime) * this.fps); //sets target time for next update

			//Calls some method to update game logic.
			//Important to pass in deltaTime so objects know how much time has passed since their last update.
			tick(deltaTime);

			render(); //Calls some method to update rendering 

			System.out.println((double)System.nanoTime()/1000000000); //Debugging purposes
		}
		
		stop();
	}

	public synchronized void start() {
		/* Ensures evm is not restarted */
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		/* Calls this.run() */
		thread.start();
	}

	public static Game getInstance() {
		return intance;
	}

	public void addEntity(Entity e){
		entitiesToAdd.add(e);
	}

	public void removeEntity(Entity e){
		entitiesToAdd.remove(e);
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	//Vertical and horizontal determine number of tiles in the grid, border the free space on the right
	public void fillGrid(int vertical, int horizontal, int border){
		grid = new Tile[vertical][horizontal];
		int w = (width-border)/horizontal;
		int h = height/vertical;
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
	public static void addPlant(int x, int y){
		maximPlant = new Plant(25, 25, 0, 0);

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
					grid[i][j].setPlant(new Plant(maximPlant, posX+25, posY+25));
					grid[i][j].empty = false;
					Game.getInstance().addEntity(grid[i][j].getPlant());
				}

			}
		}
	}


	public Room getRoom() {
		return room;
	}

}
