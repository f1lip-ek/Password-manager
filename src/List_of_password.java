import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class List_of_password extends JScrollPane {

    // Výška jednoho panelu pro výpočet preferované výšky
    public static final int PANEL_HEIGHT = 25;
    // Mezera mezi panely
    public static final int VERTICAL_STRUT_HEIGHT = 10;
    // Počet panelů, které mají být viditelné bez rolování
    public static final int VISIBLE_PANEL_COUNT = 10;

    // Vypočítáme preferovanou výšku pro JScrollPane
    // (Visible panely * výška panelu) + (počet mezer * výška mezery) + malý padding
    int preferredScrollPanelHeight = (VISIBLE_PANEL_COUNT * PANEL_HEIGHT) +
            ((VISIBLE_PANEL_COUNT - 1) * VERTICAL_STRUT_HEIGHT) + 20; // Přidáme trochu místa navíc pro okraj

    private final JPanel mainPanel;
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
            if (i < this.list.size()) { // Přidáme mezeru, jen pokud to není poslední panel
                mainPanel.add(Box.createVerticalStrut(VERTICAL_STRUT_HEIGHT));
            }
        }
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void addPassword(){
        this.list.add(new Password("google.com", "filip", "1234567890"));
        this.list.add(new Password("seznam.cz", "karel", "1234567890"));
        setScrollPane();
    }
}
