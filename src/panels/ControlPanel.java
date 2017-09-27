package panels;

import extensions.ColorExtension;
import extensions.StringExtension;
import helpers.AlertHelper;
import logic.Calculation;
import models.AnswerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel implements ActionListener
{
	private String oldDiceTextValue;
	private JButton BtnThrow, BtnCheck;
	private JTextField diceTextField, penguinTextField, polarBearTextField, wakkenTextField;
	private MainPanel mainPanel;
	public ControlPanel(MainPanel panel){
		mainPanel = panel;
		this.setBackground(ColorExtension.MY_INDIGO());
		this.setLayout(new GridBagLayout());

		diceTextField = new JTextField(2);
		penguinTextField = new JTextField(2);
		polarBearTextField = new JTextField(2);
		wakkenTextField = new JTextField(2);

		JLabel diceLabel = new JLabel("Amount of dices");
		JLabel penguinLabel = new JLabel("Penguins");
		JLabel polarBearLabel = new JLabel("Polar Bears");
		JLabel wakkenLabel = new JLabel("Wakken");

		BtnThrow = new JButton("Throw");
		BtnThrow.addActionListener(this);

		BtnCheck = new JButton("Check");
		BtnCheck.addActionListener(this);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		add(wakkenLabel, gbc);

		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		add(wakkenTextField, gbc);

		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		add(polarBearLabel, gbc);

		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		add(polarBearTextField, gbc);

		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		add(penguinLabel, gbc);

		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 5;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		add(penguinTextField, gbc);

		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 6;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		add(BtnCheck, gbc);

		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 7;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		add(diceLabel, gbc);

		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 8;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		add(diceTextField, gbc);

		gbc = new GridBagConstraints();
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 9;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		add(BtnThrow, gbc);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BtnThrow){
			if(diceTextField.getText() != oldDiceTextValue){
				AddOrRemoveDices();
			}
			mainPanel.dicePanel.ThrowDices();
			mainPanel.dicePanel.repaint();
		}
		else if(e.getSource() == BtnCheck){
			HandleAnswers();
		}
	}

	private void HandleAnswers(){
		if(!StringExtension.isNumeric(wakkenTextField.getText()) || !StringExtension.isNumeric(polarBearTextField.getText()) || !StringExtension.isNumeric(penguinTextField.getText())){
			AlertHelper.ShowWarning("One of the answer inputs is not numerical", "Warning");
			return;
		}

		int totalWakken = StringExtension.GetNumericValue(wakkenTextField.getText()),
				totalPolarBears = StringExtension.GetNumericValue(polarBearTextField.getText()),
				totalPenguins = StringExtension.GetNumericValue(penguinTextField.getText());

		AnswerModel answers = Calculation.GetAnswers(mainPanel.dicePanel.dices);

		CheckAnswers(answers, totalWakken, totalPolarBears, totalPenguins);

	}

	private void CheckAnswers(AnswerModel answers, int wakken, int polarBears, int penguins){
		if(answers.TotalWakken == wakken)
			ChangeJTextField(wakkenTextField, true);
		else
			ChangeJTextField(wakkenTextField, false);

		if(answers.TotalPolarBears == polarBears)
			ChangeJTextField(polarBearTextField, true);
		else
			ChangeJTextField(polarBearTextField, false);

		if(answers.TotalPenguins == penguins)
			ChangeJTextField(penguinTextField, true);
		else
			ChangeJTextField(penguinTextField, false);
	}

	private void ChangeJTextField(JTextField textField, boolean isRight){
		if(isRight)
			textField.setBackground(ColorExtension.MY_RIGHT_ANSWER());
		else
			textField.setBackground(ColorExtension.MY_WRONG_ANSWER());
	}

	private void AddOrRemoveDices(){
		if(!StringExtension.isNumeric(diceTextField.getText())){
			AlertHelper.ShowWarning("'Amount of dices' value is not numeric", "Warning");
			return;
		}
		int number = StringExtension.GetNumericValue(diceTextField.getText());
		if(number < 1 || number > 12) {
			AlertHelper.ShowWarning("'Amount of dices' value needs to be higher than 0 and lower than 13", "Warning");
			return;
		}

		mainPanel.dicePanel.CreateDices(number);
		oldDiceTextValue = diceTextField.getText();
	}
}
