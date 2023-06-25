package projeto_mc322;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Map extends JPanel {
    
    // Instance Variables
    private final int linhas;
    private final int colunas;
    private final int tamanhoPixel = 30;
    private Color[][] background;
    private Shape block;
    private Shape[] blocks;
    // private Projection projection;

    // Constructor
    public Map(JPanel position){
        this.setBounds(position.getBounds());
        this.setBackground(position.getBackground());
        this.setBorder(position.getBorder());
        this.colunas = position.getWidth()/tamanhoPixel;
        this.linhas = position.getHeight()/tamanhoPixel;


        blocks = new Shape[]{new BlueBar(), new PurpleT(), new GreenS(), new RedZ(), new BlueL(), new OrangeL(), new YellowBox()};
    }
    
    public void initBackground(){
        background = new Color[linhas][colunas];
    }

    // Getters and Setters
    public int getLinhas(){
        return linhas;
    }
    public int getColunas(){
        return colunas;
    }

    // Spawning the shape
    public void spawnShape(){
        Random r = new Random();

        block = blocks[r.nextInt(blocks.length)];
        block.spawn();
    }

    public boolean isBlockOutOfBounds(){
        if(block.getY() < 0){
            block = null;
            return true;
        }
        return false;
    }

    public void shadow(){

    }
    public boolean moveShapeDown(){
        if(checkBottom() == false){
            return false;
        }
        block.moveDown();
        repaint();
        return true;
    }
    public void moveShapeRight(){
        if(block == null) return;
        if(checkRight() == false){
            return;
        }
        block.moveRight();
        repaint();
    }
    public void moveShapeLeft(){
        if(block == null) return;
        if(checkLeft() == false){
            return;
        }
        block.moveLeft();
        repaint();
    }
    public void moveShapeFaterDown(){
        if(block == null) return;
        moveShapeDown();
        repaint();
    }
    public void moveShapeInstantlyDown(){
        if(block == null) return;
        while(checkBottom()){
            moveShapeDown();
        }
        repaint();
    }
    //*************************************** */
    //PROJECTION WORKING AREA
    //***************************************** */
    public void moveProjectionInstantlyDown(Shape projection){
        if(projection == null) return;
        while(checkBottom()){
            moveShapeDown();
        }
        repaint();
    }
    public void rotateShape(){
        if(block == null) return;
        block.rotate();
        if(block.getLeftEdge() < 0) block.setX(0);
        if(block.getRightEdge() >= colunas) block.setX(colunas - block.getWidth());
        if(block.getBottomEdge() >= linhas) block.setY(linhas - block.getHeight());
        repaint();
    }
    private boolean checkBottom(){
        if(block.getBottomEdge() == linhas){
            return false;
        }
        
        int[][]dimensions = block.getDimensions();
        int w = block.getWidth();
        int h = block.getHeight();

        for(int i = 0; i < w; i++){
            for(int j = h-1; j >= 0; j--){
                if(dimensions[j][i] != 0){
                    int x = i + block.getX();
                    int y = j + block.getY()+ 1;
                    if(y < 0) break;
                    if(background[y][x] != null) return false;
                    break;
                }
            }
        }
        return true;
    }
    private boolean checkLeft(){
        if(block.getLeftEdge() == 0){
            return false;
        }
        int[][]dimensions = block.getDimensions();
        int w = block.getWidth();
        int h = block.getHeight();

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(dimensions[i][j] != 0){
                    int x = j + block.getX()-1;
                    int y = i + block.getY();
                    if(y < 0) break;
                    if(background[y][x] != null) return false;
                    break;
                }
            }
        }
        return true;
    }
    private boolean checkRight(){
        if(block.getRightEdge() == colunas){
            return false;
        }
        int[][]dimensions = block.getDimensions();
        int w = block.getWidth();
        int h = block.getHeight();

        for(int i = 0; i < h; i++){
            for(int j = w-1; j >= 0; j--){
                if(dimensions[i][j] != 0){
                    int x = j + block.getX()+1;
                    int y = i + block.getY();
                    if(y < 0) break;
                    if(background[y][x] != null) return false;
                    break;
                }
            }
        }      
        return true;
    }
    public void saveToBackground(){
        int[][] dimensions = block.getDimensions();
        int h = block.getHeight();
        int w = block.getWidth();

        int xPos = block.getX();
        int yPos = block.getY();

        Color color = block.getColor();

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                if(dimensions[i][j] == 1){
                    background[i+yPos][j+xPos] = color;
                }
            }
        }

    }

    // Graaphic interface functions 
    public void paintGrid(Graphics g){
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 10; j++){
                g.drawRect(tamanhoPixel*j, tamanhoPixel*i, tamanhoPixel, tamanhoPixel);
            }
        }
    }
    private Shape spawnProjection(){
        Shape projection = this.block;

        return projection;
    }
    private void paintShape(Graphics g){
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

    private void drawBackground(Graphics g){
        Color color;
        for(int i = 0; i < linhas; i++){
            for(int j = 0; j < colunas; j++){
                color = background[i][j];
                if(color != null){
                    int x = j*tamanhoPixel;
                    int y = i*tamanhoPixel;
                    drawGridSquare(g, color, x, y);
                }
            }
        }
    }

    public int clearLines(){
        boolean lineFilled;
        int linesCleared = 0;
        for(int i = linhas -1; i>= 0; i--){
            lineFilled = true;
            for(int j = 0; j < colunas; j++){
                if(background[i][j] == null){
                    lineFilled = false;
                    break;
                }
            }
            if(lineFilled){
                linesCleared++;
                clearline(i);
                shiftDown(i);
                clearline(0);
                i++;
                repaint();
            }
        }
        return linesCleared;
    }
    private void clearline(int i){
        for(int k = 0; k < colunas; k++){
            background[i][k] = null;
        }
    }

    private void shiftDown(int i){
        for(int k = i; k > 0; k--){
            for(int j = 0; j < colunas; j++){
                background[k][j] = background[k-1][j];
            }
        }
    }

    private void drawGridSquare(Graphics g, Color color, int x, int y){
        g.setColor(color);
        g.fillRect(x, y, tamanhoPixel, tamanhoPixel);
        g.setColor(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        paintGrid(g);
        drawBackground(g);
        paintShape(g);

    }
}