package com.hania;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStreamReader;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class Game {

    private static final Logger LOG = LoggerFactory.getLogger(Game.class);
    private static final int EMPTY = 0;

    private int[] board;
    private int grid;
    private int intelligence;
    private Invocable invocable;

    public Game(int grid, int intelligence) {
        this.grid = grid;
        this.intelligence = intelligence;
        initBoard();
        initJavaScriptEngine();
    }

    private void initJavaScriptEngine() {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            engine.eval(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("engine.js")));
            invocable = (Invocable) engine;
            invocable.invokeFunction("startGame", grid, intelligence);
        } catch (ScriptException | NoSuchMethodException e) {
            LOG.error("", e);
        }
    }

    private void initBoard() {
        board = new int[grid * grid];
        for (int i = 0; i < grid * grid; ++i) {
            board[i] = EMPTY;
        }
    }

    public int[] getBoard() {
        return board;
    }

    public int getGrid() {
        return grid;
    }

    public String makeMove(int move) {
        Object output = null;
        try {
            output = invocable.invokeFunction("makeMove", move);
            updateBoard();
        } catch (ScriptException | NoSuchMethodException e) {
            LOG.error("", e);
        }

        if (output instanceof String) {
            return output.toString();
        }

        return "";
    }

    private void updateBoard() throws ScriptException, NoSuchMethodException {
        Object output = invocable.invokeFunction("getBoard");
        board = (int[]) output;
    }
}
