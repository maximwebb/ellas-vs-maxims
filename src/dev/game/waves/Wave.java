package dev.game.waves;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import dev.game.Game;
import dev.game.objects.GameObject;
import dev.game.rooms.*;
import dev.game.zombies.ZombieBuilder;

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
				activeTime += Room.getRoom().getDeltaTime();
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
			int randNum = (int)Math.floor(Math.random() * 10) + 1;
			System.out.println(randNum);
			if (randNum < 3) {
				((GameRoom)Room.getRoom()).getZombieBuilder().setCurrentZombieType(ZombieBuilder.ZombieType.ENGINEER);
			}
			else if (randNum >= 3 && randNum < 6 ) {
				((GameRoom)Room.getRoom()).getZombieBuilder().setCurrentZombieType(ZombieBuilder.ZombieType.POLITICS);
			}
			else if (randNum >= 6 && randNum < 8) {
				((GameRoom)Room.getRoom()).getZombieBuilder().setCurrentZombieType(ZombieBuilder.ZombieType.ASNAC);
			}
			else {
				((GameRoom)Room.getRoom()).getZombieBuilder().setCurrentZombieType(ZombieBuilder.ZombieType.NORMAL);
			}
			((GameRoom)Room.getRoom()).addZombie(zombieEvent.lane);
		}
		
		this.usedEvents.add(event);
	}
	
	public static Wave getDemoWave(int length) {
		Wave demo = new Wave();
		
		for(int i = 0; i < length; i++) {
			demo.waveEvents.add(new ZombieSpawnEvent(2 * i + 2));
		}
		
		return demo;
	}
}
