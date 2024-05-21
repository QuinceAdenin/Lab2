package Components.Event;

import Components.Resource.Resource;//Подключили ресурсы
import Components.Personnel.Personnel;//Подключили персонал
import Components.Schedule.Visitor;//Подлючили посетителя
import org.springframework.beans.factory.annotation.Autowired;
//Класс мероприятие

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
        return "EventType: " + type +
                ", Resource: " + myResource.getDescription() +
                ", Personnel: " + personnel.getRole() +
                ", Description: " + description;
    }
}
