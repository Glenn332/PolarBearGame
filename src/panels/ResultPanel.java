package panels;

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

        btnSolution = new JButton("Solution");
        btnSolution.addActionListener(this);
        btnReset = new JButton("Reset");
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

        JLabel penguinLabel = new JLabel("Penguins");
        JLabel polarBearLabel = new JLabel("Polar Bears");
        JLabel iceHolesLabel = new JLabel("Ice Holes");
        JLabel timesThrownLabel = new JLabel("Number of times thrown");
        JLabel timesGuessedWrongLabel = new JLabel("Number of times guessed wrong");
        JLabel timesGuessedRightLabel = new JLabel("Number of times guessed right");

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

    private void HandleSolution(){
        if(mainPanel.dicePanel.dices.size() == 0){
            AlertHelper.ShowWarning("Throw dices first", "Warning");
            return;
        }
        AnswerModel answers = Calculation.GetAnswers(mainPanel.dicePanel.dices);
        iceHolesTextField.setText(Integer.toString(answers.TotalIceHoles));
        polarBearTextField.setText(Integer.toString(answers.TotalPolarBears));
        penguinTextField.setText(Integer.toString(answers.TotalPenguins));
        mainPanel.controlPanel.BtnCheck.setEnabled(false);
    }

    private void UpdateCounterTextFields(){
        timesGuessedRightTextField.setText(Integer.toString(timesGuessedRight));
        timesGuessedWrongTextField.setText(Integer.toString(timesGuessedWrong));
        timesThrownTextField.setText(Integer.toString(timesThrown));
    }

    public void ResetSolution(){
        iceHolesTextField.setText("");
        polarBearTextField.setText("");
        penguinTextField.setText("");
    }

    public void AddTimesThrown(){
        timesThrown++;
        UpdateCounterTextFields();
    }

    public void AddTimesGuessedWrong(){
        timesGuessedWrong++;
        UpdateCounterTextFields();
    }

    public void AddTimesGuessedRight(){
        timesGuessedRight++;
        UpdateCounterTextFields();
    }

    public void ResetCounters(){
        timesGuessedRight = 0;
        timesGuessedWrong = 0;
        timesThrown = 0;
        UpdateCounterTextFields();
    }
}
