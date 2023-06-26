package projeto_mc322;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;


public class MpMapForm extends javax.swing.JFrame {
    
    private Map mp1;
    private Map mp2;
    protected MPGameThread gt1;
    protected MPGameThread gt2;
    private Bag bg1;
    private Bag bg2;
    private Queue q1;
    private Queue q2;

    public MpMapForm() {
        initComponents();
        q1 = new Queue(p1NextShapes);
        q2 = new Queue(p2NextShapes);
        
        mp1 = new Map(p1map);
        mp2 = new Map(p2map);
        
        bg1 = new Bag(p1bag);
        bg2 = new Bag(p2bag);
        
        mp1.bagStructure = bg1;
        mp1.queueStructure = q1;
        
        mp2.bagStructure = bg2;
        mp2.queueStructure = q2;
        
        this.add(bg1);
        this.add(mp1);
        this.add(q1);
        this.add(bg2);
        this.add(mp2);
        this.add(q2);
        
        mp1.initNextBlocks();
        mp2.initNextBlocks();


        initControls();
        
        
    }
    
    public void startGame(){
        mp1.initBackground();
        mp2.initBackground();
        gt1 = new MPGameThread(mp1, mp2, this);
        gt2 = new MPGameThread(mp2, mp1, this);

        gt1.start();
        gt2.start();
    }
    // public void updateScore(int score){
    //     scoreDisplay.setText("Score: "+ score);
    // }
    // public void updateLevel(int level ){
    //     levelDisplay.setText("Level: "+ level);
    // }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        levelDisplay = new javax.swing.JLabel();
        p1NextShapes = new javax.swing.JPanel();
        menuButton = new javax.swing.JButton();
        p1bag = new javax.swing.JPanel();
        p1map = new javax.swing.JPanel();
        scoreDisplay = new javax.swing.JLabel();
        levelDisplay1 = new javax.swing.JLabel();
        p2NextShapes = new javax.swing.JPanel();
        p2bag = new javax.swing.JPanel();
        p2map = new javax.swing.JPanel();
        scoreDisplay1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        levelDisplay.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        levelDisplay.setText("Level: 1");

        p1NextShapes.setBackground(new java.awt.Color(51, 0, 0));

        javax.swing.GroupLayout p1NextShapesLayout = new javax.swing.GroupLayout(p1NextShapes);
        p1NextShapes.setLayout(p1NextShapesLayout);
        p1NextShapesLayout.setHorizontalGroup(
            p1NextShapesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
        );
        p1NextShapesLayout.setVerticalGroup(
            p1NextShapesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );

