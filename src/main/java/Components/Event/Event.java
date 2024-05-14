package Components.Event;

import Components.Schedule.Visitor;

public interface Event {
    void accept(Visitor visitor);
    String toString();
}
