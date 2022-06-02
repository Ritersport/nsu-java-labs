package ru.nsu.leorita.Model;

public class Field {
    private Cell[][] field;
    private int fWidth;
    private int fHeight;
    private int mineCount;

    Field(int fWidth, int fHeight, int mineCount) {

        this.mineCount = mineCount;
        this.fWidth = fWidth;
        this.fHeight = fHeight;
        this.field = new Cell[fWidth][fHeight];

        for (int i = 0; i < this.fWidth; i++) {
            for (int j = 0; j < this.fHeight; j++) {
                field[i][j] = new Cell(i, j);
            }
        }
    }


    public boolean isMinePoint(Point p) {
        return (p.getX() >= 0) && (p.getY() >= 0) && (p.getX() < fWidth) && (p.getY() < fHeight);
    }


    public void open(Point p) {
        field[p.getX()][p.getY()].open();
    }


    public  boolean getIsMined(Point p) {
        return field[p.getX()][p.getY()].getIsMined();
    }


    public State getState(Point p) {
        return field[p.getX()][p.getY()].getState();
    }

    public int getNumOfMines(Point p) {
        return field[p.getX()][p.getY()].getNumOfMines();
    }

    public void nextMark(Point p) {
        field[p.getX()][p.getY()].nextMark();
    }

    public void makeMined(Point p) {
        field[p.getX()][p.getY()].makeMined();
    }

    public void setNumOfMines(Point p, int count) {
        field[p.getX()][p.getY()].setNumOfMines(count);
    }


    public Cell getCell(Point p) {
        return field[p.getX()][p.getY()];
    }

}
