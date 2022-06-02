package ru.nsu.leorita;

import ru.nsu.leorita.Model.Events;

public interface Listener {
    void update(Events eventType, int x, int y);
}
