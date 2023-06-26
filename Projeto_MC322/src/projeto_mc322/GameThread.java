package projeto_mc322;

public class GameThread extends MovementThread{
    protected SPMapForm mf;

    public GameThread(Map mp, SPMapForm mf){
        super(mp);
        this.mf = mf;
        mf.updateScore(score);
        mf.updateLevel(level);
    }

    public SPMapForm getMf() {
        return this.mf;
    }

    public void setMf(SPMapForm mf) {
        this.mf = mf;
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

    @Override
    public String toString() {
        return "{" +
            " mf='" + getMf() + "'" +
            "}";
    }

}
