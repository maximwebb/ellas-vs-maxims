package dev.game.waves;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import dev.game.Game;
import dev.game.objects.GameObject;
import dev.game.rooms.*;
import dev.game.zombies.ZombieBuilder;
import dev.game.zombies.ZombieBuilder.ZombieType;

public class Wave extends GameObject {

	public enum SpawnDistribution {
		EVEN,
		PEAK_START,
		PEAK_MIDDLE,
		PEAK_END
	}
  
	private ArrayList<GameObject> children = new ArrayList<GameObject>(); 
  
	protected boolean isActive = false;
	protected double activeTime = 0;
	protected PriorityQueue<WaveEvent> waveEvents = new PriorityQueue<WaveEvent>();
	protected Queue<WaveEvent> usedEvents = new LinkedList<WaveEvent>();

	@Override
	public void update() {
		
		if (this.isActive) {
			if(this.waveEvents.isEmpty()) {
				this.stop();
				this.reset();
			} else {
				this.activeTime += Room.getRoom().getDeltaTime();
				if (this.activeTime > this.waveEvents.peek().time) {
					this.processEvent(this.waveEvents.poll());
				}
			}
		}
		
		for(GameObject child : children) {
			child.update();
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

	public void addEvent(WaveEvent event) {
		this.waveEvents.add(event);
	}

	protected void processEvent(WaveEvent event) {
		if (event instanceof ZombieSpawnEvent) {
			ZombieSpawnEvent zombieEvent = (ZombieSpawnEvent)event;
			((GameRoom)Room.getRoom()).addZombie(zombieEvent.lane, zombieEvent.zombieType);
			System.out.println("ZOMBIE SPAWNED");
		}
		else if (event instanceof WaveChunk) {
			WaveChunk chunk = (WaveChunk)event;
			for (int i = 0; i < chunk.waveEvents.size(); i++) {
				addEvent(chunk.waveEvents.get(i));
			}
			System.out.println("NEW WAVE CHUNK");
		}
		this.usedEvents.add(event);
	}

	public Wave() {
	}

	//Commenting this code out for now, we should delete once we're happy with the refactor.

	/*public Wave(int zombies) {
		for (int i = 0; i < zombies; i++) {
			this.addEvent(new ZombieSpawnEvent(2 * i + 2));
		}
	}

	public Wave(double length, int zombies, HashMap<ZombieType, Float> zombieTypes, SpawnDistribution distribution) {

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
			this.addEvent(new ZombieSpawnEvent(randNum * length));
		}
	}*/

	/* All waves should be created using this constructor */
	public Wave(WaveChunk[] waveChunksList) {
		for (int i = 0; i < waveChunksList.length; i++) {
			this.addEvent(waveChunksList[i]);
		}
	}
}
