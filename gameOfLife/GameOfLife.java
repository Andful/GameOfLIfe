package gameOfLife;

public class GameOfLife {
    public Cell[][] grid;
    public boolean pause = true;
    public void togglePause(){
        if(pause){
            pause = false;
            advance();
        }else{
            pause = true;
        }
    }
    public GameOfLife(int numOfCol, int numOfRow) {
        grid = new Cell[numOfCol][numOfRow];
        advance();
    }
    public void advance(){
        while(!pause){
            for(int i = 0;i<grid.length;i++){
                for(int j = 0;j<grid[0].length;j++){
                    grid[i][j].update();
                }
            }
            for(int i = 0;i<grid.length;i++){
                for(int j = 0;j<grid[0].length;j++){
                    grid[i][j].tick();
                }
            }
        }
    }
}