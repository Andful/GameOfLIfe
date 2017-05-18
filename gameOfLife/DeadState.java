package gameOfLife;

public class DeadState extends CellState {
	private boolean stateType = false;
    public boolean isAlive(){
        return stateType;
    }
    public CellState nextState(int neighbors) {
        if (neighbors == 3){
            return new AliveState();
        }else{
            return this;
        }        
    }
}