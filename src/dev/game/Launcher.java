package dev.game;

public class Launcher {
	public static void main(String[] args) {
		Game gameInstance = Game.getInstance();
		gameInstance.start();
	}
}