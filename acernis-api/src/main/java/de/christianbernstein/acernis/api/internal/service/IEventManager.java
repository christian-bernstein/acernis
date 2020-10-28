package de.christianbernstein.acernis.api.internal.service;

import lombok.NonNull;

import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author Christian Bernstein
 */
public interface IEventManager {

    void appendAll(@NonNull Object instance);

    void appendMethodSubscriber(@NonNull Method subscriberMethod, @NonNull Object instance);

    void appendFieldSubscriber(Class<? extends Event> eventClass, @NonNull ISubscriber<?> subscriber);

    void appendBus(@NonNull Bus bus);

    List<RegisteredSubscriber> getSubscribersOfEvent(Class<? extends Event> eventClass);

    Stream<RegisteredSubscriber> filter(@NonNull Predicate<SubscribeEvent> filter);

    void removeViaPredicates(List<Predicate<SubscribeEvent>> filter, boolean enableSingleMatch);

    void fireEvent(@NonNull Event event, Consumer<Event.Result> handler, String... bus);
}
