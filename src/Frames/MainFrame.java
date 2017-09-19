package Frames;

import Panels.MainPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    /**
     * Creates a frame for main usage.
     * @param args Not used in current frame.
     */
    public static void main(String[] args) {
        JFrame frame = new MainFrame();
        frame.setSize(1600, 1300);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setTitle( "Frames.MainFrame" );
        frame.setContentPane( new MainPanel() );
        frame.setVisible( true );
    }
}
