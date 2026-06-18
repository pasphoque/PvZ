package models.environments;

public abstract class Obstacle {
    protected int health;
    protected int height;

    public Obstacle(int health, int height) {
        this.health = health;
        this.height = height;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
    }

    public boolean isDestroyed() {
        return this.health <= 0;
    }

    public int getHealth() { return health; }
}
