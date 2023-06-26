package projeto_mc322;

public class MPGameThread extends MovementThread{

    protected MpMapForm mf;
    protected Map opponent;

    public MPGameThread(Map mp, Map opponent,  MpMapForm mf){
        super(mp);
        this.opponent = opponent;
        this.mf = mf;
    }

    public MpMapForm getMf() {
        return this.mf;
    }

    public void setMf(MpMapForm mf) {
        this.mf = mf;
    }

    public Map getOpponent() {
        return this.opponent;
    }

    public void setOpponent(Map opponent) {
        this.opponent = opponent;
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

            int lvl = score/scorePerLevel +1;
            if(score >= 30){
                pause = 50;
            }
            if(lvl > level){
                level = lvl;
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
            ", opponent='" + getOpponent() + "'" +
            "}";
    }

}
