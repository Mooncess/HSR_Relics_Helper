package userInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import enums.MainStat;
import enums.SubsidiaryStat;

public class CharacterReader {
	static void getCharacterList(List<gameData.Character> characterList){
        String filePath = "src/gameData/CharacterData.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
            	gameData.Character character = new gameData.Character();
            	character.setName(line.substring(1, line.length() - 1));
            	
            	character.setBestRelicSet(CharacterReader.readerForSets(br.readLine()));
            	character.setAltRelicSet(CharacterReader.readerForSets(br.readLine()));
            	
            	line = br.readLine();
            	int equalsIndex = line.indexOf("=");
                String value = line.substring(equalsIndex + 1);
                character.setPlanetarySet(value);
                
                character.setAltPlanetarySet(CharacterReader.readerForSets(br.readLine()));
                
                character.setMainBodyStat(CharacterReader.readerForMainStat(br.readLine()));
                character.setMainFeetStat(CharacterReader.readerForMainStat(br.readLine()));
                character.setMainPlanarSphereStat(CharacterReader.readerForMainStat(br.readLine()));
                character.setMainLinkRopeStat(CharacterReader.readerForMainStat(br.readLine()));
                
                character.setSubStatTier_1(CharacterReader.readerForSubsidiaryStat(br.readLine()));;
                character.setSubStatTier_2(CharacterReader.readerForSubsidiaryStat(br.readLine()));;
                character.setSubStatTier_3(CharacterReader.readerForSubsidiaryStat(br.readLine()));;
                
                characterList.add(character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private static String[] readerForSets(String line) {
    	int equalsIndex = line.indexOf("=");
        String values = line.substring(equalsIndex + 1);
        String[] valuesArray = values.split(",");
    	return valuesArray; 
    }
    
    private static MainStat[] readerForMainStat(String line) {
    	int equalsIndex = line.indexOf("=");
        String values = line.substring(equalsIndex + 1);
        String[] valuesArray = values.split(",");
        MainStat[] result = new MainStat[valuesArray.length];
        
        for (int i = 0; i < valuesArray.length; i++) {
            result[i] = MainStat.valueOf(valuesArray[i]);
        }
        return result; 
    }
    
    private static SubsidiaryStat[] readerForSubsidiaryStat(String line) {
    	int equalsIndex = line.indexOf("=");
        String values = line.substring(equalsIndex + 1);
        String[] valuesArray = values.split(",");
        SubsidiaryStat[] result = new SubsidiaryStat[valuesArray.length];
        
        for (int i = 0; i < valuesArray.length; i++) {
            result[i] = SubsidiaryStat.valueOf(valuesArray[i]);
        }
        return result; 
    }
}
