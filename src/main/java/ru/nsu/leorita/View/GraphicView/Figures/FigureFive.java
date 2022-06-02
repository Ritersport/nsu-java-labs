package ru.nsu.leorita.View.GraphicView.Figures;

import java.awt.*;

public class FigureFive implements  FigureNumber{
    int x, y, width, height, line_width;

    public FigureFive(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.line_width = height / 7;
    }

    @Override
    public void draw(Graphics g) {
        int[] xPoints = {
                (int) (width * (double) 4 / 20), //0
                (int) (width * (double) 4 / 20), //1
                (int) (width * (double) 5 / 20), //2//3
                (int) (width * (double) 12 / 20),     //4
                (int) (width * (double)12 / 20),     //5
                (int) (width * (double)4 / 20),
                (int) (width * (double)4 / 20),     //7
                (int) (width * (double)12 / 20),    //8
                (int) (width * (double)13 / 20),
                (int) (width * (double)13 / 20),
                (int) (width * (double)5 / 20),
                (int) (width * (double)5 / 20),
                (int) (width * (double)13 / 20),
                (int) (width * (double)13 / 20)

        };

        int[] yPoints = {
                (int) (width * (double) 3 / 20),               //0
                (int) (height * (double)7 / 20), //1
                (int) (height * (double)8 / 20), //2
                (int) (height * (double)8 / 20),                   //3
                (int) (height * (double)12 / 20),                   //4
                (int) (height * (double)12 / 20),                   //5
                (int) (height * (double)13 / 20),
                (int) (height * (double)13 / 20),                   //7
                (int) (width * (double)12 / 20),                   //8
                (int) (width * (double)7 / 20),
                (int) (width * (double)7 / 20),
                (int) (width * (double)4 / 20),
                (int) (width * (double)4 / 20),
                (int) (width * (double)3 / 20)

        };
        FigureNumber.setGraphics((Graphics2D) g, xPoints, yPoints, x, y, Color.getHSBColor((float) 0.9, 1F, (float) 0.5));
    }
}
