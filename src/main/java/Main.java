import Components.Event.Event;
import Components.Event.EventFactory;
import Components.Event.SingletonEventFactory;
import Components.Personnel.Personnel;
import Components.Personnel.PersonnelFactory;
import Components.Personnel.SingletonPersonnelFactory;
import Components.Resource.Resource;
import Components.Resource.ResourceFactory;
import Components.Resource.SingletonResourceFactory;
import Components.Schedule.Schedule;
import Components.Event.EventType;
import Components.Schedule.ScheduleObserver;
import Components.Schedule.ScheduleNotifier;
import Components.Schedule.Command;
import Components.Schedule.CreateEventCommand;
import Components.Schedule.Visitor;
import Components.Schedule.EventPrinterVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// Паттерны: Синглтон, Фабрика, Команда, Посетитель, Наблюдатель, Мост, Компоновщик

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanBeanConfig.class);
        EventFactory weddingFactory = context.getBean(EventFactory.class);
        ResourceFactory resourceFactory = context.getBean(ResourceFactory.class);
        PersonnelFactory personnelFactory = context.getBean(PersonnelFactory.class);
        Schedule schedule = context.getBean(Schedule.class);

        EventType eventType = EventType.WEDDING;
        String resourceDescription = "Wedding Hall";
        String personnelRole = "Wedding Planner";
        String eventDescription = "Beautiful wedding ceremony";

        Personnel personnel = personnelFactory.createPersonnel(personnelRole);
        Resource myResource = resourceFactory.createResource(resourceDescription);
        Event weddingEvent = weddingFactory.createEvent(eventType, myResource, personnel, eventDescription);

        Command command1 = context.getBean(Command.class, weddingEvent, schedule);
        command1.execute();

        EventType eventType2 = EventType.NEW_YEAR_CELEBRATION;
        String resourceDescription2 = "Snowman";
        String personnelRole2 = "Santa";
        String eventDescription2 = "Snowing";

        Personnel personnel2 = personnelFactory.createPersonnel(personnelRole2);
        Resource myResource2 = resourceFactory.createResource(resourceDescription2);
        Event newyearEvent = weddingFactory.createEvent(eventType2, myResource2, personnel2, eventDescription2);

        Command command2 = context.getBean(Command.class, newyearEvent, schedule);
        command2.execute();
    }
}
