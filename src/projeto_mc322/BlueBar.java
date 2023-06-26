package projeto_mc322;

import java.awt.Color;

public class BlueBar extends Shape {

    /**
     * Shape: blue rectangle 1x4 
     */
    public BlueBar(){
        super(new int[][]{{1, 1, 1, 1}}, Color.cyan);
    }

    /**
     * rotation of the shape
     */
    public void rotate(){
        super.rotate();
        if(this.getWidth() == 1){
            this.setX(this.getX() +1);
            this.setY(this.getY() -1);
        }
        else{
            this.setX(this.getX() -1);
            this.setY((this.getY()+1));
        }
    }
}
