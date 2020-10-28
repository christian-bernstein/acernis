package de.christianbernstein.acernis.api.internal.service;

import lombok.NonNull;

import java.util.Optional;

/**
 * @author Christian Bernstein
 */
public interface IServiceManager {

    IServiceManager appendService(@NonNull Class<? extends Service> serviceClass);

    <T extends Service> IServiceManager appendService(@NonNull Class<T> serviceClass, @NonNull T serviceInstance);

    <T extends Service> Optional<T> getService(@NonNull Class<T> serviceClass);

    IEventManager getEventManager();
}
