package Components.Schedule;

import Components.Event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//Класс расписание

public class Schedule {
    private List<Event> events;//Компоновщик

    @Autowired
    private Visitor visitor;

    public Schedule() {
        this.events = new ArrayList<>();
    }

    //Добавление ивента в список
    public void addEvent(Event event) {
        events.add(event);
    }

    //Реализация посетителя
    public void accept() {
        for (Event event : events) {
            event.accept(visitor);
        }
    }
}
