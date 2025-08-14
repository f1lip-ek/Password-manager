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

        this.setLayout(new GridLayout(5, 1));
        this.add(title);
        this.add(websitePanel);
        this.add(usernamePanel);
        this.add(passwordPanel);
        this.add(buttonsPanel);
    }

    public void setWebsitePanel(){
        this.websitePanel.setLayout(new BorderLayout());
        this.websitePanel.add(websiteLabel, BorderLayout.NORTH);
        this.websitePanel.add(website, BorderLayout.SOUTH);
    }

    public void setUsernamePanel(){
        this.usernamePanel.setLayout(new BorderLayout());
        this.usernamePanel.add(usernameLabel, BorderLayout.NORTH);
        this.usernamePanel.add(username, BorderLayout.SOUTH);
    }

    public void setPasswordPanel(){
        this.passwordPanel.setLayout(new BorderLayout());
        this.passwordPanel.add(passwordLabel, BorderLayout.NORTH);
        this.passwordPanel.add(password, BorderLayout.CENTER);
        this.passwordPanel.add(generateNewPassword, BorderLayout.SOUTH);
    }

    public void setButtonsPanel(){
        this.buttonsPanel.setLayout(new BorderLayout());
        this.buttonsPanel.add(save, BorderLayout.WEST);
        this.buttonsPanel.add(cancel, BorderLayout.EAST);
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
