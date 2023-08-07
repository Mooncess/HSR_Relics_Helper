package userInterface;
import java.awt.BorderLayout;
import java.awt.CardLayout;
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
    public ApplicationWindow() {
    	List<gameData.Character> characterList = new ArrayList<>();
        
        String filePath = "src/gameData/CharacterData.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
            	gameData.Character character = new gameData.Character();
            	character.setName(line.substring(1, line.length() - 1));
            	
            	character.setBestRelicSet(ApplicationWindow.readerForSets(br.readLine()));
            	character.setAltRelicSet(ApplicationWindow.readerForSets(br.readLine()));
            	
            	line = br.readLine();
            	int equalsIndex = line.indexOf("="); // Находим индекс знака "="
                String value = line.substring(equalsIndex + 1);
                character.setPlanetarySet(value);
                
                character.setAltPlanetarySet(ApplicationWindow.readerForSets(br.readLine()));
                
                character.setMainBodyStat(ApplicationWindow.readerForMainStat(br.readLine()));
                character.setMainFeetStat(ApplicationWindow.readerForMainStat(br.readLine()));
                character.setMainPlanarSphereStat(ApplicationWindow.readerForMainStat(br.readLine()));
                character.setMainLinkRopeStat(ApplicationWindow.readerForMainStat(br.readLine()));
                
                character.setSubStatTier_1(ApplicationWindow.readerForSubsidiaryStat(br.readLine()));;
                character.setSubStatTier_2(ApplicationWindow.readerForSubsidiaryStat(br.readLine()));;
                character.setSubStatTier_3(ApplicationWindow.readerForSubsidiaryStat(br.readLine()));;
                
                characterList.add(character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
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
        frame.setSize(700, 400);

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
        
        JPanel relicPage = createRelicPage();
        JPanel planetaryPage = createPlanetaryPage();

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

    private JPanel createRelicPage() {
        JPanel relicPage = new JPanel(new BorderLayout(10, 10));    
        
        relicPage.setLayout(new GridLayout(3, 1, 10, 10));
        
        JPanel middlePanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel mainStatPanel = new JPanel();
        JPanel subStatPanel = new JPanel();
        
        String filePath = "src/gameData/RelicSet.txt";
        List<String> relicList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
            	relicList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Создание элементов списка
        String[] relics = new String[relicList.size()];
        
        for (int i = 0; i < relicList.size(); i++) {
        	relics[i] = relicList.get(i); // преобразуем строку в значение enum
        }

        // Создание выпадающего списка
        JComboBox<String> comboBox = new JComboBox<>(relics);
        JLabel middleLabel = new JLabel("Relic Set");
        middlePanel.add(middleLabel);
        middlePanel.add(comboBox);
        
        JRadioButton head = new JRadioButton("Head");
        JRadioButton hands = new JRadioButton("Hands");
        JRadioButton body = new JRadioButton("Body");
        JRadioButton feet = new JRadioButton("Feet");
        
        JRadioButton mHP = new JRadioButton("HP");
        JRadioButton mATK = new JRadioButton("ATK");
        JRadioButton mSPD = new JRadioButton("SPD");
        JRadioButton mHPp = new JRadioButton("HP%");
        
        head.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mHP.setSelected(true);
            	mHP.setEnabled(false);
            	mATK.setEnabled(false);
            	mSPD.setEnabled(false);
            	mHPp.setEnabled(false);
            }
        });
        
        hands.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mATK.setSelected(true);
            	mATK.setEnabled(false);
            	mHP.setEnabled(false);
            	mSPD.setEnabled(false);
            	mHPp.setEnabled(false);
            }
        });
        
        body.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mHP.setEnabled(true);
            	mATK.setEnabled(true);
            	mSPD.setEnabled(true);
            	mHPp.setEnabled(true);
            }
        });
        
        feet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mHP.setEnabled(true);
            	mATK.setEnabled(true);
            	mSPD.setEnabled(true);
            	mHPp.setEnabled(true);
            }
        });
        
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(head); buttonGroup1.add(hands);
        buttonGroup1.add(body); buttonGroup1.add(feet);
        
        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(mHP); buttonGroup2.add(mATK);
        buttonGroup2.add(mSPD); buttonGroup2.add(mHPp);
        
        buttonPanel.add(head); buttonPanel.add(hands);
        buttonPanel.add(body); buttonPanel.add(feet);
        
        
        mainStatPanel.add(mHP); mainStatPanel.add(mATK);
        mainStatPanel.add(mSPD); mainStatPanel.add(mHPp);
        
        JLabel buttonLabel = new JLabel("Equipment");
        middlePanel.add(buttonLabel);
        middlePanel.add(buttonPanel);
        
        JLabel mainStatLabel = new JLabel("Main stat");
        middlePanel.add(mainStatLabel);
        middlePanel.add(mainStatPanel);

        JCheckBox spd = new JCheckBox("SPD");
        JCheckBox hp = new JCheckBox("HP");
        JCheckBox atk = new JCheckBox("ATK");
        JCheckBox def = new JCheckBox("DEF");
        JCheckBox hpp = new JCheckBox("HP%");
        JCheckBox atkp = new JCheckBox("ATK%");
        JCheckBox defp = new JCheckBox("DEF%");
        JCheckBox breakEffect = new JCheckBox("BREAK EFFECT");
        JCheckBox effectHitRate = new JCheckBox("EFFECT HIT RATE");
        JCheckBox effectRes = new JCheckBox("EFFECT RES");
        JCheckBox critRate = new JCheckBox("CRIT RATE");
        JCheckBox critDmg = new JCheckBox("CRIT DMG");
        
        JLabel subStatLabel = new JLabel("Subsidiary stats");
        subStatPanel.add(subStatLabel);
        subStatPanel.add(spd);
        subStatPanel.add(hp);
        subStatPanel.add(atk);
        subStatPanel.add(def);
        subStatPanel.add(hpp);
        subStatPanel.add(atkp);
        subStatPanel.add(defp);
        subStatPanel.add(breakEffect);
        subStatPanel.add(effectHitRate);
        subStatPanel.add(effectRes);
        subStatPanel.add(critRate);
        subStatPanel.add(critDmg);
        
        relicPage.add(middlePanel);
        relicPage.add(subStatPanel);
        
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
    
    private static String[] readerForSets(String line) {
    	int equalsIndex = line.indexOf("="); // Находим индекс знака "="
        String values = line.substring(equalsIndex + 1); // Получаем подстроку после знака "="
        String[] valuesArray = values.split(","); // Разделяем подстроку по запятым и получаем массив значений
    	return valuesArray; 
    }
    
    private static MainStat[] readerForMainStat(String line) {
    	int equalsIndex = line.indexOf("="); // Находим индекс знака "="
        String values = line.substring(equalsIndex + 1); // Получаем подстроку после знака "="
        String[] valuesArray = values.split(","); // Разделяем подстроку по запятым и получаем массив значений
        MainStat[] result = new MainStat[valuesArray.length];
        
        for (int i = 0; i < valuesArray.length; i++) {
            result[i] = MainStat.valueOf(valuesArray[i]); // преобразуем строку в значение enum
        }
        return result; 
    }
    
    private static SubsidiaryStat[] readerForSubsidiaryStat(String line) {
    	int equalsIndex = line.indexOf("="); // Находим индекс знака "="
        String values = line.substring(equalsIndex + 1); // Получаем подстроку после знака "="
        String[] valuesArray = values.split(","); // Разделяем подстроку по запятым и получаем массив значений
        SubsidiaryStat[] result = new SubsidiaryStat[valuesArray.length];
        
        for (int i = 0; i < valuesArray.length; i++) {
            result[i] = SubsidiaryStat.valueOf(valuesArray[i]); // преобразуем строку в значение enum
        }
        return result; 
    }
}
