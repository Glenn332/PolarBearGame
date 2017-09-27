package helpers;

import javax.swing.*;

public class AlertHelper {
    public static void ShowWarning(String message, String title){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }
}
