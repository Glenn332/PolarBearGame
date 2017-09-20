package frames;

import javax.swing.*;

import panels.MainPanel;

import java.awt.*;

public class MainFrame extends JFrame {
    /**
     * Creates a frame for main usage.
     * @param args Not used in current frame.
     */
    public static void main(String[] args) {
        JFrame frame = new MainFrame();
        frame.setSize(1600, 1000);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setTitle( "frames.MainFrame" );
        frame.setContentPane( new MainPanel() );
        frame.setVisible( true );
    }
}
