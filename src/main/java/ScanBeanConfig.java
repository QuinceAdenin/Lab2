import Components.Event.EventFactory;
import Components.Event.SingletonEventFactory;
import Components.Personnel.PersonnelFactory;
import Components.Personnel.SingletonPersonnelFactory;
import Components.Resource.ResourceFactory;
import Components.Resource.SingletonResourceFactory;
import Components.Schedule.*;
import Components.Event.Event;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScan(basePackages = {"Components", "logger"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
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
    public Schedule schedule() {
        return new Schedule();
    }

    @Bean
    @Scope("prototype")
    public Command command(Event event, Schedule schedule) {
        return new CreateEventCommand(event, schedule);
    }

    @Bean
    public Visitor visitor() {
        return new EventPrinterVisitor();
    }
}

