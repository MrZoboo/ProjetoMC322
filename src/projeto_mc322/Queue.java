package projeto_mc322;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Queue extends JPanel implements PanelAsset{
    private final int tamanhoPixel = 22;
    protected List<Shape> nextBlocks = new ArrayList<>();
    private Shape block;

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

    public void drawGridSquare(Graphics g, Color color, int x, int y){
        g.setColor(color);
        g.fillRect(x, y, tamanhoPixel, tamanhoPixel);
    }

    public void paintShape(Graphics g){
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
            Shape nextBlock = new Shape((nextBlocks.get(i).getAllRotations()[1]), nextBlocks.get(i).getColor());
            nextBlock.setX(0);
            nextBlock.setY(i*3);
            nextBlock.rotate();
            block = nextBlock;
            paintShape(g);
        }


    }
}
