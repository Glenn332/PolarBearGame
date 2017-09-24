package logic;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import panels.DicePanel;

public class Dice
{
	private int value;
	private boolean enabled = true;
	
	public Dice(){
		this.value = 0;
	}
	
	public void ThrowDice(){
		this.value = (int)(Math.random() * 6) + 1;
	}
	
	public void DrawDice(Graphics g, int position){
		g.setColor(Color.BLACK);
		int x = 65 + ((position%15)*100), y = 65 + ((position / 15)* 100);
		g.drawRect(x, y, 60, 60);
		x += 3;
		y += 3;
		switch(value){
		case 1:
			DrawDiceOne(g, x, y);
			break;
		case 2:
			DrawDiceTwo(g, x, y);
			break;
		case 3:
			DrawDiceThree(g, x, y);
			break;
		case 4:
			DrawDiceFour(g, x, y);
			break;
		case 5:
			DrawDiceFive(g, x, y);
			break;
		default:
			DrawDiceSix(g, x, y);
			break;
		}
	}
	
	public void DrawDiceOne(Graphics g, int x, int y){
		g.fillOval(x + 20, y + 20, 15, 15);
	}
	
	public void DrawDiceTwo(Graphics g, int x, int y){
		g.fillOval(x + 40, y, 15, 15);
		g.fillOval(x, y + 40, 15, 15);
	}
	
	public void DrawDiceThree(Graphics g, int x, int y){
		g.fillOval(x + 40, y, 15, 15);
		g.fillOval(x + 20, y + 20, 15, 15);
		g.fillOval(x, y + 40, 15, 15);
	}
	
	public void DrawDiceFour(Graphics g, int x, int y){
		g.fillOval(x, y, 15, 15);
		g.fillOval(x + 40, y, 15, 15);
		g.fillOval(x, y + 40, 15, 15);
		g.fillOval(x + 40, y + 40, 15, 15);
	}
	
	public void DrawDiceFive(Graphics g, int x, int y){
		g.fillOval(x, y, 15, 15);
		g.fillOval(x + 40, y, 15, 15);
		g.fillOval(x + 20, y + 20, 15, 15);
		g.fillOval(x, y + 40, 15, 15);
		g.fillOval(x + 40, y + 40, 15, 15);
	}
	
	public void DrawDiceSix(Graphics g, int x, int y){
		g.fillOval(x, y, 15, 15);
		g.fillOval(x + 40, y, 15, 15);
		g.fillOval(x, y + 20, 15, 15);
		g.fillOval(x + 40, y + 20, 15, 15);
		g.fillOval(x, y + 40, 15, 15);
		g.fillOval(x + 40, y + 40, 15, 15);
	}
}
