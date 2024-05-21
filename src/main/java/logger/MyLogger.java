package logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogger {

    @AfterReturning(value = "execution(Components.Schedule.Schedule *.*(..))", returning = "schedule")
    public void afterSchedule() {
        System.out.println("[] - Schedule created.");
    }

    @Before("execution(* Components.Schedule.CreateEventCommand.execute(..))")
    public void beforeCommand() {
        System.out.println("[] - Beginning of command execution");
    }
    @After("execution(* Components.Schedule.CreateEventCommand.execute(..))")
    public void afterCommand() {
        System.out.println("[] - Execution has ended");
    }
}
