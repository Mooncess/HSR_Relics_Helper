import javax.swing.SwingUtilities;

import userInterface.ApplicationWindow;

public class Main {

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ApplicationWindow();
            }
        });
    }

}
