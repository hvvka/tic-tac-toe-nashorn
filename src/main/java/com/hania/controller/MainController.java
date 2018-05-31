package com.hania.controller;

import com.hania.Game;
import com.hania.view.MainFrame;
import com.hania.view.WindowMessages;

import javax.swing.*;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class MainController {

    private MainFrame mainFrame;
    private JSpinner gridSpinner;
    private JButton resetButton;
    private JSpinner intelligenceSpinner;
    private JPanel boardPanel;
    private Game game;
    private JButton[] grid;

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
        grid = mainFrame.getGrid();
    }

    private void initListeners() {
        resetButton.addActionListener(e -> {
            int size = Integer.parseInt(String.valueOf(gridSpinner.getValue()));
            int intelligence = Integer.parseInt(String.valueOf(intelligenceSpinner.getValue()));
            game = new Game(size, intelligence);
            mainFrame.createGrid(size);
            grid = mainFrame.getGrid();
            initGrid();
        });
    }

    private void initGrid() {
        IntStream.range(0, game.getGrid() * game.getGrid())
                .forEach(i -> grid[i].addActionListener(e -> {
                            String result = game.makeMove(i);
                            mainFrame.repaintBoard(game);
                            if (!result.equals("")) {
                                WindowMessages.showResult(result);
                            }
                        })
                );
    }
}
