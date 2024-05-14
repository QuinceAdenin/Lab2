import Event.Event;
import Event.EventFactory;
import Event.SingletonEventFactory;
import Personnel.Personnel;
import Personnel.PersonnelFactory;
import Personnel.SingletonPersonnelFactory;
import Resource.Resource;
import Resource.ResourceFactory;
import Resource.SingletonResourceFactory;
import Schedule.Schedule;
import Event.EventType;
import Schedule.ScheduleObserver;
import Schedule.ScheduleNotifier;
import Schedule.Command;
import Schedule.CreateEventCommand;
import Schedule.Visitor;
import Schedule.EventPrinterVisitor;
// Паттерны: Синглтон, Фабрика, Команда, Посетитель, Наблюдатель, Мост, Компоновщик

public class Main {
    public static void main(String[] args) {
        // Создаем фабрику для создания мероприятий
        EventFactory weddingFactory = SingletonEventFactory.getInstance();

        ResourceFactory resourceFactory = SingletonResourceFactory.getInstance();

        PersonnelFactory personnelFactory = SingletonPersonnelFactory.getInstance();
        // Создаем экземпляр класса Schedule.Schedule
        Schedule schedule = new Schedule();

        // Создаем наблюдателя
        ScheduleObserver notifier = new ScheduleNotifier();
        schedule.registerObserver(notifier);

        // Передаем данные о мероприятии
        EventType eventType = EventType.WEDDING;
        String resourceDescription = "Wedding Hall";
        String personnelRole = "Wedding Planner";
        String eventDescription = "Beautiful wedding ceremony";

        Personnel personnel = personnelFactory.createPersonnel(personnelRole);

        Resource myResource = resourceFactory.createResource(resourceDescription);
        // Создаем мероприятие с помощью фабрики мероприятий и переданных данных
        Event weddingEvent = weddingFactory.createEvent(eventType, myResource, personnel, eventDescription);

        // Создаем команду для создания мероприятия
        Command createWeddingCommand = new CreateEventCommand(weddingEvent, schedule);

        // Выполняем команду
        createWeddingCommand.execute();

        EventType eventType2 = EventType.NEW_YEAR_CELEBRATION;
        String resourceDescription2 = "Snowman";
        String personnelRole2 = "Santa";
        String eventDescription2 = "Snowing";

        Personnel personnel2 = personnelFactory.createPersonnel(personnelRole2);

        Resource myResource2 = resourceFactory.createResource(resourceDescription2);
        // Создаем мероприятие с помощью фабрики мероприятий и переданных данных
        Event newyearEvent = weddingFactory.createEvent(eventType2, myResource2, personnel2, eventDescription2);

        // Создаем команду для создания мероприятия
        Command createnewyearCommand = new CreateEventCommand(newyearEvent, schedule);

        // Выполняем команду
        createnewyearCommand.execute();

        // Выводим информацию о мероприятиях в расписании
        Visitor eventVisitor = new EventPrinterVisitor();
        schedule.accept(eventVisitor);

    }
}
