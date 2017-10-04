package panels;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import extensions.ColorExtension;
import logic.Dice;

public class DicePanel extends JPanel
{
	public List<Dice> dices = new ArrayList<>();
	public DicePanel (){
		this.setBackground(ColorExtension.MY_INDIGO_2());
	}

	/**
	 * addDice will add a Dice instance to the dices list.
	 */
	private void addDice(){
		dices.add(new Dice());
	}

	/**
	 * ThrowDices will loop over all the dices in the Dice list and call the ThrowDice method.
	 */
	public void ThrowDices(){
		for(Dice dice : dices){
			dice.ThrowDice();
		}
	}

	/**
	 * CreateDices will reset the Dice list and add create new dice instances equal to the number given in the parameter numberOfDices.
	 * @param numberOfDices the number of dice instances to create.
	 */
	public void CreateDices(int numberOfDices){
		dices = new ArrayList<>();
		for (int i = 0; i < numberOfDices; i++){
			addDice();
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
