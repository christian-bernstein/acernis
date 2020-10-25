package de.christianbernstein.acernis.api.internal.service;

import lombok.Builder;
import lombok.NonNull;

/**
 * @author Christian Bernstein
 */
@Builder
public class Bus {
    
    @NonNull
    private final String busID;
    
    @Builder.Default
    private final boolean log = false;

}
