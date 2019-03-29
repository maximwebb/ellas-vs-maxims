package dev.game;

import dev.game.display.Display;
import dev.game.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

	private Display display;
	public int width, height;
	public String title;

	private boolean running = false;
	private Thread thread;

	/* A way for the computer to draw things to the screen */
	private BufferStrategy bs;
	private Graphics g;

	private BufferedImage testImage;

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}

	private void init() {
		display = new Display(title, width, height);
		testImage = ImageLoader.loadImage("/textures/ella.png");
	}

	/* Updates to various objects happen here */
	private void tick() {

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
		g.drawImage(testImage, 10, 10, null);

		bs.show();
		g.dispose();
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* Required for Runnable */
	public void run() {
		init();

		/* Game loop */
		while (running) {
			tick();
			render();
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

	public synchronized void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
