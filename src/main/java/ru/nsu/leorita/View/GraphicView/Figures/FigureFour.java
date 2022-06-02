package ru.nsu.leorita.View.GraphicView.Figures;

import java.awt.*;

public class FigureFour implements FigureNumber {
    int x, y, width, height, line_width;

    public FigureFour(int x, int y, int width, int height) {
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
                (int) (width * (double) 10 / 20), //2
                (int) (width * (double)10 / 20), //3
                (int) (width * (double) 13 / 20),     //4
                (int) (width * (double)13 / 20),     //5
                (int) (width * (double)11 / 20),
                (int) (width * (double)11 / 20),     //7
                (int) (width * (double)6 / 20),    //8
                (int) (width * (double)6 / 20)

        };

        int[] yPoints = {
                (int) (width * (double) 2 / 20),               //0
                (int) (height * (double)10 / 20), //1
                (int) (height * (double)10 / 20), //2
                (int) (height * (double)14 / 20),                   //3
                (int) (height * (double)14 / 20),                   //4
                (int) (height * (double)2 / 20),                   //5
                (int) (height * (double)2 / 20),
                (int) (height * (double)7 / 20),                   //7
                (int) (width * (double)7 / 20),                   //8
                (int) (width * (double)2 / 20)

        };
        FigureNumber.setGraphics((Graphics2D) g, xPoints, yPoints, x, y, Color.getHSBColor((float) 0.7, 1F, (float) 0.5));
    }


}
