package projeto_mc322;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Queue extends JPanel{
    private final int tamanhoPixel = 22;
    protected List<Shape> nextBlocks = new ArrayList<>();

    public Queue(JPanel queuePanel){
        this.setBounds(queuePanel.getBounds());
        this.setBackground(queuePanel.getBackground());
        this.setBorder(queuePanel.getBorder());
    }

    public List<Shape> getNextBlocks(){
        return nextBlocks;
    }
    public void setNextBlocks(List<Shape> nextBlocks){
        this.nextBlocks = nextBlocks;
    }

    private void drawGridSquare(Graphics g, Color color, int x, int y){
        g.setColor(color);
        g.fillRect(x, y, tamanhoPixel, tamanhoPixel);
    }

    public void paintShapeQueue(Graphics g, Shape block){
        int h = block.getHeight();
        int w = block.getWidth();
        Color color = block.getColor();
        int[][] dimensions = block.getDimensions();

        for(int i = 0; i < h; i++){
            for(int j = 0; j< w;j++){
                if(dimensions[i][j] == 1){
                    int x = (j + block.getX())*tamanhoPixel;
                    int y = (i + block.getY())*tamanhoPixel;
                    drawGridSquare(g, color, x, y);
                }
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < 6; i++){
            Shape block = new Shape((nextBlocks.get(i).getAllRotations()[1]), nextBlocks.get(i).getColor());
            block.setX(0);
            block.setY(i*3);
            block.rotate();
            paintShapeQueue(g, block);
        }


    }
}
