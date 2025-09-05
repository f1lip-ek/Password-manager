import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SwitchingPanels extends JPanel {

    private final ListOfPasswords listOfPasswords; //Panel1
    private final SettingProperties settingProperties; //Panel2
    private final GeneratedPassword generatedPassword; //Panel3
    private final NewPassword newPassword; //Panel4
    private final PasswordView passwordView; //Panel5
    private final CardLayout cardLayout;

    public static int index = 0;

    public SwitchingPanels() {
        this.settingProperties = new SettingProperties();
        this.generatedPassword = new GeneratedPassword();
        this.listOfPasswords = new ListOfPasswords();
        this.newPassword = new NewPassword();
        this.passwordView = new PasswordView();
        this.cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.add(listOfPasswords, "Panel1");
        this.add(settingProperties, "Panel2");
        this.add(generatedPassword, "Panel3");
        this.add(newPassword, "Panel4");
        this.add(passwordView, "Panel5");
        this.cardLayout.show(this, "Panel1");
        act();
    }

    public void act(){
        SettingProperties.generatePassword.addActionListener(_ -> {
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
        });

        SettingProperties.cancel.addActionListener(_ -> {
            settingProperties.getLength().setText("");
            cardLayout.show(SwitchingPanels.this, "Panel4");
        });

        GeneratedPassword.goBack.addActionListener(_ -> {
            RandomGenerator.password = "";

            cardLayout.show(SwitchingPanels.this, "Panel2");
        });

        GeneratedPassword.regeneratePassword.addActionListener(_ -> {
            settingProperties.getRg().generatePassword();
            generatedPassword.password.setText(RandomGenerator.password);
        });

        GeneratedPassword.goBackAndFillItInCollum.addActionListener(_ -> {
            newPassword.getPassword().setText(RandomGenerator.password);
            cardLayout.show(SwitchingPanels.this, "Panel4");
        });

        ListOfPasswords.newPassword.addActionListener(_ -> cardLayout.show(SwitchingPanels.this, "Panel4"));

        NewPassword.generateNewPassword.addActionListener(_ -> cardLayout.show(SwitchingPanels.this, "Panel2"));

        NewPassword.cancel.addActionListener(_ -> {
            newPassword.getWebsite().setText("");
            newPassword.getUsername().setText("");
            newPassword.getPassword().setText("");
            reloadList();
            cardLayout.show(SwitchingPanels.this, "Panel1");
        });

        NewPassword.save.addActionListener(_ -> {

            fileWriting();

            listOfPasswords.getList_of_password().addNewPassword(
                    newPassword.getWebsite().getText(),
                    newPassword.getUsername().getText(),
                    newPassword.getPassword().getText()
            );
            reloadList();
            cardLayout.show(SwitchingPanels.this, "Panel1");
        });

        reloadList();

        PasswordView.back.addActionListener(_ -> cardLayout.show(SwitchingPanels.this, "Panel1"));
    }

    public void fileWriting(){
        try{
            BufferedWriter bw1 = new BufferedWriter(new FileWriter("res\\websites.txt", true));
            BufferedWriter bw2 = new BufferedWriter(new FileWriter("res\\usernames.txt", true));
            BufferedWriter bw3 = new BufferedWriter(new FileWriter("res\\passwords.txt", true));


            bw1.newLine();
            bw1.write(newPassword.getWebsite().getText());
            bw1.flush();

            bw2.newLine();
            bw2.write(newPassword.getUsername().getText());
            bw2.flush();

            bw3.newLine();
            bw3.write(newPassword.getPassword().getText());
            bw3.flush();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setPasswordView(){
        passwordView.removeAll();
        passwordView.setWebsitePanel();
        passwordView.setUsernamePanel();
        passwordView.setPasswordPanel();
        passwordView.add(PasswordView.back);
    }

    public void reloadList(){
        for (int i = 0; i < List_of_password.list.size(); i++) {
            List_of_password.list.get(i).setItemIndex(i);
            int iFor = i;
            List_of_password.list.get(i).addActionListener(_ -> {
                SwitchingPanels.index = List_of_password.list.get(iFor).getItemIndex();
                setPasswordView();
                cardLayout.show(SwitchingPanels.this, "Panel5");
            });
        }
    }

}
