package projeto_mc322;

import java.awt.Color;

public class Shape {
    // Instance variables
    private int[][] dimensions;
    private int[][][] allRotations;
    protected Color color;
    private int x, y;
    private int currentRotation;

    public Shape(int[][] dimensions, Color color){
        this.color = color;
        this.dimensions = dimensions;
        initRotations();
    }
    private void initRotations(){
        allRotations = new int[4][][];
        for(int i = 0; i < 4; i++){
            int l = dimensions.length;
            int c = dimensions[0].length;

            allRotations[i] = new int[c][l];

            for(int k = 0; k < c; k++){
                for(int j = 0; j < l; j++){
                    allRotations[i][k][j] = dimensions[l-j-1][k];
                }
            }
            dimensions = allRotations[i];
        }
    }
    public int[][] getDimensions(){
        return dimensions;
    }
    public void setDimensions(int[][] dimensions){
        this.dimensions = dimensions;
    }
    public Color getColor(){
        return color;
    }
    public int getHeight(){
        return dimensions.length;
    }
    public int getWidth(){
        return dimensions[0].length;
    }
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }


    // Moving the block
    public void moveDown(){
        y++;
    }
    public void moveLeft(){
        x--;
    }
    public void moveRight(){
        x++;
    }
    public void rotate(){
        currentRotation = (currentRotation+1)%4;
        dimensions = allRotations[currentRotation];
    }

    public void spawn(){
        currentRotation = 0;
        dimensions = allRotations[currentRotation];
        y = -getHeight();
        x = 4;
    }
    public int getBottomEdge(){
        return y + getHeight();
    }
    public int getLeftEdge(){
        return x ;
    }
    public int getRightEdge(){
        return x+ getWidth();
    }
    
//    public abstract void xMotion();
//    
//    public abstract void yMotion();
    
    
}
