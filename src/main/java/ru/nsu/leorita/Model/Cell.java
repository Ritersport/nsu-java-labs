package ru.nsu.leorita.Model;

import org.jetbrains.annotations.NotNull;
import ru.nsu.leorita.EventManager;

enum State {CLOSED, OPENED, FLAGGED};

public class Cell {
    private int x;
    private int y;
    private boolean isMined;
    private int numOfMines = 0;
    private State state;

    public boolean getIsMined() {

        return this.isMined;
    }

    public int getX() {

        return this.x;
    }

    public int getY() {

        return this.y;
    }

    public Point getPoint() {
        return new Point(x, y);
    }

    public State getState() {
        return this.state;
    }

    public int getNumOfMines() {
        return this.numOfMines;
    }

    public void setNumOfMines(int numOfMines) {
        if (isMined) {
            this.numOfMines = -1;
        }
        else {
            this.numOfMines = numOfMines;
        }
    }

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.isMined = false;
        this.numOfMines = 0;
        this.state = State.CLOSED;
    }

    public void open() {
//        System.out.println("opened cell" + (new Point(x, y).toString()));
        this.state = State.OPENED;
    }

    public void nextMark() {
        if ((this.state).equals(State.CLOSED)) {
            this.state = State.FLAGGED;

        } else if ((this.state).equals(State.FLAGGED)) {
            this.state = State.CLOSED;

        }
    }

    public void makeMined() {
        this.isMined = true;
    }
}
