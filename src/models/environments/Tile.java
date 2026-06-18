package models.environments;

import enums.TileType;
// import models.entities.Plant;
// import models.entities.Zombie;


public class Tile {
    private int x; // column
    private int y; // row
    private TileType type;
    private Obstacle obstacle;

    // We will initialize these in the next phase
    // private List<Plant> plantedPlants;
    // private List<Zombie> residentZombies;

    private boolean hasDangerLine; // Used for specific minigames/quests

    public Tile(int x, int y, TileType type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.obstacle = null;
        // this.plantedPlants = new ArrayList<>();
        // this.residentZombies = new ArrayList<>();
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public TileType getType() { return type; }
    public void setType(TileType type) { this.type = type; }

    public Obstacle getObstacle() { return obstacle; }
    public void placeObstacle(Obstacle obstacle) { this.obstacle = obstacle; }
    public void removeObstacle() { this.obstacle = null; }
}
