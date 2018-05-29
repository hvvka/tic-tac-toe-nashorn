package com.hania.view;

import com.hania.model.Game;

import javax.swing.*;

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
        int size = game.getGrid();
//        IntStream.range(0, size).forEach(i -> {
//            grid[i].setText(String.valueOf(game.getBoard()[i][i]));
//            boardPanel.add(grid[i]);
//        });
//        Arrays.stream(grid)
//                .forEach(button ->
//                    boardPanel.add(button)
//                );
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

    public void createGrid(int size) {
        grid = new JButton[size];

    }
}
