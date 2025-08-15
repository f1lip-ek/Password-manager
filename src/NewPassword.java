import javax.swing.*;
import java.awt.*;

public class NewPassword extends JPanel {


    private final JTextField website;
    private final JTextField username;
    private final JTextField password;

    public static JButton save;
    public static JButton cancel;
    public static JButton generateNewPassword;

    private final JLabel websiteLabel;
    private final JLabel usernameLabel;
    private final JLabel passwordLabel;

    private final JPanel websitePanel;
    private final JPanel usernamePanel;
    private final JPanel passwordPanel;
    private final JPanel buttonsPanel;

    public NewPassword() {
        JLabel title = new JLabel("New password");
        this.website = new JTextField();
        this.website.setEditable(true);
        this.username = new JTextField();
        this.username.setEditable(true);
        this.password = new JTextField();
        this.password.setEditable(true);
        save = new JButton("Save");
        cancel = new JButton("Cancel");
        generateNewPassword = new JButton("Gen. new pass.");
        this.websiteLabel = new JLabel("Website:");
        this.usernameLabel = new JLabel("Username:");
        this.passwordLabel = new JLabel("Password:");

        this.websitePanel = new JPanel();
        this.usernamePanel = new JPanel();
        this.passwordPanel = new JPanel();
        this.buttonsPanel = new JPanel();

        setWebsitePanel();
        setUsernamePanel();
        setPasswordPanel();
        setButtonsPanel();

        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(websitePanel);
        panel.add(usernamePanel);
        panel.add(passwordPanel);
        panel.add(buttonsPanel);
        this.add(panel, BorderLayout.SOUTH);
    }

    public void setWebsitePanel(){
        this.websitePanel.setLayout(new GridLayout(2, 1));
        this.websitePanel.add(websiteLabel);
        this.websitePanel.add(website);
    }

    public void setUsernamePanel(){
        this.usernamePanel.setLayout(new GridLayout(2, 1));
        this.usernamePanel.add(usernameLabel);
        this.usernamePanel.add(username);
    }

    public void setPasswordPanel(){
        this.passwordPanel.setLayout(new GridLayout(3, 1));
        this.passwordPanel.add(passwordLabel);
        this.passwordPanel.add(password);
        this.passwordPanel.add(generateNewPassword);
    }

    public void setButtonsPanel(){
        this.buttonsPanel.setLayout(new GridLayout(1, 2));
        this.buttonsPanel.add(save);
        this.buttonsPanel.add(cancel);
    }

    public JTextField getWebsite() {
        return website;
    }

    public JTextField getUsername() {
        return username;
    }

    public JTextField getPassword() {
        return password;
    }
}
