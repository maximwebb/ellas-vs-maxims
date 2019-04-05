package dev.game.waves;

import dev.game.rooms.Room;

public class CyclicWave extends Wave {
	
	@Override
	public void update() {
		if(this.isActive) {
			if(this.waveEvents.isEmpty()) {
				this.reset();
			} else {
				activeTime += Room.getRoom().getDeltaTime();
				if(this.activeTime > this.waveEvents.peek().time) {
					this.processEvent(this.waveEvents.poll());
				}
			}
		}
	}
	
	public static CyclicWave getDemoWave(int length) {
		CyclicWave demo = new CyclicWave();
		
		for(int i = 0; i < length; i++) {
			demo.waveEvents.add(new ZombieSpawnEvent(2 * i + 2));
		}
		
		return demo;
	}
}
