import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class List_of_password extends JScrollPane {

    // Height of 1 panel for calculation preferred height
    public static final int PANEL_HEIGHT = 25;
    // Free space between panels
    public static final int VERTICAL_STRUT_HEIGHT = 10;
    // Num of panels, which have to be visible without rolling
    public static final int VISIBLE_PANEL_COUNT = 10;

    // We calculate the preferred height for the JScrollPane
    // (Visible panels * panel height) + (num of spaces * height of space) + small padding
    int preferredScrollPanelHeight = (VISIBLE_PANEL_COUNT * PANEL_HEIGHT) +
            ((VISIBLE_PANEL_COUNT - 1) * VERTICAL_STRUT_HEIGHT) + 20; // We add a little extra space for the margin

    public final JPanel mainPanel;
    private final ArrayList<Password> list;

    public List_of_password() {
        this.mainPanel = new JPanel();
        this.list = new ArrayList<>();
        this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS));
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setPreferredSize(new Dimension(250, preferredScrollPanelHeight));
        this.setViewportView(this.mainPanel);
        addPassword();
        setScrollPane();
    }

    public void setScrollPane(){
        mainPanel.removeAll();
        for (int i = 0; i < this.list.size(); i++) {
            this.mainPanel.add(this.list.get(i));
            if (i < this.list.size()) { // Add a space only if it is not the last panel
                mainPanel.add(Box.createVerticalStrut(VERTICAL_STRUT_HEIGHT));
            }
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void addPassword() {
        ArrayList<String> passwords = new ArrayList<>();
        ArrayList<String> websites = new ArrayList<>();
        ArrayList<String> usernames = new ArrayList<>();
        try {
            BufferedReader br1 = new BufferedReader(new FileReader("res\\passwords.txt"));
            String line;
            while ((line = br1.readLine()) != null) {
                passwords.add(line);
            }
            br1.close();

            BufferedReader br2 = new BufferedReader(new FileReader("res\\usernames.txt"));
            String line2;
            while ((line2 = br2.readLine()) != null) {
                usernames.add(line2);
            }
            br2.close();

            BufferedReader br3 = new BufferedReader(new FileReader("res\\websites.txt"));
            String line3;
            while ((line3 = br3.readLine()) != null) {
                websites.add(line3);
            }
            br3.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        setScrollPane();
        int length = websites.size();
        for (int i = 0; i < length; i++) {
            this.list.add(new Password(websites.get(i), usernames.get(i), passwords.get(i)));
        }
        setScrollPane();
        System.out.println(passwords +"\n"+ usernames +"\n"+ websites);
    }

    // Method to add a single new password and then update the UI
    public void addNewPassword(String website, String username, String password) {
        // Add the new password to the main list of the class
        this.list.add(new Password(website, username, password));

        // Update the UI
        setScrollPane();
    }
}
