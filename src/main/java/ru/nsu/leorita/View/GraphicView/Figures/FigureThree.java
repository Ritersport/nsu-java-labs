package ru.nsu.leorita.View.GraphicView.Figures;

import java.awt.*;

public class FigureThree implements FigureNumber {
    int x, y, width, height, line_width;

    public FigureThree(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.line_width = height / 7;
    }

    @Override
    public void draw(Graphics g) {
        int[] xPoints = {   (int) (width * (double) 1 / 4), //0
                (int) (width * (double) 1 / 4), //1
                (int) (width * (double) 11 / 20), //2
                (int) (width * (double)11 / 20), //3
                (int) (width * (double) 2 / 5),     //4
                (int) (width * (double)2 / 5),     //5
                (int) (width * (double)11 / 20),
                (int) (width * (double)11 / 20),     //7
                (int) (width * (double)1 / 4),    //8
                (int) (width * (double)1 / 4),     //9
                (int) (width * (double)13 / 20),//10
                (int) (width * (double)7 / 10),
                (int) (width * (double)7 / 10),
                (int) (width * (double)13 / 20),
                (int) (width * (double)13 / 20),
                (int) (width * (double)7 / 10),
                (int) (width * (double)7 / 10),
                (int) (width * (double)13 / 20),

        };

        int[] yPoints = {  (int) (width * (double) 1 / 5),               //0
                (int) (height * (double)7 / 20), //1
                (int) (height * (double)7 / 20), //2
                (int) (height * (double)9 / 20),                   //3
                (int) (height * (double)9 / 20),                   //4
                (int) (height * (double)1 / 2),                   //5
                (int) (height * (double)1 / 2),
                (int) (height * (double)3 / 5),                   //7
                (int) (width * (double)3 / 5),                   //8
                (int) (width * (double)7 / 10),               //9
                (int) (width * (double)7 / 10),                      //10
                (int) (width * (double)13 / 20),
                (int) (height * (double)11 / 20),
                (int) (width * (double)1 / 2),
                (int) (width * (double)9 / 20),
                (int) (width * (double)2 / 5),
                (int) (width * (double)1 / 4),
                (int) (width * (double)1 / 5),

        };
        FigureNumber.setGraphics((Graphics2D) g, xPoints, yPoints, x, y, Color.RED);
    }


}
