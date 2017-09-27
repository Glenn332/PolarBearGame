package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    public DicePanel dicePanel;
    private ControlPanel controlPanel;

    public MainPanel() {
        this.setLayout(new GridBagLayout());


        dicePanel = new DicePanel();
        controlPanel = new ControlPanel(this);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 4;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        add(dicePanel, gbc);
        
        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(controlPanel, gbc);
    }
}
