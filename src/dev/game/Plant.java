public class Plant extends Entity {
	private int health;
	private int max_health;
	private int attack_strength;
	private int row;
	private int x;
	private float cooldown;
			
	// Constructor class
	public Plant(int start_row, int start_x, int start_attack, int start_health) {
		super(start_row, start_x);
		this.health = start_health;
		this.max_health = start_health;
		this.attack_strength = start_attack;
		this.cooldown = 0;
	}
	
	// The update method is called every step to update all entities
	public void update(){

		if this.cooldown > 0 {
			this.cooldown -= 1000/60;
			// We can change this later so that the cooldown is decreased by the number of milliseconds since the last frame
		}
			
		// nearest_zombie = ??
		// Test for the distance to the nearest zombie
		// If a zombie exists && cooldown == 0 {
			// We need to decide where we'll store entities so we can store Bullets there
			new Bullet(this.row, this.x, this.attack);
			this.cooldown = 1000;
		}
	}
}
