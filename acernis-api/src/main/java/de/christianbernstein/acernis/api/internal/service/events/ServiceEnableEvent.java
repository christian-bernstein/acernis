package de.christianbernstein.acernis.api.internal.service.events;

import de.christianbernstein.acernis.api.internal.service.Event;
import de.christianbernstein.acernis.api.internal.service.EventMeta;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Christian Bernstein
 */
@AllArgsConstructor
@EventMeta(isCancellable = false)
public class ServiceEnableEvent extends Event {

    @Getter
    private final String serviceName;

}
