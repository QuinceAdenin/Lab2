package Schedule;

import Event.Event;
//Реализация наблюдателя
public class ScheduleNotifier implements ScheduleObserver {
    @Override
    public void update(Event event) {
        System.out.println("Event added to schedule: " + event.toString());
    }
}

