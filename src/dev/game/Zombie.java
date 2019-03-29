public class Zombie extends Entity {
    private int health;
    private int max_health;
    private int attack_strength;
    private int row;
    private int x;
    private float cooldown;

    // Constructor class
    public Zombie(int start_row, int start_x, int start_attack, int start_health) {
        super(start_row, start_x);
        this.health = start_health;
        this.max_health = start_health;
        this.attack_strength = start_attack;
        this.cooldown = 0;
    }
    
    // Method to allow the Zombie to take damage when hit by a Bullet
    public void damage(int damage) {
        this.health -= damage;
    }

    // The update method is called every step to update all entities
    public void update(){

    // Move the Zombie 1 pixel to the left
        this.x -= 1;
        if this.cooldown > 0 {
            // Reduce the attack cooldown by 1
            this.cooldown -= 1;
            // We can change this later so that the cooldown is decreased by the number of milliseconds since the last frame
        }

        // nearest_plant = ??
        // Test for the distance to the nearest Plant
        // If the Plant is less than 50 pixels away from the Zombie && cooldown <= 0 {
            nearest_plant.damage(this.attack);
        }
    }
}
