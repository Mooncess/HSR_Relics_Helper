package userInterface;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import enums.MainStat;
import enums.SubsidiaryStat;
import gameData.CharacterBuilder;

public class ApplicationWindow extends JFrame { 
	final int WIDTH = 800;
	final int HEIGHT = 500;
    public ApplicationWindow() {
    	List<gameData.Character> characterList = new ArrayList<>();
    	CharacterReader.getCharacterList(characterList);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Characteristics");
        model.addColumn("Item");
        
        
        for (gameData.Character i : characterList) {
        	model.addRow(new Object[]{i.getName(), "-", "-"});
        }
   
        JTable table = new JTable(model);
        
        // Создание главного окна
        JFrame frame = new JFrame("HSR_Relics_Helper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Dimension maxSizeForApplicationWindow = new Dimension(WIDTH, HEIGHT);
        frame.setSize(maxSizeForApplicationWindow);
        frame.setMaximumSize(maxSizeForApplicationWindow);

        // Создание главных панелей - левая и правая
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel(new BorderLayout());

        // Создание верхней панели в левой панели
        JPanel upperPanel = new JPanel();

        // Создание кнопок в верхней панели
        JButton relicsButton = new JButton("Relic sets");
        JButton planetaryButton = new JButton("Planetary Sets");
        upperPanel.add(relicsButton);
        upperPanel.add(planetaryButton);

        // Создание CardLayout для нижней панели
        CardLayout cardLayout = new CardLayout();
        JPanel lowerPanel = new JPanel(cardLayout);
        
        JPanel relicPage = RelicPageCreator.createRelicPage();

        frame.getContentPane().add(relicPage);
        
        JPanel planetaryPage = PlanetaryPageCreator.createPlanetaryPage();

        // Добавление панелей содержимого в нижнюю панель
        lowerPanel.add(relicPage, "relicPage");
        lowerPanel.add(planetaryPage, "planetaryPage");

        // Добавление ActionListener для кнопок
        relicsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(lowerPanel, "relicPage");
            }
        });

        planetaryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(lowerPanel, "planetaryPage");
            }
        });

        // Добавление верхней и нижней панели в левую панель
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(upperPanel, BorderLayout.NORTH);
        leftPanel.add(lowerPanel, BorderLayout.CENTER);

        // Добавление таблицы в правую панель
        rightPanel.add(new JScrollPane(table));

        // Добавление левой и правой панелей в главное окно
        frame.setLayout(new GridLayout(1, 2));
        frame.add(leftPanel);
        frame.add(rightPanel);

        // Отображение главного окна
        frame.setVisible(true);
    }
}
