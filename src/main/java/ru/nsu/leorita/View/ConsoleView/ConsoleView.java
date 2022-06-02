package ru.nsu.leorita.View.ConsoleView;

import ru.nsu.leorita.Controller.ConsoleController;
import ru.nsu.leorita.Listener;
import ru.nsu.leorita.Model.Events;
import ru.nsu.leorita.Model.Model;
import ru.nsu.leorita.View.View;

public class ConsoleView implements View, Listener {

    public ConsoleView(Model model, ConsoleController controller) {
        model.events.subscribeAll(this);
    }

    @Override
    public void update(Events eventType, int x, int y) {

    }

    public void printField() {

    }


    @Override
    public void init() {

    }
}
