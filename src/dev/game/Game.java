package dev.game;

import dev.game.display.Display;
import dev.game.gfx.Assets;
import dev.game.gfx.ImageLoader;
import dev.game.rooms.GameRoom;
import dev.game.rooms.MenuRoom;
import dev.game.rooms.Room;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class Game implements Runnable {

	private Display display;
	public int width, height;
	public String title;
	private boolean showFPS = false;
	private boolean running = false;

	private Thread thread;
	private static Game instance = new Game("Ellas vs. Maxims", 1920, 1080);

	/* Rooms */
	private Room gameRoom;
	private Room menuRoom; //Currently not implemented

	/* A way for the computer to draw things to the screen */
	private BufferStrategy bs;
	private Graphics g;

	/* Add test properties here */
	private BufferedImage background;

	/* Equivalent of sun in PvZ */


	private Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}

	private void init() {
		Assets.init();
		display = new Display(title, width, height);

		gameRoom = new GameRoom();
		menuRoom = new MenuRoom();
		/* By default sets the room to the game room. Will likely be changed to the Main Menu in the future. */
		Room.setRoom(gameRoom);

		background = ImageLoader.loadImage("/backgrounds/lawn.png");
		Room.getRoom().init();
	}

	/* Updates to various objects happen here */
	private void tick() {
		Room.getRoom().tick();
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);

		/* Draw graphics */
		g.drawImage(background, 0, 0, null);
		Room.getRoom().render(g);

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
		return instance;
	}

	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}