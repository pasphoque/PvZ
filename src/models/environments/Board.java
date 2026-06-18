package models.environments;

import enums.TileType;

public class Board {
    private int rows;
    private int cols;
    private Tile[][] grid;
    // private LawnMower[] lawnMowers;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Tile[rows][cols];
        initializeDefaultGrid();
    }

    private void initializeDefaultGrid() {
        // Standard PvZ Board is 5 rows (y) by 9 columns (x)
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                grid[y][x] = new Tile(x, y, TileType.NORMAL);
            }
        }
    }

    public Tile getTile(int x, int y) {
        // Boundary check to prevent array index out of bounds
        if (x >= 0 && x < cols && y >= 0 && y < rows) {
            return grid[y][x];
        }
        return null;
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }
}
