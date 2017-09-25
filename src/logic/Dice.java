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
	
	public void DrawDice(Graphics g, int position, int panelWidth, int panelHeight){
		g.setColor(Color.BLACK);
		int width = (panelWidth / 100 * 16 ), height = (panelHeight / 100 * 40);
		int x = 65 + ((position%6)*width), y = 65 + ((position / 6)* (height + 10));
		g.drawRoundRect(x, y, height, height, 10 ,10); // to keep aspect ratio we will make them both the same
		switch(value){
		case 1:
			DrawDiceOne(g, x, y, height);
			break;
		case 2:
			DrawDiceTwo(g, x, y, height);
			break;
		case 3:
			DrawDiceThree(g, x, y, height);
			break;
		case 4:
			DrawDiceFour(g, x, y, height);
			break;
		case 5:
			DrawDiceFive(g, x, y, height);
			break;
		default:
			DrawDiceSix(g, x, y, height);
			break;
		}
	}
	
	private void DrawDiceOne(Graphics g, int x, int y, int height){
		int width = (height / 3);
		int balWidth = (height / 3) - 20;
		g.fillOval(x + width + ((width / 2) - (balWidth / 2)), y + (width) + (width / 2) - (balWidth / 2), balWidth, balWidth);
	}

    private void DrawDiceTwo(Graphics g, int x, int y, int height){
		int width = (height / 3);
		int balWidth = (height / 3) - 20;
		g.fillOval(x + (height - (balWidth + 6)), y + 6, balWidth, balWidth);
		g.fillOval(x + 6, y + (height - balWidth - 6), balWidth, balWidth);
	}

    private void DrawDiceThree(Graphics g, int x, int y, int height){
		int width = (height / 3);
		int balWidth = (height / 3) - 20;
		g.fillOval(x + (height - (balWidth + 6)), y + 6, balWidth, balWidth);
		g.fillOval(x + width + ((width / 2) - (balWidth / 2)), y + (width) + (width / 2) - (balWidth / 2), balWidth, balWidth);
		g.fillOval(x + 6, y + (height - balWidth - 6), balWidth, balWidth);
	}

    private void DrawDiceFour(Graphics g, int x, int y, int height){
		int balWidth = (height / 3) - 20;
		g.fillOval(x + 6, y + 6, balWidth, balWidth);
		g.fillOval(x + (height - (balWidth + 6)), y + 6, balWidth, balWidth);

		g.fillOval(x + 6, y + (height - balWidth - 6), balWidth, balWidth);
		g.fillOval(x + (height - (balWidth + 6)), y + (height - balWidth - 6), balWidth, balWidth);
	}

    private void DrawDiceFive(Graphics g, int x, int y, int height){
		int width = (height / 3);
		int balWidth = (height / 3) - 20;
		g.fillOval(x + 6, y + 6, balWidth, balWidth);
		g.fillOval(x + (height - (balWidth + 6)), y + 6, balWidth, balWidth);

		g.fillOval(x + width + ((width / 2) - (balWidth / 2)), y + (width) + (width / 2) - (balWidth / 2), balWidth, balWidth);

		g.fillOval(x + 6, y + (height - balWidth - 6), balWidth, balWidth);
		g.fillOval(x + (height - (balWidth + 6)), y + (height - balWidth - 6), balWidth, balWidth);
	}

    private void DrawDiceSix(Graphics g, int x, int y, int height){
		int width = (height / 3);
		int balWidth = (height / 3) - 20;
		g.fillOval(x + 6, y + 6, balWidth, balWidth);
		g.fillOval(x + (height - (balWidth + 6)), y + 6, balWidth, balWidth);

		g.fillOval(x + 6, y + (width) + (width / 2) - (balWidth / 2), balWidth, balWidth);
		g.fillOval(x + (height - (balWidth + 6)), y + (width) + (width / 2) - (balWidth / 2), balWidth, balWidth);

		g.fillOval(x + 6, y + (height - balWidth - 6), balWidth, balWidth);
		g.fillOval(x + (height - (balWidth + 6)), y + (height - balWidth - 6), balWidth, balWidth);
	}
}
