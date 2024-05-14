package Schedule;

import Event.Event;
//Паттерн Посетитель
public class EventPrinterVisitor implements Visitor {
    @Override
    public void visit(Event event) {
        System.out.println("Event details: " + event.toString());
    }
}