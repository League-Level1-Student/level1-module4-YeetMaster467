package _12_slot_machine;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel slot1 = new JLabel();
	JLabel slot2 = new JLabel();
	JLabel slot3 = new JLabel();
	JButton spin = new JButton("SPIN!");
	Random r = new Random();
	int num;
	int s1;
	int s2;
	int s3;

	public void showWindow() {
		frame = new JFrame();
		panel = new JPanel();
		slot1 = setSlotImage(0);
		slot2 = setSlotImage(1);
		slot3 = setSlotImage(2);
		panel.setLayout(new GridLayout(2, 3));
		panel.add(slot1);
		panel.add(slot2);
		panel.add(slot3);
		panel.add(spin);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Slot Machine");
		frame.setVisible(true);
		spin.addActionListener(this);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
		showWindow();
		
		if (s1 == s2 && s2 == s3 && s3 == s1) {
			JOptionPane.showMessageDialog(null, "YOU WIN!!");
		}
	}

	private JLabel setSlotImage(int slot) {
		JLabel input = null;
		num = r.nextInt(3);
		switch (slot) {
		case 0:
			s1 = num;
			break;
		case 1:
			s2 = num;
			break;
		case 2:
			s3 = num;
		}
		try {
			switch (num) {
			case 0:
				input = createLabelImage("bell.jpeg");
				break;
			case 1:
				input = createLabelImage("cherry.jpeg");
				break;
			case 2:
				input = createLabelImage("seven.jpeg");
				break;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println(num);
		return input;
	}

	private JLabel createLabelImage(String fileName) throws MalformedURLException {
		URL imageURL = getClass().getResource(fileName);
		if (imageURL == null) {
			System.err.println("Could not find image " + fileName);
			return new JLabel();
		}
		Icon icon = new ImageIcon(imageURL);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
	}

}
