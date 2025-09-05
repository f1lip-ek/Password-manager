import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class GeneratedPassword extends JPanel {

    public JTextField password;
    public static JButton goBack;
    public static JButton goBackAndFillItInCollum;
    public static JButton regeneratePassword;
    private final JButton copyToClipboard;
    private final JPanel panel;

    public GeneratedPassword() {
        this.panel = new JPanel();
        goBack =  new JButton("Go Back to set different properties");
        this.password = new JTextField("act");
        this.copyToClipboard = new JButton("Copy to clipboard");
        regeneratePassword = new JButton("Regenerate password");
        goBackAndFillItInCollum = new JButton("Go Back and fill it in password collum");
        setPanel();
        this.setLayout(new BorderLayout());
        this.setSize(250, 250);
        this.add(new JLabel("Generated password:"), BorderLayout.NORTH);
        this.add(this.password, BorderLayout.CENTER);
        setButtons();
    }

    public void setPanel() {
        this.password.setText(RandomGenerator.password);
        this.password.setEditable(false);
        this.password.setBorder(null);
        this.password.setBackground(null);
        this.password.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void setButtons(){
        setCopyButton();
        this.panel.setLayout(new GridLayout(4, 1));
        this.panel.add(copyToClipboard);
        this.panel.add(regeneratePassword);
        this.panel.add(goBack);
        this.panel.add(goBackAndFillItInCollum);
        this.add(this.panel, BorderLayout.SOUTH);
    }

    public void setCopyButton(){
        this.copyToClipboard.addActionListener(_ -> {
            StringSelection stringSelection = new StringSelection(RandomGenerator.password);

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            clipboard.setContents(stringSelection, null);
        });
    }


}
