package keita.rookiered.gui;

import javax.swing.*;
import java.io.Serializable;

public class ContentPanel extends JPanel implements Serializable {

    private String paneName;

    public ContentPanel(String paneName) {
        super();
        setVisible(true);
        this.paneName = paneName;
    }

    public String getPaneName() {
        return paneName;
    }
}