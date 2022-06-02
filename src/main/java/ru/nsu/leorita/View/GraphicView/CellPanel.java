package ru.nsu.leorita.View.GraphicView;

import ru.nsu.leorita.View.GraphicView.Figures.*;
import ru.nsu.leorita.View.GraphicView.Figures.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class CellPanel extends JPanel {
    private final int x;
    private final int y;
    private int mines;
    private ArrayList<FigureNumber> shapes = new ArrayList<>();

    public CellPanel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setMines(int mines) {
        this.mines = mines;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Object s : shapes) {
            if (s instanceof FigureOne) {
                ((FigureOne) s).draw(g);
            } else if (s instanceof FigureTwo) {
                     ((FigureTwo) s).draw(g);
            }
            else if (s instanceof FigureThree) {
                ((FigureThree) s).draw(g);
            }
            else if (s instanceof FigureFour) {
                ((FigureFour) s).draw(g);
            }
            else if (s instanceof FigureFive) {
                ((FigureFive) s).draw(g);
            }
            else if (s instanceof FigureSix) {
                ((FigureSix) s).draw(g);
            }
            else if (s instanceof  FigureSeven) {
                ((FigureSeven) s).draw(g);
            }
            else if (s instanceof FigureEight) {
                ((FigureEight) s).draw(g);
            }
        }

    }

    public void drawNumber() {
        setBackground(Color.getHSBColor((float) 0.8, 0.1F, (float) 0.93));
        addFigure(0, 0, 30, 30, mines);
    }


    public void addFigure(int x, int y, int height, int width, int num) {
        switch (num) {
            case 1 -> {
                shapes.add(new FigureOne(x, y, width, height));
            }
            case 2 -> {
                shapes.add(new FigureTwo(x, y, width, height));
            }
            case 3 -> {
                shapes.add(new FigureThree(x, y, width, height));
            }
            case 4 -> {
                shapes.add(new FigureFour(x, y, width, height));
            }
            case 5 -> {
                shapes.add(new FigureFive(x, y, width, height));
            }
            case 6 -> {
                shapes.add(new FigureSix(x, y, width, height));
            }
            case 7 -> {
                shapes.add(new FigureSeven(x, y, width, height));
            }
            case 8 -> {
                shapes.add(new FigureEight(0, 0, width, height));
            }
        }
        repaint();
    }
}
