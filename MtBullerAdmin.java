package mtbuller;

import javax.swing.SwingUtilities;

/* 
 * Hey Tanya! From the bottom of my heart, thank you so much for everything you have taught me this semester.
 * I hope that over the course of this year I have made you proud. I look up to you not as a tutor, teacher, or lecturer,
 * I see you as a mentor. The guidance you've given me and the faith you have placed in me change my outlook on my abilities in what
 * I personally could achieve. So this assessment I didn't do for my grades, I did for you. I am truly humbled to be your student.
 * 
 * PS. I normally don't include many comments in my work. I have been trying to follow the teaching of Clean Code and 
 * Agile Software Development. I wanted however to share with you my thoughts and reasoning behind coding grouping/layout choices
 * and see if I am on the right path with my practices. Feel free to ignore these if this is too much though.
*/

public class MtBullerAdmin {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MtBullerResortGUI();
			}
		});
	}
}
