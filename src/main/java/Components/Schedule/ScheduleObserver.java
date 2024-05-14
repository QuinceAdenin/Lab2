package Components.Schedule;

import Components.Event.Event;

public interface ScheduleObserver {
    void update(Event event);
}
