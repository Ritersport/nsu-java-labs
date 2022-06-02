package ru.nsu.leorita.Model;

import java.util.Vector;

public class GameRound {

    private final int fWidth;
    private final int fHeight;
    private final int minesCount;
    private int leftToOpen;
    private Vector<Point> notMinedPoints;
    private Field field;
    private final Point[] offsets = {
            new Point(-1, -1),
            new Point(-1, 0),
            new Point(-1, 1),
            new Point(0, -1),
            new Point(0, 1),
            new Point(1, -1),
            new Point(1, 0),
            new Point(1, 1)
    };


    public GameRound(int width, int height, int minesCount) {
        notMinedPoints = new Vector<>();
        this.fWidth = width;
        this.fHeight = height;
        this.minesCount = minesCount;
        this.leftToOpen = fHeight * fWidth - minesCount;
    }

    public void start(int firstX, int firstY) {
        field = new Field(fWidth, fHeight, minesCount);
        setMines(firstX, firstY);
        setNumOfMines();
    }


    private void setMines(int firstX, int firstY) {
        for (int i = 0; i < fWidth; i++) {
            for (int j = 0; j < fHeight; j++) {
                if ((i != firstX) || (j != firstY)) {
                    notMinedPoints.add(new Point(i, j));
                }
            }
        }
        int mines = 0;
        while (mines < minesCount) {
            Point p = getRandomFreePoint();
            mines++;
            field.makeMined(p);
        }
    }

    public boolean getIsMined(Point p) {
        return field.getIsMined(p);
    }

    public Cell getCell(Point p) {
        return field.getCell(p);
    }

    public boolean isMinePoint(Point p) {
        return field.isMinePoint(p);
    }

    public void openCell(Point p) {

        field.open(p);
        leftToOpen--;
    }


    public State getState(Point p) {
        return field.getState(p);
    }

    public void nextMark(Point p) {
        field.nextMark(p);
    }

    private void setNumOfMines() {
        for (int i = 0; i < fWidth; i++) {
            for (int j = 0; j < fHeight; j++) {
                Point p = new Point(i, j);
                field.setNumOfMines(p, countMines(field.getCell(p)));
            }
        }
    }

    private int countMines(Cell c) {
        int count = 0;
        for (Point i : offsets) {
            Point j = i.addPoint(c.getPoint());
            if (field.isMinePoint(j)) {
                if (field.getCell(j).getIsMined()) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getNumOfMines(Point p) {
        return field.getNumOfMines(p);
    }

    public boolean checkWin() {
        return (leftToOpen == 0);
    }

    public Point getRandomFreePoint() {

        int key = (int) ((Math.random() * (notMinedPoints.size() - 1)));
        Point p = notMinedPoints.elementAt(key);
        notMinedPoints.remove(key);
        return p;
    }
}
