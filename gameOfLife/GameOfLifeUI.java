package gameOfLife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class GameOfLifeUI extends JPanel {

    private int squaresize;
    private GameOfLife gol;
    
    public GameOfLifeUI(int numbrows, int numbcols, int squaresize) {
        // init grid
    	gol = new GameOfLife(numbrows, numbcols, this);
        // choose some initial configuration
        // multiple inits might interfere with the shape behavior
        
        this.squaresize = squaresize;
        setPreferredSize(new Dimension(numbcols*squaresize,numbrows*squaresize));
        
        this.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseClicked(MouseEvent e) {
                toggleGridValue(e.getX(),e.getY());
            }
        });
    }

    protected void toggleGridValue(int x, int y) {
        int i = x/squaresize;
        int j = y/squaresize;
        gol.changeState(i, j);
        repaint();
    }

    public void tick() {
        gol.advance();
        this.repaint();
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        
        //draw background
        drawgrid(g2);
        
        //draw alive cells
        g2.setColor(Color.GREEN);
        for (int i=0; i<gol.grid.length; i++)
            for (int j=0; j<gol.grid[0].length; j++) 
                if (gol.grid[i][j].getState()) 
                    g2.fill(new Rectangle2D.Double(i*squaresize+1,j*squaresize+1,squaresize-1,squaresize-1));
    }

    public void drawgrid(Graphics2D g2) {
        //fillbackground
        g2.setColor(Color.LIGHT_GRAY);
        g2.fill(getVisibleRect());
        //drawgrid
        g2.setColor(Color.GRAY);
        for (int i=0;i<=gol.grid.length;i++)
            g2.drawLine(i*squaresize, 0, i*squaresize,gol.grid[0].length*squaresize);
        for (int i=0;i<=gol.grid[0].length;i++)
            g2.drawLine(0,i*squaresize,gol.grid.length*squaresize,i*squaresize);
    }
        
}