import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.lang.Math;
import java.awt.*; 
import java.awt.event.*;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

public class Interface {
	public static void main(String[] args) {
		
		JFrame f = new JFrame("Interface");
		f.getContentPane().setBackground(new Color(0,200,0));
		f.setSize(600,400);
		f.setVisible(true);
		
		JLabel bal = new JLabel();
		bal.setBounds(130,40,320,50);
		bal.setText("-");
		bal.setForeground(Color.DARK_GRAY);
		bal.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		bal.setHorizontalAlignment(SwingConstants.CENTER);
		f.add(bal);
		
		JButton get = new JButton("Get Date & Time");
		get.setBounds(150,120,300,40);
		f.add(get);
		JButton prnt = new JButton("Print Date & Time");
		prnt.setBounds(150,180,300,40);
		f.add(prnt);
		JButton rand = new JButton("New Green!");
		rand.setBounds(150,240,300,40);
		f.add(rand);
		
		JPanel pan = new JPanel();
		pan.setVisible(false);
		f.add(pan);
		
		get.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				bal.setText(dateformat.format(now));
			}
		});
		prnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String date = bal.getText();
				System.out.println("Printing to file.");
				FileWriter printedFile = new FileWriter("C:/Temp/Date.txt");
				printedFile.write(date);
				printedFile.close();
				System.out.println("Successfully printed to file.");
				} catch(Exception x) {
					System.out.println("Something went wrong when trying to print to file.");
					System.out.println(x);
				}
			}
		});
		rand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int red = (int)(Math.random() * 100);
				int blue = (int)(Math.random() * 100);
				System.out.println(red + " " + blue);
				f.getContentPane().setBackground(new Color(red,200,blue));
			}
		});
		
	}
}