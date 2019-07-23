package dev.game.waves;
import dev.game.zombies.ZombieBuilder;

public class LevelManager {

	public static ZombieBuilder.ZombieType[] normalZombie = new ZombieBuilder.ZombieType[]{ZombieBuilder.ZombieType.NORMAL};
	public static ZombieBuilder.ZombieType[] engineerZombie = new ZombieBuilder.ZombieType[]{ZombieBuilder.ZombieType.ENGINEER};
	public static ZombieBuilder.ZombieType[] asnacZombie = new ZombieBuilder.ZombieType[]{ZombieBuilder.ZombieType.ASNAC};
	public static ZombieBuilder.ZombieType[] politicsZombie = new ZombieBuilder.ZombieType[]{ZombieBuilder.ZombieType.POLITICS};

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
