package de.christianbernstein.acernis.api.command;

import lombok.NonNull;

/**
 * A context holds all data of an command. The context is used to retrieve all the data for processing and
 * permission management. A {@link de.christianbernstein.acernis.api.command.util.Parser} is used for construction.
 *
 * @author Christian Bernstein
 */
public interface IContext {

    @NonNull
    IConductor getConductor();

    @NonNull
    String getRaw();
}
