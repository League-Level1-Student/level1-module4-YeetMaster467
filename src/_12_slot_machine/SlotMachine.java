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

	public void showWindow() {
		slot1 = setSlotImage();
		slot2 = setSlotImage();
		slot3 = setSlotImage();
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
		panel = new JPanel();
		slot1 = setSlotImage();
		slot2 = setSlotImage();
		slot3 = setSlotImage();
		if (slot1.equals(slot2) && slot2.equals(slot3) && slot3.equals(slot1)) {
			JOptionPane.showMessageDialog(null, "YOU WIN!!");
		}
	}

	private JLabel setSlotImage() {
		JLabel input = null;
		num = r.nextInt(3);
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
