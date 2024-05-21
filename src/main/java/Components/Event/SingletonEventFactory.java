package Components.Event;
import Components.Resource.Resource;
import Components.Personnel.Personnel;

//Класс реализующий паттерн фабрика мероприятий

public class SingletonEventFactory implements EventFactory {
    private static SingletonEventFactory instance;//единственный экз

    private SingletonEventFactory() {} //Приватный конструктор
    //создание синглтона
    public static SingletonEventFactory getInstance() {
        if (instance == null) {
            instance = new SingletonEventFactory();
        }
        return instance;
    }
    //Создание мероприятия
    @Override
    public Event createEvent(EventType type, Resource myResource, Personnel personnel, String description) {
        return new MyEvent(type, myResource, personnel, description);
    }
}

