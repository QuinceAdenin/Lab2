package Components.Schedule;

import Components.Event.Event;
//Паттерн Посетитель
public interface Visitor {
    void visit(Event event);
}
