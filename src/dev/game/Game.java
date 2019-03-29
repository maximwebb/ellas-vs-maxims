package dev.game;

import dev.game.display.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

	private Display display;
	private float frameRate;
	public int width, height;
	public String title;

	private boolean running = false;
	private Thread thread;

	/* A way for the computer to draw things to the screen */
	private BufferStrategy bs;
	private Graphics g;

	public Game(String title, int width, int height, float frameRate) {
		this.title = title;
		this.width = width;
		this.height = height;
		this.frameRate = frameRate;
	}

	private void init() {
		display = new Display(title, width, height);
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
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, 100, 100);

		bs.show();
		g.dispose();
		try {
			Thread.sleep((long)(1000/this.frameRate));
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
