package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import extensions.ColorExtension;
import logic.Dice;

public class DicePanel extends JPanel
{
	private List<Dice> dices = new ArrayList<>();
	public DicePanel (){
		this.setBackground(ColorExtension.MY_RED());
		addDice();
		addDice();
		addDice();
		addDice();
		addDice();
		addDice();
		addDice();
		addDice();
	}
	
	private void addDice(){
		dices.add(new Dice());
	}

	public void ThrowDices(){
		for(Dice dice : dices){
			dice.ThrowDice();
		}
	}
	
	public void paintComponent( Graphics g ) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		for(int i=0; i < dices.size(); i++){
			dices.get(i).DrawDice(g, i, this.getWidth(), this.getHeight());
		}
	}
}
