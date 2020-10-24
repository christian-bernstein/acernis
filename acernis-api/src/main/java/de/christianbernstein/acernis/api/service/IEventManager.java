package de.christianbernstein.acernis.api.service;

import java.util.function.Consumer;

/**
 * @author Christian Bernstein
 */
public interface IEventManager {

    void fireEvent(Event event, String bus, Consumer<Event.Result> handler);

    default void fireEvent(Event event, String bus){
        this.fireEvent(event, bus, null);
    }

    default void fireEvent(Event event){
        this.fireEvent(event, "*", null);
    }
}
