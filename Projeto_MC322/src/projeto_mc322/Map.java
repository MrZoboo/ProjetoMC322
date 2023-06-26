package projeto_mc322;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Map extends JPanel implements PanelAsset {
    
    // Instance Variables
    private int linhas;
    private int colunas;
    private int tamanhoPixel = 30;
    private Color[][] background;
    private Shape block;
    private Shape[] blocks;
    protected Shape bag;
    protected boolean isBagEmpty = true;
    protected boolean canSave = true;
    private Shape projection;
    public Bag bagStructure;
    public Queue queueStructure;


    // Constructor
    public Map(JPanel position){


        this.setBounds(position.getBounds());
        this.setBackground(position.getBackground());
        this.setBorder(position.getBorder());
        this.colunas = position.getWidth()/tamanhoPixel;
        this.linhas = position.getHeight()/tamanhoPixel;


        blocks = new Shape[]{new BlueBar(), new PurpleT(), new GreenS(), new RedZ(), new BlueL(), new OrangeL(), new YellowBox()};
    }
    
    public void initNextBlocks(){
        for(int i = 0; i < 7; i++){
            Random r = new Random();
            queueStructure.nextBlocks.add(blocks[r.nextInt(blocks.length)]);
        }
        
    }
    public void addNextBlockToQueue(){
        queueStructure.nextBlocks.remove(0);
        Random r = new Random();
        queueStructure.nextBlocks.add(blocks[r.nextInt(blocks.length)]);
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
        canSave = true;
        block = queueStructure.nextBlocks.get(0);
        addNextBlockToQueue();

        block.spawn();
        this.projection = spawnProjection();
        projection.spawn();

        
        repaint();
    }
    public void spawnNextShape(){
        // Random r = new Random();
        // block = blocks[r.nextInt(blocks.length)];
        block = queueStructure.nextBlocks.get(0);
        addNextBlockToQueue();
        block.spawn();
        this.projection = spawnProjection();
        projection.spawn();

        
        repaint();
    }
    public void spawnBagShape(Shape bag){
        block = new Shape(bag.getDimensions(), bag.getColor());
        block.spawn();
        this.projection = spawnProjection();
        projection.spawn();

        repaint();
    }

    public boolean isBlockOutOfBounds(){
        if(block.getY() < 0){
            block = null;
            return true;
        }
        return false;
    }
    
    public void saveToBag(){
        if(canSave){
            if(isBagEmpty){
                bag = new Shape(block.getAllRotations()[1], block.getColor());
                
                spawnNextShape();
                isBagEmpty = false;
                canSave = false;
                bag.setX(1);
                bag.setY(2);
                bagStructure.bag =bag;
                bagStructure.repaint();
                return;
            }
            else{
                
                Shape tmp = new Shape(bag.getDimensions(), bag.getColor());
                bag = new  Shape(block.getAllRotations()[1], block.getColor());
                bag.setX(1);
                bag.setY(2);
                bagStructure.bag = bag;
                bagStructure.repaint();
                spawnBagShape(tmp);

                canSave = false;
                return;
            }
        }
        else{
            return;
        }

        
    }
    public boolean moveShapeDown(){
        if(checkBottom() == false){
            return false;
        }
        block.moveDown();

        updateProjection(projection);


        repaint();
        return true;
    }
    public void moveShapeRight(){
        if(block == null) return;
        if(checkRight() == false){
            return;
        }
        block.moveRight();


        updateProjection(projection);

        repaint();
    }
    public void moveShapeLeft(){
        if(block == null) return;
        if(checkLeft() == false){
            return;
        }
        block.moveLeft();

        updateProjection(projection);

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
        while(projectionCheckBottom(projection)){
            moveProjectionDown(projection);
        }
        repaint();
    }
    private boolean projectionCheckBottom(Shape projection){
        if(projection.getBottomEdge() == linhas){
            return false;
        }
        
        int[][]dimensions = projection.getDimensions();
        int w = projection.getWidth();
        int h = projection.getHeight();

        for(int i = 0; i < w; i++){
            for(int j = h-1; j >= 0; j--){
                if(dimensions[j][i] != 0){
                    int x = i + projection.getX();
                    int y = j + projection.getY()+ 1;
                    if(y < 0) break;
                    if(background[y][x] != null) return false;
                    break;
                }
            }
        }
        return true;
    }
    public boolean moveProjectionDown(Shape projection){
        if(projectionCheckBottom(projection) == false){
            return false;
        }
        projection.moveDown();
        repaint();
        return true;
    }
    //*********************************************************** */


    public void rotateShape(){
        if(block == null) return;
        block.rotate();
        if(block.getLeftEdge() < 0) block.setX(0);
        if(block.getRightEdge() >= colunas) block.setX(colunas - block.getWidth());
        if(block.getBottomEdge() >= linhas) block.setY(linhas - block.getHeight());

        updateProjection(projection);

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
    //***************** */
    private Shape spawnProjection(){
        Shape projection = new Shape(block.getDimensions(), block.getColor());
        updateProjection(projection);
        return projection;
    }
    private void updateProjection(Shape projection){
        projection.setDimensions(block.getDimensions());
        projection.setX(block.getX());
        projection.setY(block.getY());
        projection.color = Color.gray;
        moveProjectionInstantlyDown(projection);
    }
    private void paintProjection(Graphics g, Shape projection){
        int h = projection.getHeight();
        int w = projection.getWidth();
        Color color = projection.getColor();
        int[][] dimensions = projection.getDimensions();

        for(int i = 0; i < h; i++){
            for(int j = 0; j< w;j++){
                if(dimensions[i][j] == 1){
                    int x = (j + projection.getX())*tamanhoPixel;
                    int y = (i + projection.getY())*tamanhoPixel;
                    drawGridSquare(g, color, x, y);
                }
            }
        }
    }
    //********************************* */


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
                if(background[i][j] == null || background[i][j] == Color.darkGray){
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

    public void liftBarrier(){
        shiftUp();
        paintGrayBarrier();
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
    private void shiftUp(){
        if(!checkBottom()){
            block.setY(block.getY()-1);
        }
        for(int k = 0; k < linhas -1 ; k++){
            for(int j = 0; j < colunas; j++){
                background[k][j] = background[k+1][j];
                
            }
        }
        paintGrayBarrier();
    }
    private void paintGrayBarrier(){
        for(int k = 0; k < colunas; k++){
            background[linhas-1][k] = Color.darkGray;
        }
    }

    public void drawGridSquare(Graphics g, Color color, int x, int y){
        g.setColor(color);
        g.fillRect(x, y, tamanhoPixel, tamanhoPixel);
        g.setColor(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g){
        // bagStructure.repaint();
        queueStructure.repaint();
        super.paintComponent(g);
        paintGrid(g);
        drawBackground(g);
        paintProjection(g, projection);
        try{
            paintShape(g);
        }
        catch(Exception e){

        }





    }
}
