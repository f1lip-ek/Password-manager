import javax.swing.*;

public class MyFrame extends JFrame {

    private final NewPassword panel;

    public MyFrame() {
        this.panel = new NewPassword();
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
