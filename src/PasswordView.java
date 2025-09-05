import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.*;

public class PasswordView extends JPanel {

    private final JLabel websiteLabel;
    private final JLabel usernameLabel;
    private final JLabel passwordLabel;

    private final JPanel websitePanel;
    private final JPanel usernamePanel;
    private final JPanel passwordPanel;

    private final JTextField website;
    private final JTextField username;
    private final JTextField password;

    private final JButton websiteCopy;
    private final JButton usernameCopy;
    private final JButton passwordCopy;

    public static JButton back;

    public PasswordView() {
        this.websitePanel = new JPanel();
        this.usernamePanel = new JPanel();
        this.passwordPanel = new JPanel();

        this.website = new JTextField();
        this.username = new JTextField();
        this.password = new JTextField();

        this.websiteCopy = new JButton("Copy");
        this.usernameCopy = new JButton("Copy");
        this.passwordCopy = new JButton("Copy");

        this.websiteLabel = new JLabel("Website:");
        this.usernameLabel = new JLabel("Username:");
        this.passwordLabel = new JLabel("Password:");

        back = new JButton("Go back");

        this.setLayout(new GridLayout(4, 1));
        setWebsitePanel();
        setUsernamePanel();
        setPasswordPanel();
        this.add(back);
    }

    public void setWebsitePanel(){
        this.websitePanel.setLayout(new GridLayout(3, 1));
        this.website.setText(List_of_password.list.get(SwitchingPanels.index).getWebsite());
        this.websiteCopy.addActionListener(_ -> {
            StringSelection stringSelection = new StringSelection(website.getText());

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            clipboard.setContents(stringSelection, null);
        });
        this.websitePanel.add(websiteLabel);
        this.websitePanel.add(website);
        this.websitePanel.add(websiteCopy);
        this.add(websitePanel);
    }

    public void setUsernamePanel(){
        this.usernamePanel.setLayout(new GridLayout(3, 1));
        this.username.setText(List_of_password.list.get(SwitchingPanels.index).getUsername());
        this.usernameCopy.addActionListener(_ -> {
            StringSelection stringSelection = new StringSelection(username.getText());

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            clipboard.setContents(stringSelection, null);
        });
        this.usernamePanel.add(usernameLabel);
        this.usernamePanel.add(username);
        this.usernamePanel.add(usernameCopy);
        this.add(usernamePanel);
    }

    public void setPasswordPanel(){
        this.passwordPanel.setLayout(new GridLayout(3, 1));
        this.password.setText(List_of_password.list.get(SwitchingPanels.index).getPassword());
        this.passwordCopy.addActionListener(_ -> {
            StringSelection stringSelection = new StringSelection(password.getText());

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            clipboard.setContents(stringSelection, null);
        });
        this.passwordPanel.add(passwordLabel);
        this.passwordPanel.add(password);
        this.passwordPanel.add(passwordCopy);
        this.add(passwordPanel);
    }

}
