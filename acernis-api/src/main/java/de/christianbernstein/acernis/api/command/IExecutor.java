package de.christianbernstein.acernis.api.command;

import lombok.NonNull;

import java.util.Properties;

/**
 * The actual executor for a command, which get wrapped into a {@link INode}.
 *
 * @author Christian Bernstein
 */
@FunctionalInterface
public interface IExecutor {

    void execute(@NonNull IContext context);

}
