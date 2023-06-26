package projeto_mc322;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MPGameThread extends Thread{

    protected Map mp;
    protected MpMapForm mf;
    protected int score;
    protected int level = 1;
    protected int scorePerLevel = 3;
    protected int pause = 1000;
    protected int decreasePause = (int) Math.floor(pause*(0.1));
    protected Map opponent;

    public MPGameThread(Map mp, Map opponent,  MpMapForm mf){
        this.mp = mp;
        this.opponent = opponent;
        this.mf = mf;
        // mf.updateScore(score);
        // mf.updateLevel(level);
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
                Projeto_MC322.gameOverMulti();
                break;
            }
            mp.saveToBackground();
            int tmp = mp.clearLines();
            score += tmp;
            for(int i = 0; i < tmp; i++){
                opponent.liftBarrier();
                System.out.println("pintado!");
            }
            // mf.updateScore(score);

            int lvl = score/scorePerLevel +1;
            if(score >= 30){
                pause = 50;
            }
            if(lvl > level){
                level = lvl;
                // mf.updateLevel(level);
                pause -= decreasePause;
                updatePause();
                System.out.println("PAUSA: " + pause + " DP " + decreasePause);
            }
        }
    }
}
