package Components.Schedule;

import Components.Event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//Класс расписание
@Component
public class Schedule {
    private List<Event> events = new ArrayList<>();//Компоновщик
    private List<ScheduleObserver> observers = new ArrayList<>();//Компоновщик
    //Добавление ивента в список
    public void addEvent(Event event) {
        events.add(event);
        notifyObservers(event);
    }
    //Создание наблюдателя
    public void registerObserver(ScheduleObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ScheduleObserver observer) {
        observers.remove(observer);
    }
    //Уведомление наблюдателей
    private void notifyObservers(Event event) {
        for (ScheduleObserver observer : observers) {
            observer.update(event);
        }
    }
    //Реализация посетителя
    @Autowired
    public void accept(Visitor visitor) {
        for (Event event : events) {
            event.accept(visitor);
        }
    }
}
