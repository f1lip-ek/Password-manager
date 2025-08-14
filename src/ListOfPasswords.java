import javax.swing.*;
import java.awt.*;

public class ListOfPasswords extends JPanel {

    private final List_of_password listOfPasswords;
    public static JButton newPassword;

    public ListOfPasswords() {
        this.listOfPasswords = new List_of_password();
        newPassword = new JButton("Add new password");
        this.setLayout(new BorderLayout());
        this.add(this.listOfPasswords, BorderLayout.NORTH);
        this.add(newPassword, BorderLayout.SOUTH);
    }

    public List_of_password getList_of_password() {
        return listOfPasswords;
    }

}
