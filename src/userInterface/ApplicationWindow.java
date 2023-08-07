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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import enums.MainStat;
import enums.SubsidiaryStat;
import gameData.CharacterBuilder;

public class ApplicationWindow extends JFrame {
	private JPanel menu;
    private CardLayout menuLayout;  

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
    	
    	
        setTitle("HSR_Relics_Helper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel generalPanel = new JPanel();
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Characteristics");
        model.addColumn("Item");
        
        
        for (gameData.Character i : characterList) {
        	model.addRow(new Object[]{i.getName(), "-", "-"});
        }
   
        JTable table = new JTable(model);

        // Создаем панель прокрутки и добавляем в нее табли
        JScrollPane scrollPane = new JScrollPane(table);
        
        JPanel tableOfCharacters = new JPanel();
        tableOfCharacters.add(scrollPane);

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
        generalPanel.add(buttonPanel, BorderLayout.NORTH);
        generalPanel.add(menu, BorderLayout.CENTER);
        
        getContentPane().add(generalPanel, BorderLayout.WEST);
        getContentPane().add(tableOfCharacters, BorderLayout.EAST);

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
