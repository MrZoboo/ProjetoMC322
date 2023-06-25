package projeto_mc322;

import javax.swing.JPanel;

public class Bag extends JPanel{
    private final int linhas;
    private final int colunas;
    private final int tamanhoPixel = 10;

    public Bag(JPanel bagPanel){
        this.setBounds(bagPanel.getBounds());
        this.setBackground(bagPanel.getBackground());
        this.setBorder(bagPanel.getBorder());
        this.colunas = bagPanel.getWidth()/tamanhoPixel;
        this.linhas = bagPanel.getHeight()/tamanhoPixel;
    }
}
