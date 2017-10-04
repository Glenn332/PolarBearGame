package panels;

import constants.Resources;
import extensions.ColorExtension;
import helpers.GridBagHelper;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class HintPanel extends JPanel
{
	public JLabel hintLabel;
	public HintPanel(){
		this.setLayout(new GridBagLayout());
		this.setBackground(ColorExtension.MY_INDIGO_2());

		JLabel hintTitleLabel = new JLabel(Resources.game_hint_title);
		hintLabel = new JLabel(Resources.game_hint_starting_text);
		
		add(hintTitleLabel, GridBagHelper.CreateGridBagConstraintsTopAnchor(0,0,1,1, GridBagConstraints.NONE));
		add(hintLabel, GridBagHelper.CreateGridBagConstraintsTopAnchor(0,1,1,1, GridBagConstraints.NONE));
	}

	/**
	 * Handle hints will show the next tip if the numberOfThrows can be divided evenly in five.
	 * @param numberOfThrows the amount of times the dices have been thrown.
	 */
	public void HandleHints(int numberOfThrows){
		if(numberOfThrows % 5 == 0)
			ShowNextTip();
	}

	/**
	 * ShowNextTip will show the next hint in its sequence.
	 */
	public void ShowNextTip(){
		switch(hintLabel.getText()){
			case Resources.game_hint_1:
				hintLabel.setText(Resources.game_hint_2);
				break;
			case Resources.game_hint_2:
				hintLabel.setText(Resources.game_hint_3);
				break;
			case Resources.game_hint_3:
				hintLabel.setText(Resources.game_hint_4);
				break;
			case Resources.game_hint_4:
				hintLabel.setText(Resources.game_hint_1);
				break;
			default:
				hintLabel.setText(Resources.game_hint_1);
				break;
		}
	}
}
