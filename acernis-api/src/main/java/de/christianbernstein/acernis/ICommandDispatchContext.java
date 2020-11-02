package de.christianbernstein.acernis;

import de.christianbernstein.acernis.conduction.IConductor;
import de.christianbernstein.acernis.node.INode;
import de.christianbernstein.acernis.parameters.IContainer;
import de.christianbernstein.acernis.util.IParser;
import lombok.NonNull;

/**
 * A context that holds all data related to the issued command. The context is used to retrieve all the data for processing and
 * permission management. A {@link IParser} is used for construction.
 *
 * @author Christian Bernstein
 */
public interface ICommandDispatchContext {

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
