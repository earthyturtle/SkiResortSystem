package SkiResort;

import javax.swing.SwingUtilities;

public class SkiResortAdmin {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SkiResortGUI();
			}
		});
	}
}
