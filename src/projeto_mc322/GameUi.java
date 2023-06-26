package projeto_mc322;

import javax.swing.JFrame;

public abstract class GameUi extends JFrame {
    
    protected Map mp;
    protected Map mp2;
    protected GameThread gt;
    protected MPGameThread gt1;
    protected MPGameThread gt2;
    protected Bag bg;
    protected Bag bg2;
    protected Queue q;
    protected Queue q2;

    public GameUi(){
        initControls();
    }

    public Map getMp() {
        return this.mp;
    }

    public void setMp(Map mp) {
        this.mp = mp;
    }

    public GameThread getGt() {
        return this.gt;
    }

    public void setGt(GameThread gt) {
        this.gt = gt;
    }

    public Bag getBg() {
        return this.bg;
    }

    public void setBg(Bag bg) {
        this.bg = bg;
    }

    public Queue getQ() {
        return this.q;
    }

    public void setQ(Queue q) {
        this.q = q;
    }

    public Map getMp2() {
        return this.mp2;
    }

    public void setMp2(Map mp2) {
        this.mp2 = mp2;
    }

    public MPGameThread getGt1() {
        return this.gt1;
    }

    public void setGt1(MPGameThread gt1) {
        this.gt1 = gt1;
    }

    public MPGameThread getGt2() {
        return this.gt2;
    }

    public void setGt2(MPGameThread gt2) {
        this.gt2 = gt2;
    }

    public Bag getBg2() {
        return this.bg2;
    }

    public void setBg2(Bag bg2) {
        this.bg2 = bg2;
    }

    public Queue getQ2() {
        return this.q2;
    }

    public void setQ2(Queue q2) {
        this.q2 = q2;
    }


    protected abstract void initControls();

    public abstract void startGame();

    protected abstract void menuButtonActionPerformed(java.awt.event.ActionEvent evt);
}
