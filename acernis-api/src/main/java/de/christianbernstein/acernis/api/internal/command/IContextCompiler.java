package de.christianbernstein.acernis.api.internal.command;

import de.christianbernstein.acernis.api.internal.command.conduction.IConductor;

/**
 * @author Christian Bernstein
 */
public interface IContextCompiler {

    ICommandDispatchContext compile(IConductor conductor, String command);

}
