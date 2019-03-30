package dev.game;

import dev.game.display.Display;
import dev.game.gfx.Assets;
import dev.game.gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

	private Display display;
	public int width, height;
	public String title;
	privtae double fps = 20;
	private boolean showFPS = false;
	private boolean running = false;
	private Thread thread;

	/* A way for the computer to draw things to the screen */
	private BufferStrategy bs;
	private Graphics g;

	/* Add test properties here */
	private Zombie ella;
	private Plant maxim;
	private BufferedImage background;

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}

	private void init() {
		display = new Display(title, width, height);
		Assets.init();
		ella = new Zombie(width, 25, -2, 0, Assets.zombie);
		maxim = new Plant(25, 25, 0, 0, Assets.plant);
		background = ImageLoader.loadImage("/backgrounds/lawn.png");
	}

	/* Updates to various objects happen here */
	private void tick(double deltaTime) {
		ella.updatePos();
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
		g.drawImage(ella.sprite, ella.posX, ella.posY, null);
		g.drawImage(maxim.sprite, maxim.posX, maxim.posY, null);
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
