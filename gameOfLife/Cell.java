
package gameOfLife;

public class Cell {
    public int x;
    public int y;
    public Cell[][] grid;
    public CellState state;
    public CellState nextState;
    
    public Cell(Cell[][] grid, int i, int j) {
        this.grid = grid;
        this.x = i;
        this.y = j;
        this.state = new DeadState();
    }
    
    public void tick() {
        state = nextState;
    }
    public void update() {
        nextState = state.nextState(nbrOfNeighbors(x, y));
    }
    
    private int nbrOfNeighbors(int x, int y) {
        int result = 0;
        if ((0 <= x-1) && (0 <= y-1) && (grid[x-1][y-1].getState())) result++;
        if ((0 <= x-1) && (grid[x-1][y].getState())) result++;
        if ((0 <= x-1) && (y+1 < grid[0].length) && (grid[x-1][y+1].getState())) result++;
        if ((0 <= y-1) && (grid[x][y-1]).getState()) result++;
        if ((y+1 < grid[0].length) && (grid[x][y+1]).getState()) result++;
        if ((x+1 < grid.length) && (0 <= y-1) && (grid[x+1][y-1]).getState()) result++;
        if ((x+1 < grid.length) && (grid[x+1][y]).getState()) result++;
        if ((x+1 < grid.length) && (y+1 < grid[0].length) && (grid[x+1][y+1]).getState()) result++;
        return result;
    }
    
    public boolean getState(){
        return state.isAlive();
    }
}