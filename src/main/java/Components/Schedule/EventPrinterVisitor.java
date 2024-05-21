package Components.Schedule;

import Components.Event.Event;
import org.springframework.stereotype.Component;

//Паттерн Посетитель

public class EventPrinterVisitor implements Visitor {
    @Override
    public void visit(Event event) {
        System.out.println("Event details: " + event.toString());
    }
}