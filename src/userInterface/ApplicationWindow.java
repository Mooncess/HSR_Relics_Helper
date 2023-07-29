package userInterface;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class ApplicationWindow extends JFrame {
	private JPanel menu;
    private CardLayout menuLayout;

    public ApplicationWindow() {
        setTitle("HSR_Relics_Helper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание панели для карточек
        menu = new JPanel();
        menuLayout = new CardLayout();
        menu.setLayout(menuLayout);

        // Создание и добавление карточек на панель
        menu.add(createRelicPage(), "relicPage");
        menu.add(createPlanetaryPage(), "planetaryPage");

        // Создание кнопок для переключения карточек
        JButton relicsButton = new JButton("Relic sets");
        JButton planetaryButton = new JButton("Planetary Sets");

        // Добавление обработчика событий для кнопок
        relicsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuLayout.show(menu, "relicPage");
            }
        });

        planetaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuLayout.show(menu, "planetaryPage");
            }
        });

        // Создание панели для кнопок и добавление их на нее
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(relicsButton);
        buttonPanel.add(planetaryButton);

        // Добавление панели с карточками и панели с кнопками на окно
        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        getContentPane().add(menu, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    private JPanel createRelicPage() {
        JPanel relicPage = new JPanel(new BorderLayout(10, 10));
        
        Dimension preferredSize = new Dimension(100, 30);
        
        relicPage.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        relicPage.setLayout(new GridLayout(3, 2, 10, 10));
        
        JLabel spd = new JLabel("SPD");
        JTextField spd_field = new JTextField(1);
        spd_field.setPreferredSize(preferredSize);
        JLabel hp = new JLabel("HP");
        JTextField hp_field = new JTextField(1);
        hp_field.setPreferredSize(preferredSize);
        JLabel atk = new JLabel("ATK");
        atk.setPreferredSize(preferredSize);
        JTextField atk_field = new JTextField(1);
        
        relicPage.add(spd); relicPage.add(spd_field);
        relicPage.add(hp); relicPage.add(hp_field);
        relicPage.add(atk); relicPage.add(atk_field);
        
        return relicPage;
    }
    
    private JPanel createPlanetaryPage() {
        JPanel relicPage = new JPanel();
        
        JLabel rText = new JLabel("Planetary");
        relicPage.add(rText);
        
        JLabel spd = new JLabel("SPD");
        JTextField spd_field = new JTextField();
        JLabel hp = new JLabel("HP");
        JTextField hp_field = new JTextField();
        JLabel atk = new JLabel("ATK");
        JTextField atk_field = new JTextField();
        
        relicPage.add(spd); relicPage.add(spd_field);
        relicPage.add(hp); relicPage.add(hp_field);
        relicPage.add(atk); relicPage.add(atk_field);
        
        return relicPage;
    }
}
