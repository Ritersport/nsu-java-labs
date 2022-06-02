package ru.nsu.leorita.View.GraphicView.Figures;

import java.awt.*;
import java.awt.geom.GeneralPath;

public interface FigureNumber {
    public void draw(Graphics g);
    static void setGraphics(Graphics2D g, int[] xPoints, int[] yPoints, int x, int y, Color color) {
        GeneralPath three = new GeneralPath();

        three.moveTo(xPoints[0] + x, yPoints[0] + y);
        for (int i = 0; i < xPoints.length; i++) {
            three.lineTo(xPoints[i] + x, yPoints[i] + y);
        }
        three.closePath();

        g.setColor(color);
        g.fill(three);
    }
}
