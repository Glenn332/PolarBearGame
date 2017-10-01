package helpers;

import javax.swing.*;

public class AlertHelper {
    /**
     * Shows a message dialog with a warning image, a custom message and a title.
     * @param message the custom message you want to show on the message dialog.
     * @param title the title of your message dialog.
     */
    public static void ShowWarning(String message, String title){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }
}
