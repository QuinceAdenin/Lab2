import Event.EventFactory;
import Event.SingletonEventFactory;
import Personnel.PersonnelFactory;
import Personnel.SingletonPersonnelFactory;
import Resource.ResourceFactory;
import Resource.SingletonResourceFactory;
import Schedule.Schedule;
import Schedule.Command;
import Event.Event;
import Schedule.CreateEventCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class ScanBeanConfig {
    @Bean
    public EventFactory eventFactory() {
        return SingletonEventFactory.getInstance();
    }

    @Bean
    public ResourceFactory resourceFactory() {
        return SingletonResourceFactory.getInstance();
    }

    @Bean
    public PersonnelFactory personnelFactory() {
        return SingletonPersonnelFactory.getInstance();
    }
    @Bean
    @Scope("prototype")
    public Schedule schedule(){
        return new Schedule();
    }
    @Bean
    @Scope("prototype")
    public Command command(Event event,Schedule schedule){
        return new CreateEventCommand(event, schedule);
    }
}

