package de.christianbernstein.acernis.conduction;

import java.util.UUID;

/**
 * @author Christian Bernstein
 */
public interface IConductor extends IPermissible {

    UUID getID();

    void sendMessage(String message);

}
