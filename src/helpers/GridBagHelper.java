package helpers;

import java.awt.*;

public class GridBagHelper {
    /**
     * returns a GridBagConstraints instance with some default values and the values from the parameters.
     * @param x the horizontal position of the current cell.
     * @param y the vertical position of the current cell.
     * @param gridWidth the width of the current cell.
     * @param gridHeight the height of the current cell.
     * @param fill how to fill the current cell in the grid bag.
     */
    public static GridBagConstraints CreateGridBagConstraints(int x, int y, int gridWidth, double gridHeight, int fill){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = fill;
        gbc.weightx = gridWidth;
        gbc.weighty = gridHeight;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = gridWidth;
        return gbc;
    }

    /**
     * returns a GridBagConstraints instance with some default values including an anchor to the top of the cell and the values from the parameters.
     * @param x the horizontal position of the current cell.
     * @param y the vertical position of the current cell.
     * @param gridWidth the width of the current cell.
     * @param gridHeight the height of the current cell.
     * @param fill how to fill the current cell in the grid bag.
     */
    public static GridBagConstraints CreateGridBagConstraintsTopAnchor(int x, int y, int gridWidth, double gridHeight, int fill){
        GridBagConstraints gbc = CreateGridBagConstraints(x, y, gridWidth, gridHeight, fill);
        gbc.anchor = GridBagConstraints.PAGE_START;
        return gbc;
    }
}