        menuButton.setText("Menu");
        menuButton.setFocusable(false);
        menuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButtonActionPerformed(evt);
            }
        });

        p1bag.setBackground(new java.awt.Color(51, 0, 0));

        javax.swing.GroupLayout p1bagLayout = new javax.swing.GroupLayout(p1bag);
        p1bag.setLayout(p1bagLayout);
        p1bagLayout.setHorizontalGroup(
            p1bagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
        );
        p1bagLayout.setVerticalGroup(
            p1bagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        p1map.setBackground(new java.awt.Color(51, 0, 0));
        p1map.setPreferredSize(new java.awt.Dimension(301, 481));

        javax.swing.GroupLayout p1mapLayout = new javax.swing.GroupLayout(p1map);
        p1map.setLayout(p1mapLayout);
        p1mapLayout.setHorizontalGroup(
            p1mapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        p1mapLayout.setVerticalGroup(
            p1mapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
        );

        scoreDisplay.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        scoreDisplay.setText("Score: 0");

        levelDisplay1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        levelDisplay1.setText("Level: 1");

        p2NextShapes.setBackground(new java.awt.Color(51, 0, 0));

        javax.swing.GroupLayout p2NextShapesLayout = new javax.swing.GroupLayout(p2NextShapes);
        p2NextShapes.setLayout(p2NextShapesLayout);
        p2NextShapesLayout.setHorizontalGroup(
            p2NextShapesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
        );
        p2NextShapesLayout.setVerticalGroup(
            p2NextShapesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );

        p2bag.setBackground(new java.awt.Color(51, 0, 0));

        javax.swing.GroupLayout p2bagLayout = new javax.swing.GroupLayout(p2bag);
        p2bag.setLayout(p2bagLayout);
        p2bagLayout.setHorizontalGroup(
            p2bagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
        );
        p2bagLayout.setVerticalGroup(
            p2bagLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        p2map.setBackground(new java.awt.Color(51, 0, 0));
        p2map.setPreferredSize(new java.awt.Dimension(301, 481));

        javax.swing.GroupLayout p2mapLayout = new javax.swing.GroupLayout(p2map);
        p2map.setLayout(p2mapLayout);
        p2mapLayout.setHorizontalGroup(
            p2mapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        p2mapLayout.setVerticalGroup(
            p2mapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
        );

        scoreDisplay1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        scoreDisplay1.setText("Score: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(p1bag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(menuButton)))
                .addGap(26, 26, 26)
                .addComponent(p1map, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p1NextShapes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(levelDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scoreDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(p2bag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(p2map, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p2NextShapes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(levelDisplay1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scoreDisplay1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p2map, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p2bag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(p2NextShapes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(scoreDisplay1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(levelDisplay1))
                    .addComponent(p1map, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(p1bag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(menuButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(p1NextShapes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        gt1.interrupt();
        gt2.interrupt();
        this.setVisible(false);
        Projeto_MC322.showMenu();
    }//GEN-LAST:event_menuButtonActionPerformed
    
    private void initControls(){
        InputMap im = this.getRootPane().getInputMap();
        ActionMap  am = this.getRootPane().getActionMap();

        im.put(KeyStroke.getKeyStroke("D"), "d");
        im.put(KeyStroke.getKeyStroke("A"), "a");
        im.put(KeyStroke.getKeyStroke("W"), "w");
        im.put(KeyStroke.getKeyStroke("S"), "s");
        im.put(KeyStroke.getKeyStroke("Q"), "q");
        im.put(KeyStroke.getKeyStroke("E"), "e");
        
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
                mp2.moveShapeRight();
            }
            
        });
        am.put("left", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Left");
                mp2.moveShapeLeft();
            }
            
        });
        am.put("up", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Up");
                mp2.rotateShape();
            }
            
        });
        am.put("down", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Down");
                mp2.moveShapeFaterDown();

            }
            
        });
        am.put("c", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Bag");
                mp2.saveToBag();

            }
            
        });
        am.put("space", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Space");
                mp2.moveShapeInstantlyDown();
                mp2.saveToBackground();
                int tmp = mp2.clearLines();
                gt2.score += tmp;
                for(int i = 0; i < tmp; i++){
                    mp1.liftBarrier();
                }
                // gt2.mf.updateScore(gt2.score);

                int lvl = gt2.score/gt2.scorePerLevel +1;
                if(lvl > gt2.level){
                    gt2.level = lvl;
                    // gt2.mf.updateLevel(gt2.level);
                    gt2.pause -= gt2.decreasePause;
                }
                mp2.spawnShape();
            }
            
        });
        am.put("d", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Right");
                mp1.moveShapeRight();
            }
            
        });
        am.put("a", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Left");
                mp1.moveShapeLeft();
            }
            
        });
        am.put("w", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Up");
                mp1.rotateShape();
            }
            
        });
        am.put("s", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Down");
                mp1.moveShapeFaterDown();

            }
            
        });
        am.put("q", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Bag");
                mp1.saveToBag();

            }
            
        });
        am.put("e", new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Space");
                mp1.moveShapeInstantlyDown();
                mp1.saveToBackground();
                int tmp = mp1.clearLines();
                gt1.score += tmp;
                for(int i = 0; i < tmp; i++){
                    mp2.liftBarrier();
                }
                // gt1.mf.updateScore(gt1.score);

                int lvl = gt1.score/gt1.scorePerLevel +1;
                if(lvl > gt1.level){
                    gt1.level = lvl;
                    // gt1.mf.updateLevel(gt1.level);
                    gt1.pause -= gt1.decreasePause;
                }
                mp1.spawnShape();
            }
            
        });
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MpMapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MpMapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MpMapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MpMapForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MpMapForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel levelDisplay;
    private javax.swing.JLabel levelDisplay1;
    private javax.swing.JButton menuButton;
    private javax.swing.JPanel p1NextShapes;
    private javax.swing.JPanel p1bag;
    private javax.swing.JPanel p1map;
    private javax.swing.JPanel p2NextShapes;
    private javax.swing.JPanel p2bag;
    private javax.swing.JPanel p2map;
    private javax.swing.JLabel scoreDisplay;
    private javax.swing.JLabel scoreDisplay1;
    // End of variables declaration//GEN-END:variables
}
