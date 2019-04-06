package dev.game.waves;

public abstract class WaveEvent implements Comparable<WaveEvent>{
	
	public final double time;
	
	public WaveEvent(double time) {
		this.time = time;
	}

	@Override
	public int compareTo(WaveEvent event) {
		return this.time > event.time ? 1 : (this.time < event.time ? -1 : 0);
	}
}
