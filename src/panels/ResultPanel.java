package panels;

import constants.Resources;
import extensions.ColorExtension;
import helpers.AlertHelper;
import helpers.GridBagHelper;
import logic.Calculation;
import models.AnswerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultPanel extends JPanel implements ActionListener {
    private int timesThrown, timesGuessedWrong, timesGuessedRight;
    private MainPanel mainPanel;
    private JButton btnSolution, btnReset;
    private JTextField penguinTextField, polarBearTextField, iceHolesTextField, timesThrownTextField, timesGuessedWrongTextField, timesGuessedRightTextField;
    public ResultPanel(MainPanel panel) {
        mainPanel = panel;
        this.setBackground(ColorExtension.MY_INDIGO_2());
        this.setLayout(new GridBagLayout());

        btnSolution = new JButton(Resources.btn_solution);
        btnSolution.addActionListener(this);
        btnReset = new JButton(Resources.btn_reset);
        btnReset.addActionListener(this);

        penguinTextField = new JTextField(2);
        polarBearTextField = new JTextField(2);
        iceHolesTextField = new JTextField(2);
        timesThrownTextField = new JTextField(2);
        timesThrownTextField.setEnabled(false);
        timesGuessedWrongTextField = new JTextField(2);
        timesGuessedWrongTextField.setEnabled(false);
        timesGuessedRightTextField = new JTextField(2);
        timesGuessedRightTextField.setEnabled(false);

        JLabel penguinLabel = new JLabel(Resources.lbl_penguins);
        JLabel polarBearLabel = new JLabel(Resources.lbl_polar_bears);
        JLabel iceHolesLabel = new JLabel(Resources.lbl_ice_holes);
        JLabel timesThrownLabel = new JLabel(Resources.times_thrown);
        JLabel timesGuessedWrongLabel = new JLabel(Resources.times_guessed_wrong);
        JLabel timesGuessedRightLabel = new JLabel(Resources.times_guessed_right);

        add(btnSolution, GridBagHelper.CreateGridBagConstraints(0, 0, 3, 1, GridBagConstraints.HORIZONTAL));
        add(btnReset, GridBagHelper.CreateGridBagConstraints(3, 0, 3, 1, GridBagConstraints.HORIZONTAL));

        add(iceHolesLabel, GridBagHelper.CreateGridBagConstraints(0, 1, 1, 1, GridBagConstraints.NONE));
        add(iceHolesTextField, GridBagHelper.CreateGridBagConstraints(1, 1, 1, 1, GridBagConstraints.HORIZONTAL));
        add(polarBearLabel, GridBagHelper.CreateGridBagConstraints(2, 1, 1, 1, GridBagConstraints.NONE));
        add(polarBearTextField, GridBagHelper.CreateGridBagConstraints(3, 1, 1, 1, GridBagConstraints.HORIZONTAL));
        add(penguinLabel, GridBagHelper.CreateGridBagConstraints(4, 1, 1, 1, GridBagConstraints.NONE));
        add(penguinTextField, GridBagHelper.CreateGridBagConstraints(5, 1, 1, 1, GridBagConstraints.HORIZONTAL));

        add(timesThrownLabel, GridBagHelper.CreateGridBagConstraints(0, 2, 3, 1, GridBagConstraints.WEST));
        add(timesThrownTextField, GridBagHelper.CreateGridBagConstraints(3, 2, 3, 1, GridBagConstraints.HORIZONTAL));

        add(timesGuessedWrongLabel, GridBagHelper.CreateGridBagConstraints(0, 3, 3, 1, GridBagConstraints.WEST));
        add(timesGuessedWrongTextField, GridBagHelper.CreateGridBagConstraints(3, 3, 3, 1, GridBagConstraints.HORIZONTAL));

        add(timesGuessedRightLabel, GridBagHelper.CreateGridBagConstraints(0, 4, 3, 1, GridBagConstraints.WEST));
        add(timesGuessedRightTextField, GridBagHelper.CreateGridBagConstraints(3, 4, 3, 1, GridBagConstraints.HORIZONTAL));
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSolution){
            HandleSolution();
        }
        else if(e.getSource() == btnReset){
            ResetCounters();
        }
    }

    /**
     * HandleSolution will try and give you the solution of the current thrown dices.
     */
    private void HandleSolution(){
        if(mainPanel.dicePanel.dices.size() == 0){
            AlertHelper.ShowWarning(Resources.msg_throw_dice_first, Resources.lbl_warning);
            return;
        }
        AnswerModel answers = Calculation.GetAnswers(mainPanel.dicePanel.dices);
        iceHolesTextField.setText(Integer.toString(answers.TotalIceHoles));
        polarBearTextField.setText(Integer.toString(answers.TotalPolarBears));
        penguinTextField.setText(Integer.toString(answers.TotalPenguins));
        mainPanel.controlPanel.BtnCheck.setEnabled(false);
    }

    /**
     * UpdateCounterTextFields will update the textfields with information of how many times you have thrown, times you have guessed the answer wrong and right.
     */
    private void UpdateCounterTextFields(){
        timesGuessedRightTextField.setText(Integer.toString(timesGuessedRight));
        timesGuessedWrongTextField.setText(Integer.toString(timesGuessedWrong));
        timesThrownTextField.setText(Integer.toString(timesThrown));
    }

    /**
     * ResetSolution will reset the TextFields currently showing the solution.
     */
    public void ResetSolution(){
        iceHolesTextField.setText("");
        polarBearTextField.setText("");
        penguinTextField.setText("");
    }

    /**
     * AddTimesThrown will add one by the timesThrown public integer and it will all the methods to update the TextFields.
     * It will also send a signal to the hintPanel to check whether its time to show the next hint.
     */
    public void AddTimesThrown(){
        timesThrown++;
        UpdateCounterTextFields();
        mainPanel.hintPanel.HandleHints(timesThrown);
    }

    /**
     * AddTimesGuessedWrong will add one by the timesGuessedWrong public integer and it will all the methods to update the TextFields.
     */
    public void AddTimesGuessedWrong(){
        timesGuessedWrong++;
        UpdateCounterTextFields();
    }

    /**
     * AddTimesGuessedRight will add one by the timesGuessedRight public integer and it will all the methods to update the TextFields.
     */
    public void AddTimesGuessedRight(){
        timesGuessedRight++;
        UpdateCounterTextFields();
    }

    /**
     * ResetCounters will reset all the public integers which keeps the stats of the game basically resetting the game entirely.
     */
    public void ResetCounters(){
        timesGuessedRight = 0;
        timesGuessedWrong = 0;
        timesThrown = 0;
        UpdateCounterTextFields();
    }
}
