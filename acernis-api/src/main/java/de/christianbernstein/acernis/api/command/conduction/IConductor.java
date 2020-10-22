package de.christianbernstein.acernis.api.command.conduction;

import de.christianbernstein.acernis.api.command.conduction.IPermissible;

import java.util.UUID;

/**
 * @author Christian Bernstein
 */
public interface IConductor extends IPermissible {

    UUID getID();

    void sendMessage(String message);

}
