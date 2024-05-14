package Schedule;

import Event.Event;
//команда
public class CreateEventCommand implements Command {
    private Event event;
    private Schedule schedule;

    public CreateEventCommand(Event event, Schedule schedule) {
        this.event = event;
        this.schedule = schedule;
    }

    @Override
    public void execute() {
        schedule.addEvent(event);
    }
}
