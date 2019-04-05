package dev.game.waves;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import dev.game.objects.GameObject;
import dev.game.objects.Zombie;
import dev.game.rooms.*;

public class Wave extends GameObject {
	
	protected boolean isActive = false;
	protected double activeTime = 0;
	protected PriorityQueue<WaveEvent> waveEvents = new PriorityQueue<WaveEvent>();
	protected Queue<WaveEvent> usedEvents = new LinkedList<WaveEvent>();
	
	@Override
	public void update() {
		if(this.isActive) {
			if(this.waveEvents.isEmpty()) {
				this.stop();
				this.reset();
			} else {
				activeTime++;
				if(this.activeTime > this.waveEvents.peek().time) {
					this.processEvent(this.waveEvents.poll());
				}
			}
		}
	}
	
	public void play() {
		this.isActive = true;
	}
	
	public void stop() {
		this.isActive = false;
	}
	
	public void reset() {
		this.waveEvents.addAll(this.usedEvents);
		this.usedEvents.clear();
		this.activeTime = 0;
	}
	
	protected void processEvent(WaveEvent event) {
		
		if(event instanceof ZombieSpawnEvent) {
			ZombieSpawnEvent zombieEvent = (ZombieSpawnEvent)event;
			((GameRoom)Room.getRoom()).addZombie(zombieEvent.lane);
		}
		
		this.usedEvents.add(event);
	}
	
	public static Wave getDemoWave(int length) {
		Wave demo = new Wave();
		
		for(int i = 0; i < length; i++) {
			demo.waveEvents.add(new ZombieSpawnEvent(60 * i + 60));
		}
		
		return demo;
	}
}
