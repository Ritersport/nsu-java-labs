package ru.nsu.leorita.View.GraphicView.Figures;

import java.awt.*;

public class FigureOne implements FigureNumber {
    int x, y, width, height, line_width;

    public FigureOne(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.line_width = height / 7;
    }

    @Override
    public void draw(Graphics g) {
        int[] xPoints = {width/2, width/2, width/6, width/6, width/2 - line_width, width/2 - line_width};
        int[] yPoints = {height * 3 / 4, height / 7, height * 5 / 12, height * 5 / 12 + line_width, height * 2 / 7 + line_width, height * 3 / 4};

        FigureNumber.setGraphics((Graphics2D) g, xPoints, yPoints, x, y, Color.BLUE);
    }
}
