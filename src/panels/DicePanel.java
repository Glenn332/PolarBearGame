package panels;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import extensions.ColorExtension;

public class DicePanel extends JPanel
{
	private JLabel myLabel;
	public DicePanel (){
		this.setBackground(ColorExtension.MY_RED());
		
		myLabel = new JLabel("My example text");
		myLabel.setForeground(Color.WHITE);
		Font lblFont = new Font("Dialog", Font.BOLD, 15);
		myLabel.setFont(lblFont);
		
		add(myLabel);
	}
}
