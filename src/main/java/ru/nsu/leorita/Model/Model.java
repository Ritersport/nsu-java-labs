package ru.nsu.leorita.Model;

import ru.nsu.leorita.EventManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Model {

    public EventManager events;
    private GameRound round;
    private List<Events> operations;
    private final Point[] offsets =
            {new Point(-1, -1),
                    new Point(-1, 0),
                    new Point(-1, 1),
                    new Point(0, -1),
                    new Point(0, 1),
                    new Point(1, -1),
                    new Point(1, 0),
                    new Point(1, 1)
            };



    public Model() {
        this.operations = new ArrayList<>();
        this.operations.addAll(Arrays.asList(Events.values()));
        this.events = new EventManager(operations);
    }

    public void newGame(int width, int height, int mineCount, int firstX, int firstY) {
        this.round = new GameRound(width, height, mineCount);
        round.start(firstX,firstY);
    }

    public void openCell(Point p) {
        if (round.getState(p).equals(State.CLOSED)) {
            if (round.getIsMined(p)) {
                events.notify(Events.GAMEOVER, p.getX(), p.getY());
            }
            else {
                events.notify(Events.OPEN_CELL, p.getX(), p.getY());
                round.openCell(p);
                checkWin();
                if (round.getNumOfMines(p) == 0) {
                    for (Point i : offsets) {
                        Point j = i.addPoint(round.getCell(p).getPoint());
                        if (round.isMinePoint(j)) {
                            if (round.getState(j).equals(State.CLOSED)) {
                                openCell(j);
                            }
                        }
                    }
                }
            }
        }
    }

    public void changeCellState(Point p) {

        round.nextMark(p);
        if (round.getState(p).equals(State.FLAGGED)) {
            events.notify(Events.PUT_FLAG, p.getX(), p.getY());
        }
        if (round.getState(p).equals(State.CLOSED)) {
            events.notify(Events.CLOSE_CELL, p.getX(), p.getY());
        }
    }


    private void checkWin() {
        if (round.checkWin()) {
            events.notify(Events.WIN, 0, 0);
        }
    }

    public int getNumOfMines(int x, int y) {
        Point p = new Point(x, y);
        return round.getNumOfMines(p);
    }

}