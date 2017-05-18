package gameOfLife;

public abstract class CellState {
    public abstract boolean isAlive();
    public abstract CellState nextState(int neighbors);
}