import de.christianbernstein.acernis.api.internal.service.*;
import de.christianbernstein.acernis.api.internal.service.events.ServiceEnableEvent;

/**
 * @author Christian Bernstein
 */
public class ServiceEventTest {

    @ServiceMeta(id = "greeting_service")
    public static class GreetingService extends Service {

        @SubscribeEvent
        public static final ISubscriber<ServiceEnableEvent> enableSubscriber = event -> {
            System.out.println("Hello from the GreetingService!");
        };

        @SubscribeEvent
        public void onEnable(ServiceEnableEvent event){
            System.out.println("New service: " + event.getServiceName());
        }
        
        public void greet(String name){
            System.out.printf("Hello, %s", name);
        }
    }
}
