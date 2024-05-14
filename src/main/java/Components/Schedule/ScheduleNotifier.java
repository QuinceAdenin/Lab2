package Components.Schedule;

import Components.Event.Event;
//Реализация наблюдателя
public class ScheduleNotifier implements ScheduleObserver {
    @Override
    public void update(Event event) {
        System.out.println("Components.Event added to schedule: " + event.toString());
    }
}

