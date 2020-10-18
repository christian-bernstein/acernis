package de.christianbernstein.acernis.api.command;

import java.util.UUID;

/**
 *
 *
 * @author Christian Bernstein
 */
public interface IConductor extends IPermissible {

    UUID getPersistentID();
    
}
