package com.hania.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class WindowMessages {

    private WindowMessages() {
        throw new IllegalStateException("Utility class!");
    }

    public static void showResult(String result) {
        switch (result) {
            case "won":
                win();
                break;
            case "tie":
                tie();
                break;
            case "lost":
                lose();
                break;
            default:
                unknown();
                break;
        }
    }

    private static void win() {
        String title = "Hurray!";
        String message = "You won!";
        showMessage(title, message);
    }

    private static void tie() {
        String title = "Oh well...";
        String message = "It's a tie!";
        showMessage(title, message);
    }

    private static void lose() {
        String title = "Sorry!";
        String message = "You lost!";
        showMessage(title, message);
    }

    private static void unknown() {
        String title = "Whoopsadaisy";
        String message = "Unknown game state!";
        showMessage(title, message);
    }

    private static void showMessage(String title, String message) {
        JOptionPane.showMessageDialog(new Frame(), message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
