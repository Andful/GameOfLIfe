package gameOfLife;

public class GameOfLife {
    public Cell[][] grid;
    private GameOfLifeUI panel;
    public GameOfLife(int numbrows, int numbcols, GameOfLifeUI panel) {
        grid = new Cell[numbcols][numbrows];
        this.panel = panel;
        for (int i=0; i<numbcols; i++)
            for (int j=0; j<numbrows; j++)
                grid[i][j] = new Cell(grid, i, j);
        initGlider();
        initSmallExploder();
        initTumbler();
        advance();
    }
    public void advance() {
    	for(int i = 0;i<grid.length;i++) {
    		for(int j = 0;j<grid[0].length;j++) {
    			grid[i][j].update();
    		}
    	}
    	for(int i = 0;i<grid.length;i++) {
    		for(int j = 0;j<grid[0].length;j++) {
    			grid[i][j].tick();
    		}
    	}
    	panel.repaint();
    }
    
    private void initSmallExploder() {
        grid[30][31].state = new AliveState();
        grid[30][32].state = new AliveState();
        grid[31][30].state = new AliveState();
        grid[31][31].state = new AliveState();
        grid[31][33].state = new AliveState();
        grid[32][31].state = new AliveState();
        grid[32][32].state = new AliveState();
    }

    private void initGlider() {
        grid[21][20].state = new AliveState();
        grid[22][21].state = new AliveState();
        grid[22][22].state = new AliveState();
        grid[21][22].state = new AliveState();
        grid[20][22].state = new AliveState();
    }
    
    private void initTumbler() {
        grid[30][23].state = new AliveState();
        grid[30][24].state = new AliveState();
        grid[30][25].state = new AliveState();
        grid[31][20].state = new AliveState();
        grid[31][21].state = new AliveState();
        grid[31][25].state = new AliveState();
        grid[32][20].state = new AliveState();
        grid[32][21].state = new AliveState();
        grid[32][22].state = new AliveState();
        grid[32][23].state = new AliveState();
        grid[32][24].state = new AliveState();
        grid[34][20].state = new AliveState();
        grid[34][21].state = new AliveState();
        grid[34][22].state = new AliveState();
        grid[34][23].state = new AliveState();
        grid[34][24].state = new AliveState();
        grid[35][20].state = new AliveState();
        grid[35][21].state = new AliveState();
        grid[35][25].state = new AliveState();
        grid[36][23].state = new AliveState();
        grid[36][24].state = new AliveState();
        grid[36][25].state = new AliveState();
    }
    
    public void changeState(int i, int j) {
    	if(grid[i][j].getState())
    		grid[i][j].state = new DeadState();
    	else
    		grid[i][j].state = new AliveState();
    }
}