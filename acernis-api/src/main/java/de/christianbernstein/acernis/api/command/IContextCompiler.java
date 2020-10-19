package de.christianbernstein.acernis.api.command;

/**
 * @author Christian Bernstein
 */
public interface IContextCompiler {

    IContext compile(IConductor conductor, String command);

}
