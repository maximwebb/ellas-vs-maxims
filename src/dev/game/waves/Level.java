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
	
	public static Level level1() {
		WaveChunk waveC1 = new WaveChunk(5, new Wave(1));
		WaveChunk waveC2 = new WaveChunk(30, new Wave(10, 3, null, SpawnDistribution.EVEN));
		WaveChunk waveC3 = new WaveChunk(60, new Wave(30, 7, null, SpawnDistribution.PEAK_END));
		WaveChunk waveC4 = new WaveChunk(120, new Wave(60, 20, null, SpawnDistribution.PEAK_MIDDLE));
		
		Wave wave = new Wave();
		wave.addEvent(waveC1);
		wave.addEvent(waveC2);
		wave.addEvent(waveC3);
		wave.addEvent(waveC4);
		
		Level level = new Level();
		level.waves.add(wave);
		
		return level;
	}
}
