package projeto_mc322;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class MapForm extends JFrame {

    private Map mp;
    private GameThread gt;
    private Bag bg;
    
    public MapForm() {

        initComponents();
        mp = new Map(mapPosition);
        bg = new Bag(bagPanel);
        mp.bagStructure = bg;
        this.add(bg);
        this.add(mp);
        initControls();

    }

    private void initControls(){
        InputMap im = this.getRootPane().getInputMap();
        ActionMap  am = this.getRootPane().getActionMap();

        im.put(KeyStroke.getKeyStroke("RIGHT"), "right");
        im.put(KeyStroke.getKeyStroke("LEFT"), "left");
        im.put(KeyStroke.getKeyStroke("UP"), "up");
        im.put(KeyStroke.getKeyStroke("DOWN"), "down");
        im.put(KeyStroke.getKeyStroke("SPACE"), "space");
        im.put(KeyStroke.getKeyStroke("C"), "c");

        am.put("right", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Right");
                mp.moveShapeRight();
            }
            
        });
        am.put("left", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Left");
                mp.moveShapeLeft();
            }
            
        });
        am.put("up", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Up");
                mp.rotateShape();
            }
            
        });
        am.put("down", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Down");
                mp.moveShapeFaterDown();

            }
            
        });
        am.put("c", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Bag");
                mp.saveToBag();

            }
            
        });
        am.put("space", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Space");
                mp.moveShapeInstantlyDown();
                mp.saveToBackground();
                gt.score += mp.clearLines();
                gt.mf.updateScore(gt.score);

                int lvl = gt.score/gt.scorePerLevel +1;
                if(lvl > gt.level){
                    gt.level = lvl;
                    gt.mf.updateLevel(gt.level);
                    gt.pause -= gt.decreasePause;
                }
                mp.spawnShape();
            }
            
        });
    }
    public void startGame(){
        mp.initBackground();
        gt = new GameThread(mp, this);
        gt.start();
    }
    
    public void updateScore(int score){
        scoreDisplay.setText("Score: "+ score);
    }
    public void updateLevel(int level ){
        levelDisplay.setText("Level: "+ level);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mapPosition = new javax.swing.JPanel();
        scoreDisplay = new javax.swing.JLabel();
        levelDisplay = new javax.swing.JLabel();
        nextShapes = new javax.swing.JPanel();
        menuButton = new javax.swing.JButton();
        bagPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        mapPosition.setBackground(new java.awt.Color(102, 102, 102));
        mapPosition.setPreferredSize(new java.awt.Dimension(301, 481));

        javax.swing.GroupLayout mapPositionLayout = new javax.swing.GroupLayout(mapPosition);
        mapPosition.setLayout(mapPositionLayout);
        mapPositionLayout.setHorizontalGroup(
            mapPositionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        mapPositionLayout.setVerticalGroup(
            mapPositionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
        );

        scoreDisplay.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        scoreDisplay.setText("Score: 0");

        levelDisplay.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        levelDisplay.setText("Level: 1");

        nextShapes.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout nextShapesLayout = new javax.swing.GroupLayout(nextShapes);
        nextShapes.setLayout(nextShapesLayout);
        nextShapesLayout.setHorizontalGroup(
            nextShapesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
        );
        nextShapesLayout.setVerticalGroup(
            nextShapesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );

        menuButton.setText("Menu");
        menuButton.setFocusable(false);
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });

        bagPanel.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout bagPanelLayout = new javax.swing.GroupLayout(bagPanel);
        bagPanel.setLayout(bagPanelLayout);
        bagPanelLayout.setHorizontalGroup(
            bagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bagPanelLayout.setVerticalGroup(
            bagPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bagPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuButton, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(mapPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nextShapes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(levelDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scoreDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mapPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bagPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(menuButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nextShapes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(scoreDisplay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(levelDisplay)))
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButtonActionPerformed
        gt.interrupt();
        this.setVisible(false);
        Projeto_MC322.showMenu();
    }//GEN-LAST:event_menuButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MapForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bagPanel;
    private javax.swing.JLabel levelDisplay;
    private javax.swing.JPanel mapPosition;
    private javax.swing.JButton menuButton;
    private javax.swing.JPanel nextShapes;
    private javax.swing.JLabel scoreDisplay;
    // End of variables declaration//GEN-END:variables
}
