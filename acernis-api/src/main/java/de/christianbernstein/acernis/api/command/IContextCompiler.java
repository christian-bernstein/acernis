package de.christianbernstein.acernis.api.command;

import de.christianbernstein.acernis.api.command.conduction.IConductor;

/**
 * @author Christian Bernstein
 */
public interface IContextCompiler {

    ICommandDispatchContext compile(IConductor conductor, String command);

}
