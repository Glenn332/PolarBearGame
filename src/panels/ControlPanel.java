package panels;

import constants.Resources;
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

		JLabel diceLabel = new JLabel(Resources.amount_of_dices);
		JLabel penguinLabel = new JLabel(Resources.lbl_penguins);
		JLabel polarBearLabel = new JLabel(Resources.lbl_polar_bears);
		JLabel iceHolesLabel = new JLabel(Resources.lbl_ice_holes);

		BtnThrow = new JButton(Resources.btn_throw);
		BtnThrow.addActionListener(this);

		BtnCheck = new JButton(Resources.btn_check);
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
				AlertHelper.ShowWarning(Resources.msg_throw_dice_first, Resources.lbl_warning);
				return;
			}
			HandleAnswers();
		}
	}

	/**
	 * ResetGuessTextFields will reset all the TextFields in which you can guess the answer for the current thrown dices.
	 */
	private void ResetGuessTextFields(){
		iceHolesTextField.setText("");
		iceHolesTextField.setBackground(Color.WHITE);
		polarBearTextField.setText("");
		polarBearTextField.setBackground(Color.WHITE);
		penguinTextField.setText("");
		penguinTextField.setBackground(Color.WHITE);
	}

	/**
	 * HandleAnswers will be called when you press check and will process your answers and it will handle all calls to external methods to handle your answers.
	 */
	private void HandleAnswers(){
		if(!StringExtension.IsNumeric(iceHolesTextField.getText()) || !StringExtension.IsNumeric(polarBearTextField.getText()) || !StringExtension.IsNumeric(penguinTextField.getText())){
			AlertHelper.ShowWarning(Resources.msg_answer_not_numerical, Resources.lbl_warning);
			return;
		}

		int totalIceHoles = StringExtension.GetNumericValue(iceHolesTextField.getText()),
				totalPolarBears = StringExtension.GetNumericValue(polarBearTextField.getText()),
				totalPenguins = StringExtension.GetNumericValue(penguinTextField.getText());

		CheckAnswers(Calculation.GetAnswers(mainPanel.dicePanel.dices), totalIceHoles, totalPolarBears, totalPenguins);
		BtnCheck.setEnabled(false);
	}

	/**
	 * CheckAnswers will check your answers with the help of the AnswerModel which will contain all of the current answers of the thrown dice.
	 */
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

	/**
	 * UpdateCounter will update the resultPanel counters where we want to either add one to the guessedRight or guessedWrong depending on the outcome of CheckAnswers.
	 */
	private void UpdateCounter(boolean iceHolesRight, boolean polarBearsRight, boolean penguinsRight) {
		if(iceHolesRight && polarBearsRight && penguinsRight)
			mainPanel.resultPanel.AddTimesGuessedRight();
		else
			mainPanel.resultPanel.AddTimesGuessedWrong();
	}

	/**
	 * ChangeJTextField will change the color of the background for each answer TextField depending on whether the answer that is filled within is right or wrong.
	 */
	private void ChangeJTextField(JTextField textField, boolean isRight){
		if(isRight)
			textField.setBackground(ColorExtension.MY_RIGHT_ANSWER());
		else
			textField.setBackground(ColorExtension.MY_WRONG_ANSWER());
	}

	/**
	 * AddOrRemoveDices will be called when the diceTextField has changed its value and it will recreate the dice list on the dicePanel
	 * with an amount of instances we have supplied in the textfield.
	 */
	private boolean AddOrRemoveDices(){
		if(!StringExtension.IsNumeric(diceTextField.getText())){
			AlertHelper.ShowWarning(Resources.msg_dices_not_numerical, Resources.lbl_warning);
			return false;
		}
		int number = StringExtension.GetNumericValue(diceTextField.getText());
		if(number < 1 || number > 12) {
			AlertHelper.ShowWarning(Resources.msg_dice_value, Resources.lbl_warning);
			return false;
		}

		mainPanel.dicePanel.CreateDices(number);
		oldDiceTextValue = diceTextField.getText();
		return true;
	}
}
