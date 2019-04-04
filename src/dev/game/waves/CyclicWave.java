package dev.game.waves;

public class CyclicWave extends Wave {
	
	@Override
	public void update() {
		if(this.isActive) {
			if(this.waveEvents.isEmpty()) {
				this.reset();
			} else {
				activeTime++;
				if(this.activeTime > this.waveEvents.peek().time) {
					this.processEvent(this.waveEvents.poll());
				}
			}
		}
	}
	
	public static CyclicWave getDemoWave(int length) {
		CyclicWave demo = new CyclicWave();
		
		for(int i = 0; i < length; i++) {
			demo.waveEvents.add(new ZombieSpawnEvent(60 * i + 60));
		}
		
		return demo;
	}
}
