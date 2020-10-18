package de.christianbernstein.acernis.api.command;

import de.christianbernstein.acernis.api.command.permissions.IPermissible;

import java.util.UUID;

/**
 *
 *
 * @author Christian Bernstein
 */
public interface IConductor extends IPermissible {

    UUID getPersistentID();

}
