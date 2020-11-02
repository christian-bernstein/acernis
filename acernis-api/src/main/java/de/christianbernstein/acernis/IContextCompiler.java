package de.christianbernstein.acernis;

import de.christianbernstein.acernis.conduction.IConductor;

/**
 * @author Christian Bernstein
 */
public interface IContextCompiler {

    ICommandDispatchContext compile(IConductor conductor, String command);

}
