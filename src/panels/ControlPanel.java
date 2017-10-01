package panels;

import extensions.ColorExtension;
import extensions.StringExtension;
import helpers.AlertHelper;
import helpers.GridBagHelper;
import logic.Calculation;
import models.AnswerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel implements ActionListener
{
	private String oldDiceTextValue;
	private JButton BtnThrow;
	public JButton BtnCheck;
	private JTextField diceTextField, penguinTextField, polarBearTextField, iceHolesTextField;
	private MainPanel mainPanel;
	public ControlPanel(MainPanel panel){
		mainPanel = panel;
		this.setBackground(ColorExtension.MY_INDIGO_2());
		this.setLayout(new GridBagLayout());

		diceTextField = new JTextField(2);
		penguinTextField = new JTextField(2);
		polarBearTextField = new JTextField(2);
		iceHolesTextField = new JTextField(2);

		JLabel diceLabel = new JLabel("Amount of dices");
		JLabel penguinLabel = new JLabel("Penguins");
		JLabel polarBearLabel = new JLabel("Polar Bears");
		JLabel iceHolesLabel = new JLabel("Ice Holes");

		BtnThrow = new JButton("Throw");
		BtnThrow.addActionListener(this);

		BtnCheck = new JButton("Check");
		BtnCheck.addActionListener(this);
		BtnCheck.setEnabled(false);

		add(iceHolesLabel, GridBagHelper.CreateGridBagConstraints(0, 0, 1, 1, GridBagConstraints.NONE));
		add(iceHolesTextField, GridBagHelper.CreateGridBagConstraints(1, 0, 1, 1, GridBagConstraints.HORIZONTAL));
		add(polarBearLabel, GridBagHelper.CreateGridBagConstraints(2, 0, 1, 1, GridBagConstraints.NONE));
		add(polarBearTextField, GridBagHelper.CreateGridBagConstraints(3, 0, 1, 1, GridBagConstraints.HORIZONTAL));
		add(penguinLabel, GridBagHelper.CreateGridBagConstraints(4, 0, 1, 1, GridBagConstraints.NONE));
		add(penguinTextField, GridBagHelper.CreateGridBagConstraints(5, 0, 1, 1, GridBagConstraints.HORIZONTAL));
		add(BtnCheck, GridBagHelper.CreateGridBagConstraints(6, 0, 1, 1, GridBagConstraints.HORIZONTAL));
		add(diceLabel, GridBagHelper.CreateGridBagConstraints(7, 0, 1, 1, GridBagConstraints.NONE));
		add(diceTextField, GridBagHelper.CreateGridBagConstraints(8, 0, 1, 1, GridBagConstraints.HORIZONTAL));
		add(BtnThrow, GridBagHelper.CreateGridBagConstraints(9, 0, 1, 1, GridBagConstraints.HORIZONTAL));
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BtnThrow){
			if(diceTextField.getText() != oldDiceTextValue){
				if(!AddOrRemoveDices())
					return;
			}
			mainPanel.resultPanel.AddTimesThrown();
			mainPanel.dicePanel.ThrowDices();
			mainPanel.dicePanel.repaint();
			BtnCheck.setEnabled(true);
			mainPanel.resultPanel.ResetSolution();
			ResetGuessTextFields();
		}
		else if(e.getSource() == BtnCheck){
			if(mainPanel.dicePanel.dices.size() == 0){
				AlertHelper.ShowWarning("Throw dices first", "Warning");
				return;
			}
			HandleAnswers();
		}
	}

	private void ResetGuessTextFields(){
		iceHolesTextField.setText("");
		iceHolesTextField.setBackground(Color.WHITE);
		polarBearTextField.setText("");
		polarBearTextField.setBackground(Color.WHITE);
		penguinTextField.setText("");
		penguinTextField.setBackground(Color.WHITE);
	}

	private void HandleAnswers(){
		if(!StringExtension.isNumeric(iceHolesTextField.getText()) || !StringExtension.isNumeric(polarBearTextField.getText()) || !StringExtension.isNumeric(penguinTextField.getText())){
			AlertHelper.ShowWarning("One of the answer inputs is not numerical", "Warning");
			return;
		}

		int totalIceHoles = StringExtension.GetNumericValue(iceHolesTextField.getText()),
				totalPolarBears = StringExtension.GetNumericValue(polarBearTextField.getText()),
				totalPenguins = StringExtension.GetNumericValue(penguinTextField.getText());

		CheckAnswers(Calculation.GetAnswers(mainPanel.dicePanel.dices), totalIceHoles, totalPolarBears, totalPenguins);
		BtnCheck.setEnabled(false);
	}

	private void CheckAnswers(AnswerModel answers, int iceHoles, int polarBears, int penguins){
		boolean iceHolesRight = answers.TotalIceHoles == iceHoles;
		boolean polarBearsRight = answers.TotalPolarBears == polarBears;
		boolean penguinsRight = answers.TotalPenguins == penguins;

		if(iceHolesRight)
			ChangeJTextField(iceHolesTextField, true);
		else
			ChangeJTextField(iceHolesTextField, false);

		if(polarBearsRight)
			ChangeJTextField(polarBearTextField, true);
		else
			ChangeJTextField(polarBearTextField, false);

		if(penguinsRight)
			ChangeJTextField(penguinTextField, true);
		else
			ChangeJTextField(penguinTextField, false);

		UpdateCounter(iceHolesRight, polarBearsRight, penguinsRight);
	}

	private void UpdateCounter(boolean iceHolesRight, boolean polarBearsRight, boolean penguinsRight) {
		if(iceHolesRight && polarBearsRight && penguinsRight)
			mainPanel.resultPanel.AddTimesGuessedRight();
		else
			mainPanel.resultPanel.AddTimesGuessedWrong();
	}

	private void ChangeJTextField(JTextField textField, boolean isRight){
		if(isRight)
			textField.setBackground(ColorExtension.MY_RIGHT_ANSWER());
		else
			textField.setBackground(ColorExtension.MY_WRONG_ANSWER());
	}

	private boolean AddOrRemoveDices(){
		if(!StringExtension.isNumeric(diceTextField.getText())){
			AlertHelper.ShowWarning("'Amount of dices' value is not numeric", "Warning");
			return false;
		}
		int number = StringExtension.GetNumericValue(diceTextField.getText());
		if(number < 1 || number > 12) {
			AlertHelper.ShowWarning("'Amount of dices' value needs to be higher than 0 and lower than 13", "Warning");
			return false;
		}

		mainPanel.dicePanel.CreateDices(number);
		oldDiceTextValue = diceTextField.getText();
		return true;
	}
}
