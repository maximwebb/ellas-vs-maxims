package dev.game.waves;
import dev.game.zombies.ZombieBuilder;

import java.util.HashMap;

public class LevelManager {

	// Might be an idea to add an alternative constructor for WaveChunk, to simplify this.
	public static HashMap<ZombieBuilder.ZombieType, Double> normalZombie = new HashMap<>() {{ put(ZombieBuilder.ZombieType.NORMAL, 1d); }};
	public static HashMap<ZombieBuilder.ZombieType, Double> engineerZombie = new HashMap<>() {{ put(ZombieBuilder.ZombieType.ENGINEER, 1d); }};
	public static HashMap<ZombieBuilder.ZombieType, Double> asnacZombie = new HashMap<>() {{ put(ZombieBuilder.ZombieType.ASNAC, 1d); }};
	public static HashMap<ZombieBuilder.ZombieType, Double> politicsZombie = new HashMap<>() {{ put(ZombieBuilder.ZombieType.POLITICS, 1d); }};

	public LevelManager() {
	}

	/* Checks to see if level exists, and if so, builds it. */
	public static Level getLevel(String levelName) {
		switch(levelName) {
			case "level1": {
				WaveChunk[] chunkList = {
					new WaveChunk(10, 5, 1, normalZombie, Wave.SpawnDistribution.EVEN),
					new WaveChunk(20, 5, 2, normalZombie, Wave.SpawnDistribution.PEAK_END),
					new WaveChunk(25, 5, 1, normalZombie, Wave.SpawnDistribution.PEAK_END),
					new WaveChunk(40, 5, 1, engineerZombie, Wave.SpawnDistribution.PEAK_END),
					new WaveChunk(60, 5, 5, null, Wave.SpawnDistribution.PEAK_MIDDLE)
				};

				Wave wave = new Wave(chunkList);

				Level level = new Level();
				level.waves.add(wave);

				return level;
			}
			case "level2": {
				WaveChunk[] chunkList = {
					new WaveChunk(5, 10, 1, null, Wave.SpawnDistribution.EVEN),
					new WaveChunk(30, 10, 3, null, Wave.SpawnDistribution.PEAK_END),
					new WaveChunk(40, 10, 4, null, Wave.SpawnDistribution.PEAK_MIDDLE),
					new WaveChunk(60, 20, 10, null, Wave.SpawnDistribution.PEAK_MIDDLE)
				};

				Wave wave = new Wave(chunkList);

				Level level = new Level();
				level.waves.add(wave);

				return level;
			}
			case "level3": {
				WaveChunk[] chunkList = {
					new WaveChunk(5, 10, 3, null, Wave.SpawnDistribution.EVEN),
					new WaveChunk(20, 10, 3, null, Wave.SpawnDistribution.PEAK_END),
					new WaveChunk(30, 10, 7, null, Wave.SpawnDistribution.PEAK_MIDDLE),
					new WaveChunk(60, 20, 15, null, Wave.SpawnDistribution.PEAK_MIDDLE)
				};

				Wave wave = new Wave(chunkList);

				Level level = new Level();
				level.waves.add(wave);

				return level;
			}
			default:
				return null;
		}

	}
}
