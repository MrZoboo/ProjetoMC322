package projeto_mc322;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GameThread extends Thread{

    private Map mp;
    private MapForm mf;
    private int score;
    private int level = 1;
    private int scorePerLevel = 3;
    private int pause = 1000;
    private int decreasePause = 100;

    public GameThread(Map mp, MapForm mf){
        this.mp = mp;
        this.mf = mf;
        mf.updateScore(score);
        mf.updateLevel(level);
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
            if(lvl > level){
                level = lvl;
                mf.updateLevel(level);
                pause -= decreasePause;
            }
        }
    }
}
