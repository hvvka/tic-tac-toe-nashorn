package com.hania.controller;

import com.hania.view.MainFrame;

import javax.swing.*;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class MainController {

    private MainFrame mainFrame;
    private JSpinner gridSpinner;
    private JButton resetButton;
    private JSpinner intelligenceSpinner;
    private JPanel boardPanel;

    public MainController() {
        mainFrame = new MainFrame();
        initComponents();
        initListeners();
    }

    private void initComponents() {
        gridSpinner = mainFrame.getGridSpinner();
        resetButton = mainFrame.getResetButton();
        intelligenceSpinner = mainFrame.getIntelligenceSpinner();
        boardPanel = mainFrame.getBoardPanel();
    }

    private void initListeners() {
        resetButton.addActionListener(e -> {

        });
    }
}
