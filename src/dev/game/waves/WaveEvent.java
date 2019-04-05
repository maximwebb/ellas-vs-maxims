package dev.game.waves;

public abstract class WaveEvent implements Comparable<WaveEvent>{
	
	public final double time;
	
	public WaveEvent(double time) {
		this.time = time;
	}

	@Override
	public int compareTo(WaveEvent event) {
		return Double.compare(this.time, event.time);
	}
}
