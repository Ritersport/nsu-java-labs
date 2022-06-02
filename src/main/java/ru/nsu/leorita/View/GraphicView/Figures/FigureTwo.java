package ru.nsu.leorita.View.GraphicView.Figures;

import java.awt.*;

public class FigureTwo implements FigureNumber {

    int x, y, width, height, line_width;

    public FigureTwo(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.line_width = height / 7;
    }

    @Override
    public void draw(Graphics g) {
        int[] xPoints = {(int) (width * (double) 7 / 10), //0
                (int) (width * (double) 7 / 10), //1
                (int) (width * (double) 3 / 10), //2
                (int) (width * (double) 7 / 10), //3
                (int) (width * (double) 7 / 10),     //5
                (int) (width * (double) 1 / 2),     //6
                (int) (width * (double) 1 / 4),
                (int) (width * (double) 3 / 20),     //7
                (int) (width * (double) 3 / 20),    //8
                (int) (width * (double) 1 / 4),     //9
                (int) (width * (double) 9 / 20),//10
                (int) (width * (double) 1 / 2),
                (int) (width * (double) 1 / 2),
                width / 20,
                width / 20

        };

        int[] yPoints = {(int) (width * (double) 3 / 4),               //0
                (int) (height * (double) 13 / 20), //1
                (int) (height * (double) 13 / 20), //2
                height / 3,                   //3
                height / 6,                   //5
                height / 10,                   //6
                (int) (height * (double) 3 / 20),
                height / 4,                   //7
                (int) (width * (double) 7 / 20),                   //8
                (int) (width * (double) 7 / 20),               //9
                height / 4,                      //10
                height / 4,
                (int) (height * (double) 2 / 5),
                (int) (width * (double) 7 / 10),
                (int) (width * (double) 3 / 4),

        };

        FigureNumber.setGraphics((Graphics2D) g, xPoints, yPoints, x, y, Color.getHSBColor(0.4F, 1F, (float) 0.7));
    }

}
