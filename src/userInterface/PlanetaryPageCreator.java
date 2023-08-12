package userInterface;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlanetaryPageCreator {
	public static JPanel createPlanetaryPage() {
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
