package ru.nsu.leorita;

import ru.nsu.leorita.Controller.ConsoleController;
import ru.nsu.leorita.Controller.GraphicController;
import java.io.IOException;

public class Minesweeper {
    public static void main(String[] args) throws IOException {
        GraphicController controller = new GraphicController();
        controller.newGame();
    }
}

