package projeto_mc322;

public abstract class MovementThread  extends Thread{
    
    protected Map mp;
    protected int score;
    protected int level = 1;
    protected int scorePerLevel = 3;
    protected int pause = 1000 ;
    protected int decreasePause = (int) Math.floor(pause*(0.1));

    public MovementThread(Map mp){
        this.mp = mp;
    }

    public Map getMp() {
        return this.mp;
    }

    public void setMp(Map mp) {
        this.mp = mp;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScorePerLevel() {
        return this.scorePerLevel;
    }

    public void setScorePerLevel(int scorePerLevel) {
        this.scorePerLevel = scorePerLevel;
    }

    public int getPause() {
        return this.pause;
    }

    public void setPause(int pause) {
        this.pause = pause;
    }

    public int getDecreasePause() {
        return this.decreasePause;
    }

    public void setDecreasePause(int decreasePause){
        this.decreasePause = decreasePause;
    }

    public abstract void updatePause();

    public abstract void run();


    @Override
    public String toString() {
        return "{" +
            " mp='" + getMp() + "'" +
            ", score='" + getScore() + "'" +
            ", level='" + getLevel() + "'" +
            ", scorePerLevel='" + getScorePerLevel() + "'" +
            ", pause='" + getPause() + "'" +
            ", decreasePause='" + getDecreasePause() + "'" +
            "}";
    }

}
