package Event;

import Schedule.Visitor;

public interface Event {
    void accept(Visitor visitor);
    String toString();
}
