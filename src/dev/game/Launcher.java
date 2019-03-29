package dev.game;

public class Launcher {
	public static void main(String[] args) {
		Game gameInstance = new Game("Ellas vs. Maxim", 1200, 800);
		gameInstance.start();
	}
}
