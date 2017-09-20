package panels;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private JButton knopWorp;
    private JLabel TextLabel, TextLabel2;
    private DicePanel dicePanel;

    public MainPanel() {
        this.setLayout(new GridBagLayout());

        knopWorp = new JButton("Werpen");
        TextLabel = new JLabel("U heeft nog niet geworpen");
        TextLabel2 = new JLabel("U heeft geworpen");
        dicePanel = new DicePanel();

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
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(TextLabel, gbc);

        gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(TextLabel2, gbc);
    }
}
