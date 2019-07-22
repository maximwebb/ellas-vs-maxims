package dev.game.waves;

import java.util.ArrayList;

import dev.game.waves.Wave.SpawnDistribution;

public class Level {
	
	public ArrayList<Wave> waves = new ArrayList<Wave>();
	private int currentWaveIndex = 0;
	
	public void playNext() {
		if(currentWaveIndex < waves.size()) {
			waves.get(currentWaveIndex).play();
			currentWaveIndex++;
		}
	}
}
