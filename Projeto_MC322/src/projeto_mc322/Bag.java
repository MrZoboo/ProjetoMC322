package projeto_mc322;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * This is class that will implement our item bag
 * Basically, it stores a shape
 */

public class Bag extends JPanel implements PanelAsset{
    // Instance Variables
    private final int tamanhoPixel = 22;
    protected Shape bag = new OrangeL();

    /**
     * Standard constructor
     * @param bagPanel
     */
    public Bag(JPanel bagPanel){
        this.setBounds(bagPanel.getBounds());
        this.setBackground(bagPanel.getBackground());
        this.setBorder(bagPanel.getBorder());
    }

    // Getters and Setters
    public int getTamanhoPixel() {
        return this.tamanhoPixel;
    }
    public Shape getBag(){
        return bag;
    }
    public void setBag(Shape bag){
        this.bag = new Shape(bag.getDimensions(), bag.getColor());
    }

    /**
     * Draws a square of a certain color in a determined position
     * @param g Graphics 
     * @param color Color
     * @param x int
     * @param y int
     */
    public void drawGridSquare(Graphics g, Color color, int x, int y){
        g.setColor(color);
        g.fillRect(x, y, tamanhoPixel, tamanhoPixel);
    }

    /**
     * Paints the selected shape in the bag panel
     * @param g Graphics
     */
    public void paintShape(Graphics g){
        int h = bag.getHeight();
        int w = bag.getWidth();
        Color color = bag.getColor();
        int[][] dimensions = bag.getDimensions();

        for(int i = 0; i < h; i++){
            for(int j = 0; j< w;j++){
                if(dimensions[i][j] == 1){
                    int x = (j + bag.getX())*tamanhoPixel;
                    int y = (i + bag.getY())*tamanhoPixel;
                    drawGridSquare(g, color, x, y);
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        paintShape(g);
    }

    @Override
    public String toString() {
        return "{" +
            " tamanhoPixel='" + getTamanhoPixel() + "'" +
            ", bag='" + getBag() + "'" +
            "}";
    }

}
