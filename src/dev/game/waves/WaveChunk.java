package dev.game.waves;

public class WaveChunk extends WaveEvent {
	
	public final Wave wave;
	
	public WaveChunk(double time, Wave wave) {
		super(time);
		this.wave = wave;
	}
}
