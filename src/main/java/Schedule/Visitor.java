package Schedule;

import Event.Event;
//Паттерн Посетитель
public interface Visitor {
    void visit(Event event);
}
