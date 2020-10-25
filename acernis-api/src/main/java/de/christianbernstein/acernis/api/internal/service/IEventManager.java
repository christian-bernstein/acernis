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

    void appendMethodSubscriber(@NonNull Method subscriberMethod);

    void appendFieldSubscriber(Class<? extends Event> eventClass, @NonNull ISubscriber<?> subscriber);

    void appendBus(@NonNull Bus bus);

    /**
     * @deprecated Instead use {@link IEventManager#appendBus(Bus)}
     *
     * @param busID create a new bus by id
     */
    @Deprecated
    void createBus(@NonNull String busID);

    @NonNull
    List<RegisteredSubscriber> getSubscribersForEvent(Class<? extends Event> eventClass);

    Stream<RegisteredSubscriber> filter(@NonNull Predicate<SubscribeEvent> filter);

    /**
     * Removes subscribers via matching them to a list of predicates.
     *
     * @param filter A list of predicates, that are getting used to determine, which subscribers should get
     *               removed.
     * @param enableSingleMatch At default a subscriber gets only removed if all predicates return true, if
     *                          this parameter is true, a subscriber gets removed if at least one predicate is true
     */
    void removeViaPredicates(List<Predicate<SubscribeEvent>> filter, boolean enableSingleMatch);

    /**
     *
     * @param event The event that will be distributed though the busses.
     * @param bus The event will be distributed through these busses. If the parameter is null (in this case empty),
     *            the event will be broadcasted through all busses. This equals to the bus selector: '*'
     * @param handler A handler can be hand over to handle the result of an event
     */
    void fireEvent(@NonNull Event event, Consumer<Event.Result> handler, String... bus);
}
