package dev.game;

import dev.game.display.Display;
import dev.game.gfx.Assets;
import dev.game.gfx.ImageLoader;

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
	private static Game intance = new Game("Ellas vs. Maxim", 640, 480);

	private Room room;

	/* A way for the computer to draw things to the screen */
	private BufferStrategy bs;
	private Graphics g;

	/* Add test properties here */
	private BufferedImage background;

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
	}

	/* Updates to various objects happen here */
	private void tick() {
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

		bs.show();
		g.dispose();
	}

	/* Required for Runnable */
	public void run() {
		init();

		int FPS = 60;
		double timePerTick = 1000000000 / FPS;
		double delta = 0;
		long currentTime;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		/* Game loop */
		while (running) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / timePerTick;
			timer += currentTime - lastTime;
			lastTime = currentTime;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				if (showFPS) {
					System.out.println("Frames: " + ticks);
				}
				ticks = 0;
				timer = 0;
			}

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

	public Room getRoom() {
		return room;
	}
}
