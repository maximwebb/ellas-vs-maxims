package dev.game.waves;

import dev.game.zombies.ZombieBuilder;

import java.util.ArrayList;
import java.util.HashMap;

public class WaveChunk extends WaveEvent {

	public ArrayList<WaveEvent> waveEvents;

	public WaveChunk(double time, int zombies) {
		super(time);
		waveEvents = new ArrayList<>();
		for (int i = 0; i < zombies; i++) {
			waveEvents.add(new ZombieSpawnEvent(2 * i + 2, null));
		}
	}

	public WaveChunk(double time, double length, int zombies, ZombieBuilder.ZombieType[] zombieTypes, Wave.SpawnDistribution distribution) {
		super(time);
		waveEvents = new ArrayList<>();
		for (int i = 0; i < zombies; i++) {

			double randNum = Math.random();

			switch (distribution) {
				case PEAK_START:
					randNum = 1 - Math.sqrt(1 - randNum);
					break;
				case PEAK_MIDDLE:
					randNum = 4 * Math.pow(randNum - 0.5, 3) + 0.5;
					break;
				case PEAK_END:
					randNum = Math.sqrt(randNum);
					break;
			}
			System.out.println("Random number: " + randNum);
			waveEvents.add(new ZombieSpawnEvent(randNum * length, zombieTypes));
		}
	}
}
