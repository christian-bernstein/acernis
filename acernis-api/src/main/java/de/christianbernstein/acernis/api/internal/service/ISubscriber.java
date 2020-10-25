package de.christianbernstein.acernis.api.internal.service;

import lombok.NonNull;

/**
 * @author Christian Bernstein
 */
@FunctionalInterface
public interface ISubscriber<T extends Event> {

    void handle(@NonNull T event);

    /**
     * @param exception The exception, which raised in {@link ISubscriber#handle(Event)}.
     */
    default void caughtException(@NonNull Exception exception){
        exception.printStackTrace();
    }
}
