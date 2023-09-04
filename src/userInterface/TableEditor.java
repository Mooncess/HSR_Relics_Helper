package userInterface;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableEditor {
	public static void updateTable(JTable table) {
		for (int row = 0; row < table.getRowCount(); row++) {
            table.setValueAt("Что-то другое", row, 1); // Замена значения во второй колонке
            table.setValueAt("Что-то другое", row, 2); // Замена значения в третьей колонке
        }
	}
}
