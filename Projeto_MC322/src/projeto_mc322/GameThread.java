package projeto_mc322;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GameThread extends Thread{

    protected Map mp;
    protected MapForm mf;
    protected int score;
    protected int level = 1;
    protected int scorePerLevel = 3;
    protected int pause = 1000;
    protected int decreasePause = (int) Math.floor(pause*(0.1));

    public GameThread(Map mp, MapForm mf){
        this.mp = mp;
        this.mf = mf;
        mf.updateScore(score);
        mf.updateLevel(level);
    }
    public void updatePause(){
        decreasePause = (int) Math.floor(pause*(0.1)); 
    }
    public void run(){
        while(true){
            mp.spawnShape();
            while(mp.moveShapeDown()){
                try{
                    Thread.sleep(pause);
                }
                catch(InterruptedException ex){
                    return;
                }
            }
            if(mp.isBlockOutOfBounds()){
                Projeto_MC322.gameOver(score);
                break;
            }
            mp.saveToBackground();
            score += mp.clearLines();
            mf.updateScore(score);

            int lvl = score/scorePerLevel +1;
            if(score >= 30){
                pause = 50;
            }
            if(lvl > level){
                level = lvl;
                mf.updateLevel(level);
                pause -= decreasePause;
                updatePause();
                System.out.println("PAUSA: " + pause + " DP " + decreasePause);
            }
        }
    }
}
