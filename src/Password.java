import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Password extends JPanel {

    private final String website;
    private final String username;
    private final String password;

    public Password(String website, String username, String password) {
        this.website = website;
        this.username = username;
        this.password = password;
        this.setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.setPreferredSize(new Dimension(250, List_of_password.PANEL_HEIGHT));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, List_of_password.PANEL_HEIGHT));
        this.setMinimumSize(new Dimension(250, List_of_password.PANEL_HEIGHT));
        this.setAlignmentX(Component.CENTER_ALIGNMENT); // Centering panels horizontally in BoxLayout
        JLabel label = new JLabel(website);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.BLACK);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(label, BorderLayout.NORTH);
        setEvent();
    }

    public void setEvent(){
        this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(SwingUtilities.isLeftMouseButton(e)){
                        JOptionPane.showMessageDialog(null, "Website: " + website + "\nUsername: " + username + "\nPassword: " + password);
                    }
                }
            }
        );
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    System.out.println("karel");
                }
            }
        });
    }
}
