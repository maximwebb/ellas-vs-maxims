package dev.game.waves;

import java.util.HashMap;

import dev.game.rooms.Room;
import dev.game.waves.Wave.SpawnDistribution;
import dev.game.zombies.ZombieBuilder.ZombieType;

public class CyclicWave extends Wave {
	
	@Override
	public void update() {
		if(this.isActive) {
			if(this.waveEvents.isEmpty()) {
				this.reset();
			} else {
				this.activeTime += Room.getRoom().getDeltaTime();
				if(this.activeTime > this.waveEvents.peek().time) {
					this.processEvent(this.waveEvents.poll());
				}
			}
		}
	}
	
	public CyclicWave(double length, int zombies, HashMap<ZombieType, Float> zombieTypes, SpawnDistribution distribution) {
			
		for(int i = 0; i < zombies; i++) {
			
			double randNum = Math.random();
			
			switch(distribution) {
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
			
			this.addEvent(new ZombieSpawnEvent(randNum * length));
		}
	}
}
