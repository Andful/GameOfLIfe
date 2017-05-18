package gameOfLife;

public class DeadState extends CellState {
    public boolean isAlive(){
        return false;
    }
    public CellState nextState(int neighbors) {
        if (neighbors == 3){
            return new AliveState();
        }else{
            return this;
        }        
    }
}