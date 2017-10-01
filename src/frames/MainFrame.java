package frames;

import javax.swing.*;

import extensions.ColorExtension;
import panels.MainPanel;

import java.awt.*;

public class MainFrame extends JFrame {
    /**
     * Main method for our MainFrame JFrame
     * @param args Not used in current process.
     */
    public static void main(String[] args) {
        JFrame frame = new MainFrame();
        frame.setSize(1600, 1000);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setTitle( "PolarBear Game" );
        frame.setContentPane( new MainPanel() );
        frame.setVisible( true );
    }
}
