import javax.swing.*;
import java.awt.*;

public class Password extends JButton {

    private final String website;
    private final String username;
    private final String password;
    private int itemIndex;

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
    }

    public String getWebsite(){
        return website;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }
}
