package de.christianbernstein.acernis.api.internal.command.conduction;

import java.util.UUID;

/**
 * @author Christian Bernstein
 */
public interface IConductor extends IPermissible {

    UUID getID();

    void sendMessage(String message);

}
