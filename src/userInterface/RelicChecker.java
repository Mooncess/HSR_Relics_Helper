package userInterface;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import enums.MainStat;
import enums.SubsidiaryStat;

public class RelicChecker {
	public static void checkRelic(JTable table, List<gameData.Character> characterList, String relicSet, 
			String selectedEquipment, MainStat selectedMainStat, ArrayList<SubsidiaryStat> subStats) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		mainLoop:
		for (int row = 0; row < table.getRowCount(); row++) {
			// Установка новых значений для каждой ячейки в строке
			model.setValueAt(characterList.get(row).getName(), row, 0);
			
			boolean statusOfCharacteristic = false;
			
			if (selectedEquipment == "Body") {
				for (MainStat i : characterList.get(row).getMainBodyStat()) {
					if (selectedMainStat == i) {
						statusOfCharacteristic = true;
						break;
					}
				}
			} else if (selectedEquipment == "Feet") {
				for (MainStat i : characterList.get(row).getMainFeetStat()) {
					if (selectedMainStat == i) {
						statusOfCharacteristic = true;
						break;
					}
				}
			} else {
				statusOfCharacteristic = true;
			}
			
			if (statusOfCharacteristic == false) {
				model.setValueAt("-", row, 1);
			}
			else {
				byte counter = 0;
				outerLoop:
				for (SubsidiaryStat i : subStats) {
					for (SubsidiaryStat j : characterList.get(row).getSubStatTier_1()) {
						if (i == j) {
							counter+=1;
							continue outerLoop;
						}
					}
					for (SubsidiaryStat j : characterList.get(row).getSubStatTier_2()) {
						if (i == j) {
							counter+=2;
							continue outerLoop;
						}
					}
					for (SubsidiaryStat j : characterList.get(row).getSubStatTier_3()) {
						if (i == j) {
							counter+=3;
							continue outerLoop;
						}
					}
					counter+=4;
				}
				
				// System.out.println(characterList.get(row).getName() + " " + counter + " " + relicSet);
				
				if (counter < 8) {
					model.setValueAt("Perfect", row, 1);
				} else if (counter > 8 && counter < 10) {
					model.setValueAt("Good", row, 1);
				} else if (counter > 10 && counter < 12) {
					model.setValueAt("Normal", row, 1);
				} else {
					model.setValueAt("Bad", row, 1);
				}
			}
			
			for (String i : characterList.get(row).getBestRelicSet()) {
				// System.out.println("|" + i + "|" + "  |" + relicSet + "|");
				if (i.equals(relicSet)) {
					model.setValueAt("Best set", row, 2);
					continue mainLoop;
				}
			}
			for (String i : characterList.get(row).getAltRelicSet()) {
				if (i.equals(relicSet)) {
					model.setValueAt("Alternative set", row, 2);
					continue mainLoop;
				}
			}

			model.setValueAt("-", row, 2);
		}

		// Обновление отображения таблицы
		model.fireTableDataChanged();
	}
}
