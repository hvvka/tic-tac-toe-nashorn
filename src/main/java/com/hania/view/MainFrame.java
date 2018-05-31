package com.hania.view;

import com.hania.Game;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class MainFrame extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private JPanel mainPanel;
    private JSpinner gridSpinner;
    private JButton resetButton;
    private JSpinner intelligenceSpinner;
    private JPanel boardPanel;
    private JButton[] grid;

    public MainFrame() {
        super("Tic Tac Toe");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setDefaultSpinnerValues();
        setVisible(true);
    }

    public void repaintBoard(Game game) {
        boardPanel.removeAll();
        int size = game.getGrid();
        IntStream.range(0, size * size)
                .forEach(i -> {
                    String character = "";
                    if (game.getBoard()[i] != 0)
                        character = game.getBoard()[i] == 1 ? "O" : "X";
                    grid[i].setText(character);
                    boardPanel.add(grid[i]);
                });
        boardPanel.repaint();
    }

    private void setDefaultSpinnerValues() {
        gridSpinner.setValue(3);
        intelligenceSpinner.setValue(2);
    }

    public JSpinner getGridSpinner() {
        return gridSpinner;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JSpinner getIntelligenceSpinner() {
        return intelligenceSpinner;
    }

    public JPanel getBoardPanel() {
        return boardPanel;
    }

    public JButton[] getGrid() {
        return grid;
    }

    public void createGrid(int size) {
        boardPanel.removeAll();
        boardPanel.setLayout(new GridLayout(size, size));
        grid = new JButton[size * size];
        for (int i = 0; i < size * size; ++i) {
            grid[i] = new JButton();
            boardPanel.add(grid[i]);
        }
        boardPanel.revalidate();
    }
}
