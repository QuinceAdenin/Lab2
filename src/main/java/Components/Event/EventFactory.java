package Components.Event;

import Components.Personnel.Personnel;
import Components.Resource.Resource;

//Интерфейс паттерна фабрика мероприятий
public interface EventFactory {
    Event createEvent(EventType type, Resource myResource, Personnel personnel, String description);
}