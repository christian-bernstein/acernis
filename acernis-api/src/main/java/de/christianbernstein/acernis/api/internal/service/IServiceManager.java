package de.christianbernstein.acernis.api.internal.service;

import java.util.Optional;

/**
 * @author Christian Bernstein
 */
public interface IServiceManager {

    IServiceManager appendService(Class<? extends Service> serviceClass);

    IServiceManager appendService(Class<? extends Service> serviceClass, Service service);

    <T extends Service> Optional<T> getService(Class<T> serviceClass);

}
