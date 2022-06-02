package ru.nsu.leorita.Controller;

import ru.nsu.leorita.GameSettings;
import ru.nsu.leorita.Listener;
import ru.nsu.leorita.Model.Model;
import ru.nsu.leorita.Model.Point;
import ru.nsu.leorita.View.GraphicView.GraphicView;
import ru.nsu.leorita.Model.Events;

import javax.swing.*;
import java.io.IOException;

public class GraphicController implements Controller, Listener {

    int fWidth;
    int fHeight;
    int minesCount;
    Model model;
    GraphicView view;
    public GameSettings settings;
    Thread timer;
    static boolean gameStopped = false;

    public GraphicController() throws IOException {
        this.settings = new GameSettings();
        this.model = new Model();
        model.events.subscribeAll(this);
        view = new GraphicView();
    }

    @Override
    public void newGame() {
        gameStopped = true;
        getStats();
        view.newGame(model, this, fWidth, fHeight, minesCount);
        SwingUtilities.invokeLater(view::init);
    }

    @Override
    public void update(Events eventType, int x, int y) {
        switch (eventType) {
            case WIN, GAMEOVER -> {
                gameStopped = true;
            }
        }

    }

    public void cellPressedLeft(int x, int y) {
        model.openCell(new Point(x, y));
    }

    public void cellPressedRight(int x, int y) {
        model.changeCellState(new Point(x, y));
    }

    private void getStats() {
        settings.updateStats();
        fWidth = settings.getfWidth();
        fHeight = settings.getfHeight();
        minesCount = settings.getMinesCount();
    }

    public void firstMove(int x, int y) {
        gameStopped = false;
        model.newGame(fWidth, fHeight, minesCount, x, y);
        view.setMines();
        startTimer();
        model.openCell(new Point(x, y));
    }

    public int getNumOfMines(int x, int y) {
        return model.getNumOfMines(x, y);
    }

    private void startTimer() {
        timer = new Thread(() -> {
            int second = 0;
            while (!gameStopped) {
                try {
                    view.setTime(second);
                    Thread.sleep(1000);
                    if (second < 999) second++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        timer.start();

    }
}

