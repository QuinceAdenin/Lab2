package Schedule;

import Event.Event;

public interface ScheduleObserver {
    void update(Event event);
}
