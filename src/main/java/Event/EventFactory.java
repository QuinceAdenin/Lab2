package Event;

import Personnel.Personnel;
import Resource.Resource;

//Интерфейс паттерна фабрика мероприятий
public interface EventFactory {
    Event createEvent(EventType type, Resource myResource, Personnel personnel, String description);
}