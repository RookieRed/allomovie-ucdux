package keita.rookiered.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton mainMenuButton;
    private JPanel headerPanel;
    private JPanel mainPanel;
    private JPanel contentPanel;
    private JPanel accueilPanel;
    private JPopupMenu mainMenu;
    private CardLayout cardsLayout;

    public MainFrame() {
        super("Réservez vos séances de film avec cette super app du turfu !");
        init();
        setContentPane(mainPanel);
        setSize(400, 500);
        //setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void init() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Init main menu
        mainMenu = new JPopupMenu("Menu principal");
        JMenuItem seConnecter = new JMenuItem("Se connecter");
        JMenuItem mesRéservations = new JMenuItem("Mes réservations");
        JMenuItem aide = new JMenuItem("Aide");
        // Assemblage
        mainMenu.add(seConnecter);
        mainMenu.add(mesRéservations);
        mainMenu.add(aide);
        mainMenuButton.setComponentPopupMenu(mainMenu);
        mainMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu.show(MainFrame.this.mainMenuButton, -10, 0);
            }
        });

        // Conteneur principale
        accueilPanel = new RechercheFilms().getMainPane();
        cardsLayout = (CardLayout) contentPanel.getLayout();
        contentPanel.add(accueilPanel, "a");
        cardsLayout.show(contentPanel, "a");
    }
}
