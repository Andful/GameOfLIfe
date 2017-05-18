package gameOfLife;

public class AliveState extends CellState {
    public boolean isAlive(){
        return true;
    }
    public CellState nextState(int neighbors) {
                if (neighbors < 2)
                    return new DeadState();
                else if ((2 <= neighbors) && (neighbors <= 3))
                    return this;
                else if ((3 < neighbors))
                    return new DeadState();
                return this;
    }
}