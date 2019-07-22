package dev.game.waves;

public class LevelManager {

	public LevelManager() {

	}

	/* Checks to see if level exists, and if so, builds it. */
	public static Level getLevel(String levelName) {
		switch(levelName) {
			case "level1":
				WaveChunk waveC2 = new WaveChunk(5,5, 1, null, Wave.SpawnDistribution.EVEN);
				WaveChunk waveC3 = new WaveChunk(10,5, 2, null, Wave.SpawnDistribution.PEAK_END);
				WaveChunk waveC4 = new WaveChunk(15,5, 5, null, Wave.SpawnDistribution.PEAK_MIDDLE);

				WaveChunk[] chunkList = {waveC2, waveC3, waveC4};
				Wave wave = new Wave(chunkList);

				Level level = new Level();
				level.waves.add(wave);

				return level;
			default:
				return null;
		}
	}
}
