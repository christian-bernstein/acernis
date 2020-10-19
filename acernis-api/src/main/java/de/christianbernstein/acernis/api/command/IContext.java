package de.christianbernstein.acernis.api.command;

import de.christianbernstein.acernis.api.command.parameters.IContainer;
import de.christianbernstein.acernis.api.internal.IParser;
import lombok.NonNull;

/**
 * A context holds all data of a command. The context is used to retrieve all the data for processing and
 * permission management. A {@link IParser} is used for construction.
 *
 * @author Christian Bernstein
 */
public interface IContext {

    @NonNull
    IConductor getConductor();

    /**
     * Provides parameters for the command. Those parameters are validates, by a pattern
     * in the {@link INode}
     *
     * @return IContainer instance
     */
    @NonNull
    IContainer getParameters();

    @NonNull
    IContainer getProperties();

    @NonNull
    String getRaw();
}
