import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SettingProperties extends JPanel {

    public static JButton generatePassword;
    public static JButton cancel;
    private final JCheckBox upperCase;
    private final JCheckBox lowerCase;
    private final JCheckBox numbers;
    private final JCheckBox special;
    private final JTextField length;
    private final JLabel napis;
    private final RandomGenerator rg;

    public SettingProperties() {
        this.napis = new JLabel("Password generator");
        generatePassword = new JButton("Generate password");
        cancel = new JButton("Cancel");
        this.upperCase = new JCheckBox("Upper case");
        this.lowerCase = new JCheckBox("Lower case");
        this.numbers = new JCheckBox("Numbers");
        this.special = new JCheckBox("Special characters");
        this.length = new JTextField("");
        rg = new RandomGenerator();
        this.setLayout(new BorderLayout());
        setPanelCheckBoxes();
        setPanelLenght();
        setPanelButton();
    }

    public void setPanelCheckBoxes(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(upperCase);
        panel.add(lowerCase);
        panel.add(numbers);
        panel.add(special);
        this.add(panel, BorderLayout.CENTER);
        setParameters();
        setDefault();
    }

    public void setPanelLenght(){
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(napis, BorderLayout.NORTH);
        panel1.add(length, BorderLayout.SOUTH);
        this.add(panel1, BorderLayout.NORTH);
        this.length.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    generatePassword.doClick();
                }
            }
        });
    }

    public void setPanelButton(){
        JPanel panelButton = new JPanel();
        panelButton.setLayout(new GridLayout(1, 2));
        panelButton.add(cancel);
        panelButton.add(generatePassword);
        this.add(panelButton, BorderLayout.SOUTH);
    }

    public void setParameters(){
        this.upperCase.addActionListener(e -> {
            if (upperCase.isSelected()) {
                RandomGenerator.user.setUpperCase(true);
            }
        });
        this.lowerCase.addActionListener(e -> {
            if (lowerCase.isSelected()) {
                RandomGenerator.user.setLowerCase(true);
            }
        });
        this.numbers.addActionListener(e -> {
            if (numbers.isSelected()) {
                RandomGenerator.user.setNumbers(true);
            }
        });
        this.special.addActionListener(e -> {
            if (special.isSelected()) {
                RandomGenerator.user.setSpecial(true);
            }
        });
    }

    public void setDefault(){
        this.upperCase.setSelected(true);
        this.lowerCase.setSelected(true);
        this.numbers.setSelected(true);
        this.special.setSelected(true);
    }

    public JCheckBox getUpperCase() {
        return upperCase;
    }

    public JCheckBox getLowerCase() {
        return lowerCase;
    }

    public JCheckBox getNumbers() {
        return numbers;
    }

    public JCheckBox getSpecial() {
        return special;
    }

    public JTextField getLength() {
        return length;
    }

    public RandomGenerator getRg() {
        return rg;
    }
}
