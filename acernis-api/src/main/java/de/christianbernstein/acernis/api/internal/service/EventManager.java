package de.christianbernstein.acernis.api.internal.service;

import de.christianbernstein.acernis.api.internal.Ignore;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author Christian Bernstein
 */
public class EventManager implements IEventManager {

    private final List<RegisteredSubscriber> subscribers = new ArrayList<>();

    @Override
    public void appendAll(@NonNull Object instance) {

    }

    @Override
    public void appendMethodSubscriber(@NonNull Method subscriberMethod, @NonNull Object instance) {
        if (subscriberMethod.getParameterCount() != 1
                || Event.class.isAssignableFrom(subscriberMethod.getParameters()[0].getType())
                || !subscriberMethod.isAnnotationPresent(SubscribeEvent.class)
                || subscriberMethod.isAnnotationPresent(Ignore.class)){
            // Method cannot be parsed to a functioning subscriber.
            return;
        }
        final SubscribeEvent subscribeAnnotation = subscriberMethod.getAnnotation(SubscribeEvent.class);
        final MethodSubscriberWrapper wrapper = new MethodSubscriberWrapper(instance, subscriberMethod, null);
        final RegisteredSubscriber subscriber = new RegisteredSubscriber(subscribeAnnotation, wrapper);
        this.subscribers.add(subscriber);
    }

    @Override
    public void appendFieldSubscriber(Class<? extends Event> eventClass, @NonNull ISubscriber<?> subscriber) {

    }

    @Override
    public void appendBus(@NonNull Bus bus) {

    }

    @Override
    public List<RegisteredSubscriber> getSubscribersOfEvent(Class<? extends Event> eventClass) {
        return null;
    }

    @Override
    public Stream<RegisteredSubscriber> filter(@NonNull Predicate<SubscribeEvent> filter) {
        return null;
    }

    @Override
    public void removeViaPredicates(List<Predicate<SubscribeEvent>> filter, boolean enableSingleMatch) {

    }

    @Override
    public void fireEvent(@NonNull Event event, Consumer<Event.Result> handler, String... bus) {

    }

    @AllArgsConstructor
    @SuppressWarnings("all")
    public static class MethodSubscriberWrapper implements ISubscriber {

        private final Object instance;

        private final Method method;

        private final Consumer<Exception> handler;

        @Override
        public void handle(Event event) {
            try {
                method.invoke(this.instance, event);
            } catch (IllegalAccessException | InvocationTargetException e) {
                this.caughtException(e);
            }
        }

        @Override
        public void caughtException(@NonNull Exception exception) {
            if (this.handler != null){
                this.handler.accept(exception);
            } else {
                exception.printStackTrace();
            }
        }
    }
}
