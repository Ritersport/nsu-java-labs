package ru.nsu.leorita.View.GraphicView.Figures;

import java.awt.*;

public class FigureSeven implements FigureNumber{
    int x, y, width, height, line_width;

    public FigureSeven(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.line_width = height / 7;
    }

    @Override
    public void draw(Graphics g) {
        int[] xPoints = {
                (int) (width * (double) 5 / 20),
                (int) (width * (double)5 / 20),
                (int) (width * (double)12 / 20),
                (int) (width * (double)5 / 20),
                (int) (width * (double)7 / 20),
                (int) (width * (double)14 / 20),
                (int) (width * (double)14 / 20),

        };

        int[] yPoints = {
                (int) (width * (double) 4 / 20),
                (int) (height * (double)6 / 20),
                (int) (height * (double)6 / 20),
                (int) (width * (double)15 / 20),
                (int) (width * (double)15 / 20),
                (int) (width * (double)5 / 20),
                (int) (width * (double)4 / 20),

        };

        FigureNumber.setGraphics((Graphics2D) g, xPoints, yPoints, x, y, Color.getHSBColor((float) 0.78, 1F, (float) 0.9));
    }
}
