import javax.swing.*;

public class MyFrame extends JFrame {

    private final SwitchingPanels panel;

    public MyFrame() {
        this.panel = new SwitchingPanels();
        this.setSize(250, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setResizable(false);
        this.pack();
    }

    public void turnOnFrame(){
        this.setVisible(true);
    }

}
