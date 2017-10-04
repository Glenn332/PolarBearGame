package panels;

import extensions.ColorExtension;
import helpers.GridBagHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    public DicePanel dicePanel;
    public ControlPanel controlPanel;
    public ResultPanel resultPanel;
    public HintPanel hintPanel;

    public MainPanel() {
        this.setLayout(new GridBagLayout());
        this.setBackground(ColorExtension.MY_INDIGO());


        dicePanel = new DicePanel();
        controlPanel = new ControlPanel(this);
        resultPanel = new ResultPanel(this);
        hintPanel = new HintPanel();

        add(dicePanel, GridBagHelper.CreateGridBagConstraints(0, 0, 2, 3, GridBagConstraints.BOTH));
        add(controlPanel, GridBagHelper.CreateGridBagConstraints(0, 3, 2, 0.2, GridBagConstraints.BOTH));
        add(hintPanel, GridBagHelper.CreateGridBagConstraints(0, 4, 1, 1, GridBagConstraints.BOTH));
        add(resultPanel, GridBagHelper.CreateGridBagConstraints(1, 4, 1, 1, GridBagConstraints.BOTH));
    }
}
