package logic;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import panels.DicePanel;

public class Dice
{
	private int value;

	/**
	 * constructor of the Dice object.
	 */
	public Dice(){
		this.value = 0;
	}

	/**
	 * randomises the value of the dice between 0 to 6.
	 */
	public void ThrowDice(){
		this.value = (int)(Math.random() * 6) + 1;
	}

	/**
	 * draws the current instant dice on the panel affected by the value of the dice.
	 * @param g Graphics of the caller.
	 * @param position the current index of the dice in the dice instance list.
	 * @param panelWidth the current width in which the dice can be drawn.
	 * @param panelHeight the current height in which the dice can be drawn.
	 */
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

	/**
	 * returns the value of the current instance.
	 */
	public int GetValue(){
		return value;
	}

	/**
	 * draws a dice if it has the value of one.
	 * @param g Graphics of the caller.
	 * @param x horizontal start position of the dice.
	 * @param y vertical start position of the dice.
	 * @param height height in which the dice can be drawn.
	 */
	private void DrawDiceOne(Graphics g, int x, int y, int height){
		int width = (height / 3);
		int balWidth = (height / 3) - 20;
		DrawBalMiddle(g, x, y, width, balWidth);
	}

	/**
	 * draws a dice if it has the value of two.
	 * @param g Graphics of the caller.
	 * @param x horizontal start position of the dice.
	 * @param y vertical start position of the dice.
	 * @param height height in which the dice can be drawn.
	 */
    private void DrawDiceTwo(Graphics g, int x, int y, int height){
		int width = (height / 3);
		int balWidth = (height / 3) - 20;
		DrawBalTopRight(g, x, y, height, balWidth);
		DrawBalBottomLeft(g, x, y, height, balWidth);
	}

	/**
	 * draws a dice if it has the value of three.
	 * @param g Graphics of the caller.
	 * @param x horizontal start position of the dice.
	 * @param y vertical start position of the dice.
	 * @param height height in which the dice can be drawn.
	 */
    private void DrawDiceThree(Graphics g, int x, int y, int height){
		int width = (height / 3);
		int balWidth = (height / 3) - 20;
		DrawBalTopRight(g, x, y, height, balWidth);
		DrawBalMiddle(g, x, y, width, balWidth);
		DrawBalBottomLeft(g, x, y, height, balWidth);
	}

	/**
	 * draws a dice if it has the value of four.
	 * @param g Graphics of the caller.
	 * @param x horizontal start position of the dice.
	 * @param y vertical start position of the dice.
	 * @param height height in which the dice can be drawn.
	 */
    private void DrawDiceFour(Graphics g, int x, int y, int height){
		int balWidth = (height / 3) - 20;
		DrawBalTopLeft(g, x, y, balWidth);
		DrawBalTopRight(g, x, y, height, balWidth);
		DrawBalBottomLeft(g, x, y, height, balWidth);
		DrawBalBottomRight(g, x, y, height, balWidth);
	}

	/**
	 * draws a dice if it has the value of five.
	 * @param g Graphics of the caller.
	 * @param x horizontal start position of the dice.
	 * @param y vertical start position of the dice.
	 * @param height height in which the dice can be drawn.
	 */
    private void DrawDiceFive(Graphics g, int x, int y, int height){
		int width = (height / 3);
		int balWidth = (height / 3) - 20;
		DrawBalTopLeft(g, x, y, balWidth);
		DrawBalTopRight(g, x, y, height, balWidth);
		DrawBalMiddle(g, x, y, width, balWidth);
		DrawBalBottomLeft(g, x, y, height, balWidth);
		DrawBalBottomRight(g, x, y, height, balWidth);
	}

	/**
	 * draws a dice if it has the value of six.
	 * @param g Graphics of the caller.
	 * @param x horizontal start position of the dice.
	 * @param y vertical start position of the dice.
	 * @param height height in which the dice can be drawn.
	 */
    private void DrawDiceSix(Graphics g, int x, int y, int height){
		int width = (height / 3);
		int balWidth = (height / 3) - 20;
		DrawBalTopLeft(g, x, y, balWidth);
		DrawBalTopRight(g, x, y, height, balWidth);
		DrawBalMiddleLeft(g, x, y, width, balWidth);
		DrawBalMiddleRight(g, x, y, height, width, balWidth);
		DrawBalBottomLeft(g, x, y, height, balWidth);
		DrawBalBottomRight(g, x, y, height, balWidth);
	}

	/**
	 * draws a dice bal in the top left of the dice.
	 * @param g Graphics of the caller.
	 * @param x horizontal start position of the dice bal.
	 * @param y vertical start position of the dice bal.
	 * @param balWidth width of the bal.
	 */
	private void DrawBalTopLeft(Graphics g, int x, int y, int balWidth){
		g.fillOval(x + 6, y + 6, balWidth, balWidth);
	}

	/**
	 * draws a dice bal in the top right of the dice.
	 * @param g Graphics of the caller.
	 * @param x horizontal start position of the dice bal.
	 * @param y vertical start position of the dice bal.
	 * @param balWidth width of the bal.
	 */
	private void DrawBalTopRight(Graphics g, int x, int y, int height, int balWidth){
		g.fillOval(x + (height - (balWidth + 6)), y + 6, balWidth, balWidth);
	}

	/**
	 * draws a dice bal in the middle left of the dice.
	 * @param g Graphics of the caller.
	 * @param x horizontal start position of the dice bal.
	 * @param y vertical start position of the dice bal.
	 * @param balWidth width of the bal.
	 */
	private void DrawBalMiddleLeft(Graphics g, int x, int y, int width, int balWidth){
		g.fillOval(x + 6, y + (width) + (width / 2) - (balWidth / 2), balWidth, balWidth);
	}

	/**
	 * draws a dice bal in the middle right of the dice.
	 * @param g Graphics of the caller.
	 * @param x horizontal start position of the dice bal.
	 * @param y vertical start position of the dice bal.
	 * @param balWidth width of the bal.
	 */
	private void DrawBalMiddleRight(Graphics g, int x, int y, int height, int width, int balWidth){
		g.fillOval(x + (height - (balWidth + 6)), y + (width) + (width / 2) - (balWidth / 2), balWidth, balWidth);
	}

	/**
	 * draws a dice bal in the bottom left of the dice.
	 * @param g Graphics of the caller.
	 * @param x horizontal start position of the dice bal.
	 * @param y vertical start position of the dice bal.
	 * @param balWidth width of the bal.
	 */
	private void DrawBalBottomLeft(Graphics g, int x, int y, int height, int balWidth){
		g.fillOval(x + 6, y + (height - balWidth - 6), balWidth, balWidth);
	}

	/**
	 * draws a dice bal in the bottom right of the dice.
	 * @param g Graphics of the caller.
	 * @param x horizontal start position of the dice bal.
	 * @param y vertical start position of the dice bal.
	 * @param balWidth width of the bal.
	 */
	private void DrawBalBottomRight(Graphics g, int x, int y, int height, int balWidth){
		g.fillOval(x + (height - (balWidth + 6)), y + (height - balWidth - 6), balWidth, balWidth);
	}

	/**
	 * draws a dice bal in the center of the dice.
	 * @param g Graphics of the caller.
	 * @param x horizontal start position of the dice bal.
	 * @param y vertical start position of the dice bal.
	 * @param balWidth width of the bal.
	 */
	private void DrawBalMiddle(Graphics g, int x, int y, int width, int balWidth){
		g.fillOval(x + width + ((width / 2) - (balWidth / 2)), y + (width) + (width / 2) - (balWidth / 2), balWidth, balWidth);
	}
}
