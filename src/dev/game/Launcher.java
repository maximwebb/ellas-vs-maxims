package dev.game;

public class Launcher {
	public static void main(String[] args) {
		Game gameInstance = new Game("Ellas vs. Maxim", 1920, 1080, 20);
		gameInstance.start();
	}
}
