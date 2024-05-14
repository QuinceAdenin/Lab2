package Event;

import Resource.Resource;//Подключили ресурсы
import Personnel.Personnel;//Подключили персонал
import Schedule.Visitor;//Подлючили посетителя
//Класс мероприятие в
public class MyEvent implements Event{
    private EventType type;
    private Resource myResource;
    private Personnel personnel;
    private String description;

    public MyEvent(EventType type, Resource myResource, Personnel personnel, String description) {
        this.type = type;
        this.myResource = myResource;
        this.personnel = personnel;
        this.description = description;
    }
    //Реализация паттерна посетитель
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    //Вывод строки
    @Override
    public String toString() {
        return "Event Type: " + type +
                ", Resource: " + myResource.getDescription() +
                ", Personnel: " + personnel.getRole() +
                ", Description: " + description;
    }
}
