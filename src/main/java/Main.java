import Components.Event.Event;
import Components.Event.EventFactory;
import Components.Personnel.Personnel;
import Components.Personnel.PersonnelFactory;
import Components.Resource.Resource;
import Components.Resource.ResourceFactory;
import Components.Schedule.Schedule;
import Components.Event.EventType;
import Components.Schedule.Command;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// Паттерны: Синглтон, Фабрика, Команда, Посетитель, Наблюдатель, Мост, Компоновщик

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanBeanConfig.class);

        EventFactory eventFactory = context.getBean(EventFactory.class);
        ResourceFactory resourceFactory = context.getBean(ResourceFactory.class);
        PersonnelFactory personnelFactory = context.getBean(PersonnelFactory.class);
        Schedule schedule = context.getBean(Schedule.class);

        EventType eventType1 = EventType.WEDDING;
        String resourceDescription1 = "Wedding Hall";
        String personnelRole1 = "Wedding Planner";
        String eventDescription1 = "Beautiful wedding ceremony";

        Personnel personnel1 = personnelFactory.createPersonnel(personnelRole1);
        Resource resource1 = resourceFactory.createResource(resourceDescription1);
        Event weddingEvent = eventFactory.createEvent(eventType1, resource1, personnel1, eventDescription1);

        Command createWeddingCommand = context.getBean(Command.class, weddingEvent, schedule);
        createWeddingCommand.execute();

        EventType eventType2 = EventType.NEW_YEAR_CELEBRATION;
        String resourceDescription2 = "Snowman";
        String personnelRole2 = "Santa";
        String eventDescription2 = "Snowing";

        Personnel personnel2 = personnelFactory.createPersonnel(personnelRole2);
        Resource resource2 = resourceFactory.createResource(resourceDescription2);
        Event newYearEvent = eventFactory.createEvent(eventType2, resource2, personnel2, eventDescription2);

        Command createNewYearCommand = context.getBean(Command.class, newYearEvent, schedule);
        createNewYearCommand.execute();

        schedule.accept();
    }
}
