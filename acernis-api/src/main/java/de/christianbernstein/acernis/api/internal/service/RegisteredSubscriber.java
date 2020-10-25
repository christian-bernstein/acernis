package de.christianbernstein.acernis.api.internal.service;

import lombok.AllArgsConstructor;
import lombok.NonNull;

/**
 * @author Christian Bernstein
 */
@AllArgsConstructor
public class RegisteredSubscriber {

    @NonNull
    private final SubscribeEvent subscribeMeta;

    @NonNull
    private final ISubscriber<?> subscriber;

}
