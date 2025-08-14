import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchingPanels extends JPanel {

    private final SettingProperties settingProperties; //Panel2
    private final GeneratedPassword generatedPassword; //Panel3
    private final ListOfPasswords listOfPasswords; //Panel1
    private final NewPassword newPassword; //Panel4
    private final CardLayout cardLayout;

    public SwitchingPanels() {
        this.settingProperties = new SettingProperties();
        this.generatedPassword = new GeneratedPassword();
        this.listOfPasswords = new ListOfPasswords();
        this.newPassword = new NewPassword();
        this.cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.add(listOfPasswords, "Panel1");
        this.add(settingProperties, "Panel2");
        this.add(generatedPassword, "Panel3");
        this.add(newPassword, "Panel4");
        this.cardLayout.show(this, "Panel1");
        act();
    }

    public void act(){
        SettingProperties.generatePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!settingProperties.getLength().getText().isEmpty() && RandomGenerator.user.isSelected()){
                    RandomGenerator.user.setLength(Integer.parseInt(settingProperties.getLength().getText()));
                    RandomGenerator.user.setUpperCase(settingProperties.getUpperCase().isSelected());
                    RandomGenerator.user.setLowerCase(settingProperties.getLowerCase().isSelected());
                    RandomGenerator.user.setNumbers(settingProperties.getNumbers().isSelected());
                    RandomGenerator.user.setSpecial(settingProperties.getSpecial().isSelected());
                    settingProperties.getRg().generatePassword();
                    generatedPassword.password.setText(RandomGenerator.password);

                    cardLayout.show(SwitchingPanels.this, "Panel3");
                }
            }
        });

        GeneratedPassword.goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RandomGenerator.password = "";

                cardLayout.show(SwitchingPanels.this, "Panel4");
            }
        });

        ListOfPasswords.newPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(SwitchingPanels.this, "Panel4");
            }
        });

        NewPassword.generateNewPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(SwitchingPanels.this, "Panel2");
            }
        });

        NewPassword.cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(SwitchingPanels.this, "Panel1");
            }
        });

        NewPassword.save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
