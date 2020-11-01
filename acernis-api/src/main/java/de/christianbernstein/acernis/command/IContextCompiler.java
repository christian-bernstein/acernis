package de.christianbernstein.acernis.command;

import de.christianbernstein.acernis.command.conduction.IConductor;

/**
 * @author Christian Bernstein
 */
public interface IContextCompiler {

    ICommandDispatchContext compile(IConductor conductor, String command);

}
