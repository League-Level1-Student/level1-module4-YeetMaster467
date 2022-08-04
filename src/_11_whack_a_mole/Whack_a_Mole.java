package _11_whack_a_mole;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Whack_a_Mole implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton mole;
	Date date = new Date();
	int count = 0;
	int correct = 0;

	public void showWindow() {
		frame.setVisible(true);
		frame.add(panel);
		panel.setLayout(new GridLayout(10, 3));
		Random r = new Random();
		int num = r.nextInt(30);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (int i = 0; i < 30; i++) {
			JButton button = new JButton();
			button.addActionListener(this);
			panel.add(button);
			if (i == num) {
				mole = button;
				mole.setText("mole!");
			}
		}

		frame.setSize(500, 500);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();

		if (buttonPressed != mole) {
			count++;
			switch (count) {
			case 1:
				speak("YOU MISSED");
				break;
			case 2:
				speak("AM I GOOD AT NOT BEING HIT, OR IS IT YOUR SWINGING SKILLS?");
				break;
			case 3:
				speak("HOW MANY OF US ARE YOU GOING TO MISS?!");
				break;
			case 4:
				speak("JUST HIT US ALREADY!");
				break;
			case 5:
				speak("ALRIGHT GET AWAY FROM OUR VILLAGE AND NEVER COME BACK AGAIN!");
				break;
			default:
				System.out.println("Why have you broken the game?");
			}
		} else {
			correct++;
		}

		if (correct == 10) {
			endGame(date, correct);
			date = new Date();
			correct = 0;
		}

		if (count == 5) {
			JOptionPane.showMessageDialog(null, "You have lost. Leave.");
			System.exit(0);
		}

		frame.dispose();
		frame = new JFrame();
		panel = new JPanel();
		frame.add(panel);
		showWindow();
	}

	static void speak(String words) {
		if (System.getProperty("os.name").contains("Windows")) {
			String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
					+ words + "');\"";
			try {
				Runtime.getRuntime().exec(cmd).waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				Runtime.getRuntime().exec("say " + words).waitFor();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void endGame(Date timeAtStart, int molesWhacked) {
		Date timeAtEnd = new Date();
		JOptionPane.showMessageDialog(null, "Your whack rate is "
				+ ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked) + " moles per second.");
	}

}
